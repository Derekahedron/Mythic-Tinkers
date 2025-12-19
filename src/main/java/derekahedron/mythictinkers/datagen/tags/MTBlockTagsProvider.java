package derekahedron.mythictinkers.datagen.tags;

import derekahedron.mythictinkers.block.MTBlockTags;
import derekahedron.mythictinkers.block.MTBlocks;
import derekahedron.mythictinkers.util.CompatUtil;
import derekahedron.mythictinkers.util.ForgeTags;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry;
import com.kyanite.deeperdarker.content.DDBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.common.registration.GeodeItemObject;
import slimeknights.tconstruct.shared.TinkerMaterials;
import slimeknights.tconstruct.world.TinkerWorld;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class MTBlockTagsProvider extends BlockTagsProvider {

    public MTBlockTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, derekahedron.mythictinkers.MythicTinkers.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return String.format("%s Block Tags", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    protected void addTags(HolderLookup.Provider lookupProvider) {
        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(MTBlocks.BYZANTIUM_NEODYMIUM_BLOCK.get())
                .add(MTBlocks.TECTELLUS_BLOCK.get())
                .add(MTBlocks.ELEMENT_122_BLOCK.get())
                .add(MTBlocks.AURICHALCUM_BLOCK.get())
                .add(MTBlocks.DESOLUM_BLOCK.get())
                .add(MTBlocks.PROSPRUM_BLOCK.get())
                .add(MTBlocks.GUMBRONZE_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(MTBlocks.STYGIAN_DEEPSLATE.get())
                .add(MTBlocks.STYGIAN_SCULK_STONE.get())
                .add(MTBlocks.STYGIAN_GLOOMSLATE.get())

                .add(MTBlocks.DOMBSTONE.get())
                .add(MTBlocks.DOMBSTONE_STAIRS.get())
                .add(MTBlocks.DOMBSTONE_SLAB.get())
                .add(MTBlocks.DOMBSTONE_WALL.get())
                .add(MTBlocks.DOMBSTONE_BRICKS.get())
                .add(MTBlocks.DOMBSTONE_BRICK_STAIRS.get())
                .add(MTBlocks.DOMBSTONE_BRICK_SLAB.get())
                .add(MTBlocks.DOMBSTONE_BRICK_WALL.get())

                .add(MTBlocks.BYZANTIUM_ENERGIZED_GALENA.get())
                .add(MTBlocks.BYZANTIUM_NEODYMIUM_NODE.get())
                .add(MTBlocks.BYZANTIUM_NEODYMIUM_PILLAR.get())
                .add(MTBlocks.BYZANTIUM_NEODYMIUM_BLOCK.get())

                .add(MTBlocks.RAW_TECTELLUS_BLOCK.get())
                .add(MTBlocks.DORMANT_TECTELLUS_ORE.get())
                .add(MTBlocks.TECTELLUS_ORE.get())
                .add(MTBlocks.TECTELLUS_BLOCK.get())

                .add(MTBlocks.ELEMENT_122_BLOCK.get())
                .add(MTBlocks.ELEMENT_122_ORE.get())
                .add(MTBlocks.RAW_ELEMENT_122_BLOCK.get())

                .add(MTBlocks.ATLANTEAN_BRICKS.get())
                .add(MTBlocks.CRACKED_ATLANTEAN_BRICKS.get())
                .add(MTBlocks.ATLANTEAN_BRICK_STAIRS.get())
                .add(MTBlocks.ATLANTEAN_BRICK_SLAB.get())
                .add(MTBlocks.ATLANTEAN_BRICK_WALL.get())
                .add(MTBlocks.ATLANTEAN_TILES.get())
                .add(MTBlocks.CRACKED_ATLANTEAN_TILES.get())
                .add(MTBlocks.ATLANTEAN_TILE_STAIRS.get())
                .add(MTBlocks.ATLANTEAN_TILE_SLAB.get())
                .add(MTBlocks.ATLANTEAN_TILE_WALL.get())
                .add(MTBlocks.ATLANTEAN_PILLAR.get())
                .add(MTBlocks.CRACKED_ATLANTEAN_PILLAR.get())

                .add(MTBlocks.AURICHALCUM_BLOCK.get())

                .add(MTBlocks.DESOLUM_BLOCK.get())

                .add(MTBlocks.IMPRISONING_COPROLITH.get())

                .add(MTBlocks.PROSPRUM_BLOCK.get())

                .add(MTBlocks.GUMBRONZE_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(MTBlocks.EARTHEN_GUM_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(MTBlocks.DESOLUM_BLOCK.get());

        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(MTBlocks.STYGIAN_DEEPSLATE.get())
                .add(MTBlocks.STYGIAN_SCULK_STONE.get())
                .add(MTBlocks.STYGIAN_GLOOMSLATE.get())

                .add(MTBlocks.BYZANTIUM_ENERGIZED_GALENA.get())
                .add(MTBlocks.BYZANTIUM_NEODYMIUM_NODE.get())
                .add(MTBlocks.BYZANTIUM_NEODYMIUM_PILLAR.get())
                .add(MTBlocks.BYZANTIUM_NEODYMIUM_BLOCK.get())

                .add(MTBlocks.DORMANT_TECTELLUS_ORE.get())
                .add(MTBlocks.TECTELLUS_ORE.get())
                .add(MTBlocks.RAW_TECTELLUS_BLOCK.get())
                .add(MTBlocks.TECTELLUS_BLOCK.get())

                .add(MTBlocks.RAW_ELEMENT_122_BLOCK.get())
                .add(MTBlocks.ELEMENT_122_ORE.get())
                .add(MTBlocks.ELEMENT_122_BLOCK.get())

                .add(MTBlocks.ATLANTEAN_BRICKS.get())
                .add(MTBlocks.CRACKED_ATLANTEAN_BRICKS.get())
                .add(MTBlocks.ATLANTEAN_BRICK_STAIRS.get())
                .add(MTBlocks.ATLANTEAN_BRICK_SLAB.get())
                .add(MTBlocks.ATLANTEAN_BRICK_WALL.get())
                .add(MTBlocks.ATLANTEAN_TILES.get())
                .add(MTBlocks.CRACKED_ATLANTEAN_TILES.get())
                .add(MTBlocks.ATLANTEAN_TILE_STAIRS.get())
                .add(MTBlocks.ATLANTEAN_TILE_SLAB.get())
                .add(MTBlocks.ATLANTEAN_TILE_WALL.get())
                .add(MTBlocks.ATLANTEAN_PILLAR.get())
                .add(MTBlocks.CRACKED_ATLANTEAN_PILLAR.get())

                .add(MTBlocks.AURICHALCUM_BLOCK.get())

                .add(MTBlocks.IMPRISONING_COPROLITH.get())

                .add(MTBlocks.PROSPRUM_BLOCK.get())

                .add(MTBlocks.EARTHEN_GUM_ORE.get())

                .add(MTBlocks.GUMBRONZE_BLOCK.get());

        tag(BlockTags.STAIRS)
                .add(MTBlocks.DOMBSTONE_STAIRS.get())
                .add(MTBlocks.DOMBSTONE_BRICK_STAIRS.get())
                .add(MTBlocks.ATLANTEAN_BRICK_STAIRS.get())
                .add(MTBlocks.ATLANTEAN_TILE_STAIRS.get());

        tag(BlockTags.SLABS)
                .add(MTBlocks.DOMBSTONE_SLAB.get())
                .add(MTBlocks.DOMBSTONE_BRICK_SLAB.get())
                .add(MTBlocks.ATLANTEAN_BRICK_SLAB.get())
                .add(MTBlocks.ATLANTEAN_TILE_SLAB.get());

        tag(BlockTags.WALLS)
                .add(MTBlocks.DOMBSTONE_WALL.get())
                .add(MTBlocks.DOMBSTONE_BRICK_WALL.get())
                .add(MTBlocks.ATLANTEAN_BRICK_WALL.get())
                .add(MTBlocks.ATLANTEAN_TILE_WALL.get());

        tag(ForgeTags.Blocks.STYX_ORES)
                .add(MTBlocks.STYGIAN_DEEPSLATE.get())
                .add(MTBlocks.STYGIAN_SCULK_STONE.get())
                .add(MTBlocks.STYGIAN_GLOOMSLATE.get());

        tag(ForgeTags.Blocks.BYZANTIUM_NEODYMIUM_BLOCKS)
                .add(MTBlocks.BYZANTIUM_NEODYMIUM_BLOCK.get());

        tag(ForgeTags.Blocks.TECTELLUS_BLOCKS)
                .add(MTBlocks.TECTELLUS_BLOCK.get());
        tag(ForgeTags.Blocks.TECTELLUS_ORES)
                .add(MTBlocks.TECTELLUS_ORE.get());
        tag(ForgeTags.Blocks.RAW_TECTELLUS_BLOCKS)
                .add(MTBlocks.RAW_TECTELLUS_BLOCK.get());

        tag(ForgeTags.Blocks.ELEMENT_122_BLOCKS)
                .add(MTBlocks.ELEMENT_122_BLOCK.get());
        tag(ForgeTags.Blocks.ELEMENT_122_ORES)
                .add(MTBlocks.ELEMENT_122_ORE.get());
        tag(ForgeTags.Blocks.RAW_ELEMENT_122_BLOCKS)
                .add(MTBlocks.RAW_ELEMENT_122_BLOCK.get());

        tag(ForgeTags.Blocks.AURICHALCUM_BLOCKS)
                .add(MTBlocks.AURICHALCUM_BLOCK.get());

        tag(ForgeTags.Blocks.DESOLUM_BLOCKS)
                .add(MTBlocks.DESOLUM_BLOCK.get());

        tag(ForgeTags.Blocks.PROSPRUM_BLOCKS)
                .add(MTBlocks.PROSPRUM_BLOCK.get());

        tag(ForgeTags.Blocks.EARTHEN_GUM_BLOCKS)
                .add(MTBlocks.EARTHEN_GUM_BLOCK.get());
        tag(ForgeTags.Blocks.EARTHEN_GUM_ORES)
                .add(MTBlocks.EARTHEN_GUM_ORE.get());

        tag(ForgeTags.Blocks.GUMBRONZE_BLOCKS)
                .add(MTBlocks.GUMBRONZE_BLOCK.get());

        tag(Tags.Blocks.ORES)
                .add(MTBlocks.IMPRISONING_COPROLITH.get())
                .addTag(ForgeTags.Blocks.STYX_ORES)
                .addTag(ForgeTags.Blocks.TECTELLUS_ORES)
                .addTag(ForgeTags.Blocks.ELEMENT_122_ORES)
                .addTag(ForgeTags.Blocks.EARTHEN_GUM_ORES);

        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(ForgeTags.Blocks.BYZANTIUM_NEODYMIUM_BLOCKS)
                .addTag(ForgeTags.Blocks.TECTELLUS_BLOCKS)
                .addTag(ForgeTags.Blocks.RAW_TECTELLUS_BLOCKS)
                .addTag(ForgeTags.Blocks.ELEMENT_122_BLOCKS)
                .addTag(ForgeTags.Blocks.RAW_ELEMENT_122_BLOCKS)
                .addTag(ForgeTags.Blocks.AURICHALCUM_BLOCKS)
                .addTag(ForgeTags.Blocks.DESOLUM_BLOCKS)
                .addTag(ForgeTags.Blocks.PROSPRUM_BLOCKS)
                .addTag(ForgeTags.Blocks.EARTHEN_GUM_BLOCKS)
                .addTag(ForgeTags.Blocks.GUMBRONZE_BLOCKS);

        tag(ACTagRegistry.MAGNETIC_BLOCKS)
                .addOptionalTag(TinkerMaterials.slimesteel.getBlockTag())
                .addOptionalTag(TinkerMaterials.pigIron.getBlockTag())
                .addOptionalTag(TinkerMaterials.cobalt.getBlockTag())
                .addOptionalTag(TinkerMaterials.manyullyn.getBlockTag())
                .addOptionalTag(TinkerMaterials.hepatizon.getBlockTag())
                .addOptionalTag(TinkerMaterials.slimesteel.getBlockTag());

        tag(TinkerTags.Blocks.WORKSTATION_ROCK)
                .add(MTBlocks.DOMBSTONE.get());

        tag(TinkerTags.Blocks.ANVIL_METAL)
                .addTag(ForgeTags.Blocks.BYZANTIUM_NEODYMIUM_BLOCKS)
                .addTag(ForgeTags.Blocks.TECTELLUS_BLOCKS)
                .addTag(ForgeTags.Blocks.ELEMENT_122_BLOCKS)
                .addTag(ForgeTags.Blocks.AURICHALCUM_BLOCKS)
                .addTag(ForgeTags.Blocks.DESOLUM_BLOCKS)
                .addTag(ForgeTags.Blocks.PROSPRUM_BLOCKS)
                .addTag(ForgeTags.Blocks.GUMBRONZE_BLOCKS);

        tag(MTBlockTags.SCULK_STONE)
                .addOptional(DDBlocks.SCULK_STONE.getId());
        tag(MTBlockTags.GLOOMSLATE)
                .addOptional(DDBlocks.GLOOMSLATE.getId());

        tag(MTBlockTags.DOMBSTONE)
                .add(MTBlocks.DOMBSTONE.get())
                .add(MTBlocks.DOMBSTONE_STAIRS.get())
                .add(MTBlocks.DOMBSTONE_SLAB.get())
                .add(MTBlocks.DOMBSTONE_WALL.get())
                .addTag(MTBlockTags.DOMBSTONE_BRICKS);

        tag(MTBlockTags.DOMBSTONE_BRICKS)
                .add(MTBlocks.DOMBSTONE_BRICKS.get())
                .add(MTBlocks.DOMBSTONE_BRICK_STAIRS.get())
                .add(MTBlocks.DOMBSTONE_BRICK_SLAB.get())
                .add(MTBlocks.DOMBSTONE_BRICK_WALL.get());

        tag(MTBlockTags.ENERGIZED_GALENA)
                .add(ACBlockRegistry.ENERGIZED_GALENA_SCARLET.get())
                .add(ACBlockRegistry.ENERGIZED_GALENA_AZURE.get())
                .add(ACBlockRegistry.ENERGIZED_GALENA_NEUTRAL.get())
                .add(MTBlocks.BYZANTIUM_ENERGIZED_GALENA.get());

        tag(MTBlockTags.TERRAFORMABLE)
                .addTag(BlockTags.BASE_STONE_OVERWORLD)
                .addTag(BlockTags.BASE_STONE_NETHER)
                .addTag(Tags.Blocks.ORES)
                .add(Blocks.PACKED_MUD)
                .add(Blocks.SANDSTONE)
                .add(Blocks.RED_SANDSTONE)
                .add(Blocks.AMETHYST_BLOCK)
                .add(Blocks.GLOWSTONE)
                .add(Blocks.BUDDING_AMETHYST)
                .add(Blocks.SMALL_AMETHYST_BUD)
                .add(Blocks.MEDIUM_AMETHYST_BUD)
                .add(Blocks.LARGE_AMETHYST_BUD)
                .add(Blocks.AMETHYST_CLUSTER)
                .add(Blocks.DRIPSTONE_BLOCK)
                .add(Blocks.POINTED_DRIPSTONE)
                .add(Blocks.ICE)
                .add(Blocks.PACKED_ICE)
                .add(Blocks.BLUE_ICE)
                .add(Blocks.CALCITE)
                .add(Blocks.SMOOTH_BASALT)
                .add(Blocks.END_STONE)
                .add(Blocks.OBSIDIAN)
                .add(Blocks.CRYING_OBSIDIAN)
                .addTag(Tags.Blocks.STONE)
                .add(Blocks.OBSIDIAN)
                .addTag(MTBlockTags.ENERGIZED_GALENA)
                .add(ACBlockRegistry.AMBER.get())
                .add(ACBlockRegistry.AMBERSOL.get())
                .add(ACBlockRegistry.PRIMAL_MAGMA.get())
                .add(ACBlockRegistry.FLOOD_BASALT.get())
                .add(ACBlockRegistry.ACIDIC_RADROCK.get())
                .add(ACBlockRegistry.GEOTHERMAL_VENT.get())
                .add(ACBlockRegistry.GEOTHERMAL_VENT_MEDIUM.get())
                .add(ACBlockRegistry.GEOTHERMAL_VENT_THIN.get())
                .add(ACBlockRegistry.SULFUR.get())
                .add(ACBlockRegistry.SULFUR_BUD_SMALL.get())
                .add(ACBlockRegistry.SULFUR_BUD_MEDIUM.get())
                .add(ACBlockRegistry.SULFUR_BUD_LARGE.get())
                .add(ACBlockRegistry.SULFUR_CLUSTER.get())
                .add(ACBlockRegistry.ABYSSMARINE.get())
                .add(ACBlockRegistry.GUANOSTONE.get())
                .add(ACBlockRegistry.COPROLITH.get())
                .add(ACBlockRegistry.POROUS_COPROLITH.get())
                .add(ACBlockRegistry.PEERING_COPROLITH.get())
                .addOptional(CompatUtil.biomesOPlenty("white_sandstone"))
                .addOptional(CompatUtil.biomesOPlenty("orange_sandstone"))
                .addOptional(CompatUtil.biomesOPlenty("black_sandstone"))
                .addOptional(CompatUtil.biomesOPlenty("thermal_calcite"))
                .addOptional(CompatUtil.biomesOPlenty("thermal_calcite_vent"))
                .addOptional(CompatUtil.biomesOPlenty("brimstone"))
                .addOptional(CompatUtil.biomesOPlenty("brimstone_fumarole"))
                .addOptional(CompatUtil.biomesOPlenty("brimstone_cluster"))
                .addOptional(CompatUtil.biomesOPlenty("brimstone_bud"))
                .addOptional(CompatUtil.biomesOPlenty("blackstone_spines"))
                .addOptional(CompatUtil.biomesOPlenty("blackstone_bulb"))
                .addOptional(CompatUtil.biomesOPlenty("rose_quartz_block"))
                .addOptional(CompatUtil.biomesOPlenty("rose_quartz_cluster"))
                .addOptional(CompatUtil.biomesOPlenty("large_rose_quartz_bud"))
                .addOptional(CompatUtil.biomesOPlenty("medium_rose_quartz_bud"))
                .addOptional(CompatUtil.biomesOPlenty("small_rose_quartz_bud"))
                .addOptional(CompatUtil.biomesOPlenty("algal_end_stone"))
                .addOptional(CompatUtil.biomesOPlenty("unmapped_end_stone"))
                .addOptional(CompatUtil.biomesOPlenty("null_end_stone"))
                .addOptional(CompatUtil.create("asurine"))
                .addOptional(CompatUtil.create("crimsite"))
                .addOptional(CompatUtil.create("limestone"))
                .addOptional(CompatUtil.create("ochrum"))
                .addOptional(CompatUtil.create("scoria"))
                .addOptional(CompatUtil.create("scorchia"))
                .addOptional(CompatUtil.create("veridium"))
                .addOptional(CompatUtil.galosphere("allurite_block"))
                .addOptional(CompatUtil.galosphere("lumiere_block"))
                .addOptional(CompatUtil.galosphere("allurite_cluster"))
                .addOptional(CompatUtil.galosphere("lumiere_cluster"))
                .addOptional(CompatUtil.galosphere("glinted_allurite_cluster"))
                .addOptional(CompatUtil.galosphere("glinted_lumiere_cluster"))
                .addOptional(CompatUtil.galosphere("glinted_amethyst_cluster"))
                .addOptional(CompatUtil.galosphere("pink_salt"))
                .addOptional(CompatUtil.galosphere("rose_pink_salt"))
                .addOptional(CompatUtil.galosphere("pastel_pink_salt"))
                .addOptional(CompatUtil.galosphere("pink_salt_straw"))
                .addOptional(CompatUtil.galosphere("pink_salt_cluster"))
                .addOptional(CompatUtil.yungsCaveBiomes("icicle"))
                .addOptional(CompatUtil.yungsCaveBiomes("rare_ice"))
                .addOptional(CompatUtil.yungsCaveBiomes("ice_sheet"))
                .addOptional(CompatUtil.yungsCaveBiomes("ancient_sandstone"))
                .addOptional(CompatUtil.yungsCaveBiomes("layered_ancient_sandstone"));

        for (GeodeItemObject geode : new GeodeItemObject[]{
                TinkerWorld.earthGeode,
                TinkerWorld.skyGeode,
                TinkerWorld.ichorGeode,
                TinkerWorld.enderGeode}) {
            tag(MTBlockTags.TERRAFORMABLE)
                    .add(geode.getBlock())
                    .add(geode.getBudding())
                    .add(geode.getBud(GeodeItemObject.BudSize.SMALL))
                    .add(geode.getBud(GeodeItemObject.BudSize.MEDIUM))
                    .add(geode.getBud(GeodeItemObject.BudSize.LARGE))
                    .add(geode.getBud(GeodeItemObject.BudSize.CLUSTER));
        }

        tag(MTBlockTags.ATLANTEAN)
                .add(MTBlocks.ATLANTEAN_BRICKS.get())
                .add(MTBlocks.CRACKED_ATLANTEAN_BRICKS.get())
                .add(MTBlocks.ATLANTEAN_BRICK_STAIRS.get())
                .add(MTBlocks.ATLANTEAN_BRICK_SLAB.get())
                .add(MTBlocks.ATLANTEAN_BRICK_WALL.get())
                .add(MTBlocks.ATLANTEAN_TILES.get())
                .add(MTBlocks.CRACKED_ATLANTEAN_TILES.get())
                .add(MTBlocks.ATLANTEAN_TILE_STAIRS.get())
                .add(MTBlocks.ATLANTEAN_TILE_SLAB.get())
                .add(MTBlocks.ATLANTEAN_TILE_WALL.get())
                .add(MTBlocks.ATLANTEAN_PILLAR.get())
                .add(MTBlocks.CRACKED_ATLANTEAN_PILLAR.get());
    }
}
