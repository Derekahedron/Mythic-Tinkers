package derekahedron.mythictinkers.block;

import com.github.alexmodguy.alexscaves.server.block.PrimalMagmaBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;

public class TectellusOreBlock extends DropExperienceBlock {
    public static final BooleanProperty PERMANENT = PrimalMagmaBlock.PERMANENT;

    public TectellusOreBlock(Properties properties, IntProvider xpRange) {
        super(properties, xpRange);
        registerDefaultState(defaultBlockState()
                .setValue(PERMANENT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PERMANENT);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state != null) {
            state = state.setValue(PERMANENT, true);
        }
        return state;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        BlockState newState = super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        level.scheduleTick(pos, this, 2);
        return newState;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.getValue(PERMANENT) && !PrimalMagmaBlock.isBossActive(level)) {
            level.setBlockAndUpdate(pos, MTBlocks.DORMANT_TECTELLUS_ORE.get().defaultBlockState());
        }
    }
}
