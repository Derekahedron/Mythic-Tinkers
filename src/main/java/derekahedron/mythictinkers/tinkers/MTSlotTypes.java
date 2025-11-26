package derekahedron.mythictinkers.tinkers;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import slimeknights.mantle.client.model.NBTKeyModel;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.tools.SlotType;

public class MTSlotTypes {

    public static final SlotType BOON =
            SlotType.getOrCreate("boons");

    @OnlyIn(Dist.CLIENT)
    public static void registerTextures() {
        NBTKeyModel.registerExtraTexture(
                TConstruct.getResource("creative_slot"),
                BOON.getName(),
                MTUtil.location("item/" + BOON.getName()));
    }
}
