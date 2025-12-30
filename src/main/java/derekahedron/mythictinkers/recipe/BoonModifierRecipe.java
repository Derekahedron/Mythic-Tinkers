package derekahedron.mythictinkers.recipe;

import derekahedron.mythictinkers.mixin.ComposableModifierAccessor;
import derekahedron.mythictinkers.tinkers.modifiers.modules.ModifierMaterialModule;
import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import slimeknights.mantle.data.loadable.field.ContextKey;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.mantle.recipe.ingredient.SizedIngredient;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.json.IntRange;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.modifiers.impl.ComposableModifier;
import slimeknights.tconstruct.library.modifiers.util.LazyModifier;
import slimeknights.tconstruct.library.module.WithHooks;
import slimeknights.tconstruct.library.recipe.modifiers.adding.IDisplayModifierRecipe;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipe;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BoonModifierRecipe extends ModifierRecipe {
    public static final RecordLoadable<BoonModifierRecipe> LOADER =
            RecordLoadable.create(
                    ContextKey.ID.requiredField(),
                    INPUTS_FIELD,
                    TOOLS_FIELD,
                    MAX_TOOL_SIZE_FIELD,
                    RESULT_FIELD,
                    LEVEL_FIELD,
                    SLOTS_FIELD,
                    ALLOW_CRYSTAL_FIELD,
                    CHECK_TRAIT_LEVEL_FIELD,
                    BoonModifierRecipe::new);
    private @Nullable List<ItemStack> toolWithModifier;

    public BoonModifierRecipe(
            ResourceLocation id, List<SizedIngredient> inputs, Ingredient toolRequirement,
            int maxToolSize, ModifierId result, IntRange level, @Nullable SlotType.SlotCount slots,
            boolean allowCrystal, boolean checkTraitLevel) {
        super(id, inputs, toolRequirement, maxToolSize, result, level, slots, allowCrystal, checkTraitLevel);
    }

    @Override
    public List<ItemStack> getToolWithModifier() {
        if (toolWithModifier == null) {
            if (getModifier() instanceof ComposableModifier modifier) {
                // Get all materials being added
                List<MaterialId> materialIds = ((ComposableModifierAccessor) modifier).mythictinkers$getModules().stream()
                        .map(WithHooks::module)
                        .filter((module) -> module instanceof ModifierMaterialModule)
                        .map((module) -> (ModifierMaterialModule) module)
                        .map(ModifierMaterialModule::material)
                        .toList();

                // Add the modifier traits from all materials to each tool.
                toolWithModifier = super.getToolWithModifier().stream()
                        .map((stack) -> {
                            if (stack.is(TinkerTags.Items.MODIFIABLE)) {
                                ToolStack tool = ToolStack.from(stack);
                                ToolDefinition toolDefinition = tool.getDefinition();
                                ModifierEntry result = getDisplayResult();
                                List<ModifierEntry> modifiers = new ArrayList<>(
                                        IDisplayModifierRecipe.modifiersForResult(result, result));

                                for (MaterialId materialId : materialIds) {
                                    modifiers.addAll(MTUtil.getMaterialModifiers(
                                            materialId,
                                            toolDefinition));
                                }
                                return IDisplayModifierRecipe.withModifiers(stack, maxToolSize, modifiers);
                            }
                            return stack;
                        })
                        .toList();
            } else {
                toolWithModifier = super.getToolWithModifier();
            }
        }

        return toolWithModifier;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return MTRecipeSerializers.BOON_MODIFIER.get();
    }

    public static class Builder extends ModifierRecipeBuilder {

        protected Builder(ModifierId result) {
            super(result);
        }

        public static Builder modifier(ModifierId modifier) {
            return new Builder(modifier);
        }

        public static Builder modifier(LazyModifier modifier) {
            return modifier(modifier.getId());
        }

        @Override
        public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
            if (inputs.isEmpty() && !allowCrystal) {
                throw new IllegalStateException("Must have at least 1 input");
            } else {
                ResourceLocation advancementId = buildOptionalAdvancement(id, "modifiers");
                consumer.accept(new LoadableFinishedRecipe<>(new BoonModifierRecipe(
                        id,
                        inputs,
                        tools,
                        maxToolSize,
                        result,
                        ModifierEntry.VALID_LEVEL.range(minLevel, maxLevel),
                        slots,
                        allowCrystal,
                        checkTraitLevel
                ), BoonModifierRecipe.LOADER, advancementId));
            }
        }
    }
}
