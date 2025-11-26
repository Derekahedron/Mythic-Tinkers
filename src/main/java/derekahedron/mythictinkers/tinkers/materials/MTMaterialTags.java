package derekahedron.mythictinkers.tinkers.materials;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.tags.TagKey;
import slimeknights.tconstruct.library.materials.definition.IMaterial;
import slimeknights.tconstruct.library.materials.definition.MaterialManager;

public class MTMaterialTags {

    public static final TagKey<IMaterial> FERROMAGNETIC =
            MaterialManager.getTag(MTUtil.location("ferromagnetic"));

    public static final TagKey<IMaterial> ACID_RESISTANT =
            MaterialManager.getTag(MTUtil.location("acid_resistant"));
}
