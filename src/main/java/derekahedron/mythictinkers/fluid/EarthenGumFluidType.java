package derekahedron.mythictinkers.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

import java.awt.*;

public class EarthenGumFluidType extends MTFluidType {

    public EarthenGumFluidType(
            ResourceLocation stillTexture, ResourceLocation flowingTexture,
            Color fogColor, float fogStart, float fogEnd, FluidType.Properties properties) {
        super(stillTexture, flowingTexture, fogColor, fogStart, fogEnd, properties);
    }

    @Override
    public void setItemMovement(ItemEntity entity)
    {
        Vec3 velocity = entity.getDeltaMovement();
        entity.setDeltaMovement(
                velocity.x * 0.2F,
                velocity.y * 0.3F + (entity.isNoGravity() ? 0 : -0.08D / 64.0D),
                velocity.z * 0.2F);
    }

    @Override
    public boolean move(FluidState state, LivingEntity entity, Vec3 movementVector, double gravity) {
        Vec3 velocity = entity.getDeltaMovement();
        double originalY = entity.getY();
        boolean falling = velocity.y <= 0.0D;

        entity.moveRelative(0.02F, movementVector);
        entity.move(MoverType.SELF, entity.getDeltaMovement());

        if (entity.getFluidTypeHeight(this) <= entity.getFluidJumpThreshold()) {
            entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.2D, 0.3F, 0.2D));
            velocity = entity.getFluidFallingAdjustedMovement(gravity, falling, entity.getDeltaMovement());
            entity.setDeltaMovement(velocity);
        } else {
            velocity = entity.getDeltaMovement().scale(0.2D);
            entity.setDeltaMovement(velocity);
        }

        if (!entity.isNoGravity()) {
            velocity = velocity.add(0.0D, -gravity / 16.0D, 0.0D);
        }

        if (entity.horizontalCollision && entity.isFree(
                velocity.x,
                velocity.y + 0.6D - entity.getY() + originalY,
                velocity.z)) {
            velocity = velocity.add(0.0D, 0.3F, 0.0D);
        }
        entity.setDeltaMovement(velocity);
        return true;
    }
}
