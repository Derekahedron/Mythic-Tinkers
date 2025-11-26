package derekahedron.mythictinkers.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.BaseAshSmokeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StyxSmokeParticle extends BaseAshSmokeParticle {

    protected StyxSmokeParticle(
            ClientLevel level,
            double x, double y, double z,
            double xd, double yd, double zd,
            SpriteSet sprites) {
        super(level, x, y, z, 0.1F, 0.1F, 0.1F, xd, yd, zd, 1.0F, sprites, 0.3F, 8, -0.1F, true);
        rCol = 1.0F;
        gCol = 1.0F;
        bCol = 1.0F;
        roll = oRoll = (float) (level.random.nextFloat() * 2 * Math.PI);
        scale(Mth.lerp(level.random.nextFloat(), 0.8F, 1.2F));
    }

    public void tick() {
        if (Minecraft.getInstance().player == null || Minecraft.getInstance().player.isDeadOrDying()) {
            remove();
        }
        super.tick();
    }

    @OnlyIn(Dist.CLIENT)
    public record Provider(SpriteSet sprites) implements ParticleProvider<SimpleParticleType> {

        public Particle createParticle(
                SimpleParticleType type, ClientLevel level,
                double x, double y, double z,
                double dx, double dy, double dz) {
            return new StyxSmokeParticle(level, x, y, z, dx, dy, dz, sprites);
        }
    }
}
