package derekahedron.mythictinkers.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.recipe.helper.LoadableRecipeSerializer;

public class MTRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final RegistryObject<RecipeSerializer<BoonModifierRecipe>> BOON_MODIFIER =
            RECIPE_SERIALIZERS.register("boon_modifier", () -> LoadableRecipeSerializer.of(BoonModifierRecipe.LOADER));
}
