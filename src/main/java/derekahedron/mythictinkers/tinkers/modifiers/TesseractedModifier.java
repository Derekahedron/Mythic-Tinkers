package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.tinkers.hooks.LivingDropsModifierHook;
import derekahedron.mythictinkers.tinkers.hooks.MTModifierHooks;
import derekahedron.mythictinkers.tinkers.hooks.PickupItemModifierHook;
import com.google.common.collect.ImmutableList;
import net.minecraft.ResourceLocationException;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.VanillaInventoryCodeHooks;
import org.apache.commons.lang3.tuple.Pair;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ProcessLootModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.build.ModifierRemovalHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.BlockInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import javax.annotation.Nullable;
import java.util.*;

public class TesseractedModifier extends NoLevelsModifier
        implements ProcessLootModifierHook, BlockInteractionModifierHook, GeneralInteractionModifierHook,
        PickupItemModifierHook, ModifierRemovalHook, ProjectileLaunchModifierHook, LivingDropsModifierHook {
    public static final String ADD_TEXT = "modifier.mythictinkers.tesseracted.add";
    public static final String REMOVE_TEXT = "modifier.mythictinkers.tesseracted.remove";
    public static final String ACTIVATE_TEXT = "modifier.mythictinkers.tesseracted.activate";
    public static final String DEACTIVATE_TEXT = "modifier.mythictinkers.tesseracted.deactivate";

    public static final String LOCATION_KEY = "Location";
    public static final String ACTIVE_KEY = "Active";

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.PROCESS_LOOT,
                ModifierHooks.BLOCK_INTERACT,
                ModifierHooks.GENERAL_INTERACT,
                MTModifierHooks.PICKUP_ITEM,
                ModifierHooks.PROJECTILE_LAUNCH,
                MTModifierHooks.LIVING_DROPS);
    }

    @Override
    public void onPickupItem(
            IToolStackView tool, ModifierEntry modifier,
            Player player, EquipmentSlot slot, ImmutableList<ItemStack> stacks) {
        if (slot.isArmor() && player.level() instanceof ServerLevel level) {
            warpToLocation(tool, stacks.listIterator(), level);
        }
    }

    @Override
    @Nullable
    public Component onRemoved(IToolStackView tool, Modifier modifier) {
        tool.getPersistentData().remove(getId());
        return null;
    }

    @Override
    public InteractionResult onToolUse(
            IToolStackView tool, ModifierEntry modifier, Player player,
            InteractionHand hand, InteractionSource source) {
        if (player.isCrouching()) {
            if (!player.level().isClientSide()) {
                CompoundTag data = getModifierData(tool);
                boolean active = !readActive(data);
                if (active) {
                    data.remove(ACTIVE_KEY);
                } else {
                    data.putBoolean(ACTIVE_KEY, false);
                }
                setModifierData(tool, data);
                player.displayClientMessage(Component.translatable(active ? ACTIVATE_TEXT : DEACTIVATE_TEXT), true);
            }
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult beforeBlockUse(
            IToolStackView tool, ModifierEntry modifier, UseOnContext context, InteractionSource source) {
        Player player = context.getPlayer();
        if (player != null && player.isCrouching()) {

            BlockPos pos = context.getClickedPos();
            Level level = context.getLevel();
            Direction direction = context.getClickedFace();

            Optional<Pair<IItemHandler, Object>> optionalHandler = VanillaInventoryCodeHooks.getItemHandler(
                    level, pos.getX(), pos.getY(), pos.getZ(), direction);
            if (optionalHandler.isPresent()) {
                if (!level.isClientSide()) {
                    TesseractedLocation location = new TesseractedLocation(pos, level.dimension(), direction);
                    CompoundTag data = getModifierData(tool);

                    if (data.contains(LOCATION_KEY) && location.equals(TesseractedLocation.read(data.getCompound(LOCATION_KEY)))) {
                        data.remove(LOCATION_KEY);
                        player.displayClientMessage(Component.translatable(REMOVE_TEXT), true);
                    } else {
                        data.put(LOCATION_KEY, location.write());
                        player.displayClientMessage(Component.translatable(ADD_TEXT,
                                pos.getX(), pos.getY(), pos.getZ(), direction.getName()), true);
                    }
                    setModifierData(tool, data);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public void processLoot(
            IToolStackView tool, ModifierEntry modifier, List<ItemStack> generatedLoot, LootContext context) {
        warpToLocation(tool, generatedLoot.listIterator(), context.getLevel());
    }

    @Override
    public void onLivingDrops(
            IToolStackView tool, ModifierEntry modifier, LivingEntity attacker, LivingDropsEvent event) {
        if (attacker.level() instanceof ServerLevel level) {
            warpToLocation(tool,
                    new ArrayList<>(event.getDrops().stream().map(ItemEntity::getItem).toList()).listIterator(), level);
            event.getDrops().removeIf((itemEntity -> itemEntity.getItem().isEmpty()));
        }
    }

    public void warpToLocation(IToolStackView tool, ListIterator<ItemStack> stacks, ServerLevel level) {
        CompoundTag compound = getModifierData(tool);
        if (readActive(compound) && compound.contains(LOCATION_KEY)) {
            TesseractedLocation location = TesseractedLocation.read(compound.getCompound(LOCATION_KEY));
            IItemHandler handler = location.getItemHandler(level);
            if (handler != null) {
                while (stacks.hasNext()) {
                    ItemStack stack = stacks.next();
                    ItemStack copy = stack.copy();
                    for (int slot = 0; slot < handler.getSlots() && !copy.isEmpty(); slot++) {
                        copy = handler.insertItem(slot, copy, false);
                    }
                    if (copy.isEmpty() || ItemStack.isSameItemSameTags(stack, copy)) {
                        stack.setCount(copy.getCount());
                    }
                }
            } else {
                compound.remove(LOCATION_KEY);
                setModifierData(tool, compound);
            }
        }
    }

    public CompoundTag getModifierData(IToolStackView tool) {
        return tool.getPersistentData().getCompound(getId());
    }

    public void setModifierData(IToolStackView tool, CompoundTag data) {
        if (data.isEmpty()) {
            tool.getPersistentData().remove(getId());
        } else {
            tool.getPersistentData().put(getId(), data);
        }
    }

    public boolean readActive(CompoundTag compound) {
        if (compound.contains(ACTIVE_KEY)) {
            return compound.getBoolean(ACTIVE_KEY);
        } else {
            return true;
        }
    }

    @Override
    public void onProjectileLaunch(
            IToolStackView tool, ModifierEntry modifier, LivingEntity shooter,
            Projectile projectile, @Nullable AbstractArrow arrow,
            ModDataNBT persistentData, boolean primary) {
        persistentData.put(getId(), getModifierData(tool));
    }

    public record TesseractedLocation(BlockPos pos, ResourceKey<Level> dimension, Direction direction) {
        public static final String DIMENSION_KEY = "Dimension";
        public static final String DIRECTION_KEY = "Direction";

        public @Nullable IItemHandler getItemHandler(ServerLevel level) {
            if (!dimension.equals(level.dimension())) {
                level = level.getServer().getLevel(dimension);
                if (level == null) {
                    return null;
                }
            }

            Optional<Pair<IItemHandler, Object>> optionalHandler = VanillaInventoryCodeHooks.getItemHandler(
                    level, pos.getX(), pos.getY(), pos.getZ(), direction
            );

            return optionalHandler.map(Pair::getKey).orElse(null);
        }

        public CompoundTag write() {
            CompoundTag compound = NbtUtils.writeBlockPos(pos);
            compound.putString(DIMENSION_KEY, dimension.location().toString());
            compound.putInt(DIRECTION_KEY, direction.get3DDataValue());
            return compound;
        }

        public static TesseractedLocation read(CompoundTag compound) {
            BlockPos pos;
            ResourceKey<Level> dimension;
            Direction direction;

            pos = NbtUtils.readBlockPos(compound);
            try {
                dimension = ResourceKey.create(Registries.DIMENSION,
                        new ResourceLocation(compound.getString(DIMENSION_KEY)));
            } catch (ResourceLocationException e) {
                dimension = Level.OVERWORLD;
            }

            try {
                direction = Direction.values()[compound.getInt(DIRECTION_KEY)];
            } catch (IndexOutOfBoundsException e) {
                direction = Direction.UP;
            }

            return new TesseractedLocation(pos, dimension, direction);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } else if (o instanceof TesseractedLocation otherLocation) {
                return otherLocation.pos.equals(pos)
                        && otherLocation.dimension.equals(dimension)
                        && otherLocation.direction == direction;
            }
            return false;
        }
    }
}
