package derekahedron.mythictinkers.block;

import derekahedron.mythictinkers.particle.MTParticleTypes;
import com.github.alexmodguy.alexscaves.server.block.NeodymiumPillarBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class ByzantiumNeodymiumPillarBlock extends NeodymiumPillarBlock {

    public ByzantiumNeodymiumPillarBlock() {
        super(false);
    }

    @Override
    public Block getBlock() {
        return this;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        Vec3 center = Vec3.atCenterOf(pos);
        if (random.nextInt(5) == 0) {
            level.addParticle(
                    MTParticleTypes.BYZANTIUM_MAGNETIC_ORBIT.get(),
                    center.x, center.y, center.z,
                    center.x, center.y, center.z);
        }
    }
}
