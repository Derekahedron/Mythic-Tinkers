package derekahedron.mythictinkers.datagen.recipes;

import derekahedron.mythictinkers.block.MTBlocks;
import derekahedron.mythictinkers.item.MTItems;
import derekahedron.mythictinkers.util.MTUtil;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.CompoundIngredient;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class MTRecipeProvider extends RecipeProvider {

    public MTRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Legendary Tinkering
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        MTItems.MYTHICAL_TINKERING.get())
                .requires(Items.BOOK)
                .requires(Items.ECHO_SHARD)
                .unlockedBy(
                        getHasName(Items.ECHO_SHARD),
                        has(Items.ECHO_SHARD))
                .save(consumer, MTItems.MYTHICAL_TINKERING.getId());

        // Dombstone
        stair(consumer,
                MTItems.DOMBSTONE_STAIRS.get(),
                MTItems.DOMBSTONE.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_STAIRS.get(),
                MTItems.DOMBSTONE.get());
        slab(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_SLAB.get(),
                MTItems.DOMBSTONE.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_SLAB.get(),
                MTItems.DOMBSTONE.get(),
                2);
        wall(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_WALL.get(),
                MTItems.DOMBSTONE.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_WALL.get(),
                MTItems.DOMBSTONE.get());

        // Dombstone Bricks
        polished(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICKS.get(),
                MTItems.DOMBSTONE.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICKS.get(),
                MTItems.DOMBSTONE.get());
        stair(consumer,
                MTItems.DOMBSTONE_BRICK_STAIRS.get(),
                MTItems.DOMBSTONE_BRICKS.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICK_STAIRS.get(),
                MTItems.DOMBSTONE.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICK_STAIRS.get(),
                MTItems.DOMBSTONE_BRICKS.get());
        slab(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICK_SLAB.get(),
                MTItems.DOMBSTONE_BRICKS.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICK_SLAB.get(),
                MTItems.DOMBSTONE.get(),
                2);
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICK_SLAB.get(),
                MTItems.DOMBSTONE_BRICKS.get(),
                2);
        wall(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICK_WALL.get(),
                MTItems.DOMBSTONE_BRICKS.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICK_WALL.get(),
                MTItems.DOMBSTONE.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DOMBSTONE_BRICK_WALL.get(),
                MTItems.DOMBSTONE_BRICKS.get());

        // Scarlet Neodymium
        nineBlockStorageRecipes(consumer,
                RecipeCategory.MISC,
                MTItems.SCARLET_NEODYMIUM_NUGGET.get(),
                RecipeCategory.MISC,
                ACItemRegistry.SCARLET_NEODYMIUM_INGOT.get(),
                MTUtil.location("scarlet_neodymium_ingot_from_nuggets").toString(),
                null,
                MTItems.SCARLET_NEODYMIUM_NUGGET.getId().toString(),
                null);

        // Azure Neodymium
        nineBlockStorageRecipes(consumer,
                RecipeCategory.MISC,
                MTItems.AZURE_NEODYMIUM_NUGGET.get(),
                RecipeCategory.MISC,
                ACItemRegistry.AZURE_NEODYMIUM_INGOT.get(),
                MTUtil.location("azure_neodymium_ingot_from_nuggets").toString(),
                null,
                MTItems.AZURE_NEODYMIUM_NUGGET.getId().toString(),
                null);

        // Byzantium Energized Galena
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                        MTItems.BYZANTIUM_ENERGIZED_GALENA.get(),
                        8)
                .define('G', ACBlockRegistry.GALENA.get())
                .define('N', MTItems.RAW_BYZANTIUM_NEODYMIUM.get())
                .pattern("GGG")
                .pattern("GNG")
                .pattern("GGG")
                .unlockedBy(
                        getHasName(MTItems.RAW_BYZANTIUM_NEODYMIUM.get()),
                        has(MTItems.RAW_BYZANTIUM_NEODYMIUM.get()))
                .save(consumer, MTItems.BYZANTIUM_ENERGIZED_GALENA.getId());

        // Byzantium Neodymium Ingot
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        MTItems.BYZANTIUM_NEODYMIUM_INGOT.get())
                .requires(MTItems.RAW_BYZANTIUM_NEODYMIUM.get())
                .requires(MTItems.RAW_BYZANTIUM_NEODYMIUM.get())
                .requires(MTItems.RAW_BYZANTIUM_NEODYMIUM.get())
                .requires(Tags.Items.INGOTS_IRON)
                .requires(Tags.Items.INGOTS_IRON)
                .requires(Tags.Items.INGOTS_IRON)
                .group("byzantium_neodymium_ingot")
                .unlockedBy(
                        getHasName(MTItems.RAW_BYZANTIUM_NEODYMIUM.get()),
                        has(MTItems.RAW_BYZANTIUM_NEODYMIUM.get()))
                .save(consumer, MTItems.BYZANTIUM_NEODYMIUM_INGOT.getId());

        // Byzantium Neodymium Node
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                        MTItems.BYZANTIUM_NEODYMIUM_NODE.get())
                .define('N', MTItems.RAW_BYZANTIUM_NEODYMIUM.get())
                .pattern(" N ")
                .pattern("NNN")
                .pattern(" N ")
                .unlockedBy(
                        getHasName(MTItems.RAW_BYZANTIUM_NEODYMIUM.get()),
                        has(MTItems.RAW_BYZANTIUM_NEODYMIUM.get()))
                .save(consumer, MTItems.BYZANTIUM_NEODYMIUM_NODE.getId());

        // Byzantium Neodymium Pillar
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                        MTItems.BYZANTIUM_NEODYMIUM_PILLAR.get(),
                        2)
                .define('N', MTItems.RAW_BYZANTIUM_NEODYMIUM.get())
                .pattern("NN")
                .pattern("NN")
                .pattern("NN")
                .unlockedBy(
                        getHasName(MTItems.RAW_BYZANTIUM_NEODYMIUM.get()),
                        has(MTItems.RAW_BYZANTIUM_NEODYMIUM.get()))
                .save(consumer, MTItems.BYZANTIUM_NEODYMIUM_PILLAR.getId());

        // Byzantium Neodymium
        nineBlockStorageRecipesRecipesWithCustomUnpacking(consumer,
                RecipeCategory.MISC,
                MTItems.BYZANTIUM_NEODYMIUM_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.BYZANTIUM_NEODYMIUM_BLOCK.get(),
                "byzantium_neodymium_ingot_from_byzantium_neodymium_block",
                "byzantium_neodymium_ingot");
        nineBlockStorageRecipesWithCustomPacking(consumer,
                RecipeCategory.MISC,
                MTItems.BYZANTIUM_NEODYMIUM_NUGGET.get(),
                RecipeCategory.MISC,
                MTItems.BYZANTIUM_NEODYMIUM_INGOT.get(),
                "byzantium_neodymium_ingot_from_nuggets",
                "byzantium_neodymium_ingot");

        // Tectellus Ore
        oreSmelting(consumer,
                List.of(MTItems.TECTELLUS_ORE.get(), MTItems.RAW_TECTELLUS.get()),
                RecipeCategory.MISC, MTItems.TECTELLUS_INGOT.get(),
                2.0F, 200,
                "tectellus_ingot");
        oreBlasting(consumer,
                List.of(MTItems.TECTELLUS_ORE.get(), MTItems.RAW_TECTELLUS.get()),
                RecipeCategory.MISC, MTItems.TECTELLUS_INGOT.get(),
                2.0F, 100,
                "tectellus_ingot");

        // Tectellus
        nineBlockStorageRecipes(consumer,
                RecipeCategory.MISC,
                MTItems.RAW_TECTELLUS.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.RAW_TECTELLUS_BLOCK.get());
        nineBlockStorageRecipesRecipesWithCustomUnpacking(consumer,
                RecipeCategory.MISC,
                MTItems.TECTELLUS_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.TECTELLUS_BLOCK.get(),
                "tectellus_ingot_from_tectellus_block",
                "tectellus_ingot");
        nineBlockStorageRecipesWithCustomPacking(consumer,
                RecipeCategory.MISC,
                MTItems.TECTELLUS_NUGGET.get(),
                RecipeCategory.MISC,
                MTItems.TECTELLUS_INGOT.get(),
                "tectellus_ingot_from_nuggets",
                "tectellus_ingot");

        // Element 122 Ore
        oreSmelting(consumer,
                List.of(MTItems.ELEMENT_122_ORE.get(), MTItems.RAW_ELEMENT_122.get()),
                RecipeCategory.MISC, MTItems.ELEMENT_122_INGOT.get(),
                3.0F, 200,
                "element_122_ingot");
        oreBlasting(consumer,
                List.of(MTItems.ELEMENT_122_ORE.get(), MTItems.RAW_ELEMENT_122.get()),
                RecipeCategory.MISC, MTItems.ELEMENT_122_INGOT.get(),
                3.0F, 100,
                "element_122_ingot");

        // Element 122
        nineBlockStorageRecipes(consumer,
                RecipeCategory.MISC,
                MTItems.RAW_ELEMENT_122.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.RAW_ELEMENT_122_BLOCK.get());
        nineBlockStorageRecipesRecipesWithCustomUnpacking(consumer,
                RecipeCategory.MISC,
                MTItems.ELEMENT_122_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ELEMENT_122_BLOCK.get(),
                "element_122_ingot_from_element_122_block",
                "element_122_ingot");
        nineBlockStorageRecipesWithCustomPacking(consumer,
                RecipeCategory.MISC,
                MTItems.ELEMENT_122_NUGGET.get(),
                RecipeCategory.MISC,
                MTItems.ELEMENT_122_INGOT.get(),
                "element_122_ingot_from_nuggets",
                "element_122_ingot");

        // Atlantean Bricks
        smeltingResultFromBase(consumer,
                MTItems.CRACKED_ATLANTEAN_BRICKS.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        stair(consumer,
                MTItems.ATLANTEAN_BRICK_STAIRS.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_BRICK_STAIRS.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        slab(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_BRICK_SLAB.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_BRICK_SLAB.get(),
                MTItems.ATLANTEAN_BRICKS.get(),
                2);
        wall(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_BRICK_WALL.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_BRICK_WALL.get(),
                MTItems.ATLANTEAN_BRICKS.get());

        // Atlantean Tiles
        polished(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILES.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILES.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        smeltingResultFromBase(consumer,
                MTItems.CRACKED_ATLANTEAN_TILES.get(),
                MTItems.ATLANTEAN_TILES.get());
        stair(consumer,
                MTItems.ATLANTEAN_TILE_STAIRS.get(),
                MTItems.ATLANTEAN_TILES.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILE_STAIRS.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILE_STAIRS.get(),
                MTItems.ATLANTEAN_TILES.get());
        slab(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILE_SLAB.get(),
                MTItems.ATLANTEAN_TILES.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILE_SLAB.get(),
                MTItems.ATLANTEAN_BRICKS.get(),
                2);
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILE_SLAB.get(),
                MTItems.ATLANTEAN_TILES.get(),
                2);
        wall(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILE_WALL.get(),
                MTItems.ATLANTEAN_TILES.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILE_WALL.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_TILE_WALL.get(),
                MTItems.ATLANTEAN_TILES.get());

        // Atlantean Pillar
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS,
                        MTBlocks.ATLANTEAN_PILLAR.get(),
                        2)
                .define('#', MTBlocks.ATLANTEAN_BRICKS.get())
                .pattern("#")
                .pattern("#")
                .unlockedBy(getHasName(MTBlocks.ATLANTEAN_BRICKS.get()), has(MTBlocks.ATLANTEAN_BRICKS.get()))
                .save(consumer);
        stonecutterResultFromBase(consumer,
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.ATLANTEAN_PILLAR.get(),
                MTItems.ATLANTEAN_BRICKS.get());
        smeltingResultFromBase(consumer,
                MTItems.CRACKED_ATLANTEAN_PILLAR.get(),
                MTItems.ATLANTEAN_PILLAR.get());

        // Aurichalcum
        nineBlockStorageRecipesRecipesWithCustomUnpacking(consumer,
                RecipeCategory.MISC,
                MTItems.AURICHALCUM_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.AURICHALCUM_BLOCK.get(),
                "aurichalcum_ingot_from_aurichalcum_block",
                "aurichalcum_ingot");
        nineBlockStorageRecipesWithCustomPacking(consumer,
                RecipeCategory.MISC,
                MTItems.AURICHALCUM_NUGGET.get(),
                RecipeCategory.MISC,
                MTItems.AURICHALCUM_INGOT.get(),
                "aurichalcum_ingot_from_nuggets",
                "aurichalcum_ingot");

        // Desolum
        nineBlockStorageRecipesRecipesWithCustomUnpacking(consumer,
                RecipeCategory.MISC,
                MTItems.DESOLUM_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.DESOLUM_BLOCK.get(),
                "desolum_ingot_from_desolum_block",
                "desolum_ingot");
        nineBlockStorageRecipesWithCustomPacking(consumer,
                RecipeCategory.MISC,
                MTItems.DESOLUM_NUGGET.get(),
                RecipeCategory.MISC,
                MTItems.DESOLUM_INGOT.get(),
                "desolum_ingot_from_nuggets",
                "desolum_ingot");

        // Pure Light
        for (int i = 2; i <= 9; i++) {
            ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                            MTItems.PURE_LIGHT.get(), i)
                    .requires(Ingredient.of(MTItems.PURE_LIGHT.get()));

            for (int j = 0; j < i - 2; j++) {
                builder = builder.requires(CompoundIngredient.of(
                        Ingredient.of(MTItems.PURE_LIGHT.get()),
                        Ingredient.of(ACItemRegistry.PURE_DARKNESS.get())));
            }

            builder
                    .requires(Ingredient.of(ACItemRegistry.PURE_DARKNESS.get()))
                    .group("pure_light")
                    .unlockedBy(
                            getHasName(MTItems.PURE_LIGHT.get()),
                            has(MTItems.PURE_LIGHT.get()))
                    .save(consumer, MTItems.PURE_LIGHT.getId().withSuffix("_" + i));
        }

        // Prosprum
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,
                        MTItems.PROSPRUM_INGOT.get())
                .requires(MTItems.PURE_LIGHT.get())
                .requires(MTItems.DESOLUM_INGOT.get())
                .group("prosprum_ingot")
                .unlockedBy(
                        getHasName(MTItems.PURE_LIGHT.get()),
                        has(MTItems.PURE_LIGHT.get()))
                .save(consumer, MTUtil.location("prosprum_ingot_from_desolum_ingot"));
        nineBlockStorageRecipesRecipesWithCustomUnpacking(consumer,
                RecipeCategory.MISC,
                MTItems.PROSPRUM_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.PROSPRUM_BLOCK.get(),
                "prosprum_ingot_from_prosprum_block",
                "prosprum_ingot");
        nineBlockStorageRecipesWithCustomPacking(consumer,
                RecipeCategory.MISC,
                MTItems.PROSPRUM_NUGGET.get(),
                RecipeCategory.MISC,
                MTItems.PROSPRUM_INGOT.get(),
                "prosprum_ingot_from_nuggets",
                "prosprum_ingot");

        // Earthen Gum
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MTItems.EARTHEN_GUM_WAD.get(), 4)
                .requires(MTItems.EARTHEN_GUM_BLOCK.get())
                .unlockedBy(getHasName(MTItems.EARTHEN_GUM_BLOCK.get()), has(MTItems.EARTHEN_GUM_BLOCK.get()))
                .save(consumer, MTItems.EARTHEN_GUM_WAD.getId());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MTItems.EARTHEN_GUM_BLOCK.get())
                .define('#', MTItems.EARTHEN_GUM_WAD.get())
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(MTItems.EARTHEN_GUM_WAD.get()), has(MTItems.EARTHEN_GUM_WAD.get()))
                .save(consumer, MTItems.EARTHEN_GUM_BLOCK.getId());

        // Gumbronze
        nineBlockStorageRecipesRecipesWithCustomUnpacking(consumer,
                RecipeCategory.MISC,
                MTItems.GUMBRONZE_INGOT.get(),
                RecipeCategory.BUILDING_BLOCKS,
                MTItems.GUMBRONZE_BLOCK.get(),
                "gumbronze_ingot_from_gumbronze_block",
                "gumbronze_ingot");
        nineBlockStorageRecipesWithCustomPacking(consumer,
                RecipeCategory.MISC,
                MTItems.GUMBRONZE_NUGGET.get(),
                RecipeCategory.MISC,
                MTItems.GUMBRONZE_INGOT.get(),
                "gumbronze_ingot_from_nuggets",
                "gumbronze_ingot");
    }

    protected static void nineBlockStorageRecipes(
            Consumer<FinishedRecipe> consumer,
            RecipeCategory smallItemCategory,
            ItemLike smallItem,
            RecipeCategory largeItemCategory,
            ItemLike largeItem) {
        nineBlockStorageRecipes(
                consumer,
                smallItemCategory,
                smallItem,
                largeItemCategory,
                largeItem,
                withNamespace(largeItem, getSimpleRecipeName(largeItem)),
                null,
                withNamespace(smallItem, getSimpleRecipeName(smallItem)),
                null);
    }

    protected static void nineBlockStorageRecipesWithCustomPacking(
            Consumer<FinishedRecipe> consumer,
            RecipeCategory smallItemCategory,
            ItemLike smallItem,
            RecipeCategory largeItemCategory,
            ItemLike largeItem,
            String largeItemRecipeName,
            @Nullable String largeItemGroupName) {
        nineBlockStorageRecipes(
                consumer,
                smallItemCategory,
                smallItem,
                largeItemCategory,
                largeItem,
                withNamespace(largeItem, largeItemRecipeName),
                largeItemGroupName,
                withNamespace(smallItem, getSimpleRecipeName(smallItem)),
                null);
    }

    protected static void nineBlockStorageRecipesRecipesWithCustomUnpacking(
            Consumer<FinishedRecipe> consumer,
            RecipeCategory smallItemCategory,
            ItemLike smallItem,
            RecipeCategory largeItemCategory,
            ItemLike largeItem,
            String smallItemRecipeName,
            @Nullable String smallItemGroupName) {
        nineBlockStorageRecipes(
                consumer,
                smallItemCategory,
                smallItem,
                largeItemCategory,
                largeItem,
                withNamespace(largeItem, getSimpleRecipeName(largeItem)),
                null,
                withNamespace(smallItem, smallItemRecipeName),
                smallItemGroupName);
    }

    protected static void stonecutterResultFromBase(
            Consumer<FinishedRecipe> consumer,
            RecipeCategory recipeCategory,
            ItemLike output,
            ItemLike input) {
        stonecutterResultFromBase(consumer,
                recipeCategory,
                output,
                input,
                1);
    }

    protected static void stonecutterResultFromBase(
            Consumer<FinishedRecipe> consumer,
            RecipeCategory recipeCategory,
            ItemLike output,
            ItemLike input,
            int amount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(input), recipeCategory, output, amount)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer, withNamespace(input, getConversionRecipeName(output, input) + "_stonecutting"));
    }

    protected static void smeltingResultFromBase(
            Consumer<FinishedRecipe> consumer,
            ItemLike output,
            ItemLike input) {
        SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(input),
                RecipeCategory.BUILDING_BLOCKS,
                output,
                0.1F,
                200)
                .unlockedBy(getHasName(input), has(input))
                .save(consumer);
    }

    protected static void oreSmelting(
            Consumer<FinishedRecipe> consumer,
            List<ItemLike> inputs,
            RecipeCategory recipeCategory,
            ItemLike output,
            float expReward,
            int cookTicks,
            String groupName) {
        oreCooking(
                consumer,
                RecipeSerializer.SMELTING_RECIPE,
                inputs,
                recipeCategory,
                output,
                expReward,
                cookTicks,
                groupName,
                "_from_smelting");
    }

    protected static void oreBlasting(
            Consumer<FinishedRecipe> consumer,
            List<ItemLike> inputs,
            RecipeCategory recipeCategory,
            ItemLike output,
            float expReward,
            int cookTicks,
            String groupName) {
        oreCooking(
                consumer,
                RecipeSerializer.BLASTING_RECIPE,
                inputs,
                recipeCategory,
                output,
                expReward,
                cookTicks,
                groupName,
                "_from_blasting");
    }

    protected static void oreCooking(
            Consumer<FinishedRecipe> consumer,
            RecipeSerializer<? extends AbstractCookingRecipe> recipeSerializer,
            List<ItemLike> inputs,
            RecipeCategory recipeCategory,
            ItemLike output,
            float expReward,
            int cookTicks,
            String groupName,
            String suffix) {
        for (ItemLike input : inputs) {
            SimpleCookingRecipeBuilder.generic(
                    Ingredient.of(input),
                    recipeCategory,
                    output,
                    expReward,
                    cookTicks,
                    recipeSerializer)
                    .group(groupName)
                    .unlockedBy(getHasName(input), has(input))
                    .save(consumer, withNamespace(output, getItemName(output) + suffix + "_" + getItemName(input)));
        }
    }

    protected static void stair(
            Consumer<FinishedRecipe> consumer, ItemLike stairs, ItemLike base) {
        stairBuilder(stairs, Ingredient.of(base)).unlockedBy(getHasName(base), has(base)).save(consumer);
    }

    @SuppressWarnings("deprecation")
    protected static String withNamespace(ItemLike item, String path) {
        String namespace = BuiltInRegistries.ITEM.getKey(item.asItem()).getNamespace();
        return namespace + ":" + path;
    }
}
