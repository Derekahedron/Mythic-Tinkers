package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.util.MTUtil;
import com.github.alexmodguy.alexscaves.AlexsCaves;
import com.github.alexmodguy.alexscaves.server.item.HazmatArmorItem;
import com.github.alexmodguy.alexscaves.server.message.UpdateEffectVisualityEntityMessage;
import com.github.alexmodguy.alexscaves.server.potion.ACEffectRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.OnAttackedModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ToolDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.build.ModifierRemovalHook;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InventoryTickModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.capability.PersistentDataCapability;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

import javax.annotation.Nullable;
import java.util.UUID;

public class RadioactiveModifier extends NoLevelsModifier
        implements ToolDamageModifierHook, InventoryTickModifierHook, ModifierRemovalHook,
        OnAttackedModifierHook, MeleeHitModifierHook, ProjectileLaunchModifierHook, ProjectileHitModifierHook {
    public static final String ENTITIES_KEY = "Entities" ;
    public static final String UUID_KEY = "UUID" ;
    public static final String INDIRECT_KEY = "Indirect" ;
    public static final String RADIOACTIVE_KEY = "Radioactive" ;

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.TOOL_DAMAGE,
                ModifierHooks.INVENTORY_TICK,
                ModifierHooks.REMOVE,
                ModifierHooks.MELEE_HIT,
                ModifierHooks.ON_ATTACKED,
                ModifierHooks.PROJECTILE_LAUNCH,
                ModifierHooks.PROJECTILE_HIT);
    }

    @Override
    public int onDamageTool(IToolStackView tool, ModifierEntry modifier, int amount, @Nullable LivingEntity holder) {
        if (holder != null && holder.level() instanceof ServerLevel serverLevel) {
            if (!(holder instanceof Player player && player.isCreative())) {
                makeIrradiated(holder);
            }
            CompoundTag compound = tool.getPersistentData().getCompound(getId());

            if (!compound.isEmpty()) {
                ListTag entities = compound.getList(ENTITIES_KEY, 10);

                // Try to make all other affected entities irradiated
                for (int i = 0; i < entities.size(); i++) {
                    CompoundTag entityCompound = entities.getCompound(i);
                    UUID uuid = entityCompound.getUUID(UUID_KEY);
                    Entity entity = serverLevel.getEntities().get(uuid);

                    if (entity == null) {
                        continue;
                    }
                    // For indirect entities like projectiles, mark them as radioactive
                    if (entityCompound.getBoolean(INDIRECT_KEY)) {
                        entity.getCapability(PersistentDataCapability.CAPABILITY).ifPresent((persistentData) -> {
                            CompoundTag projectileCompound = persistentData.getCompound(getId());
                            projectileCompound.putBoolean(RADIOACTIVE_KEY, true);
                            persistentData.put(getId(), projectileCompound);
                        });
                    } else if (entity instanceof LivingEntity livingEntity) {
                        makeIrradiated(livingEntity);
                    }
                }

                tool.getPersistentData().remove(getId());
            }
        }
        return amount;
    }

    @Override
    public void onInventoryTick(
            IToolStackView tool, ModifierEntry modifier, Level world,
            LivingEntity holder, int itemSlot, boolean isSelected,
            boolean isCorrectSlot, ItemStack stack) {
        tool.getPersistentData().remove(getId());
    }

    @Override
    @Nullable
    public Component onRemoved(IToolStackView tool, Modifier modifier) {
        tool.getPersistentData().remove(getId());
        return null;
    }

    @Override
    public void afterMeleeHit(
            IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        if (context.getLivingTarget() != null) {
            addEntityToList(tool, context.getLivingTarget(), false);
        }
    }

    @Override
    public void onAttacked(
            IToolStackView tool, ModifierEntry modifier, EquipmentContext context,
            EquipmentSlot slotType, DamageSource source, float amount, boolean isDirectDamage) {
        if (!source.isIndirect() && source.getEntity() != null) {
            addEntityToList(tool, source.getEntity(), false);
        }
    }

    @Override
    public void onProjectileLaunch(
            IToolStackView tool, ModifierEntry modifier, LivingEntity shooter,
            Projectile projectile, @Nullable AbstractArrow arrow,
            ModDataNBT persistentData, boolean primary) {
        addEntityToList(tool, projectile, true);
    }

    @Override
    public boolean onProjectileHitEntity(
            ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier, Projectile projectile,
            EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (MTUtil.shouldBlockHitEffect(projectile, hit)) return false;
        if (target != null && persistentData.getCompound(getId()).getBoolean(RADIOACTIVE_KEY)) {
            makeIrradiated(target);
        }
        return false;
    }

    public void addEntityToList(IToolStackView tool, Entity entity, boolean indirect) {
        CompoundTag compound = tool.getPersistentData().getCompound(getId());
        ListTag entities;
        if (compound.contains(ENTITIES_KEY)) {
            entities = compound.getList(ENTITIES_KEY, 10);
        } else {
            entities = new ListTag();
            compound.put(ENTITIES_KEY, entities);
            tool.getPersistentData().put(getId(), compound);
        }
        CompoundTag entityCompound = new CompoundTag();
        entityCompound.putUUID(UUID_KEY, entity.getUUID());
        entityCompound.putBoolean(INDIRECT_KEY, indirect);
        entities.add(entityCompound);
    }

    public static void makeIrradiated(LivingEntity entity) {
        float hazmatMultiplier = 1.0F - (float) HazmatArmorItem.getWornAmount(entity) / 4.0F;
        if (!entity.hasEffect(ACEffectRegistry.IRRADIATED.get()) && entity.level().random.nextFloat() < hazmatMultiplier) {
            MobEffectInstance instance = new MobEffectInstance(ACEffectRegistry.IRRADIATED.get(), 1800);
            entity.addEffect(instance);
            AlexsCaves.sendMSGToAll(new UpdateEffectVisualityEntityMessage(
                    entity.getId(), entity.getId(), 0, instance.getDuration()));
        }
    }
}
