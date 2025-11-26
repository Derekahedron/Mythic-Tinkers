package derekahedron.mythictinkers.tinkers.modifiers.modules;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.mantle.data.loadable.primitive.IntLoadable;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InventoryTickModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public class HalfLifeModule implements ModifierModule, InventoryTickModifierHook {
    public static final List<ModuleHook<?>> DEFAULT_HOOKS =
            HookProvider.defaultHooks(ModifierHooks.INVENTORY_TICK);
    public static final RecordLoadable<HalfLifeModule> LOADER =
            RecordLoadable.create(
                    IntLoadable.FROM_ONE.requiredField("half_life", (module) -> module.halfLife),
                    HalfLifeModule::new);
    public final int halfLife;
    public final float decayConstant;

    public HalfLifeModule(int halfLife) {
        if (halfLife <= 0) {
            throw new IllegalArgumentException(String.format("Half Life %s must be greater than zero", halfLife));
        }
        this.halfLife = halfLife;
        this.decayConstant = (float) Math.log(2) / halfLife;
    }

    @Override
    public void onInventoryTick(
            IToolStackView tool, ModifierEntry modifier, Level world,
            LivingEntity holder, int itemSlot, boolean isSelected,
            boolean isCorrectSlot, ItemStack stack) {
        if (!world.isClientSide()
                && !tool.isBroken()
                && !tool.isUnbreakable()
                && holder instanceof ServerPlayer player
                && !player.isCreative()
                && !(player.gameMode.isDestroyingBlock && isSelected)) {
            int durability = stack.getMaxDamage() - stack.getDamageValue();
            float decayRate = decayConstant * durability;
            int damage = (int) decayRate;
            if (world.getRandom().nextFloat() < (decayRate - damage)) {
                damage++;
            }

            if (damage > 0) {
                stack.hurtAndBreak(damage, player, (p) -> {
                    for (EquipmentSlot slot : EquipmentSlot.values()) {
                        if (player.getItemBySlot(slot) == stack) {
                            p.broadcastBreakEvent(slot);
                            break;
                        }
                    }
                });
            }
        }
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    @Override
    public RecordLoadable<HalfLifeModule> getLoader() {
        return LOADER;
    }
}
