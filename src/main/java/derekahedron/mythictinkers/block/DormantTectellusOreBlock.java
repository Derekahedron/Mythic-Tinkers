package derekahedron.mythictinkers.block;

import com.github.alexmodguy.alexscaves.server.block.PrimalMagmaBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;

public class DormantTectellusOreBlock extends Block {
    public static final BooleanProperty PERMANENT = PrimalMagmaBlock.PERMANENT;

    public DormantTectellusOreBlock(BlockBehaviour.Properties properties) {
        super(properties);
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
        if (PrimalMagmaBlock.isBossActive(context.getLevel())) {
            BlockState state = MTBlocks.TECTELLUS_ORE.get().getStateForPlacement(context);
            if (state != null) {
                state = state.setValue(TectellusOreBlock.PERMANENT, false);
            }
            return state;
        } else {
            return super.getStateForPlacement(context);
        }
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
        if (!state.getValue(PERMANENT) && PrimalMagmaBlock.isBossActive(level)) {
            level.setBlockAndUpdate(pos, MTBlocks.TECTELLUS_ORE.get().defaultBlockState());
        }
    }
}
