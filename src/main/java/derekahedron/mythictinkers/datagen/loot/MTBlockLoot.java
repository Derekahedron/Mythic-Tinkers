package derekahedron.mythictinkers.datagen.loot;

import derekahedron.mythictinkers.block.MTBlocks;
import derekahedron.mythictinkers.item.MTItems;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.google.common.collect.ImmutableSet;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class MTBlockLoot extends BlockLootSubProvider {
    public static final Set<Item> EXPLOSION_RESISTANT = ImmutableSet.of();

    public MTBlockLoot() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        // Styx
        dropWhenSilkTouch(MTBlocks.STYGIAN_DEEPSLATE.get());
        dropWhenSilkTouch(MTBlocks.STYGIAN_SCULK_STONE.get());
        dropWhenSilkTouch(MTBlocks.STYGIAN_GLOOMSLATE.get());

        // Dombstone
        dropSelf(MTBlocks.DOMBSTONE.get());
        dropSelf(MTBlocks.DOMBSTONE_STAIRS.get());
        add(MTBlocks.DOMBSTONE_SLAB.get(),
                createSlabItemTable(MTBlocks.DOMBSTONE_SLAB.get()));
        dropSelf(MTBlocks.DOMBSTONE_WALL.get());

        // Dombstone Bricks
        dropSelf(MTBlocks.DOMBSTONE_BRICKS.get());
        dropSelf(MTBlocks.DOMBSTONE_BRICK_STAIRS.get());
        add(MTBlocks.DOMBSTONE_BRICK_SLAB.get(),
                createSlabItemTable(MTBlocks.DOMBSTONE_BRICK_SLAB.get()));
        dropSelf(MTBlocks.DOMBSTONE_BRICK_WALL.get());

        // Byzantium Neodymium
        add(MTBlocks.BYZANTIUM_ENERGIZED_GALENA.get(),
                createEnergizedGalenaDrops(
                        MTBlocks.BYZANTIUM_ENERGIZED_GALENA.get(),
                        ACBlockRegistry.GALENA.get()));
        add(MTBlocks.BYZANTIUM_NEODYMIUM_NODE.get(),
                createNeodymiumNodeDrops(
                        MTBlocks.BYZANTIUM_NEODYMIUM_NODE.get(),
                        MTItems.RAW_BYZANTIUM_NEODYMIUM.get()));
        add(MTBlocks.BYZANTIUM_NEODYMIUM_PILLAR.get(),
                createNeodymiumPillarDrops(
                        MTBlocks.BYZANTIUM_NEODYMIUM_PILLAR.get(),
                        MTItems.RAW_BYZANTIUM_NEODYMIUM.get()));
        dropSelf(MTBlocks.BYZANTIUM_NEODYMIUM_BLOCK.get());

        // Tectellus
        dropSelf(MTBlocks.TECTELLUS_BLOCK.get());
        add(MTBlocks.DORMANT_TECTELLUS_ORE.get(),
                createSingleItemTableWithSilkTouch(
                        MTBlocks.DORMANT_TECTELLUS_ORE.get(),
                        ACBlockRegistry.LIMESTONE.get()));
        add(MTBlocks.TECTELLUS_ORE.get(),
                createOreDrop(
                        MTBlocks.TECTELLUS_ORE.get(),
                        MTItems.RAW_TECTELLUS.get()));
        dropSelf(MTBlocks.RAW_TECTELLUS_BLOCK.get());

        // Element 122
        dropSelf(MTBlocks.ELEMENT_122_BLOCK.get());
        add(MTBlocks.ELEMENT_122_ORE.get(),
                createSilkTouchDispatchTable(
                        MTBlocks.ELEMENT_122_ORE.get(),
                        LootItem.lootTableItem(MTItems.RAW_ELEMENT_122.get()).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
        dropSelf(MTBlocks.RAW_ELEMENT_122_BLOCK.get());

        // Atlantean Bricks
        dropSelf(MTBlocks.ATLANTEAN_BRICKS.get());
        dropSelf(MTBlocks.CRACKED_ATLANTEAN_BRICKS.get());
        dropSelf(MTBlocks.ATLANTEAN_BRICK_STAIRS.get());
        add(MTBlocks.ATLANTEAN_BRICK_SLAB.get(),
                createSlabItemTable(MTBlocks.ATLANTEAN_BRICK_SLAB.get()));
        dropSelf(MTBlocks.ATLANTEAN_BRICK_WALL.get());

        // Atlantean Tiles
        dropSelf(MTBlocks.ATLANTEAN_TILES.get());
        dropSelf(MTBlocks.CRACKED_ATLANTEAN_TILES.get());
        dropSelf(MTBlocks.ATLANTEAN_TILE_STAIRS.get());
        add(MTBlocks.ATLANTEAN_TILE_SLAB.get(),
                createSlabItemTable(MTBlocks.ATLANTEAN_TILE_SLAB.get()));
        dropSelf(MTBlocks.ATLANTEAN_TILE_WALL.get());

        // Atlantean Pillar
        dropSelf(MTBlocks.ATLANTEAN_PILLAR.get());
        dropSelf(MTBlocks.CRACKED_ATLANTEAN_PILLAR.get());

        // Aurichalcum
        dropSelf(MTBlocks.AURICHALCUM_BLOCK.get());

        // Desolum
        dropSelf(MTBlocks.DESOLUM_BLOCK.get());

        // Pure Light
        add(MTBlocks.IMPRISONING_COPROLITH.get(),
                createSingleItemTableWithSilkTouch(
                        MTBlocks.IMPRISONING_COPROLITH.get(),
                        MTItems.PURE_LIGHT.get()));

        // Prosprum
        dropSelf(MTBlocks.PROSPRUM_BLOCK.get());

        // Earthen Gum
        dropSelf(MTBlocks.EARTHEN_GUM_BLOCK.get());
        add(MTBlocks.EARTHEN_GUM_ORE.get(),
                createSilkTouchDispatchTable(MTBlocks.EARTHEN_GUM_ORE.get(),
                        LootItem.lootTableItem(MTItems.EARTHEN_GUM_WAD.get())
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                        Enchantments.BLOCK_FORTUNE,
                                        0.33F, 0.5F, 0.67F, 0.84F))));

        // Gumbronze
        dropSelf(MTBlocks.GUMBRONZE_BLOCK.get());
    }

    public LootTable.Builder createEnergizedGalenaDrops(Block block, ItemLike galena) {
        return createSilkTouchDispatchTable(block,
                LootItem.lootTableItem(galena)
                        .apply(ApplyExplosionDecay.explosionDecay()));
    }

    public LootTable.Builder createNeodymiumNodeDrops(Block block, ItemLike rawNeodymium) {
        return createSilkTouchDispatchTable(block,
                LootItem.lootTableItem(rawNeodymium)
                        .apply(SetItemCountFunction.setCount(
                                UniformGenerator.between(2.0F, 5.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1))
                        .apply(LimitCount.limitCount(
                                IntRange.range(1, 5)))
                        .apply(ApplyExplosionDecay.explosionDecay()));
    }

    public LootTable.Builder createNeodymiumPillarDrops(Block block, ItemLike rawNeodymium) {
        return createSilkTouchDispatchTable(block,
                LootItem.lootTableItem(rawNeodymium)
                        .apply(SetItemCountFunction.setCount(
                                UniformGenerator.between(1.0F, 2.0F)))
                        .apply(LimitCount.limitCount(
                                IntRange.range(1, 3)))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                Enchantments.BLOCK_FORTUNE, 0.1F, 0.14285715F, 0.25F, 1.0F))
                        .otherwise(LootItem.lootTableItem(block))
                        .when(ExplosionCondition.survivesExplosion()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return MTBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
