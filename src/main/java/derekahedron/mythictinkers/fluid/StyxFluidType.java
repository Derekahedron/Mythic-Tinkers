package derekahedron.mythictinkers.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import java.awt.*;

public class StyxFluidType extends MTFluidType {

    public StyxFluidType(
            ResourceLocation stillTexture, ResourceLocation flowingTexture,
            Color fogColor, float fogStart, float fogEnd, Properties properties) {
        super(stillTexture, flowingTexture, fogColor, fogStart, fogEnd, properties);
    }

    @Override
    public double motionScale(Entity entity) {
        double motionScale = super.motionScale(entity);
        if (entity.isInWater()) {
            return motionScale / 2;
        } else {
            return motionScale;
        }
    }
}
