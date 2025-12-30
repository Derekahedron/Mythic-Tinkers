package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.block.MTBlockTags;
import derekahedron.mythictinkers.tinkers.MTSlotTypes;
import derekahedron.mythictinkers.tinkers.materials.MTMaterialIds;
import derekahedron.mythictinkers.tinkers.modifiers.MTModifierIds;
import derekahedron.mythictinkers.tinkers.modifiers.modules.*;
import net.minecraft.data.PackOutput;
import slimeknights.mantle.data.predicate.block.BlockPredicate;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierProvider;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.modifiers.impl.BasicModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierLevelDisplay;

public class MTModifierProvider extends AbstractModifierProvider {

    public MTModifierProvider(PackOutput output) {
        super(output);
    }

    @Override
    public String getName() {
        return String.format("%s Modifiers", MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addModifiers() {
        buildModifier(MTModifierIds.ATTRACTIVE)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS);

        buildModifier(MTModifierIds.REPULSIVE)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS);

        buildModifier(MTModifierIds.TERRAFORMING)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(new MaximumDestroySpeedModule(0.6F, BlockPredicate.tag(MTBlockTags.TERRAFORMABLE)));

        buildModifier(MTModifierIds.HALF_LIFE)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(new HalfLifeModule(12 * 60 * 60 * 20)); // 12 Hours

        buildModifier(MTModifierIds.POLYMER_PLATED)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS);

        buildModifier(MTModifierIds.GLAMOROUS)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .addModule(new LevelingModifierSlotModule(MTSlotTypes.BOON, LevelingInt.flat(2)));

        createBoon(MTModifierIds.BYZANTIUM_NEODYMIUM_BOON, MTMaterialIds.BYZANTIUM_NEODYMIUM);
        createBoon(MTModifierIds.TECTELLUS_BOON, MTMaterialIds.TECTELLUS);
        createBoon(MTModifierIds.ELEMENT_122_BOON, MTMaterialIds.ELEMENT_122);
        createBoon(MTModifierIds.PROSPRUM_BOON, MTMaterialIds.PROSPRUM);
        createBoon(MTModifierIds.GUMBRONZE_BOON, MTMaterialIds.GUMBRONZE);
    }

    public void createBoon(ModifierId modifierId, MaterialId materialId) {
        buildModifier(modifierId)
                .levelDisplay(ModifierLevelDisplay.NO_LEVELS)
                .tooltipDisplay(BasicModifier.TooltipDisplay.TINKER_STATION)
                .addModule(new ModifierMaterialModule(materialId));
    }
}
