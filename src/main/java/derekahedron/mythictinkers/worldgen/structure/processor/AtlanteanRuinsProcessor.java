package derekahedron.mythictinkers.worldgen.structure.processor;

import derekahedron.mythictinkers.block.MTBlocks;
import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import javax.annotation.Nullable;
import java.util.Map;

public class AtlanteanRuinsProcessor extends StructureProcessor {
    public static final Codec<AtlanteanRuinsProcessor> CODEC = RecordCodecBuilder.create((builder) ->
            builder.group(
                    Codec.floatRange(0.0F, 1.0F).fieldOf("integrity")
                            .forGetter((processor) -> processor.integrity)
                    ).apply(builder, AtlanteanRuinsProcessor::new));

    private final Map<Block, Block> replacements = Util.make(Maps.newHashMap(), (map) -> {
        map.put(MTBlocks.ATLANTEAN_BRICKS.get(), MTBlocks.CRACKED_ATLANTEAN_BRICKS.get());
        map.put(MTBlocks.ATLANTEAN_TILES.get(), MTBlocks.CRACKED_ATLANTEAN_TILES.get());
        map.put(MTBlocks.ATLANTEAN_PILLAR.get(), MTBlocks.CRACKED_ATLANTEAN_PILLAR.get());
    });
    public final float integrity;

    public AtlanteanRuinsProcessor(float integrity) {
        this.integrity = integrity;
    }

    @Override
    @Nullable
    public StructureTemplate.StructureBlockInfo process(
            LevelReader level,
            BlockPos relativePos, BlockPos pos,
            StructureTemplate.StructureBlockInfo relativeInfo, StructureTemplate.StructureBlockInfo info,
            StructurePlaceSettings settings,
            @Nullable StructureTemplate template) {
        if (integrity >= 1.0F) return info;

        RandomSource random = settings.getRandom(info.pos());
        if (random.nextFloat() > integrity) return null;

        Block block = replacements.get(info.state().getBlock());
        if (block == null) return info;
        if (random.nextFloat() <= integrity) return info;

        BlockState oldState = info.state();
        BlockState newState = block.defaultBlockState();
        if (oldState.hasProperty(RotatedPillarBlock.AXIS)) {
            newState = newState.setValue(RotatedPillarBlock.AXIS, oldState.getValue(RotatedPillarBlock.AXIS));
        }

        return new StructureTemplate.StructureBlockInfo(info.pos(), newState, info.nbt());
    }

    @Override
    protected StructureProcessorType<AtlanteanRuinsProcessor> getType() {
        return MTStructureProcessorTypes.ATLANTEAN_RUINS.get();
    }
}
