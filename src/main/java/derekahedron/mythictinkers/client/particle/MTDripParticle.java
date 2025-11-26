package derekahedron.mythictinkers.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.DripParticle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.Mth;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.*;

public class MTDripParticle {

    @OnlyIn(Dist.CLIENT)
    public static class CoolingDripHandParticle extends DripParticle.DripHangParticle {
        public final Color color;
        public final Color initialColor;

        public CoolingDripHandParticle(
                ClientLevel level,
                double x, double y, double z,
                Fluid fluid,
                ParticleOptions fallingParticle,
                Color color,
                Color initialColor) {
            super(level, x, y, z, fluid, fallingParticle);
            this.color = color;
            this.initialColor = initialColor;
        }

        protected void preMoveUpdate() {
            float progress = (40 - lifetime) / 40F;
            float t = 1 - (1 - progress) / (1 + progress);
            setColor(
                    Mth.lerp(t, initialColor.getRed() / 255.0F, color.getRed() / 255.0F),
                    Mth.lerp(t, initialColor.getGreen() / 255.0F, color.getGreen() / 255.0F),
                    Mth.lerp(t, initialColor.getBlue() / 255.0F, color.getBlue() / 255.0F));
            super.preMoveUpdate();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class FallAndLandParticle extends DripParticle.FallAndLandParticle {

        public FallAndLandParticle(
                ClientLevel level,
                double x, double y, double z,
                Fluid fluid,
                ParticleOptions fallingParticle,
                Color color) {
            super(level, x, y, z, fluid, fallingParticle);
            setColor(
                    color.getRed() / 255.0F,
                    color.getGreen() / 255.0F,
                    color.getBlue() / 255.0F);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class DripLandParticle extends DripParticle.DripLandParticle {

        public DripLandParticle(
                ClientLevel level,
                double x, double y, double z,
                Fluid fluid,
                Color color) {
            super(level, x, y, z, fluid);
            setColor(
                    color.getRed() / 255.0F,
                    color.getGreen() / 255.0F,
                    color.getBlue() / 255.0F);
        }
    }
}
