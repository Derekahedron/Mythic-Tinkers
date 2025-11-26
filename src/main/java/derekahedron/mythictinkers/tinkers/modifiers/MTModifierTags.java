package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.tags.TagKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierManager;

public class MTModifierTags {

    public static final TagKey<Modifier> BOONS =
            ModifierManager.getTag(MTUtil.location("boons"));

    public static final TagKey<Modifier> FERROMAGNETIC =
            ModifierManager.getTag(MTUtil.location("ferromagnetic"));
}
