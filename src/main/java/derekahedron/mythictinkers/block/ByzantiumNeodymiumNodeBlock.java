package derekahedron.mythictinkers.block;

import derekahedron.mythictinkers.particle.MTParticleTypes;
import com.github.alexmodguy.alexscaves.server.block.NeodymiumNodeBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ByzantiumNeodymiumNodeBlock extends NeodymiumNodeBlock {

    public ByzantiumNeodymiumNodeBlock() {
        super(false);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        Vec3 center = Vec3.atCenterOf(pos);
        if (random.nextInt(1) == 0) {
            level.addParticle(
                    MTParticleTypes.BYZANTIUM_MAGNETIC_ORBIT.get(),
                    center.x, center.y, center.z,
                    center.x, center.y, center.z);
        }
    }
}
