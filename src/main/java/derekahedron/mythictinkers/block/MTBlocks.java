package derekahedron.mythictinkers.block;

import derekahedron.mythictinkers.fluid.MTFluidHolders;
import derekahedron.mythictinkers.fluid.MTFluids;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.block.ACSoundTypes;
import com.github.alexmodguy.alexscaves.server.block.EnergizedGalenaBlock;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MTBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    // Styx
    public static final RegistryObject<LiquidBlock> STYX =
            BLOCKS.register("styx", () ->
                    new LiquidBlock(
                            MTFluids.STYX,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_BLACK)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 6)
                                    .pushReaction(PushReaction.DESTROY)
                                    .randomTicks()
                                    .sound(SoundType.EMPTY)));
    public static final RegistryObject<DropFluidAndExperienceBlock> STYGIAN_DEEPSLATE =
            BLOCKS.register("stygian_deepslate", () ->
                    new DropFluidAndExperienceBlock(
                            MTFluids.STYX.get(),
                            BlockBehaviour.Properties.of()
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .mapColor(MapColor.DEEPSLATE)
                                    .requiresCorrectToolForDrops()
                                    .strength(3.0F, 3.0F)
                                    .sound(SoundType.DEEPSLATE),
                            UniformInt.of(3, 7)));
    public static final RegistryObject<DropFluidAndExperienceBlock> STYGIAN_SCULK_STONE =
            BLOCKS.register("stygian_sculk_stone", () ->
                    new DropFluidAndExperienceBlock(
                            MTFluids.STYX.get(),
                            BlockBehaviour.Properties.copy(Blocks.STONE)
                                    .sound(getSculkStoneSound())
                                    .mapColor(MapColor.COLOR_CYAN)
                                    .requiresCorrectToolForDrops(),
                            UniformInt.of(3, 7)));
    public static final RegistryObject<DropFluidAndExperienceBlock> STYGIAN_GLOOMSLATE =
            BLOCKS.register("stygian_gloomslate", () ->
                    new DropFluidAndExperienceBlock(
                            MTFluids.STYX.get(),
                            BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                                    .strength(2.5F, 4.5F)
                                    .mapColor(MapColor.TERRACOTTA_BROWN)
                                    .requiresCorrectToolForDrops(),
                            UniformInt.of(3, 7)));

    // Dombstone
    public static final RegistryObject<Block> DOMBSTONE =
            BLOCKS.register("dombstone", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_BLACK)
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(4.5F, 6.0F)));
    public static final RegistryObject<StairBlock> DOMBSTONE_STAIRS =
            BLOCKS.register("dombstone_stairs", () ->
                    new StairBlock(
                            () -> DOMBSTONE.get().defaultBlockState(),
                            BlockBehaviour.Properties.copy(DOMBSTONE.get())));
    public static final RegistryObject<SlabBlock> DOMBSTONE_SLAB =
            BLOCKS.register("dombstone_slab", () ->
                    new SlabBlock(
                            BlockBehaviour.Properties.copy(DOMBSTONE.get())));
    public static final RegistryObject<WallBlock> DOMBSTONE_WALL =
            BLOCKS.register("dombstone_wall", () ->
                    new WallBlock(
                            BlockBehaviour.Properties.copy(DOMBSTONE.get())));

    // Dombstone Bricks
    public static final RegistryObject<Block> DOMBSTONE_BRICKS =
            BLOCKS.register("dombstone_bricks", () ->
                    new Block(
                            BlockBehaviour.Properties.copy(DOMBSTONE.get())
                                    .strength(4.0F, 6.0F)));
    public static final RegistryObject<StairBlock> DOMBSTONE_BRICK_STAIRS =
            BLOCKS.register("dombstone_brick_stairs", () ->
                    new StairBlock(
                            () -> DOMBSTONE.get().defaultBlockState(),
                            BlockBehaviour.Properties.copy(DOMBSTONE_BRICKS.get())));
    public static final RegistryObject<SlabBlock> DOMBSTONE_BRICK_SLAB =
            BLOCKS.register("dombstone_brick_slab", () ->
                    new SlabBlock(
                            BlockBehaviour.Properties.copy(DOMBSTONE_BRICKS.get())));
    public static final RegistryObject<WallBlock> DOMBSTONE_BRICK_WALL =
            BLOCKS.register("dombstone_brick_wall", () ->
                    new WallBlock(
                            BlockBehaviour.Properties.copy(DOMBSTONE_BRICKS.get())));

    // Scarlet Neodymium
    public static final RegistryObject<LiquidBlock> MOLTEN_SCARLET_NEODYMIUM =
            BLOCKS.register("molten_scarlet_neodymium", () ->
                    new LiquidBlock(
                            MTFluidHolders.MOLTEN_SCARLET_NEODYMIUM.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(DyeColor.WHITE)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 12)
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    // Azure Neodymium
    public static final RegistryObject<LiquidBlock> MOLTEN_AZURE_NEODYMIUM =
            BLOCKS.register("molten_azure_neodymium", () ->
                    new LiquidBlock(
                            MTFluidHolders.MOLTEN_AZURE_NEODYMIUM.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(DyeColor.WHITE)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 12)
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    // Byzantium Neodymium
    public static final RegistryObject<EnergizedGalenaBlock> BYZANTIUM_ENERGIZED_GALENA =
            BLOCKS.register("byzantium_energized_galena", () ->
                    new EnergizedGalenaBlock(ACBlockRegistry.ENERGIZED_GALENA_PROPERTIES));
    public static final RegistryObject<ByzantiumNeodymiumNodeBlock> BYZANTIUM_NEODYMIUM_NODE =
            BLOCKS.register("byzantium_neodymium_node", ByzantiumNeodymiumNodeBlock::new);
    public static final RegistryObject<ByzantiumNeodymiumPillarBlock> BYZANTIUM_NEODYMIUM_PILLAR =
            BLOCKS.register("byzantium_neodymium_pillar", ByzantiumNeodymiumPillarBlock::new);
    public static final RegistryObject<ByzantiumNeodymiumOreBlock> BYZANTIUM_NEODYMIUM_BLOCK =
            BLOCKS.register("byzantium_neodymium_block", ByzantiumNeodymiumOreBlock::new);
    public static final RegistryObject<LiquidBlock> MOLTEN_BYZANTIUM_NEODYMIUM =
            BLOCKS.register("molten_byzantium_neodymium", () ->
                    new LiquidBlock(
                            MTFluidHolders.MOLTEN_BYZANTIUM_NEODYMIUM.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(DyeColor.WHITE)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 12)
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    // Tectellus
    public static final RegistryObject<Block> TECTELLUS_BLOCK =
            BLOCKS.register("tectellus_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.FIRE)
                                    .requiresCorrectToolForDrops()
                                    .strength(15.0F, 20.0F)
                                    .sound(SoundType.METAL)));
    public static final RegistryObject<DormantTectellusOreBlock> DORMANT_TECTELLUS_ORE =
            BLOCKS.register("dormant_tectellus_ore", () ->
                    new DormantTectellusOreBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.TERRACOTTA_YELLOW)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.2F, 4.5F)
                                    .sound(SoundType.DRIPSTONE_BLOCK)
                                    .randomTicks()));
    public static final RegistryObject<TectellusOreBlock> TECTELLUS_ORE =
            BLOCKS.register("tectellus_ore", () ->
                    new TectellusOreBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.TERRACOTTA_YELLOW)
                                    .requiresCorrectToolForDrops()
                                    .strength(3.0F, 4.5F)
                                    .sound(SoundType.DRIPSTONE_BLOCK)
                                    .randomTicks(),
                            UniformInt.of(3, 7)));
    public static final RegistryObject<Block> RAW_TECTELLUS_BLOCK =
            BLOCKS.register("raw_tectellus_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.FIRE)
                                    .requiresCorrectToolForDrops()
                                    .strength(15.0F, 20.0F)
                                    .sound(SoundType.METAL)));
    public static final RegistryObject<LiquidBlock> MOLTEN_TECTELLUS =
            BLOCKS.register("molten_tectellus", () ->
                    new LiquidBlock(
                            MTFluidHolders.MOLTEN_TECTELLUS.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.FIRE)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 15)
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    // Element 122
    public static final RegistryObject<Block> ELEMENT_122_BLOCK =
            BLOCKS.register("element_122_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_GREEN)
                                    .requiresCorrectToolForDrops()
                                    .strength(60.0F, 3600000.0F)
                                    .sound(SoundType.METAL)));
    public static final RegistryObject<Block> ELEMENT_122_ORE =
            BLOCKS.register("element_122_ore", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                                    .requiresCorrectToolForDrops()
                                    .strength(-1.0F, 3600000.0F)
                                    .sound(ACSoundTypes.RADROCK)));
    public static final RegistryObject<Block> RAW_ELEMENT_122_BLOCK =
            BLOCKS.register("raw_element_122_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                                    .requiresCorrectToolForDrops()
                                    .strength(60.0F, 3600000.0F)
                                    .sound(SoundType.METAL)));
    public static final RegistryObject<LiquidBlock> MOLTEN_ELEMENT_122 =
            BLOCKS.register("molten_element_122", () ->
                    new LiquidBlock(
                            MTFluidHolders.MOLTEN_ELEMENT_122.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_LIGHT_GREEN)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 15)
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    // Atlantean Bricks
    public static final RegistryObject<Block> ATLANTEAN_BRICKS =
            BLOCKS.register("atlantean_bricks", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.GOLD)
                                    .requiresCorrectToolForDrops()
                                    .strength(4.0F, 6.0F)
                                    .sound(SoundType.METAL)));
    public static final RegistryObject<Block> CRACKED_ATLANTEAN_BRICKS =
            BLOCKS.register("cracked_atlantean_bricks", () ->
                    new Block(
                            BlockBehaviour.Properties.copy(ATLANTEAN_BRICKS.get())));
    public static final RegistryObject<StairBlock> ATLANTEAN_BRICK_STAIRS =
            BLOCKS.register("atlantean_brick_stairs", () ->
                    new StairBlock(
                            () -> ATLANTEAN_BRICKS.get().defaultBlockState(),
                            BlockBehaviour.Properties.copy(ATLANTEAN_BRICKS.get())));
    public static final RegistryObject<SlabBlock> ATLANTEAN_BRICK_SLAB =
            BLOCKS.register("atlantean_brick_slab", () ->
                    new SlabBlock(
                            BlockBehaviour.Properties.copy(ATLANTEAN_BRICKS.get())));
    public static final RegistryObject<WallBlock> ATLANTEAN_BRICK_WALL =
            BLOCKS.register("atlantean_brick_wall", () ->
                    new WallBlock(
                            BlockBehaviour.Properties.copy(ATLANTEAN_BRICKS.get())));

    // Atlantean Tiles
    public static final RegistryObject<Block> ATLANTEAN_TILES =
            BLOCKS.register("atlantean_tiles", () ->
                    new Block(
                            BlockBehaviour.Properties.copy(ATLANTEAN_BRICKS.get())));
    public static final RegistryObject<Block> CRACKED_ATLANTEAN_TILES =
            BLOCKS.register("cracked_atlantean_tiles", () ->
                    new Block(
                            BlockBehaviour.Properties.copy(ATLANTEAN_TILES.get())));
    public static final RegistryObject<StairBlock> ATLANTEAN_TILE_STAIRS =
            BLOCKS.register("atlantean_tile_stairs", () ->
                    new StairBlock(
                            () -> ATLANTEAN_TILES.get().defaultBlockState(),
                            BlockBehaviour.Properties.copy(ATLANTEAN_TILES.get())));
    public static final RegistryObject<SlabBlock> ATLANTEAN_TILE_SLAB =
            BLOCKS.register("atlantean_tile_slab", () ->
                    new SlabBlock(
                            BlockBehaviour.Properties.copy(ATLANTEAN_TILES.get())));
    public static final RegistryObject<WallBlock> ATLANTEAN_TILE_WALL =
            BLOCKS.register("atlantean_tile_wall", () ->
                    new WallBlock(
                            BlockBehaviour.Properties.copy(ATLANTEAN_TILES.get())));

    // Atlantean Pillar
    public static final RegistryObject<RotatedPillarBlock> ATLANTEAN_PILLAR =
            BLOCKS.register("atlantean_pillar", () ->
                    new RotatedPillarBlock(
                            BlockBehaviour.Properties.copy(ATLANTEAN_BRICKS.get())));
    public static final RegistryObject<RotatedPillarBlock> CRACKED_ATLANTEAN_PILLAR =
            BLOCKS.register("cracked_atlantean_pillar", () ->
                    new RotatedPillarBlock(
                            BlockBehaviour.Properties.copy(ATLANTEAN_PILLAR.get())));

    // Aurichalcum
    public static final RegistryObject<Block> AURICHALCUM_BLOCK =
            BLOCKS.register("aurichalcum_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_ORANGE)
                                    .requiresCorrectToolForDrops()
                                    .strength(6.0F)
                                    .sound(SoundType.METAL)));
    public static final RegistryObject<LiquidBlock> MOLTEN_AURICHALCUM =
            BLOCKS.register("molten_aurichalcum", () ->
                    new LiquidBlock(
                            MTFluidHolders.MOLTEN_AURICHALCUM.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_ORANGE)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 14)
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    // Desolum
    public static final RegistryObject<Block> DESOLUM_BLOCK =
            BLOCKS.register("desolum_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_GRAY)
                                    .requiresCorrectToolForDrops()
                                    .strength(5.0F, 6.0F)
                                    .sound(SoundType.METAL)));
    public static final RegistryObject<LiquidBlock> MOLTEN_DESOLUM =
            BLOCKS.register("molten_desolum", () ->
                    new LiquidBlock(
                            MTFluidHolders.MOLTEN_DESOLUM.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_GRAY)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 4)
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    // Pure Light
    public static final RegistryObject<Block> IMPRISONING_COPROLITH =
            BLOCKS.register("imprisoning_coprolith", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.75F, 4.0F)
                                    .sound(SoundType.CALCITE)));

    // Prosprum
    public static final RegistryObject<Block> PROSPRUM_BLOCK =
            BLOCKS.register("prosprum_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.DIAMOND)
                                    .requiresCorrectToolForDrops()
                                    .strength(8.0F, 10.0F)
                                    .sound(SoundType.METAL)));
    public static final RegistryObject<LiquidBlock> MOLTEN_PROSPRUM =
            BLOCKS.register("molten_prosprum", () ->
                    new LiquidBlock(
                            MTFluidHolders.MOLTEN_PROSPRUM.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.DIAMOND)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 15)
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    // Earthen Gum
    public static final RegistryObject<EarthenGumBlock> EARTHEN_GUM_BLOCK =
            BLOCKS.register("earthen_gum_block", () ->
                    new EarthenGumBlock(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_PINK)
                                    .strength(0.5F)
                                    .sound(ACSoundTypes.SOFT_CANDY)));
    public static final RegistryObject<Block> EARTHEN_GUM_ORE =
            BLOCKS.register("earthen_gum_ore", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.DIRT)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.5F, 1.0F)
                                    .sound(ACSoundTypes.SOFT_CANDY)
                                    .instrument(NoteBlockInstrument.BASEDRUM)));
    public static final RegistryObject<LiquidBlock> EARTHEN_GUM =
            BLOCKS.register("earthen_gum", () ->
                    new LiquidBlock(
                            MTFluidHolders.EARTHEN_GUM.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_PINK)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    // Gumbronze
    public static final RegistryObject<Block> GUMBRONZE_BLOCK =
            BLOCKS.register("gumbronze_block", () ->
                    new Block(
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_PINK)
                                    .requiresCorrectToolForDrops()
                                    .strength(10.0F, 12.0F)
                                    .sound(SoundType.METAL)));
    public static final RegistryObject<LiquidBlock> MOLTEN_GUMBRONZE =
            BLOCKS.register("molten_gumbronze", () ->
                    new LiquidBlock(
                            MTFluidHolders.MOLTEN_GUMBRONZE.stillFluid,
                            BlockBehaviour.Properties.of()
                                    .mapColor(MapColor.COLOR_PINK)
                                    .noCollission()
                                    .strength(100.0F)
                                    .noLootTable()
                                    .replaceable()
                                    .liquid()
                                    .lightLevel((state) -> 10)
                                    .pushReaction(PushReaction.DESTROY)
                                    .sound(SoundType.EMPTY)));

    public static SoundType getSculkStoneSound() {
        if (ModList.get().isLoaded("deeperdarker")) {
            try {
                Class<?> DDSounds = Class.forName("com.kyanite.deeperdarker.content.DDSounds");
                return (SoundType) DDSounds.getField("SCULK_STONE").get(null);
            } catch (Exception e) {
                return SoundType.STONE;
            }
        } else {
            return SoundType.STONE;
        }
    }
}
