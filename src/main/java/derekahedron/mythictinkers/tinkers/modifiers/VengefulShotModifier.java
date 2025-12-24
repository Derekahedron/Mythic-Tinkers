package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.mixin.ProjectileInvoker;
import derekahedron.mythictinkers.potion.MTEffects;
import derekahedron.mythictinkers.tinkers.hooks.MTModifierHooks;
import derekahedron.mythictinkers.tinkers.hooks.ThrownToolHitModifierHook;
import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.capability.PersistentDataCapability;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.tools.entity.ThrownTool;

import javax.annotation.Nullable;
import java.util.List;

public class VengefulShotModifier extends NoLevelsModifier
        implements ProjectileHitModifierHook, ThrownToolHitModifierHook {
    public static final int DURATION = (int) (20 * 5.0F);
    public static final String INACTIVE_KEY = "Inactive";

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.PROJECTILE_HIT,
                MTModifierHooks.THROWN_TOOL_HIT);
    }

    @Override
    public boolean onProjectileHitEntity(
            ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier,
            Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker,
            @Nullable LivingEntity target, boolean notBlocked) {
        if (MTUtil.shouldBlockHitEffect(projectile, hit)) return false;
        if (target != null) {
            target.addEffect(new MobEffectInstance(MTEffects.MARKED_FOR_DEATH.get(), DURATION));
            CompoundTag compound = persistentData.getCompound(getId());
            compound.putBoolean(INACTIVE_KEY, true);
            persistentData.put(getId(), compound);
        }
        return false;
    }

    @Override
    public boolean onProjectileHitsBlock(
            ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier,
            Projectile projectile, BlockHitResult hit, @Nullable LivingEntity attacker) {
        if (projectile.level().isClientSide() || persistentData.getCompound(getId()).getBoolean(INACTIVE_KEY)) {
            return false;
        }

        List<Entity> entities = MTUtil.getEntitiesInRadius(
                projectile, 10,
                entity -> entity instanceof LivingEntity livingEntity
                        && livingEntity != attacker
                        && livingEntity.isAlive()
                        && livingEntity.hasEffect(MTEffects.MARKED_FOR_DEATH.get()));
        if (entities.isEmpty()) {
            return false;
        }
        if (projectile instanceof AbstractArrow arrow) {
            arrow.setPierceLevel((byte) Math.min(arrow.getPierceLevel() + entities.size(), Byte.MAX_VALUE));
        }

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity) {
                EntityHitResult hitResult = new EntityHitResult(livingEntity);
                ((ProjectileInvoker) projectile).invokeOnHit(hitResult);
                for (ModifierEntry modifierEntry : modifiers.getModifiers()) {
                    modifierEntry.getHook(ModifierHooks.PROJECTILE_HIT).onProjectileHitEntity(
                            modifiers, persistentData, modifierEntry, projectile, hitResult, attacker, livingEntity, true);
                }
                livingEntity.removeEffect(MTEffects.MARKED_FOR_DEATH.get());
            }
        }
        return false;
    }

    @Override
    public void onThrownToolHitEntity(
            IToolStackView tool, ModifierEntry modifier, ThrownTool thrownTool,
            LivingEntity attacker, Entity target, @Nullable LivingEntity livingTarget) {
        if (livingTarget == null) return;
        ModDataNBT persistentData = PersistentDataCapability.getOrWarn(thrownTool);
        CompoundTag compound = persistentData.getCompound(getId());
        compound.putBoolean(INACTIVE_KEY, true);
        persistentData.put(getId(), compound);
    }

    @Override
    public void onThrownToolHitBlock(
            IToolStackView tool, ModifierEntry modifier, ThrownTool thrownTool,
            LivingEntity owner, BlockPos pos) {
        if (thrownTool.level().isClientSide()) return;
        ModDataNBT persistentData = PersistentDataCapability.getOrWarn(thrownTool);
        if (persistentData.getCompound(getId()).getBoolean(INACTIVE_KEY)) return;

        List<Entity> entities = MTUtil.getEntitiesInRadius(
                thrownTool, 10,
                entity -> entity instanceof LivingEntity livingEntity
                        && livingEntity != owner
                        && livingEntity.isAlive()
                        && livingEntity.hasEffect(MTEffects.MARKED_FOR_DEATH.get()));
        if (entities.isEmpty()) {
            return;
        }

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity) {
                EntityHitResult hitResult = new EntityHitResult(livingEntity);
                ((ProjectileInvoker) thrownTool).invokeOnHit(hitResult);
                for (ModifierEntry modifierEntry : tool.getModifiers()) {
                    modifier.getHook(MTModifierHooks.THROWN_TOOL_HIT).onThrownToolHitEntity(
                            tool,
                            modifierEntry,
                            thrownTool,
                            owner,
                            livingEntity,
                            livingEntity);
                }
                livingEntity.removeEffect(MTEffects.MARKED_FOR_DEATH.get());
            }
        }
    }
}
