package derekahedron.mythictinkers.item;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class MTItemTags {

    public static final TagKey<Item> ACID_RESISTANT =
            ItemTags.create(MTUtil.location("acid_resistant"));
}
