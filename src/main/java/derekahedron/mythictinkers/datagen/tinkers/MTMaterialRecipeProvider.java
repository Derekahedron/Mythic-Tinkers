package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.fluid.MTFluidHolders;
import derekahedron.mythictinkers.tinkers.materials.MTMaterialIds;
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.Ingredient;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;

import java.util.function.Consumer;

public class MTMaterialRecipeProvider extends RecipeProvider implements IMaterialRecipeHelper {
    public static final String MATERIALS_FOLDER = "tools/materials/";

    public MTMaterialRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    public String getName() {
        return String.format("%s Material Recipes", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    public String getModId() {
        return derekahedron.mythictinkers.MythicTinkers.MOD_ID;
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Scarlet Neodymium
        metalMaterialRecipe(
                consumer,
                MTMaterialIds.SCARLET_NEODYMIUM,
                MATERIALS_FOLDER,
                "scarlet_neodymium",
                false);
        materialMeltingCasting(
                consumer,
                MTMaterialIds.SCARLET_NEODYMIUM,
                MTFluidHolders.MOLTEN_SCARLET_NEODYMIUM.fluidObject,
                MATERIALS_FOLDER);

        // Azure Neodymium
        metalMaterialRecipe(
                consumer,
                MTMaterialIds.AZURE_NEODYMIUM,
                MATERIALS_FOLDER,
                "azure_neodymium",
                false);
        materialMeltingCasting(
                consumer,
                MTMaterialIds.AZURE_NEODYMIUM,
                MTFluidHolders.MOLTEN_AZURE_NEODYMIUM.fluidObject,
                MATERIALS_FOLDER);

        // Byzantium Neodymium
        metalMaterialRecipe(
                consumer,
                MTMaterialIds.BYZANTIUM_NEODYMIUM,
                MATERIALS_FOLDER,
                "byzantium_neodymium",
                false);
        materialMeltingCasting(
                consumer,
                MTMaterialIds.BYZANTIUM_NEODYMIUM,
                MTFluidHolders.MOLTEN_BYZANTIUM_NEODYMIUM.fluidObject,
                MATERIALS_FOLDER);

        // Tecetellus
        metalMaterialRecipe(
                consumer,
                MTMaterialIds.TECTELLUS,
                MATERIALS_FOLDER,
                "tectellus",
                false);
        materialMeltingCasting(
                consumer,
                MTMaterialIds.TECTELLUS,
                MTFluidHolders.MOLTEN_TECTELLUS.fluidObject,
                MATERIALS_FOLDER);

        // Element 122
        metalMaterialRecipe(
                consumer,
                MTMaterialIds.ELEMENT_122,
                MATERIALS_FOLDER,
                "element_122",
                false);
        materialMeltingCasting(
                consumer,
                MTMaterialIds.ELEMENT_122,
                MTFluidHolders.MOLTEN_ELEMENT_122.fluidObject,
                MATERIALS_FOLDER);

        // Aurichalcum
        metalMaterialRecipe(
                consumer,
                MTMaterialIds.AURICHALCUM,
                MATERIALS_FOLDER,
                "aurichalcum",
                false);
        materialMeltingCasting(
                consumer,
                MTMaterialIds.AURICHALCUM,
                MTFluidHolders.MOLTEN_AURICHALCUM.fluidObject,
                MATERIALS_FOLDER);

        // Desolum
        metalMaterialRecipe(
                consumer,
                MTMaterialIds.DESOLUM,
                MATERIALS_FOLDER,
                "desolum",
                false);
        materialMeltingCasting(
                consumer,
                MTMaterialIds.DESOLUM,
                MTFluidHolders.MOLTEN_DESOLUM.fluidObject,
                MATERIALS_FOLDER);

        // Shadow Silk
        materialRecipe(
                consumer,
                MTMaterialIds.SHADOW_SILK,
                Ingredient.of(ACItemRegistry.SHADOW_SILK.get()),
                1,
                4,
                MATERIALS_FOLDER + "shadow_silk");

        // Prosprum
        metalMaterialRecipe(
                consumer,
                MTMaterialIds.PROSPRUM,
                MATERIALS_FOLDER,
                "prosprum",
                false);
        materialMeltingCasting(
                consumer,
                MTMaterialIds.PROSPRUM,
                MTFluidHolders.MOLTEN_PROSPRUM.fluidObject,
                MATERIALS_FOLDER);

        // Gumbronze
        metalMaterialRecipe(
                consumer,
                MTMaterialIds.GUMBRONZE,
                MATERIALS_FOLDER,
                "gumbronze",
                false);
        materialMeltingCasting(
                consumer,
                MTMaterialIds.GUMBRONZE,
                MTFluidHolders.MOLTEN_GUMBRONZE.fluidObject,
                MATERIALS_FOLDER);
    }
}
