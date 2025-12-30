package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.tinkers.materials.MTMaterialIds;
import derekahedron.mythictinkers.tinkers.modifiers.MTModifierIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.library.materials.MaterialRegistry;

public class MTMaterialTraitDataProvider extends AbstractMaterialTraitDataProvider {

    public MTMaterialTraitDataProvider(PackOutput packOutput, AbstractMaterialDataProvider materials) {
        super(packOutput, materials);
    }

    @Override
    public String getName() {
        return String.format("%s Material Traits", MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(MTMaterialIds.SCARLET_NEODYMIUM,
                MTModifierIds.ATTRACTIVE);

        addDefaultTraits(MTMaterialIds.AZURE_NEODYMIUM,
                MTModifierIds.REPULSIVE);

        addDefaultTraits(MTMaterialIds.BYZANTIUM_NEODYMIUM,
                MTModifierIds.TESSERACTED);

        addTraits(MTMaterialIds.TECTELLUS,
                MaterialRegistry.MELEE_HARVEST,
                MTModifierIds.TERRAFORMING);
        addTraits(MTMaterialIds.TECTELLUS,
                MaterialRegistry.RANGED,
                MTModifierIds.AEROFORMING);
        addTraits(MTMaterialIds.TECTELLUS,
                MaterialRegistry.ARMOR,
                MTModifierIds.TERRAFORMIDABLE);

        addDefaultTraits(MTMaterialIds.ELEMENT_122,
                MTModifierIds.RADIOACTIVE,
                MTModifierIds.HALF_LIFE);

        addDefaultTraits(MTMaterialIds.AURICHALCUM,
                MTModifierIds.GLAMOROUS);

        addTraits(MTMaterialIds.DESOLUM,
                MaterialRegistry.MELEE_HARVEST,
                MTModifierIds.DESOLATE);
        addTraits(MTMaterialIds.DESOLUM,
                MaterialRegistry.RANGED,
                MTModifierIds.DESOLATE);
        addTraits(MTMaterialIds.DESOLUM,
                MaterialRegistry.ARMOR,
                MTModifierIds.DARKNESS_PROTECTION);

        addDefaultTraits(MTMaterialIds.SHADOW_SILK,
                MTModifierIds.DARK_ARROW);

        addTraits(MTMaterialIds.PROSPRUM,
                MaterialRegistry.MELEE_HARVEST,
                MTModifierIds.VENGEFUL_STRIKE);
        addTraits(MTMaterialIds.PROSPRUM,
                MaterialRegistry.RANGED,
                MTModifierIds.VENGEFUL_SHOT);
        addTraits(MTMaterialIds.PROSPRUM,
                MaterialRegistry.ARMOR,
                MTModifierIds.RETRIBUTION);

        addDefaultTraits(MTMaterialIds.GUMBRONZE,
                MTModifierIds.GUMBREAKABLE);
    }
}
