package derekahedron.mythictinkers.fluid;

import derekahedron.mythictinkers.damage.MTDamageTypes;
import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

import java.awt.*;

public class MoltenOreFluidType extends MTFluidType {
    public final ResourceKey<DamageType> damageType;
    public final float damage;
    public final int secondsOnFire;

    public MoltenOreFluidType(
            ResourceLocation stillTexture,
            ResourceLocation flowingTexture,
            Color fogColor,
            float fogStart,
            float fogEnd,
            ResourceKey<DamageType> damageType,
            float damage,
            int secondsOnFire,
            FluidType.Properties properties) {
        super(stillTexture, flowingTexture, fogColor, fogStart, fogEnd, properties);
        this.damageType = damageType;
        this.damage = damage;
        this.secondsOnFire = secondsOnFire;
    }

    @Override
    public void onEntityInside(Entity entity) {
        entity.setSecondsOnFire(secondsOnFire);
        if (entity.hurt(new DamageSource(MTUtil.getDamageType(entity, MTDamageTypes.MOLTEN_PROSPRUM)), damage)) {
            entity.playSound(
                    SoundEvents.GENERIC_BURN,
                    0.4F,
                    Mth.lerp(entity.level().random.nextFloat(),2.0F, 2.4F));
        }
    }

    @Override
    public void setItemMovement(ItemEntity entity) {
        Vec3 velocity = entity.getDeltaMovement();
        entity.setDeltaMovement(
                velocity.x * 0.95F,
                velocity.y + (velocity.y < 0.06F ? 5.0E-4F : 0.0F),
                velocity.z * 0.95F);
    }

    @Override
    public boolean move(FluidState state, LivingEntity entity, Vec3 movementVector, double gravity) {
        Vec3 velocity = entity.getDeltaMovement();
        double originalY = entity.getY();
        boolean falling = velocity.y <= 0.0D;

        entity.moveRelative(0.02F, movementVector);
        entity.move(MoverType.SELF, entity.getDeltaMovement());

        if (entity.getFluidTypeHeight(this) <= entity.getFluidJumpThreshold()) {
            entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.5D, 0.8F, 0.5D));
            velocity = entity.getFluidFallingAdjustedMovement(gravity, falling, entity.getDeltaMovement());
            entity.setDeltaMovement(velocity);
        } else {
            velocity = entity.getDeltaMovement().scale(0.5D);
            entity.setDeltaMovement(velocity);
        }

        if (!entity.isNoGravity()) {
            velocity = velocity.add(0.0D, -gravity / 4.0D, 0.0D);
        }

        if (entity.horizontalCollision && entity.isFree(
                velocity.x, velocity.y + 0.6D - entity.getY() + originalY, velocity.z)) {
            velocity = velocity.add(0.0D, 0.3F, 0.0D);
        }
        entity.setDeltaMovement(velocity);
        return true;
    }
}
