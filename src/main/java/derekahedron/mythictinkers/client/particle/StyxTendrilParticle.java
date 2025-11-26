package derekahedron.mythictinkers.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StyxTendrilParticle extends RisingParticle {
    private final SpriteSet sprites;

    StyxTendrilParticle(
            ClientLevel level,
            double x, double y, double z,
            double dx, double dy, double dz,
            SpriteSet sprites) {
        super(level, x, y, z, dx, dy, dz);
        this.sprites = sprites;
        scale(2.0F);
        this.hasPhysics = false;
        setSpriteFromAge(sprites);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public int getLightColor(float p_234080_) {
        return 240;
    }

    @Override
    public void tick() {
        super.tick();
        setSpriteFromAge(sprites);
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        public Particle createParticle(
                SimpleParticleType type, ClientLevel level,
                double x, double y, double z,
                double dx, double dy, double dz) {
            StyxTendrilParticle particle = new StyxTendrilParticle(level, x, y, z, dx, dy, dz, sprites);
            particle.setAlpha(1.0F);
            return particle;
        }
    }
}
