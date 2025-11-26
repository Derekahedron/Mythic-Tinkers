package derekahedron.mythictinkers.block;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class MTBlockTags {

    public static final TagKey<Block> SCULK_STONE =
            BlockTags.create(MTUtil.location("sculk_stone"));

    public static final TagKey<Block> GLOOMSLATE =
            BlockTags.create(MTUtil.location("gloomslate"));

    public static final TagKey<Block> DOMBSTONE =
            BlockTags.create(MTUtil.location("dombstone"));

    public static final TagKey<Block> DOMBSTONE_BRICKS =
            BlockTags.create(MTUtil.location("dombstone_bricks"));

    public static final TagKey<Block> ENERGIZED_GALENA =
            BlockTags.create(MTUtil.location("energized_galena"));

    public static final TagKey<Block> TERRAFORMABLE =
            BlockTags.create(MTUtil.location("terraformable"));

    public static final TagKey<Block> ATLANTEAN =
            BlockTags.create(MTUtil.location("atlantean"));
}
