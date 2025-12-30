package derekahedron.mythictinkers.datagen.models;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.block.MTBlocks;
import derekahedron.mythictinkers.item.MTItems;
import derekahedron.mythictinkers.util.MTUtil;
import com.github.alexmodguy.alexscaves.server.block.NeodymiumNodeBlock;
import com.github.alexmodguy.alexscaves.server.block.NeodymiumPillarBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class MTBlockStateProvider extends BlockStateProvider {

    public MTBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MythicTinkers.MOD_ID, existingFileHelper);
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    protected void registerStatesAndModels() {

        // Styx
        simpleBlock(MTBlocks.STYX.get(),
                fluid(MTBlocks.STYX.getId()));
        simpleBlockWithItem(MTBlocks.STYGIAN_DEEPSLATE.get(),
                cubeColumn(MTBlocks.STYGIAN_DEEPSLATE.getId()));
        simpleBlockWithItem(MTBlocks.STYGIAN_SCULK_STONE.get(),
                cubeAll(MTBlocks.STYGIAN_SCULK_STONE.getId()));
        simpleBlockWithItem(MTBlocks.STYGIAN_GLOOMSLATE.get(),
                cubeAll(MTBlocks.STYGIAN_GLOOMSLATE.getId()));

        // Dombstone
        simpleBlockWithItem(MTBlocks.DOMBSTONE.get(),
                cubeAll(MTBlocks.DOMBSTONE.getId()));
        stairsBlock(MTBlocks.DOMBSTONE_STAIRS.get(),
                MTBlocks.DOMBSTONE.getId().withPrefix("block/"));
        simpleBlockItem(
                MTBlocks.DOMBSTONE_STAIRS.get(),
                models().getExistingFile(MTItems.DOMBSTONE_STAIRS.getId()));
        slabBlock(MTBlocks.DOMBSTONE_SLAB.get(),
                MTBlocks.DOMBSTONE.getId().withPrefix("block/"),
                MTBlocks.DOMBSTONE.getId().withPrefix("block/"));
        simpleBlockItem(
                MTBlocks.DOMBSTONE_SLAB.get(),
                models().getExistingFile(MTItems.DOMBSTONE_SLAB.getId()));
        wallBlock(MTBlocks.DOMBSTONE_WALL.get(),
                MTBlocks.DOMBSTONE.getId().withPrefix("block/"));
        simpleBlockItem(MTBlocks.DOMBSTONE_WALL.get(),
                models().wallInventory(
                        MTBlocks.DOMBSTONE_WALL.getId().getPath(),
                        MTBlocks.DOMBSTONE.getId().withPrefix("block/")));

        // Dombstone Bricks
        simpleBlockWithItem(MTBlocks.DOMBSTONE_BRICKS.get(),
                cubeAll(MTBlocks.DOMBSTONE_BRICKS.getId()));
        stairsBlock(MTBlocks.DOMBSTONE_BRICK_STAIRS.get(),
                MTBlocks.DOMBSTONE_BRICKS.getId().withPrefix("block/"));
        simpleBlockItem(
                MTBlocks.DOMBSTONE_BRICK_STAIRS.get(),
                models().getExistingFile(MTItems.DOMBSTONE_BRICK_STAIRS.getId()));
        slabBlock(MTBlocks.DOMBSTONE_BRICK_SLAB.get(),
                MTBlocks.DOMBSTONE_BRICKS.getId().withPrefix("block/"),
                MTBlocks.DOMBSTONE_BRICKS.getId().withPrefix("block/"));
        simpleBlockItem(
                MTBlocks.DOMBSTONE_BRICK_SLAB.get(),
                models().getExistingFile(MTItems.DOMBSTONE_BRICK_SLAB.getId()));
        wallBlock(MTBlocks.DOMBSTONE_BRICK_WALL.get(),
                MTBlocks.DOMBSTONE_BRICKS.getId().withPrefix("block/"));
        simpleBlockItem(MTBlocks.DOMBSTONE_BRICK_WALL.get(),
                models().wallInventory(
                        MTBlocks.DOMBSTONE_BRICK_WALL.getId().getPath(),
                        MTBlocks.DOMBSTONE_BRICKS.getId().withPrefix("block/")));

        // Scarlet Neodymium
        simpleBlock(MTBlocks.MOLTEN_SCARLET_NEODYMIUM.get(),
                fluid(MTBlocks.MOLTEN_SCARLET_NEODYMIUM.getId()));

        // Azure Neodymium
        simpleBlock(MTBlocks.MOLTEN_AZURE_NEODYMIUM.get(),
                fluid(MTBlocks.MOLTEN_AZURE_NEODYMIUM.getId()));

        // Byzantium Neodymium
        simpleBlockWithItem(MTBlocks.BYZANTIUM_ENERGIZED_GALENA.get(),
                cubeColumn(MTBlocks.BYZANTIUM_ENERGIZED_GALENA.getId()));
        neodymiumNode(MTBlocks.BYZANTIUM_NEODYMIUM_NODE.get(),
                MTBlocks.BYZANTIUM_NEODYMIUM_NODE.getId());
        neodymiumPillar(MTBlocks.BYZANTIUM_NEODYMIUM_PILLAR.get(),
                MTBlocks.BYZANTIUM_NEODYMIUM_PILLAR.getId());
        simpleBlockWithItem(MTBlocks.BYZANTIUM_NEODYMIUM_BLOCK.get(),
                cubeAll(MTBlocks.BYZANTIUM_NEODYMIUM_BLOCK.getId()));
        simpleBlock(MTBlocks.MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                fluid(MTBlocks.MOLTEN_BYZANTIUM_NEODYMIUM.getId()));

        // Tectellus
        simpleBlockWithItem(MTBlocks.TECTELLUS_BLOCK.get(),
                cubeAll(MTBlocks.TECTELLUS_BLOCK.getId()));
        simpleBlockWithItem(MTBlocks.DORMANT_TECTELLUS_ORE.get(),
                cubeAll(MTBlocks.DORMANT_TECTELLUS_ORE.getId()));
        simpleBlockWithItem(MTBlocks.TECTELLUS_ORE.get(),
                cubeAll(MTBlocks.TECTELLUS_ORE.getId()));
        simpleBlockWithItem(MTBlocks.RAW_TECTELLUS_BLOCK.get(),
                cubeAll(MTBlocks.RAW_TECTELLUS_BLOCK.getId()));
        simpleBlock(MTBlocks.MOLTEN_TECTELLUS.get(),
                fluid(MTBlocks.MOLTEN_TECTELLUS.getId()));

        // Element 122
        simpleBlockWithItem(MTBlocks.ELEMENT_122_BLOCK.get(),
                fullbrightCubeAll(MTBlocks.ELEMENT_122_BLOCK.getId()));
        simpleBlockWithItem(MTBlocks.ELEMENT_122_ORE.get(),
                glowingCubeColumn(MTBlocks.ELEMENT_122_ORE.getId()));
        simpleBlockWithItem(MTBlocks.RAW_ELEMENT_122_BLOCK.get(),
                fullbrightCubeAll(MTBlocks.RAW_ELEMENT_122_BLOCK.getId()));
        simpleBlock(MTBlocks.MOLTEN_ELEMENT_122.get(),
                fluid(MTBlocks.MOLTEN_ELEMENT_122.getId()));

        // Atlantean Bricks
        simpleBlockWithItem(MTBlocks.ATLANTEAN_BRICKS.get(),
                cubeAll(MTBlocks.ATLANTEAN_BRICKS.getId()));
        simpleBlockWithItem(MTBlocks.CRACKED_ATLANTEAN_BRICKS.get(),
                cubeAll(MTBlocks.CRACKED_ATLANTEAN_BRICKS.getId()));
        stairsBlock(MTBlocks.ATLANTEAN_BRICK_STAIRS.get(),
                MTBlocks.ATLANTEAN_BRICKS.getId().withPrefix("block/"));
        simpleBlockItem(
                MTBlocks.ATLANTEAN_BRICK_STAIRS.get(),
                models().getExistingFile(MTItems.ATLANTEAN_BRICK_STAIRS.getId()));
        slabBlock(MTBlocks.ATLANTEAN_BRICK_SLAB.get(),
                MTBlocks.ATLANTEAN_BRICKS.getId().withPrefix("block/"),
                MTBlocks.ATLANTEAN_BRICKS.getId().withPrefix("block/"));
        simpleBlockItem(
                MTBlocks.ATLANTEAN_BRICK_SLAB.get(),
                models().getExistingFile(MTItems.ATLANTEAN_BRICK_SLAB.getId()));
        wallBlock(MTBlocks.ATLANTEAN_BRICK_WALL.get(),
                MTBlocks.ATLANTEAN_BRICKS.getId().withPrefix("block/"));
        simpleBlockItem(MTBlocks.ATLANTEAN_BRICK_WALL.get(),
                models().wallInventory(
                        MTBlocks.ATLANTEAN_BRICK_WALL.getId().getPath(),
                        MTBlocks.ATLANTEAN_BRICKS.getId().withPrefix("block/")));

        // Atlantean Tiles
        simpleBlockWithItem(MTBlocks.ATLANTEAN_TILES.get(),
                cubeAll(MTBlocks.ATLANTEAN_TILES.getId()));
        simpleBlockWithItem(MTBlocks.CRACKED_ATLANTEAN_TILES.get(),
                cubeAll(MTBlocks.CRACKED_ATLANTEAN_TILES.getId()));
        stairsBlock(MTBlocks.ATLANTEAN_TILE_STAIRS.get(),
                MTBlocks.ATLANTEAN_TILES.getId().withPrefix("block/"));
        simpleBlockItem(
                MTBlocks.ATLANTEAN_TILE_STAIRS.get(),
                models().getExistingFile(MTItems.ATLANTEAN_TILE_STAIRS.getId()));
        slabBlock(MTBlocks.ATLANTEAN_TILE_SLAB.get(),
                MTBlocks.ATLANTEAN_TILES.getId().withPrefix("block/"),
                MTBlocks.ATLANTEAN_TILES.getId().withPrefix("block/"));
        simpleBlockItem(
                MTBlocks.ATLANTEAN_TILE_SLAB.get(),
                models().getExistingFile(MTItems.ATLANTEAN_TILE_SLAB.getId()));
        wallBlock(MTBlocks.ATLANTEAN_TILE_WALL.get(),
                MTBlocks.ATLANTEAN_TILES.getId().withPrefix("block/"));
        simpleBlockItem(MTBlocks.ATLANTEAN_TILE_WALL.get(),
                models().wallInventory(
                        MTBlocks.ATLANTEAN_TILE_WALL.getId().getPath(),
                        MTBlocks.ATLANTEAN_TILES.getId().withPrefix("block/")));

        // Atlantean Pillar
        logBlock(MTBlocks.ATLANTEAN_PILLAR.get());
        simpleBlockItem(MTBlocks.ATLANTEAN_PILLAR.get(),
                models().getExistingFile(MTItems.ATLANTEAN_PILLAR.getId()));
        logBlock(MTBlocks.CRACKED_ATLANTEAN_PILLAR.get());
        simpleBlockItem(MTBlocks.CRACKED_ATLANTEAN_PILLAR.get(),
                models().getExistingFile(MTItems.CRACKED_ATLANTEAN_PILLAR.getId()));

        // Aurichalcum
        simpleBlockWithItem(MTBlocks.AURICHALCUM_BLOCK.get(),
                cubeAll(MTBlocks.AURICHALCUM_BLOCK.getId()));
        simpleBlock(MTBlocks.MOLTEN_AURICHALCUM.get(),
                fluid(MTBlocks.MOLTEN_AURICHALCUM.getId()));

        // Desolum
        simpleBlockWithItem(MTBlocks.DESOLUM_BLOCK.get(),
                cubeAll(MTBlocks.DESOLUM_BLOCK.getId()));
        simpleBlock(MTBlocks.MOLTEN_DESOLUM.get(),
                fluid(MTBlocks.MOLTEN_DESOLUM.getId()));

        // Pure Light
        variantsBlockWithItem(MTBlocks.IMPRISONING_COPROLITH.get(),
                models().getBuilder(MTBlocks.IMPRISONING_COPROLITH.getId().withSuffix("_0").getPath())
                        .parent(imprisoningCoprolithBase())
                        .texture("outside", MTBlocks.IMPRISONING_COPROLITH.getId().withPrefix("block/").withSuffix("_0"))
                        .texture("inside", MTBlocks.IMPRISONING_COPROLITH.getId().withPrefix("block/").withSuffix("_inside"))
                        .texture("eyes", MTBlocks.IMPRISONING_COPROLITH.getId().withPrefix("block/").withSuffix("_eyes_0")),
                models().getBuilder(MTBlocks.IMPRISONING_COPROLITH.getId().withSuffix("_1").getPath())
                        .parent(imprisoningCoprolithBase())
                        .texture("outside", MTBlocks.IMPRISONING_COPROLITH.getId().withPrefix("block/").withSuffix("_1"))
                        .texture("inside", MTBlocks.IMPRISONING_COPROLITH.getId().withPrefix("block/").withSuffix("_inside"))
                        .texture("eyes", MTBlocks.IMPRISONING_COPROLITH.getId().withPrefix("block/").withSuffix("_eyes_1")));

        // Prosprum
        simpleBlockWithItem(MTBlocks.PROSPRUM_BLOCK.get(),
                cubeAll(MTBlocks.PROSPRUM_BLOCK.getId()));
        simpleBlock(MTBlocks.MOLTEN_PROSPRUM.get(),
                fluid(MTBlocks.MOLTEN_PROSPRUM.getId()));

        // Earthen Gum
        simpleBlockWithItem(MTBlocks.EARTHEN_GUM_BLOCK.get(),
                cubeAll(MTBlocks.EARTHEN_GUM_BLOCK.getId()));
        simpleBlockWithItem(MTBlocks.EARTHEN_GUM_ORE.get(),
                cubeColumn(MTBlocks.EARTHEN_GUM_ORE.getId()));
        simpleBlock(MTBlocks.EARTHEN_GUM.get(),
                fluid(MTBlocks.EARTHEN_GUM.getId()));

        // Gumbronze
        simpleBlockWithItem(MTBlocks.GUMBRONZE_BLOCK.get(),
                cubeAll(MTBlocks.GUMBRONZE_BLOCK.getId()));
        simpleBlock(MTBlocks.MOLTEN_GUMBRONZE.get(),
                fluid(MTBlocks.MOLTEN_GUMBRONZE.getId()));
    }

    public void variantsBlockWithItem(Block block, ModelFile... models) {
        assert models.length > 0;

        VariantBlockStateBuilder builder = getVariantBuilder(block);
        for (ModelFile model : models) {
            builder.partialState().addModels(new ConfiguredModel(model));
        }

        simpleBlockItem(block, models[0]);
    }

    public BlockModelBuilder fluid(ResourceLocation id) {
        return models().getBuilder(id.getPath())
                        .texture("particle", id.withPrefix("block/").withSuffix("_still"));
    }

    public void neodymiumNode(Block block, ResourceLocation id) {
        ResourceLocation side0 = id.withPrefix("block/").withSuffix("_side_0");
        ResourceLocation side1 = id.withPrefix("block/").withSuffix("_side_1");
        ResourceLocation side2 = id.withPrefix("block/").withSuffix("_side_2");
        ResourceLocation side3 = id.withPrefix("block/").withSuffix("_side_3");
        ResourceLocation side4 = id.withPrefix("block/").withSuffix("_side_4");
        ResourceLocation side5 = id.withPrefix("block/").withSuffix("_side_5");
        ResourceLocation side6 = id.withPrefix("block/").withSuffix("_side_6");

        ModelFile model0 = models()
                .getBuilder(id.withSuffix("_0").getPath())
                .parent(new ModelFile.UncheckedModelFile("alexscaves:block/neodymium_node_0"))
                .texture("1", side0)
                .texture("2", side1)
                .texture("3", side2)
                .texture("4", side3)
                .texture("5", side4)
                .texture("6", side5)
                .texture("7", side6)
                .texture("particle", side0);
        ModelFile model1 = models()
                .getBuilder(id.withSuffix("_1").getPath())
                .parent(new ModelFile.UncheckedModelFile("alexscaves:block/neodymium_node_1"))
                .texture("1", side0)
                .texture("2", side1)
                .texture("3", side2)
                .texture("4", side3)
                .texture("5", side4)
                .texture("6", side5)
                .texture("7", side6)
                .texture("particle", side0);
        ModelFile model2 = models()
                .getBuilder(id.withSuffix("_2").getPath())
                .parent(new ModelFile.UncheckedModelFile("alexscaves:block/neodymium_node_2"))
                .texture("1", side0)
                .texture("2", side1)
                .texture("3", side2)
                .texture("4", side3)
                .texture("5", side4)
                .texture("6", side5)
                .texture("7", side6)
                .texture("particle", side0);

        getVariantBuilder(block)
                .partialState().with(NeodymiumNodeBlock.FACING, Direction.DOWN).addModels(
                        new ConfiguredModel(model0, 180, 0, false),
                        new ConfiguredModel(model1, 180, 0, false),
                        new ConfiguredModel(model2, 180, 0, false)
                )
                .partialState().with(NeodymiumNodeBlock.FACING, Direction.EAST).addModels(
                        new ConfiguredModel(model0, 90, 90, false),
                        new ConfiguredModel(model1, 90, 90, false),
                        new ConfiguredModel(model2, 90, 90, false)
                )
                .partialState().with(NeodymiumNodeBlock.FACING, Direction.NORTH).addModels(
                        new ConfiguredModel(model0, 90, 0, false),
                        new ConfiguredModel(model1, 90, 0, false),
                        new ConfiguredModel(model2, 90, 0, false)
                )
                .partialState().with(NeodymiumNodeBlock.FACING, Direction.SOUTH).addModels(
                        new ConfiguredModel(model0, 270, 0, false),
                        new ConfiguredModel(model1, 270, 0, false),
                        new ConfiguredModel(model2, 270, 0, false)
                )
                .partialState().with(NeodymiumNodeBlock.FACING, Direction.UP).addModels(
                        new ConfiguredModel(model0),
                        new ConfiguredModel(model1),
                        new ConfiguredModel(model2)
                )
                .partialState().with(NeodymiumNodeBlock.FACING, Direction.WEST).addModels(
                        new ConfiguredModel(model0, 90, 270, false),
                        new ConfiguredModel(model1, 90, 270, false),
                        new ConfiguredModel(model2, 90, 270, false)
                );

        simpleBlockItem(block, model0);
    }

    public void neodymiumPillar(Block block, ResourceLocation id) {
        ResourceLocation side = id.withPrefix("block/").withSuffix("_side");
        ResourceLocation sideTop = id.withPrefix("block/").withSuffix("_side_top");
        ResourceLocation bottom = id.withPrefix("block/").withSuffix("_bottom");
        ResourceLocation top = id.withPrefix("block/").withSuffix("_top");

        ModelFile model = models().cubeBottomTop(
                id.getPath(),
                side,
                bottom,
                top);
        ModelFile topModel = models().cubeBottomTop(
                id.withSuffix("_top").getPath(),
                sideTop,
                bottom,
                top);

        getVariantBuilder(block)
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.DOWN)
                .with(NeodymiumPillarBlock.TOP, false)
                .addModels(new ConfiguredModel(model, 180, 0, false))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.EAST)
                .with(NeodymiumPillarBlock.TOP, false)
                .addModels(new ConfiguredModel(model, 90, 90, false))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.NORTH)
                .with(NeodymiumPillarBlock.TOP, false)
                .addModels(new ConfiguredModel(model, 90, 0, false))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.SOUTH)
                .with(NeodymiumPillarBlock.TOP, false)
                .addModels(new ConfiguredModel(model, 270, 0, false))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.UP)
                .with(NeodymiumPillarBlock.TOP, false)
                .addModels(new ConfiguredModel(model))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.WEST)
                .with(NeodymiumPillarBlock.TOP, false)
                .addModels(new ConfiguredModel(model, 90, 270, false))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.DOWN)
                .with(NeodymiumPillarBlock.TOP, true)
                .addModels(new ConfiguredModel(topModel, 180, 0, false))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.EAST)
                .with(NeodymiumPillarBlock.TOP, true)
                .addModels(new ConfiguredModel(topModel, 90, 90, false))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.NORTH)
                .with(NeodymiumPillarBlock.TOP, true)
                .addModels(new ConfiguredModel(topModel, 90, 0, false))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.SOUTH)
                .with(NeodymiumPillarBlock.TOP, true)
                .addModels(new ConfiguredModel(topModel, 270, 0, false))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.UP)
                .with(NeodymiumPillarBlock.TOP, true)
                .addModels(new ConfiguredModel(topModel))
                .partialState()
                .with(NeodymiumPillarBlock.FACING, Direction.WEST)
                .with(NeodymiumPillarBlock.TOP, true)
                .addModels(new ConfiguredModel(topModel, 90, 270, false));

        simpleBlockItem(block, topModel);
    }

    public ModelFile imprisoningCoprolithBase() {
        return getOrCreate(MTUtil.location("imprisoning_coprolith_base"), builder ->
                builder.parent(new ModelFile.UncheckedModelFile(new ResourceLocation("block/block")))
                        .renderType(new ResourceLocation("cutout"))
                        .texture("particle", "#outside")
                        .ao(false)
                        .element()
                        .from(0, 0, 0)
                        .to(16, 16, 16)
                        .textureAll("#outside")
                        .face(Direction.UP).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).end()
                        .end()
                        .element()
                        .from(15.99F, 15.99F, 15.99F)
                        .to(0.01F, 0.01F, 0.01F)
                        .shade(false)
                        .allFaces(((direction, faceBuilder) -> faceBuilder
                                .texture("#inside")
                                .emissivity(15, 0)))
                        .end()
                        .element()
                        .from(1, 0, 0)
                        .to(15, 16, 16)
                        .shade(false)
                        .face(Direction.EAST).cullface(Direction.EAST).texture("#eyes").emissivity(15, 0).end()
                        .face(Direction.WEST).cullface(Direction.WEST).texture("#eyes").emissivity(15, 0).end()
                        .end()
                        .element()
                        .from(0, 1, 0)
                        .to(16, 15, 16)
                        .shade(false)
                        .face(Direction.UP).cullface(Direction.UP).texture("#eyes").emissivity(15, 0).rotation(ModelBuilder.FaceRotation.CLOCKWISE_90).end()
                        .face(Direction.DOWN).cullface(Direction.DOWN).texture("#eyes").emissivity(15, 0).end()
                        .end()
                        .element()
                        .from(0, 0, 1)
                        .to(16, 16, 15)
                        .shade(false)
                        .face(Direction.NORTH).cullface(Direction.NORTH).texture("#eyes").emissivity(15, 0).end()
                        .face(Direction.SOUTH).cullface(Direction.SOUTH).texture("#eyes").emissivity(15, 0).end()
                        .end());
    }

    public ModelFile fullbrightCubeAllBase() {
        return getOrCreate(MTUtil.location("fullbright_cube_all"), builder ->
                builder.parent(new ModelFile.UncheckedModelFile(new ResourceLocation("block/block")))
                        .texture("particle", "#all")
                        .element()
                        .from(0, 0, 0)
                        .to(16, 16, 16)
                        .shade(false)
                        .ao(false)
                        .allFaces(((direction, faceBuilder) -> faceBuilder
                                .cullface(direction)
                                .texture("#all")
                                .emissivity(15, 0)))
                        .end());
    }

    public ModelFile fullbrightCubeAll(ResourceLocation id) {
        return models().getBuilder(id.getPath())
                .parent(fullbrightCubeAllBase())
                .texture("all", id.withPrefix("block/"));
    }

    public BlockModelBuilder cubeAll(ResourceLocation id) {
        return models().cubeAll(
                id.getPath(),
                id.withPrefix("block/"));
    }

    public BlockModelBuilder cubeColumn(ResourceLocation id) {
        return models().cubeColumn(
                id.getPath(),
                id.withPrefix("block/"),
                id.withPrefix("block/").withSuffix("_top"));
    }

    public BlockModelBuilder glowingCubeColumn(ResourceLocation id) {
        BlockModelBuilder model = models().getBuilder(id.getPath())
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation("block/block")))
                .ao(false)
                .renderType(new ResourceLocation("cutout"))
                .texture("side", id.withPrefix("block/"))
                .texture("end", id.withPrefix("block/").withSuffix("_top"))
                .texture("particle", id.withPrefix("block/"))
                .texture("fullbright", id.withPrefix("block/").withSuffix("_glow"));
        model.element()
                .from(0, 0, 0)
                .to(16, 16, 16)
                .allFaces((direction, builder) ->
                        builder.texture(direction.getAxis().isVertical() ? "#end" : "#side").cullface(direction));
        model.element()
                .from(0, 0, 0)
                .to(16, 16, 16)
                .shade(false)
                .allFaces((direction, builder) ->
                        builder
                                .texture("#fullbright")
                                .cullface(direction)
                                .emissivity(15, 0));
        return model;
    }

    public ModelFile getOrCreate(ResourceLocation id, Consumer<BlockModelBuilder> consumer) {
        try {
            return models().getExistingFile(id);
        } catch (IllegalStateException e) {
            BlockModelBuilder builder = models().getBuilder(id.getPath());
            consumer.accept(builder);
            return builder;
        }
    }
}
