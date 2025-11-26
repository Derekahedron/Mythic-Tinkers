package derekahedron.mythictinkers.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;

public class ReplaceUnexposedBlockFeature extends Feature<ReplaceBlockConfiguration> {

    public ReplaceUnexposedBlockFeature(Codec<ReplaceBlockConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ReplaceBlockConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        ReplaceBlockConfiguration config = context.config();

        for (OreConfiguration.TargetBlockState state : config.targetStates) {

            if (state.target.test(level.getBlockState(pos), context.random())) {
                BlockPos.MutableBlockPos mutablePos = pos.mutable();

                for (Direction direction : Direction.values()) {
                    mutablePos.set(pos).move(direction);

                    if (level.isOutsideBuildHeight(mutablePos)) continue;
                    BlockState neighborState = level.getBlockState(mutablePos);

                    if (!Block.isFaceFull(neighborState.getShape(level, mutablePos), direction.getOpposite())) {
                        return true;
                    }
                }
                level.setBlock(pos, state.state, 2);
                break;
            }
        }

        return true;
    }
}
