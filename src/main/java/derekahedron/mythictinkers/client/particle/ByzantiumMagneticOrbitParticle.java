package derekahedron.mythictinkers.client.particle;

import com.github.alexmodguy.alexscaves.client.particle.MagneticOrbitParticle;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ByzantiumMagneticOrbitParticle extends MagneticOrbitParticle {

    public ByzantiumMagneticOrbitParticle(
            ClientLevel world,
            double x, double y, double z,
            double xd, double yd, double zd) {
        super(world, x, y, z, xd, yd, zd);
        trailR = 0.9F + world.random.nextFloat() * 0.1F;
        trailG = 0.2F + world.random.nextFloat() * 0.05F;
        trailB = 0.9F + world.random.nextFloat() * 0.1F;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {

        public Particle createParticle(
                SimpleParticleType type, ClientLevel level,
                double x, double y, double z,
                double xd, double yd, double zd) {
            return new ByzantiumMagneticOrbitParticle(level, x, y, z, xd, yd, zd);
        }
    }
}
