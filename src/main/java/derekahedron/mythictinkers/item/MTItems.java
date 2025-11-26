package derekahedron.mythictinkers.item;

import derekahedron.mythictinkers.block.MTBlocks;
import derekahedron.mythictinkers.book.MTBooks;
import derekahedron.mythictinkers.fluid.MTFluidHolders;
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import com.github.alexmodguy.alexscaves.server.item.RadioactiveBlockItem;
import com.github.alexmodguy.alexscaves.server.item.RadioactiveItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MTItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    // Legendary Tinkering
    public static final RegistryObject<GuideBookItem> MYTHICAL_TINKERING =
            ITEMS.register("mythical_tinkering", () ->
                    new GuideBookItem(
                            MTBooks.MYTHICAL_TINKERING,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Styx
    public static final RegistryObject<BlockItem> STYGIAN_DEEPSLATE =
            ITEMS.register("stygian_deepslate", () ->
                    new BlockItem(
                            MTBlocks.STYGIAN_DEEPSLATE.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> STYGIAN_SCULK_STONE =
            ITEMS.register("stygian_sculk_stone", () ->
                    new BlockItem(
                            MTBlocks.STYGIAN_SCULK_STONE.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> STYGIAN_GLOOMSLATE =
            ITEMS.register("stygian_gloomslate", () ->
                    new BlockItem(
                            MTBlocks.STYGIAN_GLOOMSLATE.get(),
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> STYX_BUCKET =
            ITEMS.register("styx_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.STYX.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Dombstone
    public static final RegistryObject<BlockItem> DOMBSTONE =
            ITEMS.register("dombstone", () ->
                    new BlockItem(
                            MTBlocks.DOMBSTONE.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> DOMBSTONE_STAIRS =
            ITEMS.register("dombstone_stairs", () ->
                    new BlockItem(
                            MTBlocks.DOMBSTONE_STAIRS.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> DOMBSTONE_SLAB =
            ITEMS.register("dombstone_slab", () ->
                    new BlockItem(
                            MTBlocks.DOMBSTONE_SLAB.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> DOMBSTONE_WALL =
            ITEMS.register("dombstone_wall", () ->
                    new BlockItem(
                            MTBlocks.DOMBSTONE_WALL.get(),
                            new Item.Properties()));

    // Dombstone Bricks
    public static final RegistryObject<BlockItem> DOMBSTONE_BRICKS =
            ITEMS.register("dombstone_bricks", () ->
                    new BlockItem(
                            MTBlocks.DOMBSTONE_BRICKS.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> DOMBSTONE_BRICK_STAIRS =
            ITEMS.register("dombstone_brick_stairs", () ->
                    new BlockItem(
                            MTBlocks.DOMBSTONE_BRICK_STAIRS.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> DOMBSTONE_BRICK_SLAB =
            ITEMS.register("dombstone_brick_slab", () ->
                    new BlockItem(
                            MTBlocks.DOMBSTONE_BRICK_SLAB.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> DOMBSTONE_BRICK_WALL =
            ITEMS.register("dombstone_brick_wall", () ->
                    new BlockItem(
                            MTBlocks.DOMBSTONE_BRICK_WALL.get(),
                            new Item.Properties()));

    // Scarlet Neodymium
    public static final RegistryObject<Item> SCARLET_NEODYMIUM_NUGGET =
            ITEMS.register("scarlet_neodymium_nugget", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> MOLTEN_SCARLET_NEODYMIUM_BUCKET =
            ITEMS.register("molten_scarlet_neodymium_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.MOLTEN_SCARLET_NEODYMIUM.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Azure Neodymium
    public static final RegistryObject<Item> AZURE_NEODYMIUM_NUGGET =
            ITEMS.register("azure_neodymium_nugget", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> MOLTEN_AZURE_NEODYMIUM_BUCKET =
            ITEMS.register("molten_azure_neodymium_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.MOLTEN_AZURE_NEODYMIUM.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Byzantium Neodymium
    public static final RegistryObject<BlockItem> BYZANTIUM_ENERGIZED_GALENA =
            ITEMS.register("byzantium_energized_galena", () ->
                    new BlockItem(
                            MTBlocks.BYZANTIUM_ENERGIZED_GALENA.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> BYZANTIUM_NEODYMIUM_NODE =
            ITEMS.register("byzantium_neodymium_node", () ->
                    new BlockItem(
                            MTBlocks.BYZANTIUM_NEODYMIUM_NODE.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> BYZANTIUM_NEODYMIUM_PILLAR =
            ITEMS.register("byzantium_neodymium_pillar", () ->
                    new BlockItem(
                            MTBlocks.BYZANTIUM_NEODYMIUM_PILLAR.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> BYZANTIUM_NEODYMIUM_BLOCK =
            ITEMS.register("byzantium_neodymium_block", () ->
                    new BlockItem(
                            MTBlocks.BYZANTIUM_NEODYMIUM_BLOCK.get(),
                            new Item.Properties()));
    public static final RegistryObject<Item> RAW_BYZANTIUM_NEODYMIUM =
            ITEMS.register("raw_byzantium_neodymium", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<Item> BYZANTIUM_NEODYMIUM_NUGGET =
            ITEMS.register("byzantium_neodymium_nugget", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<Item> BYZANTIUM_NEODYMIUM_INGOT =
            ITEMS.register("byzantium_neodymium_ingot", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> MOLTEN_BYZANTIUM_NEODYMIUM_BUCKET =
            ITEMS.register("molten_byzantium_neodymium_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.MOLTEN_BYZANTIUM_NEODYMIUM.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Tectellus
    public static final RegistryObject<BlockItem> TECTELLUS_BLOCK =
            ITEMS.register("tectellus_block", () ->
                    new BlockItem(
                            MTBlocks.TECTELLUS_BLOCK.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> DORMANT_TECTELLUS_ORE =
            ITEMS.register("dormant_tectellus_ore", () ->
                    new BlockItem(
                            MTBlocks.DORMANT_TECTELLUS_ORE.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> TECTELLUS_ORE =
            ITEMS.register("tectellus_ore", () ->
                    new BlockItem(
                            MTBlocks.TECTELLUS_ORE.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> RAW_TECTELLUS_BLOCK =
            ITEMS.register("raw_tectellus_block", () ->
                    new BlockItem(
                            MTBlocks.RAW_TECTELLUS_BLOCK.get(),
                            new Item.Properties()));
    public static final RegistryObject<Item> RAW_TECTELLUS =
            ITEMS.register("raw_tectellus", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<Item> TECTELLUS_NUGGET =
            ITEMS.register("tectellus_nugget", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<Item> TECTELLUS_INGOT =
            ITEMS.register("tectellus_ingot", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> MOLTEN_TECTELLUS_BUCKET =
            ITEMS.register("molten_tectellus_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.MOLTEN_TECTELLUS.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Element 122
    public static final RegistryObject<RadioactiveBlockItem> ELEMENT_122_BLOCK =
            ITEMS.register("element_122_block", () ->
                    new RadioactiveBlockItem(
                            MTBlocks.ELEMENT_122_BLOCK,
                            new Item.Properties(),
                            0.002F));
    public static final RegistryObject<RadioactiveBlockItem> ELEMENT_122_ORE =
            ITEMS.register("element_122_ore", () ->
                    new RadioactiveBlockItem(
                            MTBlocks.ELEMENT_122_ORE,
                            new Item.Properties()
                                    .fireResistant(),
                            0.002F));
    public static final RegistryObject<RadioactiveBlockItem> RAW_ELEMENT_122_BLOCK =
            ITEMS.register("raw_element_122_block", () ->
                    new RadioactiveBlockItem(
                            MTBlocks.RAW_ELEMENT_122_BLOCK,
                            new Item.Properties()
                                    .fireResistant(),
                            0.002F));
    public static final RegistryObject<RadioactiveItem> RAW_ELEMENT_122 =
            ITEMS.register("raw_element_122", () ->
                    new RadioactiveItem(
                            new Item.Properties()
                                    .fireResistant(),
                            0.002F));
    public static final RegistryObject<RadioactiveItem> ELEMENT_122_NUGGET =
            ITEMS.register("element_122_nugget", () ->
                    new RadioactiveItem(
                            new Item.Properties(),
                            0.002F));
    public static final RegistryObject<RadioactiveItem> ELEMENT_122_INGOT =
            ITEMS.register("element_122_ingot", () ->
                    new RadioactiveItem(
                            new Item.Properties(),
                            0.002F));
    public static final RegistryObject<BucketItem> MOLTEN_ELEMENT_122_BUCKET =
            ITEMS.register("molten_element_122_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.MOLTEN_ELEMENT_122.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Atlantean Bricks
    public static final RegistryObject<BlockItem> ATLANTEAN_BRICKS =
            ITEMS.register("atlantean_bricks", () ->
                    new BlockItem(
                            MTBlocks.ATLANTEAN_BRICKS.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> CRACKED_ATLANTEAN_BRICKS =
            ITEMS.register("cracked_atlantean_bricks", () ->
                    new BlockItem(
                            MTBlocks.CRACKED_ATLANTEAN_BRICKS.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> ATLANTEAN_BRICK_STAIRS =
            ITEMS.register("atlantean_brick_stairs", () ->
                    new BlockItem(
                            MTBlocks.ATLANTEAN_BRICK_STAIRS.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> ATLANTEAN_BRICK_SLAB =
            ITEMS.register("atlantean_brick_slab", () ->
                    new BlockItem(
                            MTBlocks.ATLANTEAN_BRICK_SLAB.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> ATLANTEAN_BRICK_WALL =
            ITEMS.register("atlantean_brick_wall", () ->
                    new BlockItem(
                            MTBlocks.ATLANTEAN_BRICK_WALL.get(),
                            new Item.Properties()));

    // Atlantean Tiles
    public static final RegistryObject<BlockItem> ATLANTEAN_TILES =
            ITEMS.register("atlantean_tiles", () ->
                    new BlockItem(
                            MTBlocks.ATLANTEAN_TILES.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> CRACKED_ATLANTEAN_TILES =
            ITEMS.register("cracked_atlantean_tiles", () ->
                    new BlockItem(
                            MTBlocks.CRACKED_ATLANTEAN_TILES.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> ATLANTEAN_TILE_STAIRS =
            ITEMS.register("atlantean_tile_stairs", () ->
                    new BlockItem(
                            MTBlocks.ATLANTEAN_TILE_STAIRS.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> ATLANTEAN_TILE_SLAB =
            ITEMS.register("atlantean_tile_slab", () ->
                    new BlockItem(
                            MTBlocks.ATLANTEAN_TILE_SLAB.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> ATLANTEAN_TILE_WALL =
            ITEMS.register("atlantean_tile_wall", () ->
                    new BlockItem(
                            MTBlocks.ATLANTEAN_TILE_WALL.get(),
                            new Item.Properties()));

    // Atlantean Pillar
    public static final RegistryObject<BlockItem> ATLANTEAN_PILLAR =
            ITEMS.register("atlantean_pillar", () ->
                    new BlockItem(
                            MTBlocks.ATLANTEAN_PILLAR.get(),
                            new Item.Properties()));
    public static final RegistryObject<BlockItem> CRACKED_ATLANTEAN_PILLAR =
            ITEMS.register("cracked_atlantean_pillar", () ->
                    new BlockItem(
                            MTBlocks.CRACKED_ATLANTEAN_PILLAR.get(),
                            new Item.Properties()));

    // Aurichalcum
    public static final RegistryObject<BlockItem> AURICHALCUM_BLOCK =
            ITEMS.register("aurichalcum_block", () ->
                    new BlockItem(
                            MTBlocks.AURICHALCUM_BLOCK.get(),
                            new Item.Properties()));
    public static final RegistryObject<Item> AURICHALCUM_NUGGET =
            ITEMS.register("aurichalcum_nugget", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<Item> AURICHALCUM_INGOT =
            ITEMS.register("aurichalcum_ingot", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> MOLTEN_AURICHALCUM_BUCKET =
            ITEMS.register("molten_aurichalcum_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.MOLTEN_AURICHALCUM.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Desolum
    public static final RegistryObject<BlockItem> DESOLUM_BLOCK =
            ITEMS.register("desolum_block", () ->
                    new BlockItem(
                            MTBlocks.DESOLUM_BLOCK.get(),
                            new Item.Properties()));
    public static final RegistryObject<Item> DESOLUM_NUGGET =
            ITEMS.register("desolum_nugget", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<Item> DESOLUM_INGOT =
            ITEMS.register("desolum_ingot", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> MOLTEN_DESOLUM_BUCKET =
            ITEMS.register("molten_desolum_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.MOLTEN_DESOLUM.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Pure Light
    public static final RegistryObject<BlockItem> IMPRISONING_COPROLITH =
            ITEMS.register("imprisoning_coprolith", () ->
                    new BlockItem(
                            MTBlocks.IMPRISONING_COPROLITH.get(),
                            new Item.Properties()));
    public static final RegistryObject<Item> PURE_LIGHT =
            ITEMS.register("pure_light", () ->
                    new Item(
                            new Item.Properties()));

    // Prosprum
    public static final RegistryObject<BlockItem> PROSPRUM_BLOCK =
            ITEMS.register("prosprum_block", () ->
                    new BlockItem(
                            MTBlocks.PROSPRUM_BLOCK.get(),
                            new Item.Properties()));
    public static final RegistryObject<Item> PROSPRUM_NUGGET =
            ITEMS.register("prosprum_nugget", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<Item> PROSPRUM_INGOT =
            ITEMS.register("prosprum_ingot", () ->
                    new Item(
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> MOLTEN_PROSPRUM_BUCKET =
            ITEMS.register("molten_prosprum_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.MOLTEN_PROSPRUM.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Earthen Gum
    public static final RegistryObject<GumBlockItem> EARTHEN_GUM_BLOCK =
            ITEMS.register("earthen_gum_block", () ->
                    new GumBlockItem(
                            MTBlocks.EARTHEN_GUM_BLOCK.get(),
                            new Item.Properties()));
    public static final RegistryObject<EarthenGumOreBlockItem> EARTHEN_GUM_ORE =
            ITEMS.register("earthen_gum_ore", () ->
                    new EarthenGumOreBlockItem(
                            MTBlocks.EARTHEN_GUM_ORE.get(),
                            new Item.Properties()
                                    .food(MTFoods.EARTHEN_GUM_ORE)));
    public static final RegistryObject<GumItem> EARTHEN_GUM_WAD =
            ITEMS.register("earthen_gum_wad", () ->
                    new GumItem(
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> EARTHEN_GUM_BUCKET =
            ITEMS.register("earthen_gum_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.EARTHEN_GUM.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Gumbronze
    public static final RegistryObject<GumBlockItem> GUMBRONZE_BLOCK =
            ITEMS.register("gumbronze_block", () ->
                    new GumBlockItem(
                            MTBlocks.GUMBRONZE_BLOCK.get(),
                            new Item.Properties()));
    public static final RegistryObject<GumItem> GUMBRONZE_NUGGET =
            ITEMS.register("gumbronze_nugget", () ->
                    new GumItem(
                            new Item.Properties()));
    public static final RegistryObject<GumItem> GUMBRONZE_INGOT =
            ITEMS.register("gumbronze_ingot", () ->
                    new GumItem(
                            new Item.Properties()));
    public static final RegistryObject<BucketItem> MOLTEN_GUMBRONZE_BUCKET =
            ITEMS.register("molten_gumbronze_bucket", () ->
                    new BucketItem(
                            MTFluidHolders.MOLTEN_GUMBRONZE.stillFluid,
                            new Item.Properties()
                                    .stacksTo(1)));

    // Dark Arrow
    public static final RegistryObject<DarkArrowItem> DARK_ARROW =
            ITEMS.register("dark_arrow", () ->
                    new DarkArrowItem(
                            new Item.Properties()
                                    .rarity(ACItemRegistry.RARITY_DEMONIC)));
}
