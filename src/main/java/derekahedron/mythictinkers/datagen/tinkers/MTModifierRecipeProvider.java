package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.item.MTItems;
import derekahedron.mythictinkers.recipe.BoonModifierRecipe;
import derekahedron.mythictinkers.tinkers.MTSlotTypes;
import derekahedron.mythictinkers.tinkers.modifiers.MTModifierIds;
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.recipe.modifiers.adding.ModifierRecipeBuilder;
import slimeknights.tconstruct.library.tools.SlotType;

import java.util.function.Consumer;

public class MTModifierRecipeProvider extends RecipeProvider {
    public static final String MODIFIER_FOLDER = "tools/modifiers/";
    public static final String UPGRADE_FOLDER = MODIFIER_FOLDER + "upgrade/";
    public static final String ABILITY_FOLDER = MODIFIER_FOLDER + "ability/";
    public static final String DEFENSE_FOLDER = MODIFIER_FOLDER + "defense/";
    public static final String BOON_FOLDER = MODIFIER_FOLDER + "boon/";
    public static final String SALVAGE_FOLDER = MODIFIER_FOLDER + "salvage/";
    public static final String SALVAGE_UPGRADE_FOLDER = SALVAGE_FOLDER + "upgrade/";
    public static final String SALVAGE_ABILITY_FOLDER = SALVAGE_FOLDER + "ability/";
    public static final String SALVAGE_DEFENSE_FOLDER = SALVAGE_FOLDER + "defense/";
    public static final String SALVAGE_BOON_FOLDER = SALVAGE_FOLDER + "boon/";

    public MTModifierRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    public String getName() {
        return String.format("%s Modifier Recipes", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        // Tectonic Shield Level 1
        ModifierRecipeBuilder.modifier(MTModifierIds.TECTONIC_SHIELD)
                .allowCrystal()
                .checkTraitLevel()
                .addInput(ACItemRegistry.TECTONIC_SHARD.get())
                .addInput(ACItemRegistry.TECTONIC_SHARD.get())
                .addInput(ACItemRegistry.TECTONIC_SHARD.get())
                .setMaxLevel(1)
                .setTools(TinkerTags.Items.MODIFIABLE)
                .setSlots(SlotType.UPGRADE, 1)
                .saveSalvage(consumer, MTModifierIds.TECTONIC_SHIELD.withPrefix(SALVAGE_UPGRADE_FOLDER))
                .save(consumer, MTModifierIds.TECTONIC_SHIELD.withPrefix(UPGRADE_FOLDER));

        // Tectonic Shield Levels 2-4
        ModifierRecipeBuilder.modifier(MTModifierIds.TECTONIC_SHIELD)
                .allowCrystal()
                .checkTraitLevel()
                .addInput(ACItemRegistry.TECTONIC_SHARD.get())
                .setMinLevel(2)
                .setMaxLevel(4)
                .setTools(TinkerTags.Items.MODIFIABLE)
                .setSlots(SlotType.UPGRADE, 1)
                .saveSalvage(consumer, MTModifierIds.TECTONIC_SHIELD.withPrefix(SALVAGE_UPGRADE_FOLDER).withSuffix("_upgrade"))
                .save(consumer, MTModifierIds.TECTONIC_SHIELD.withPrefix(UPGRADE_FOLDER).withSuffix("_upgrade"));

        // Polymer Plated
        ModifierRecipeBuilder.modifier(MTModifierIds.POLYMER_PLATED)
                .allowCrystal()
                .checkTraitLevel()
                .addInput(ACItemRegistry.POLYMER_PLATE.get())
                .addInput(ACItemRegistry.POLYMER_PLATE.get())
                .addInput(ACItemRegistry.POLYMER_PLATE.get())
                .addInput(ACItemRegistry.POLYMER_PLATE.get())
                .addInput(ACItemRegistry.POLYMER_PLATE.get())
                .setMaxLevel(1)
                .setTools(TinkerTags.Items.ARMOR)
                .setSlots(SlotType.DEFENSE, 1)
                .saveSalvage(consumer, MTModifierIds.POLYMER_PLATED.withPrefix(SALVAGE_DEFENSE_FOLDER))
                .save(consumer, MTModifierIds.POLYMER_PLATED.withPrefix(DEFENSE_FOLDER));

        // Dreadshot
        ModifierRecipeBuilder.modifier(MTModifierIds.DREADSHOT)
                .allowCrystal()
                .checkTraitLevel()
                .addInput(ACItemRegistry.PURE_DARKNESS.get())
                .addInput(ACItemRegistry.VESPER_WING.get())
                .addInput(ACItemRegistry.VESPER_WING.get())
                .setMaxLevel(1)
                .setTools(TinkerTags.Items.BOWS)
                .setSlots(SlotType.ABILITY, 1)
                .saveSalvage(consumer, MTModifierIds.DREADSHOT.withPrefix(SALVAGE_ABILITY_FOLDER))
                .save(consumer, MTModifierIds.DREADSHOT.withPrefix(ABILITY_FOLDER));

        // Boons
        createBoonRecipe(consumer,
                MTModifierIds.BYZANTIUM_NEODYMIUM_BOON,
                MTItems.BYZANTIUM_NEODYMIUM_INGOT.get());
        createBoonRecipe(consumer,
                MTModifierIds.TECTELLUS_BOON,
                MTItems.TECTELLUS_INGOT.get());
        createBoonRecipe(consumer,
                MTModifierIds.ELEMENT_122_BOON,
                MTItems.ELEMENT_122_INGOT.get());
        createBoonRecipe(consumer,
                MTModifierIds.PROSPRUM_BOON,
                MTItems.PROSPRUM_INGOT.get());
        createBoonRecipe(consumer,
                MTModifierIds.GUMBRONZE_BOON,
                MTItems.GUMBRONZE_INGOT.get());
    }

    public static void createBoonRecipe(Consumer<FinishedRecipe> consumer, ModifierId modifierId, Item material) {
        BoonModifierRecipe.Builder.modifier(modifierId)
                .allowCrystal()
                .checkTraitLevel()
                .addInput(material)
                .addInput(material)
                .addInput(material)
                .addInput(material)
                .addInput(material)
                .setMaxLevel(1)
                .setSlots(MTSlotTypes.BOON, 1)
                .setTools(TinkerTags.Items.MODIFIABLE)
                .saveSalvage(consumer, modifierId.withPrefix(SALVAGE_BOON_FOLDER))
                .save(consumer, modifierId.withPrefix(BOON_FOLDER));
    }
}
