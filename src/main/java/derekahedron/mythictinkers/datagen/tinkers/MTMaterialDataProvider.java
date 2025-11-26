package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.tinkers.materials.MTMaterialIds;
import net.minecraft.data.PackOutput;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class MTMaterialDataProvider extends AbstractMaterialDataProvider {

    public MTMaterialDataProvider(PackOutput output) {
        super(output);
    }

    @Override
    public String getName() {
        return String.format("%s Materials", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addMaterials() {
        addMaterial(MTMaterialIds.SCARLET_NEODYMIUM,
                2,
                30,
                true);

        addMaterial(MTMaterialIds.AZURE_NEODYMIUM,
                2,
                31,
                true);

        addMaterial(MTMaterialIds.BYZANTIUM_NEODYMIUM,
                5,
                0,
                true);

        addMaterial(MTMaterialIds.TECTELLUS,
                5,
                5,
                true);

        addMaterial(MTMaterialIds.ELEMENT_122,
                5,
                10,
                true);

        addMaterial(MTMaterialIds.AURICHALCUM,
                5,
                15,
                true);

        addMaterial(MTMaterialIds.DESOLUM,
                4,
                30,
                true);

        addMaterial(MTMaterialIds.SHADOW_SILK,
                2,
                35,
                true);

        addMaterial(MTMaterialIds.PROSPRUM,
                5,
                20,
                true);

        addMaterial(MTMaterialIds.GUMBRONZE,
                5,
                25,
                true);
    }
}
