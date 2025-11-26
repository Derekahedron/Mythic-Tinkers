package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.mixin.ProjectileInvoker;
import derekahedron.mythictinkers.potion.MTEffects;
import derekahedron.mythictinkers.util.MTUtil;
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
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

import javax.annotation.Nullable;
import java.util.List;

public class VengefulShotModifier extends NoLevelsModifier
        implements ProjectileHitModifierHook {
    public static final int DURATION = (int) (20 * 5.0F);
    public static final String INACTIVE_KEY = "Inactive";

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this, ModifierHooks.PROJECTILE_HIT);
    }


    @Override
    public boolean onProjectileHitEntity(
            ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier,
            Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker,
            @Nullable LivingEntity target) {
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
    public void onProjectileHitBlock(
            ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier,
            Projectile projectile, BlockHitResult hit, @Nullable LivingEntity attacker) {
        if (projectile.level().isClientSide() || persistentData.getCompound(getId()).getBoolean(INACTIVE_KEY)) {
            return;
        }

        List<Entity> entities = MTUtil.getEntitiesInRadius(
                projectile, 10,
                entity -> entity instanceof LivingEntity livingEntity
                        && livingEntity != attacker
                        && livingEntity.isAlive()
                        && livingEntity.hasEffect(MTEffects.MARKED_FOR_DEATH.get()));
        if (entities.isEmpty()) {
            return;
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
                            modifiers, persistentData, modifierEntry, projectile, hitResult, attacker, livingEntity);
                }
                livingEntity.removeEffect(MTEffects.MARKED_FOR_DEATH.get());
            }
        }
    }
}
