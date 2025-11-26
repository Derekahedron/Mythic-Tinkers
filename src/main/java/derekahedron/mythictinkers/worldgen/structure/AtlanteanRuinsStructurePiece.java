package derekahedron.mythictinkers.worldgen.structure;

import derekahedron.mythictinkers.worldgen.structure.processor.AtlanteanRuinsProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;
import net.minecraft.world.level.material.FluidState;

public class AtlanteanRuinsStructurePiece extends TemplateStructurePiece {
    public final float integrity;

    public AtlanteanRuinsStructurePiece(
            StructureTemplateManager manager, ResourceLocation resourceLocation,
            BlockPos pos, Rotation rotation, float integrity) {
        super(
                MTStructurePieceTypes.ATLANTEAN_RUINS.get(),
                0,
                manager,
                resourceLocation,
                resourceLocation.toString(),
                makeSettings(rotation, integrity), pos);
        this.integrity = integrity;
    }

    public AtlanteanRuinsStructurePiece(
            StructureTemplateManager manager, CompoundTag tag,
            Rotation rotation, float integrity) {
        super(
                MTStructurePieceTypes.ATLANTEAN_RUINS.get(),
                tag,
                manager,
                (location) -> makeSettings(rotation, integrity));
        this.integrity = integrity;
    }

    public static AtlanteanRuinsStructurePiece create(StructurePieceSerializationContext context, CompoundTag tag) {
        Rotation rotation = Rotation.valueOf(tag.getString("Rotation"));
        float integrity = tag.getFloat("Integrity");
        return new AtlanteanRuinsStructurePiece(context.structureTemplateManager(), tag, rotation, integrity);
    }

    private static StructurePlaceSettings makeSettings(Rotation rotation, float integrity) {
        return new StructurePlaceSettings()
                .setRotation(rotation)
                .addProcessor(new AtlanteanRuinsProcessor(integrity))
                .setMirror(Mirror.NONE)
                .setKeepLiquids(true);
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext context, CompoundTag tag) {
        super.addAdditionalSaveData(context, tag);
        tag.putString("Rotation", placeSettings.getRotation().name());
        tag.putFloat("Integrity", integrity);
    }

    @Override
    public void postProcess(
            WorldGenLevel level, StructureManager structureManager,
            ChunkGenerator chunkGenerator, RandomSource random, BoundingBox boundingBox,
            ChunkPos chunkPos, BlockPos pos) {
        int y = level.getHeight(
                Heightmap.Types.OCEAN_FLOOR_WG,
                templatePosition.getX(),
                templatePosition.getZ());
        templatePosition = templatePosition.atY(y);

        BlockPos cornerPosition = StructureTemplate.transform(
                new BlockPos(
                        templatePosition.getX() + template.getSize().getX() - 1,
                        templatePosition.getY(),
                        templatePosition.getZ() + template.getSize().getZ() - 1),
                Mirror.NONE,
                placeSettings.getRotation(),
                templatePosition
        );

        templatePosition = new BlockPos(
                templatePosition.getX(),
                getHeight(templatePosition, level, cornerPosition),
                templatePosition.getZ());

        if (templatePosition.getY() > chunkGenerator.getSeaLevel() - 40) {
            templatePosition = templatePosition.atY(-128);
        }

        super.postProcess(level, structureManager, chunkGenerator, random, boundingBox, chunkPos, pos);
    }

    @Override
    protected void handleDataMarker(
            String dataMarker, BlockPos pos, ServerLevelAccessor level,
            RandomSource random, BoundingBox boundingBox) {
        level.setBlock(pos, Blocks.CAVE_AIR.defaultBlockState(), 0);
    }

    public static int getHeight(BlockPos templatePos, BlockGetter level, BlockPos cornerPos) {
        int y = templatePos.getY();
        int minY = y;
        int numElevatedBlocks = 0;

        for (BlockPos pos : BlockPos.betweenClosed(templatePos, cornerPos)) {
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos(pos.getX(), y - 1, pos.getZ());
            BlockState blockState;
            FluidState fluidState;
            int depth = 0;

            while (mutable.getY() >= level.getMinBuildHeight() + 1) {
                blockState = level.getBlockState(mutable);
                fluidState = level.getFluidState(mutable);
                if (!blockState.isAir() && !fluidState.is(FluidTags.WATER) && !blockState.is(BlockTags.ICE)) {
                    break;
                }
                mutable.move(Direction.DOWN);
                depth++;
            }

            minY = Math.min(minY, mutable.getY() + 1);
            if (depth > 2) {
                numElevatedBlocks++;
            }
        }

        int size = Math.abs(templatePos.getX() - cornerPos.getX());
        if (y - minY > 2 && numElevatedBlocks > size - 2) {
            y = minY;
        }

        return y;
    }
}
