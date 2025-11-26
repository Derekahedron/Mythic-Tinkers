package derekahedron.mythictinkers.datagen.tags;

import derekahedron.mythictinkers.tinkers.materials.MTMaterialIds;
import derekahedron.mythictinkers.tinkers.materials.MTMaterialTags;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.library.data.tinkering.AbstractMaterialTagProvider;
import slimeknights.tconstruct.tools.data.material.MaterialIds;

public class MTMaterialTagsProvider extends AbstractMaterialTagProvider {

    public MTMaterialTagsProvider(
            PackOutput output,
            ExistingFileHelper existingFileHelper) {
        super(output, derekahedron.mythictinkers.MythicTinkers.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return String.format("%s Material Tags", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addTags() {
        tag(MTMaterialTags.FERROMAGNETIC)
                .add(MaterialIds.iron)
                .add(MaterialIds.slimesteel)
                .add(MaterialIds.pigIron)
                .add(MaterialIds.cobalt)
                .add(MaterialIds.manyullyn)
                .add(MaterialIds.hepatizon)
                .add(MaterialIds.queensSlime)
                .addOptional(MaterialIds.steel)
                .addOptional(MaterialIds.invar);

        tag(MTMaterialTags.ACID_RESISTANT)
                .add(MTMaterialIds.ELEMENT_122);
    }
}
