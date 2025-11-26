package derekahedron.mythictinkers.worldgen.structure;

import derekahedron.mythictinkers.util.MTUtil;
import com.mojang.serialization.Codec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

import java.util.Optional;

public class AtlanteanRuinsStructure extends Structure {
    public static final Codec<AtlanteanRuinsStructure> CODEC = simpleCodec(AtlanteanRuinsStructure::new);
    public static final int UNDAMAGED_STRUCTURE_CHANCE = 10;
    private static final ResourceLocation[] RUINS_NBT = new ResourceLocation[] {
            MTUtil.location("atlantean_ruins_1"),
            MTUtil.location("atlantean_ruins_2"),
            MTUtil.location("atlantean_ruins_3")};

    public AtlanteanRuinsStructure(Structure.StructureSettings settings) {
        super(settings);
    }

    @Override
    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext context) {
        Rotation rotation = Rotation.getRandom(context.random());
        float integrity = context.random().nextInt(UNDAMAGED_STRUCTURE_CHANCE) == 0
                ? 1.0F
                : Mth.lerp(context.random().nextFloat(), 0.6F, 0.8F);
        LevelHeightAccessor levelHeight = context.heightAccessor();
        int x = context.chunkPos().getMinBlockX();
        int z = context.chunkPos().getMinBlockZ();
        int y = context.chunkGenerator().getBaseHeight(
                x,
                z,
                Heightmap.Types.OCEAN_FLOOR_WG,
                levelHeight,
                context.randomState());

        if (y > context.chunkGenerator().getSeaLevel()) {
            return Optional.empty();
        } else {
            BlockPos templatePosition = new BlockPos(x, context.chunkGenerator().getMinY() + 15, z);
            ResourceLocation structureLocation = Util.getRandom(RUINS_NBT, context.random());
            return Optional.of(new Structure.GenerationStub(templatePosition, (piecesBuilder) ->
                    piecesBuilder.addPiece(new AtlanteanRuinsStructurePiece(
                            context.structureTemplateManager(),
                            structureLocation,
                            templatePosition,
                            rotation,
                            integrity))));
        }
    }

    @Override
    public StructureType<AtlanteanRuinsStructure> type() {
        return MTStructureTypes.ATLANTEAN_RUINS.get();
    }

    @Override
    public GenerationStep.Decoration step() {
        return GenerationStep.Decoration.UNDERGROUND_STRUCTURES;
    }
}
