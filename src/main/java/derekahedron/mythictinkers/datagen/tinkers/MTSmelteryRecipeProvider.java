package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.fluid.MTFluidHolders;
import derekahedron.mythictinkers.fluid.MTFluids;
import derekahedron.mythictinkers.item.MTItems;
import derekahedron.mythictinkers.recipe.MTFluidValues;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fluids.FluidStack;
import slimeknights.mantle.recipe.helper.FluidOutput;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.data.recipe.ISmelteryRecipeHelper;
import slimeknights.tconstruct.library.recipe.FluidValues;
import slimeknights.tconstruct.library.recipe.alloying.AlloyRecipeBuilder;
import slimeknights.tconstruct.library.recipe.casting.ItemCastingRecipeBuilder;
import slimeknights.tconstruct.library.recipe.fuel.MeltingFuelBuilder;
import slimeknights.tconstruct.library.recipe.melting.MeltingRecipeBuilder;
import slimeknights.tconstruct.smeltery.data.Byproduct;

import java.util.function.Consumer;

public class MTSmelteryRecipeProvider extends RecipeProvider implements ISmelteryRecipeHelper {
    public static final String MELTING_FOLDER = "smeltery/melting/";
    public static final String CASTING_FOLDER = "smeltery/casting/";
    public static final String METAL_MELTING_FOLDER = MELTING_FOLDER + "metal/";
    public static final String METAL_CASTING_FOLDER = CASTING_FOLDER + "metal/";
    public static final String GUM_MELTING_FOLDER = MELTING_FOLDER + "gum/";
    public static final String GUM_CASTING_FOLDER = CASTING_FOLDER + "gum/";
    public static final String ALLOYS_FOLDER = "smeltery/alloys/";
    public static final String FUEL_FOLDER = MELTING_FOLDER + "fuel/";

    public MTSmelteryRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    public String getModId() {
        return derekahedron.mythictinkers.MythicTinkers.MOD_ID;
    }

    @Override
    public String getName() {
        return String.format("%s Smeltery Recipes", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Iron from Energized Galena
        MeltingRecipeBuilder.melting(
                Ingredient.of(ACBlockRegistry.ENERGIZED_GALENA_NEUTRAL.get()),
                        TinkerFluids.moltenIron.get(),
                        FluidOutput.fromFluid(TinkerFluids.moltenIron.get(), FluidValues.NUGGET / 2).getAmount(),
                        1.0F / 15.0F)
                .save(consumer, location(METAL_MELTING_FOLDER + "iron/energized_galena"));

        // Scarlet Neodymium
        molten(
                consumer,
                MTFluidHolders.MOLTEN_SCARLET_NEODYMIUM.fluidObject)
                .castingFolder(METAL_CASTING_FOLDER)
                .meltingFolder(METAL_MELTING_FOLDER)
                .metal();

        // Scarlet Neodymium from Energized Galena
        MeltingRecipeBuilder.melting(
                Ingredient.of(ACBlockRegistry.ENERGIZED_GALENA_SCARLET.get()),
                        MTFluids.MOLTEN_SCARLET_NEODYMIUM.get(),
                        FluidOutput.fromFluid(MTFluids.MOLTEN_SCARLET_NEODYMIUM.get(), FluidValues.NUGGET / 2).getAmount(),
                        1.0F / 15.0F)
                .save(consumer, location(METAL_MELTING_FOLDER + "scarlet_neodymium/energized_galena"));

        // Azure Neodymium
        molten(
                consumer,
                MTFluidHolders.MOLTEN_AZURE_NEODYMIUM.fluidObject)
                .castingFolder(METAL_CASTING_FOLDER)
                .meltingFolder(METAL_MELTING_FOLDER)
                .metal();

        // Azure Neodymium from Energized Galena
        MeltingRecipeBuilder.melting(
                Ingredient.of(ACBlockRegistry.ENERGIZED_GALENA_AZURE.get()),
                        MTFluids.MOLTEN_AZURE_NEODYMIUM.get(),
                        FluidOutput.fromFluid(MTFluids.MOLTEN_AZURE_NEODYMIUM.get(), FluidValues.NUGGET / 2).getAmount(),
                        1.0F / 15.0F)
                .save(consumer, location(METAL_MELTING_FOLDER + "azure_neodymium/energized_galena"));

        // Byzantium Neodymium
        molten(
                consumer,
                MTFluidHolders.MOLTEN_BYZANTIUM_NEODYMIUM.fluidObject)
                .castingFolder(METAL_CASTING_FOLDER)
                .meltingFolder(METAL_MELTING_FOLDER)
                .metal();

        // Byzantium Neodymium from Energized Galena
        MeltingRecipeBuilder.melting(
                Ingredient.of(MTItems.BYZANTIUM_ENERGIZED_GALENA.get()),
                        MTFluids.MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                        FluidOutput.fromFluid(MTFluids.MOLTEN_BYZANTIUM_NEODYMIUM.get(), FluidValues.NUGGET / 2).getAmount(),
                        1.0F / 15.0F)
                .save(consumer, location(METAL_MELTING_FOLDER + "byzantium_neodymium/energized_galena"));

        // Tectellus
        molten(
                consumer,
                MTFluidHolders.MOLTEN_TECTELLUS.fluidObject)
                .castingFolder(METAL_CASTING_FOLDER)
                .meltingFolder(METAL_MELTING_FOLDER)
                .ore(Byproduct.DIAMOND)
                .metal();

        // Element 122
        molten(
                consumer,
                MTFluidHolders.MOLTEN_ELEMENT_122.fluidObject)
                .castingFolder(METAL_CASTING_FOLDER)
                .meltingFolder(METAL_MELTING_FOLDER)
                .ore(Byproduct.DEBRIS)
                .metal();

        // Atlantean
        MeltingRecipeBuilder.melting(
                        Ingredient.of(
                                MTItems.ATLANTEAN_BRICKS.get(),
                                MTItems.CRACKED_ATLANTEAN_BRICKS.get(),
                                MTItems.ATLANTEAN_BRICK_STAIRS.get(),
                                MTItems.ATLANTEAN_BRICK_WALL.get(),
                                MTItems.ATLANTEAN_TILES.get(),
                                MTItems.CRACKED_ATLANTEAN_TILES.get(),
                                MTItems.ATLANTEAN_TILE_STAIRS.get(),
                                MTItems.ATLANTEAN_TILE_WALL.get(),
                                MTItems.ATLANTEAN_PILLAR.get(),
                                MTItems.CRACKED_ATLANTEAN_PILLAR.get()),
                        MTFluids.MOLTEN_AURICHALCUM.get(),
                        FluidOutput.fromFluid(MTFluids.MOLTEN_AURICHALCUM.get(), FluidValues.NUGGET * 2).getAmount(),
                        1.0F / 2.0F)
                .save(consumer, location(METAL_MELTING_FOLDER + "aurichalcum/atlantean"));
        MeltingRecipeBuilder.melting(
                        Ingredient.of(
                                MTItems.ATLANTEAN_BRICK_SLAB.get(),
                                MTItems.ATLANTEAN_TILE_SLAB.get()),
                        MTFluids.MOLTEN_AURICHALCUM.get(),
                        FluidOutput.fromFluid(MTFluids.MOLTEN_AURICHALCUM.get(), FluidValues.NUGGET).getAmount(),
                        1.0F / 3.0F)
                .save(consumer, location(METAL_MELTING_FOLDER + "aurichalcum/atlantean_slab"));

        // Aurichalcum
        molten(
                consumer,
                MTFluidHolders.MOLTEN_AURICHALCUM.fluidObject)
                .castingFolder(METAL_CASTING_FOLDER)
                .meltingFolder(METAL_MELTING_FOLDER)
                .metal();

        // Desolum
        molten(
                consumer,
                MTFluidHolders.MOLTEN_DESOLUM.fluidObject)
                .castingFolder(METAL_CASTING_FOLDER)
                .meltingFolder(METAL_MELTING_FOLDER)
                .metal();

        // Desolum from Desolate Dagger
        MeltingRecipeBuilder.melting(Ingredient.of(ACItemRegistry.DESOLATE_DAGGER.get()),
                        MTFluids.MOLTEN_DESOLUM.get(),
                        FluidValues.INGOT * 2,
                        1.0F)
                .save(consumer, location(METAL_MELTING_FOLDER + "desolum/desolate_dagger"));

        // Prosprum
        molten(
                consumer,
                MTFluidHolders.MOLTEN_PROSPRUM.fluidObject)
                .castingFolder(METAL_CASTING_FOLDER)
                .meltingFolder(METAL_MELTING_FOLDER)
                .metal();

        // Earthen Gum
        MeltingRecipeBuilder.melting(Ingredient.of(MTItems.EARTHEN_GUM_WAD.get()),
                        MTFluids.EARTHEN_GUM.get(),
                        MTFluidValues.GUM_WAD,
                        1.0F)
                .save(consumer, location(GUM_MELTING_FOLDER + "earthen_gum/wad"));
        MeltingRecipeBuilder.melting(Ingredient.of(MTItems.EARTHEN_GUM_BLOCK.get()),
                        MTFluids.EARTHEN_GUM.get(),
                        MTFluidValues.GUM_BLOCK,
                        2.0F)
                .save(consumer, location(GUM_MELTING_FOLDER + "earthen_gum/block"));
        ItemCastingRecipeBuilder.tableRecipe(MTItems.EARTHEN_GUM_WAD.get())
                .setFluidAndTime(new FluidStack(MTFluids.EARTHEN_GUM.get(), MTFluidValues.GUM_WAD))
                .save(consumer, location(GUM_CASTING_FOLDER + "earthen_gum/wad"));
        ItemCastingRecipeBuilder.basinRecipe(MTItems.EARTHEN_GUM_BLOCK.get())
                .setFluidAndTime(new FluidStack(MTFluids.EARTHEN_GUM.get(), MTFluidValues.GUM_BLOCK))
                .save(consumer, location(GUM_CASTING_FOLDER + "earthen_gum/block"));

        // Gumbronze
        molten(
                consumer,
                MTFluidHolders.MOLTEN_GUMBRONZE.fluidObject)
                .castingFolder(METAL_CASTING_FOLDER)
                .meltingFolder(METAL_MELTING_FOLDER)
                .metal();

        // Alloy Gumbronze
        AlloyRecipeBuilder.alloy(MTFluids.MOLTEN_GUMBRONZE.get(), FluidValues.INGOT)
                .addInput(MTFluids.EARTHEN_GUM.get(), MTFluidValues.GUM_BLOCK)
                .addInput(TinkerFluids.moltenAmethystBronze.ingredient(FluidValues.INGOT))
                .save(consumer, MTFluids.MOLTEN_GUMBRONZE.getId().withPrefix(ALLOYS_FOLDER));

        // Styx Fuel
        MeltingFuelBuilder.fuel(
                new FluidStack(MTFluids.STYX.get(), 50),
                        150)
                .save(consumer, location(FUEL_FOLDER + "styx"));
    }
}
