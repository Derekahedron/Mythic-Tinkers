package derekahedron.mythictinkers.datagen.tags;

import derekahedron.invexp.item.InvExpItemTags;
import derekahedron.mythictinkers.item.MTItemTags;
import derekahedron.mythictinkers.item.MTItems;
import derekahedron.mythictinkers.util.ForgeTags;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.shared.TinkerMaterials;

import java.util.concurrent.CompletableFuture;

public class MTItemTagsProvider extends ItemTagsProvider {

    public MTItemTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            CompletableFuture<TagsProvider.TagLookup<Block>> contentsGetter,
            ExistingFileHelper exFileHelper) {
        super(output, lookupProvider, contentsGetter, derekahedron.mythictinkers.MythicTinkers.MOD_ID, exFileHelper);
    }

    @Override
    public String getName() {
        return String.format("%s Item Tags", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        tag(ItemTags.ARROWS)
                .add(MTItems.DARK_ARROW.get());

        tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(MTItems.BYZANTIUM_NEODYMIUM_INGOT.get())
                .add(MTItems.TECTELLUS_INGOT.get())
                .add(MTItems.ELEMENT_122_INGOT.get())
                .add(MTItems.AURICHALCUM_INGOT.get())
                .add(MTItems.DESOLUM_INGOT.get())
                .add(MTItems.PROSPRUM_INGOT.get())
                .add(MTItems.GUMBRONZE_INGOT.get());

        tag(ItemTags.STAIRS)
                .add(MTItems.DOMBSTONE_STAIRS.get())
                .add(MTItems.DOMBSTONE_BRICK_STAIRS.get())
                .add(MTItems.ATLANTEAN_BRICK_STAIRS.get())
                .add(MTItems.ATLANTEAN_TILE_STAIRS.get());

        tag(ItemTags.SLABS)
                .add(MTItems.DOMBSTONE_SLAB.get())
                .add(MTItems.DOMBSTONE_BRICK_SLAB.get())
                .add(MTItems.ATLANTEAN_BRICK_SLAB.get())
                .add(MTItems.ATLANTEAN_TILE_SLAB.get());

        tag(ItemTags.WALLS)
                .add(MTItems.DOMBSTONE_WALL.get())
                .add(MTItems.DOMBSTONE_BRICK_WALL.get())
                .add(MTItems.ATLANTEAN_BRICK_WALL.get())
                .add(MTItems.ATLANTEAN_TILE_WALL.get());

        tag(ItemTags.TRIM_MATERIALS)
                .add(ACItemRegistry.SCARLET_NEODYMIUM_INGOT.get())
                .add(ACItemRegistry.AZURE_NEODYMIUM_INGOT.get())
                .add(MTItems.BYZANTIUM_NEODYMIUM_INGOT.get())
                .add(MTItems.TECTELLUS_INGOT.get())
                .add(MTItems.ELEMENT_122_INGOT.get())
                .add(MTItems.AURICHALCUM_INGOT.get())
                .add(MTItems.DESOLUM_INGOT.get())
                .add(MTItems.PROSPRUM_INGOT.get())
                .add(MTItems.GUMBRONZE_INGOT.get());

        tag(ForgeTags.Items.STYX_ORES)
                .add(MTItems.STYGIAN_DEEPSLATE.get())
                .add(MTItems.STYGIAN_SCULK_STONE.get())
                .add(MTItems.STYGIAN_GLOOMSLATE.get());

        tag(ForgeTags.Items.SCARLET_NEODYMIUM_BLOCKS)
                .add(ACBlockRegistry.BLOCK_OF_SCARLET_NEODYMIUM.get().asItem());
        tag(ForgeTags.Items.SCARLET_NEODYMIUM_NUGGETS)
                .add(MTItems.SCARLET_NEODYMIUM_NUGGET.get());
        tag(ForgeTags.Items.SCARLET_NEODYMIUM_INGOTS)
                .add(ACItemRegistry.SCARLET_NEODYMIUM_INGOT.get());

        tag(ForgeTags.Items.AZURE_NEODYMIUM_BLOCKS)
                .add(ACBlockRegistry.BLOCK_OF_AZURE_NEODYMIUM.get().asItem());
        tag(ForgeTags.Items.AZURE_NEODYMIUM_NUGGETS)
                .add(MTItems.AZURE_NEODYMIUM_NUGGET.get());
        tag(ForgeTags.Items.AZURE_NEODYMIUM_INGOTS)
                .add(ACItemRegistry.AZURE_NEODYMIUM_INGOT.get());

        tag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_BLOCKS)
                .add(MTItems.BYZANTIUM_NEODYMIUM_BLOCK.get());
        tag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_NUGGETS)
                .add(MTItems.BYZANTIUM_NEODYMIUM_NUGGET.get());
        tag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_INGOTS)
                .add(MTItems.BYZANTIUM_NEODYMIUM_INGOT.get());

        tag(ForgeTags.Items.TECTELLUS_BLOCKS)
                .add(MTItems.TECTELLUS_BLOCK.get());
        tag(ForgeTags.Items.TECTELLUS_ORES)
                .add(MTItems.TECTELLUS_ORE.get());
        tag(ForgeTags.Items.RAW_TECTELLUS_BLOCKS)
                .add(MTItems.RAW_TECTELLUS_BLOCK.get());
        tag(ForgeTags.Items.RAW_TECTELLUS)
                .add(MTItems.RAW_TECTELLUS.get());
        tag(ForgeTags.Items.TECTELLUS_NUGGETS)
                .add(MTItems.TECTELLUS_NUGGET.get());
        tag(ForgeTags.Items.TECTELLUS_INGOTS)
                .add(MTItems.TECTELLUS_INGOT.get());

        tag(ForgeTags.Items.ELEMENT_122_BLOCKS)
                .add(MTItems.ELEMENT_122_BLOCK.get());
        tag(ForgeTags.Items.ELEMENT_122_ORES)
                .add(MTItems.ELEMENT_122_ORE.get());
        tag(ForgeTags.Items.RAW_ELEMENT_122_BLOCKS)
                .add(MTItems.RAW_ELEMENT_122_BLOCK.get());
        tag(ForgeTags.Items.RAW_ELEMENT_122)
                .add(MTItems.RAW_ELEMENT_122.get());
        tag(ForgeTags.Items.ELEMENT_122_NUGGETS)
                .add(MTItems.ELEMENT_122_NUGGET.get());
        tag(ForgeTags.Items.ELEMENT_122_INGOTS)
                .add(MTItems.ELEMENT_122_INGOT.get());

        tag(ForgeTags.Items.AURICHALCUM_BLOCKS)
                .add(MTItems.AURICHALCUM_BLOCK.get());
        tag(ForgeTags.Items.AURICHALCUM_NUGGETS)
                .add(MTItems.AURICHALCUM_NUGGET.get());
        tag(ForgeTags.Items.AURICHALCUM_INGOTS)
                .add(MTItems.AURICHALCUM_INGOT.get());

        tag(ForgeTags.Items.DESOLUM_BLOCKS)
                .add(MTItems.DESOLUM_BLOCK.get());
        tag(ForgeTags.Items.DESOLUM_NUGGETS)
                .add(MTItems.DESOLUM_NUGGET.get());
        tag(ForgeTags.Items.DESOLUM_INGOTS)
                .add(MTItems.DESOLUM_INGOT.get());

        tag(ForgeTags.Items.PROSPRUM_BLOCKS)
                .add(MTItems.PROSPRUM_BLOCK.get());
        tag(ForgeTags.Items.PROSPRUM_NUGGETS)
                .add(MTItems.PROSPRUM_NUGGET.get());
        tag(ForgeTags.Items.PROSPRUM_INGOTS)
                .add(MTItems.PROSPRUM_INGOT.get());

        tag(ForgeTags.Items.EARTHEN_GUM_BLOCKS)
                .add(MTItems.EARTHEN_GUM_BLOCK.get());
        tag(ForgeTags.Items.EARTHEN_GUM_ORES)
                .add(MTItems.EARTHEN_GUM_ORE.get());

        tag(ForgeTags.Items.GUMBRONZE_NUGGETS)
                .add(MTItems.GUMBRONZE_NUGGET.get());
        tag(ForgeTags.Items.GUMBRONZE_BLOCKS)
                .add(MTItems.GUMBRONZE_BLOCK.get());
        tag(ForgeTags.Items.GUMBRONZE_INGOTS)
                .add(MTItems.GUMBRONZE_INGOT.get());

        tag(TinkerTags.Items.TINKERS_GUIDES)
                .add(MTItems.MYTHICAL_TINKERING.get());

        tag(Tags.Items.ORES)
                .addTag(ForgeTags.Items.STYX_ORES)
                .addTag(ForgeTags.Items.TECTELLUS_ORES)
                .add(MTItems.DORMANT_TECTELLUS_ORE.get())
                .addTag(ForgeTags.Items.ELEMENT_122_ORES)
                .add(MTItems.IMPRISONING_COPROLITH.get())
                .addTag(ForgeTags.Items.EARTHEN_GUM_ORES);
        tag(Tags.Items.STORAGE_BLOCKS)
                .addTag(ForgeTags.Items.SCARLET_NEODYMIUM_BLOCKS)
                .addTag(ForgeTags.Items.AZURE_NEODYMIUM_BLOCKS)
                .addTag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_BLOCKS)
                .addTag(ForgeTags.Items.TECTELLUS_BLOCKS)
                .addTag(ForgeTags.Items.RAW_TECTELLUS_BLOCKS)
                .addTag(ForgeTags.Items.ELEMENT_122_BLOCKS)
                .addTag(ForgeTags.Items.RAW_ELEMENT_122_BLOCKS)
                .addTag(ForgeTags.Items.AURICHALCUM_BLOCKS)
                .addTag(ForgeTags.Items.DESOLUM_BLOCKS)
                .addTag(ForgeTags.Items.PROSPRUM_BLOCKS)
                .addTag(ForgeTags.Items.EARTHEN_GUM_BLOCKS)
                .addTag(ForgeTags.Items.GUMBRONZE_BLOCKS);
        tag(Tags.Items.RAW_MATERIALS)
                .addTag(ForgeTags.Items.RAW_TECTELLUS)
                .addTag(ForgeTags.Items.RAW_ELEMENT_122);
        tag(Tags.Items.NUGGETS)
                .addTag(ForgeTags.Items.SCARLET_NEODYMIUM_NUGGETS)
                .addTag(ForgeTags.Items.AZURE_NEODYMIUM_NUGGETS)
                .addTag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_NUGGETS)
                .addTag(ForgeTags.Items.TECTELLUS_NUGGETS)
                .addTag(ForgeTags.Items.ELEMENT_122_NUGGETS)
                .addTag(ForgeTags.Items.AURICHALCUM_NUGGETS)
                .addTag(ForgeTags.Items.DESOLUM_NUGGETS)
                .addTag(ForgeTags.Items.PROSPRUM_NUGGETS)
                .addTag(ForgeTags.Items.GUMBRONZE_NUGGETS);
        tag(Tags.Items.INGOTS)
                .addTag(ForgeTags.Items.SCARLET_NEODYMIUM_INGOTS)
                .addTag(ForgeTags.Items.AZURE_NEODYMIUM_INGOTS)
                .addTag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_INGOTS)
                .addTag(ForgeTags.Items.TECTELLUS_INGOTS)
                .addTag(ForgeTags.Items.ELEMENT_122_INGOTS)
                .addTag(ForgeTags.Items.AURICHALCUM_INGOTS)
                .addTag(ForgeTags.Items.DESOLUM_INGOTS)
                .addTag(ForgeTags.Items.PROSPRUM_INGOTS)
                .addTag(ForgeTags.Items.GUMBRONZE_INGOTS);

        tag(TinkerTags.Items.WORKSTATION_ROCK)
                .add(MTItems.DOMBSTONE.get());

        tag(TinkerTags.Items.ANVIL_METAL)
                .addTag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_BLOCKS)
                .addTag(ForgeTags.Items.TECTELLUS_BLOCKS)
                .addTag(ForgeTags.Items.ELEMENT_122_BLOCKS)
                .addTag(ForgeTags.Items.AURICHALCUM_BLOCKS)
                .addTag(ForgeTags.Items.DESOLUM_BLOCKS)
                .addTag(ForgeTags.Items.PROSPRUM_BLOCKS)
                .addTag(ForgeTags.Items.GUMBRONZE_BLOCKS);

        tag(ACTagRegistry.MAGNETIC_ITEMS)
                .addOptionalTag(TinkerMaterials.slimesteel.getIngotTag())
                .addOptionalTag(TinkerMaterials.slimesteel.getNuggetTag())
                .addOptionalTag(TinkerMaterials.slimesteel.getBlockItemTag())
                .addOptionalTag(TinkerMaterials.pigIron.getIngotTag())
                .addOptionalTag(TinkerMaterials.pigIron.getNuggetTag())
                .addOptionalTag(TinkerMaterials.pigIron.getBlockItemTag())
                .addOptionalTag(TinkerTags.Items.ORES_COBALT)
                .addOptionalTag(TinkerTags.Items.RAW_COBALT)
                .addOptionalTag(TinkerTags.Items.RAW_BLOCK_COBALT)
                .addOptionalTag(TinkerMaterials.cobalt.getIngotTag())
                .addOptionalTag(TinkerMaterials.cobalt.getNuggetTag())
                .addOptionalTag(TinkerMaterials.cobalt.getBlockItemTag())
                .addOptionalTag(TinkerMaterials.manyullyn.getIngotTag())
                .addOptionalTag(TinkerMaterials.manyullyn.getNuggetTag())
                .addOptionalTag(TinkerMaterials.manyullyn.getBlockItemTag())
                .addOptionalTag(TinkerMaterials.hepatizon.getIngotTag())
                .addOptionalTag(TinkerMaterials.hepatizon.getNuggetTag())
                .addOptionalTag(TinkerMaterials.hepatizon.getBlockItemTag())
                .addOptionalTag(TinkerMaterials.queensSlime.getIngotTag())
                .addOptionalTag(TinkerMaterials.queensSlime.getNuggetTag())
                .addOptionalTag(TinkerMaterials.queensSlime.getBlockItemTag());

        tag(InvExpItemTags.SackType.STONE)
                .addTag(MTItemTags.DOMBSTONE)
                .add(MTItems.BYZANTIUM_ENERGIZED_GALENA.get());

        tag(InvExpItemTags.SackType.METAL_BLOCK)
                .addTag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_BLOCKS)
                .addTag(ForgeTags.Items.TECTELLUS_BLOCKS)
                .addTag(ForgeTags.Items.ELEMENT_122_BLOCKS)
                .addTag(MTItemTags.ATLANTEAN)
                .addTag(ForgeTags.Items.AURICHALCUM_BLOCKS)
                .addTag(ForgeTags.Items.DESOLUM_BLOCKS)
                .addTag(ForgeTags.Items.PROSPRUM_BLOCKS)
                .addTag(ForgeTags.Items.GUMBRONZE_BLOCKS);

        tag(InvExpItemTags.SackType.ORE)
                .addTag(ForgeTags.Items.SCARLET_NEODYMIUM_NUGGETS)
                .addTag(ForgeTags.Items.AZURE_NEODYMIUM_NUGGETS)
                .add(MTItems.BYZANTIUM_NEODYMIUM_NODE.get())
                .add(MTItems.BYZANTIUM_NEODYMIUM_PILLAR.get())
                .add(MTItems.RAW_BYZANTIUM_NEODYMIUM.get())
                .addTag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_NUGGETS)
                .addTag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_INGOTS)
                .addTag(ForgeTags.Items.RAW_TECTELLUS_BLOCKS)
                .addTag(ForgeTags.Items.RAW_TECTELLUS)
                .addTag(ForgeTags.Items.TECTELLUS_NUGGETS)
                .addTag(ForgeTags.Items.TECTELLUS_INGOTS)
                .addTag(ForgeTags.Items.RAW_ELEMENT_122_BLOCKS)
                .addTag(ForgeTags.Items.RAW_ELEMENT_122)
                .addTag(ForgeTags.Items.ELEMENT_122_NUGGETS)
                .addTag(ForgeTags.Items.ELEMENT_122_INGOTS)
                .addTag(ForgeTags.Items.AURICHALCUM_NUGGETS)
                .addTag(ForgeTags.Items.AURICHALCUM_INGOTS)
                .addTag(ForgeTags.Items.DESOLUM_NUGGETS)
                .addTag(ForgeTags.Items.DESOLUM_INGOTS)
                .addTag(ForgeTags.Items.PROSPRUM_BLOCKS)
                .addTag(ForgeTags.Items.PROSPRUM_INGOTS)
                .addTag(ForgeTags.Items.EARTHEN_GUM_BLOCKS)
                .add(MTItems.EARTHEN_GUM_WAD.get())
                .addTag(ForgeTags.Items.GUMBRONZE_NUGGETS)
                .addTag(ForgeTags.Items.GUMBRONZE_INGOTS);

        tag(InvExpItemTags.SackWeight.FIFTH)
                .addTag(ForgeTags.Items.SCARLET_NEODYMIUM_NUGGETS)
                .addTag(ForgeTags.Items.AZURE_NEODYMIUM_NUGGETS)
                .addTag(ForgeTags.Items.BYZANTIUM_NEODYMIUM_NUGGETS)
                .addTag(ForgeTags.Items.TECTELLUS_NUGGETS)
                .addTag(ForgeTags.Items.ELEMENT_122_NUGGETS)
                .addTag(ForgeTags.Items.AURICHALCUM_NUGGETS)
                .addTag(ForgeTags.Items.DESOLUM_NUGGETS)
                .addTag(ForgeTags.Items.GUMBRONZE_NUGGETS);

        tag(MTItemTags.DOMBSTONE)
                .add(MTItems.DOMBSTONE.get())
                .add(MTItems.DOMBSTONE_STAIRS.get())
                .add(MTItems.DOMBSTONE_SLAB.get())
                .add(MTItems.DOMBSTONE_WALL.get())
                .addTag(MTItemTags.DOMBSTONE_BRICKS);

        tag(MTItemTags.DOMBSTONE_BRICKS)
                .add(MTItems.DOMBSTONE_BRICKS.get())
                .add(MTItems.DOMBSTONE_BRICK_STAIRS.get())
                .add(MTItems.DOMBSTONE_BRICK_SLAB.get())
                .add(MTItems.DOMBSTONE_BRICK_WALL.get());

        tag(MTItemTags.ATLANTEAN)
                .add(MTItems.ATLANTEAN_BRICKS.get())
                .add(MTItems.CRACKED_ATLANTEAN_BRICKS.get())
                .add(MTItems.ATLANTEAN_BRICK_STAIRS.get())
                .add(MTItems.ATLANTEAN_BRICK_SLAB.get())
                .add(MTItems.ATLANTEAN_BRICK_WALL.get())
                .add(MTItems.ATLANTEAN_TILES.get())
                .add(MTItems.CRACKED_ATLANTEAN_TILES.get())
                .add(MTItems.ATLANTEAN_TILE_STAIRS.get())
                .add(MTItems.ATLANTEAN_TILE_SLAB.get())
                .add(MTItems.ATLANTEAN_TILE_WALL.get())
                .add(MTItems.ATLANTEAN_PILLAR.get())
                .add(MTItems.CRACKED_ATLANTEAN_PILLAR.get());

        tag(MTItemTags.ACID_RESISTANT)
                .add(MTItems.ELEMENT_122_BLOCK.get())
                .add(MTItems.ELEMENT_122_ORE.get())
                .add(MTItems.RAW_ELEMENT_122_BLOCK.get())
                .add(MTItems.RAW_ELEMENT_122.get())
                .add(MTItems.ELEMENT_122_NUGGET.get())
                .add(MTItems.ELEMENT_122_INGOT.get());
    }
}
