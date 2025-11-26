package derekahedron.mythictinkers.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public abstract class MoltenOreFluid extends ForgeFlowingFluid {
    public final Supplier<ParticleOptions> popParticle;
    public final Supplier<ParticleOptions> dripParticle;
    public final Supplier<SoundEvent> ambientSound;
    public final Supplier<SoundEvent> popSound;

    public MoltenOreFluid(
            ForgeFlowingFluid.Properties properties,
            Supplier<ParticleOptions> popParticle,
            Supplier<ParticleOptions> dripParticle,
            Supplier<SoundEvent> ambientSound,
            Supplier<SoundEvent> popSound) {
        super(properties);
        this.popParticle = popParticle;
        this.dripParticle = dripParticle;
        this.ambientSound = ambientSound;
        this.popSound = popSound;
    }

    @Override
    protected boolean isRandomlyTicking() {
        return true;
    }

    @Override
    public void animateTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
        BlockPos abovePos = pos.above();

        if (level.getBlockState(abovePos).isAir() && !level.getBlockState(abovePos).isSolidRender(level, abovePos)) {
            if (random.nextInt(100) == 0) {
                double x = pos.getX() + random.nextDouble();
                double y = pos.getY() + 1.0D;
                double z = pos.getZ() + random.nextDouble();
                level.addParticle(popParticle.get(), x, y, z, 0.0D, 0.0D, 0.0D);
                level.playLocalSound(
                        x, y, z,
                        popSound.get(), SoundSource.BLOCKS,
                        Mth.lerp(random.nextFloat(), 0.2F, 0.4F),
                        Mth.lerp(random.nextFloat(), 0.9F, 1.05F),
                        false);
            }

            if (random.nextInt(200) == 0) {
                level.playLocalSound(
                        pos.getX(), pos.getY(), pos.getZ(),
                        ambientSound.get(), SoundSource.BLOCKS,
                        Mth.lerp(random.nextFloat(), 0.2F, 0.4F),
                        Mth.lerp(random.nextFloat(), 0.9F, 1.05F),
                        false);
            }
        }
    }

    @Override
    protected void spreadTo(
            LevelAccessor level, BlockPos relativePos, BlockState relativeBlockState,
            Direction direction, FluidState currentState) {
        if (direction == Direction.DOWN) {
            FluidState relativeState = level.getFluidState(relativePos);
            if (relativeState.is(MTFluidTags.COOLS_MOLTEN_ORE)) {
                if (relativeBlockState.getBlock() instanceof LiquidBlock) {
                    level.setBlock(relativePos, ForgeEventFactory.fireFluidPlaceBlockEvent(
                            level, relativePos, relativePos, Blocks.STONE.defaultBlockState()), 3);
                }

                fizz(level, relativePos);
                return;
            }
        }

        super.spreadTo(level, relativePos, relativeBlockState, direction, currentState);
    }

    @Nullable
    public ParticleOptions getDripParticle() {
        return dripParticle.get();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(Level level, BlockPos pos, FluidState fluidState, RandomSource random) {
        if (level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = random.nextInt(3);
            if (i > 0) {
                BlockPos firePos = pos;

                for (int j = 0; j < i; ++j) {
                    firePos = firePos.offset(
                            random.nextInt(3) - 1,
                            1,
                            random.nextInt(3) - 1);
                    if (!level.isLoaded(firePos)) {
                        return;
                    }

                    BlockState blockState = level.getBlockState(firePos);
                    if (blockState.isAir()) {
                        if (hasFlammableNeighbours(level, firePos)) {
                            level.setBlockAndUpdate(
                                    firePos,
                                    ForgeEventFactory.fireFluidPlaceBlockEvent(level, firePos, pos, Blocks.FIRE.defaultBlockState()));
                            return;
                        }
                    } else if (blockState.blocksMotion()) {
                        return;
                    }
                }
            } else {
                for (int k = 0; k < 3; ++k) {
                    BlockPos firePos = pos.offset(
                            random.nextInt(3) - 1,
                            0,
                            random.nextInt(3) - 1);
                    if (!level.isLoaded(firePos)) {
                        return;
                    }

                    if (level.isEmptyBlock(firePos.above()) && isFlammable(level, firePos, Direction.UP)) {
                        level.setBlockAndUpdate(
                                firePos.above(),
                                ForgeEventFactory.fireFluidPlaceBlockEvent(level, firePos.above(), pos, Blocks.FIRE.defaultBlockState()));
                    }
                }
            }
        }
    }

    public void fizz(LevelAccessor level, BlockPos pos) {
        level.levelEvent(1501, pos, 0);
    }

    @SuppressWarnings("deprecation")
    private boolean isFlammable(LevelReader level, BlockPos pos, Direction face) {
        return (pos.getY() < level.getMinBuildHeight()
                || pos.getY() >= level.getMaxBuildHeight()
                || level.hasChunkAt(pos))
                && level.getBlockState(pos).isFlammable(level, pos, face);
    }

    private boolean hasFlammableNeighbours(LevelReader level, BlockPos pos) {
        for (Direction direction : Direction.values()) {
            if (isFlammable(level, pos.relative(direction), direction.getOpposite())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getSpreadDelay(Level level, BlockPos pos, FluidState state, FluidState otherState) {
        int tickDelay = getTickDelay(level);
        if (!state.isEmpty()
                && !otherState.isEmpty()
                && !state.getValue(FALLING)
                && !otherState.getValue(FALLING)
                && otherState.getHeight(level, pos) > state.getHeight(level, pos)
                && level.getRandom().nextInt(4) != 0) {
            tickDelay *= 4;
        }

        return tickDelay;
    }

    public static class Source extends MoltenOreFluid {

        public Source(
                ForgeFlowingFluid.Properties properties,
                Supplier<ParticleOptions> popParticle,
                Supplier<ParticleOptions> dripParticle,
                Supplier<SoundEvent> ambientSound,
                Supplier<SoundEvent> popSound) {
            super(properties, popParticle, dripParticle, ambientSound, popSound);
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

    public static class Flowing extends MoltenOreFluid {

        public Flowing(
                ForgeFlowingFluid.Properties properties,
                Supplier<ParticleOptions> popParticle,
                Supplier<ParticleOptions> dripParticle,
                Supplier<SoundEvent> ambientSound,
                Supplier<SoundEvent> popSound) {
            super(properties, popParticle, dripParticle, ambientSound, popSound);
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
