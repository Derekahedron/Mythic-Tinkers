package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.tinkers.materials.MTMaterialIds;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;
import slimeknights.tconstruct.tools.stats.StatlessMaterialStats;

public class MTMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Override
    public String getName() {
        return String.format("%s Material Sprites", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addAllMaterials() {

        buildMaterial(MTMaterialIds.SCARLET_NEODYMIUM)
                .meleeHarvest()
                .ranged()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF180C0D)
                        .addARGB(0x66, 0xFF3E0807)
                        .addARGB(0x8C, 0xFF510F0F)
                        .addARGB(0xB2, 0xFF752021)
                        .addARGB(0xD8, 0xFFC01C1C)
                        .addARGB(0xFF, 0xFFFF002A)
                        .build());

        buildMaterial(MTMaterialIds.AZURE_NEODYMIUM)
                .meleeHarvest()
                .ranged()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF090B11)
                        .addARGB(0x66, 0xFF060D35)
                        .addARGB(0x8C, 0xFF161F46)
                        .addARGB(0xB2, 0xFF192B75)
                        .addARGB(0xD8, 0xFF1D40DB)
                        .addARGB(0xFF, 0xFF0066FF)
                        .build());

        buildMaterial(MTMaterialIds.BYZANTIUM_NEODYMIUM)
                .meleeHarvest()
                .ranged()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF21121E)
                        .addARGB(0x66, 0xFF35093E)
                        .addARGB(0x8C, 0xFF421940)
                        .addARGB(0xB2, 0xFF662064)
                        .addARGB(0xD8, 0xFF991995)
                        .addARGB(0xFF, 0xFFB911D5)
                        .build());

        buildMaterial(MTMaterialIds.TECTELLUS)
                .meleeHarvest()
                .ranged()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF3E1209)
                        .addARGB(0x66, 0xFF64150A)
                        .addARGB(0x8C, 0xFF81250B)
                        .addARGB(0xB2, 0xFFC2250E)
                        .addARGB(0xD8, 0xFFFE672B)
                        .addARGB(0xFF, 0xFFFCAA60)
                        .build());

        buildMaterial(MTMaterialIds.ELEMENT_122)
                .meleeHarvest()
                .ranged()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF012005)
                        .addARGB(0x66, 0xFF1F2F03)
                        .addARGB(0x8C, 0xFF1C3A1A)
                        .addARGB(0xB2, 0xFF304819)
                        .addARGB(0xD8, 0xFF556F27)
                        .addARGB(0xFF, 0xFF728D25)
                        .build());

        buildMaterial(MTMaterialIds.AURICHALCUM)
                .meleeHarvest()
                .ranged()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF713D07)
                        .addARGB(0x66, 0xFFA45706)
                        .addARGB(0x8C, 0xFFCC6F01)
                        .addARGB(0xB2, 0xFFF39B15)
                        .addARGB(0xD8, 0xFFFFD983)
                        .addARGB(0xFF, 0xFFFFF7E5)
                        .build());

        buildMaterial(MTMaterialIds.DESOLUM)
                .meleeHarvest()
                .ranged()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF15100B)
                        .addARGB(0x66, 0xFF2A2A30)
                        .addARGB(0x8C, 0xFF3F3C42)
                        .addARGB(0xB2, 0xFF5A4A53)
                        .addARGB(0xD8, 0xFF8C6464)
                        .addARGB(0xFF, 0xFFAE7C7C)
                        .build());

        buildMaterial(MTMaterialIds.SHADOW_SILK)
                .statType(StatlessMaterialStats.BOWSTRING.getIdentifier())
                .repairKit()
                .fallbacks("primitive")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF000000)
                        .addARGB(0x66, 0xFF0A0A0A)
                        .addARGB(0x8C, 0xFF060606)
                        .addARGB(0xB2, 0xFF151515)
                        .addARGB(0xD8, 0xFF212121)
                        .addARGB(0xFF, 0xFF2F2F2F)
                        .build());

        buildMaterial(MTMaterialIds.PROSPRUM)
                .meleeHarvest()
                .ranged()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF305C63)
                        .addARGB(0x66, 0xFF2D8783)
                        .addARGB(0x8C, 0xFF77C5F2)
                        .addARGB(0xB2, 0xFF88EFF9)
                        .addARGB(0xD8, 0xFFDFFFF1)
                        .addARGB(0xFF, 0xFFFFFFFF)
                        .build());

        buildMaterial(MTMaterialIds.GUMBRONZE)
                .meleeHarvest()
                .ranged()
                .armor()
                .fallbacks("metal")
                .colorMapper(GreyToColorMapping.builderFromBlack()
                        .addARGB(0x3F, 0xFF7D148F)
                        .addARGB(0x66, 0xFFA928AB)
                        .addARGB(0x8C, 0xFFED5AD2)
                        .addARGB(0xB2, 0xFFF287DF)
                        .addARGB(0xD8, 0xFFFFBAF1)
                        .addARGB(0xFF, 0xFFFFDCFE)
                        .build());
    }
}
