package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.tinkers.materials.MTMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialRenderInfoProvider;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;

public class MTMaterialRenderInfoProvider extends AbstractMaterialRenderInfoProvider {

    @Override
    public String getName() {
        return String.format("%s Render Material Info", MythicTinkers.MOD_NAME);
    }

    public MTMaterialRenderInfoProvider(PackOutput output, AbstractMaterialSpriteProvider spriteProvider, ExistingFileHelper existingFileHelper) {
        super(output, spriteProvider, existingFileHelper);
    }

    @Override
    protected void addMaterialRenderInfo() {

        buildRenderInfo(MTMaterialIds.AZURE_NEODYMIUM)
                .color(0xFF0066FF)
                .fallbacks("metal");

        buildRenderInfo(MTMaterialIds.SCARLET_NEODYMIUM)
                .color(0xFFFF002A)
                .fallbacks("metal");

        buildRenderInfo(MTMaterialIds.BYZANTIUM_NEODYMIUM)
                .color(0xFFB911D5)
                .fallbacks("metal");

        buildRenderInfo(MTMaterialIds.TECTELLUS)
                .color(0xFFED4501)
                .fallbacks("metal");

        buildRenderInfo(MTMaterialIds.ELEMENT_122)
                .color(0xFF5B7E1D)
                .fallbacks("metal");

        buildRenderInfo(MTMaterialIds.AURICHALCUM)
                .color(0xFFFFA214)
                .fallbacks("metal");

        buildRenderInfo(MTMaterialIds.DESOLUM)
                .color(0xFF996F83)
                .fallbacks("metal");

        buildRenderInfo(MTMaterialIds.SHADOW_SILK)
                .color(0xFF2F2F2F);

        buildRenderInfo(MTMaterialIds.PROSPRUM)
                .color(0xFFC8FAFF)
                .fallbacks("metal");

        buildRenderInfo(MTMaterialIds.GUMBRONZE)
                .color(0xFFFC80E5)
                .fallbacks("metal");
    }
}
