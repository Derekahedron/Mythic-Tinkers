package derekahedron.mythictinkers.fluid;

import derekahedron.mythictinkers.block.MTBlocks;
import derekahedron.mythictinkers.network.MTPacketHandler;
import derekahedron.mythictinkers.network.StyxEvaporatePacket;
import derekahedron.mythictinkers.particle.MTParticleTypes;
import derekahedron.mythictinkers.util.MTSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.network.PacketDistributor;

import javax.annotation.Nullable;

public abstract class StyxFluid extends ForgeFlowingFluid {

    public StyxFluid(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean isRandomlyTicking() {
        return true;
    }

    @Override
    protected void randomTick(Level level, BlockPos pos, FluidState state, RandomSource random) {
        if (isSource(state)) {
            for (Direction direction : Direction.values()) {
                if (direction != Direction.UP) {
                    FluidState neighborState = level.getFluidState(pos.relative(direction));
                    if (isSame(neighborState.getType()) && !neighborState.isSource()) {
                        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 11);
                        fizz(null, level, pos);
                        return;
                    }
                }
            }
        }
    }

    @Override
    protected void spreadTo(
            LevelAccessor level, BlockPos relativePos, BlockState relativeBlockState,
            Direction direction, FluidState currentState) {
        if (direction == Direction.DOWN) {
            FluidState relativeState = level.getFluidState(relativePos);
            if (!relativeState.isEmpty() && relativeState.getFluidType() != getFluidType()) {
                if (relativeBlockState.getBlock() instanceof LiquidBlock) {
                    level.setBlock(
                            relativePos,
                            ForgeEventFactory.fireFluidPlaceBlockEvent(
                                    level, relativePos, relativePos, MTBlocks.DOMBSTONE.get().defaultBlockState()),
                            3);
                }

                fizz(null, level, relativePos);
                return;
            }
        }

        super.spreadTo(level, relativePos, relativeBlockState, direction, currentState);
    }

    @Override
    protected boolean canSpreadTo(BlockGetter level, BlockPos pos, BlockState blockState, Direction direction, BlockPos relativePos, BlockState relativeBlockState, FluidState fluidState, Fluid fluid) {
        if (super.canSpreadTo(level, pos, blockState, direction, relativePos, relativeBlockState, fluidState, fluid)) return true;
        if (direction == Direction.DOWN) {
            FluidState relativeState = level.getFluidState(relativePos);
            if (!relativeState.isEmpty() && relativeState.getFluidType() != getFluidType()) {
                return relativeBlockState.getBlock() instanceof LiquidBlock;
            }
        }
        return false;
    }

    public static void fizz(@Nullable Player player, LevelAccessor level, BlockPos blockPos) {
        if (level instanceof ServerLevel serverLevel) {
            MTPacketHandler.INSTANCE.send(PacketDistributor.NEAR.with(() -> new PacketDistributor.TargetPoint(
                    null,
                    blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                    64.0D,
                    serverLevel.dimension()
            )), new StyxEvaporatePacket(blockPos));
        } else if (level.isClientSide()) {
            level.playSound(
                    player,
                    blockPos,
                    MTSoundEvents.STYX_EXTINGUISH.get(),
                    SoundSource.BLOCKS,
                    0.5F,
                    Mth.lerp(level.getRandom().nextFloat(), 2.6F, 3.4F));
            for (int i = 0; i < 8; i++) {
                level.addParticle(
                        MTParticleTypes.STYX_SMOKE.get(),
                        blockPos.getX() + Math.random(),
                        blockPos.getY() + Math.random(),
                        blockPos.getZ() + Math.random(),
                        0.0D, 0.0D, 0.0D
                );
            }
        }
    }

    public static class Source extends StyxFluid {
        public Source(Properties properties) {
            super(properties);
        }

        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends StyxFluid {
        public Flowing(Properties properties) {
            super(properties);
            registerDefaultState(getStateDefinition().any().setValue(LEVEL, 7));
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }
}
