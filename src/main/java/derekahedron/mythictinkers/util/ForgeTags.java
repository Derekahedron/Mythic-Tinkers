package derekahedron.mythictinkers.util;

import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.common.Tags;

public class ForgeTags {
    public static class Items {
        public static final TagKey<Item> STYX_ORES =
                MTUtil.childTag(Tags.Items.ORES, "styx");

        public static final TagKey<Item> SCARLET_NEODYMIUM_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "scarlet_neodymium");
        public static final TagKey<Item> SCARLET_NEODYMIUM_NUGGETS =
                MTUtil.childTag(Tags.Items.NUGGETS, "scarlet_neodymium");
        public static final TagKey<Item> SCARLET_NEODYMIUM_INGOTS =
                MTUtil.childTag(Tags.Items.INGOTS, "scarlet_neodymium");

        public static final TagKey<Item> AZURE_NEODYMIUM_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "azure_neodymium");
        public static final TagKey<Item> AZURE_NEODYMIUM_NUGGETS =
                MTUtil.childTag(Tags.Items.NUGGETS, "azure_neodymium");
        public static final TagKey<Item> AZURE_NEODYMIUM_INGOTS =
                MTUtil.childTag(Tags.Items.INGOTS, "azure_neodymium");

        public static final TagKey<Item> BYZANTIUM_NEODYMIUM_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "byzantium_neodymium");
        public static final TagKey<Item> BYZANTIUM_NEODYMIUM_NUGGETS =
                MTUtil.childTag(Tags.Items.NUGGETS, "byzantium_neodymium");
        public static final TagKey<Item> BYZANTIUM_NEODYMIUM_INGOTS =
                MTUtil.childTag(Tags.Items.INGOTS, "byzantium_neodymium");

        public static final TagKey<Item> TECTELLUS_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "tectellus");
        public static final TagKey<Item> TECTELLUS_ORES =
                MTUtil.childTag(Tags.Items.ORES, "tectellus");
        public static final TagKey<Item> RAW_TECTELLUS_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "raw_tectellus");
        public static final TagKey<Item> RAW_TECTELLUS =
                MTUtil.childTag(Tags.Items.RAW_MATERIALS, "tectellus");
        public static final TagKey<Item> TECTELLUS_NUGGETS =
                MTUtil.childTag(Tags.Items.NUGGETS, "tectellus");
        public static final TagKey<Item> TECTELLUS_INGOTS =
                MTUtil.childTag(Tags.Items.INGOTS, "tectellus");

        public static final TagKey<Item> ELEMENT_122_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "element_122");
        public static final TagKey<Item> ELEMENT_122_ORES =
                MTUtil.childTag(Tags.Items.ORES, "element_122");
        public static final TagKey<Item> RAW_ELEMENT_122_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "raw_element_122");
        public static final TagKey<Item> RAW_ELEMENT_122 =
                MTUtil.childTag(Tags.Items.RAW_MATERIALS, "element_122");
        public static final TagKey<Item> ELEMENT_122_NUGGETS =
                MTUtil.childTag(Tags.Items.NUGGETS, "element_122");
        public static final TagKey<Item> ELEMENT_122_INGOTS =
                MTUtil.childTag(Tags.Items.INGOTS, "element_122");

        public static final TagKey<Item> AURICHALCUM_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "aurichalcum");
        public static final TagKey<Item> AURICHALCUM_NUGGETS =
                MTUtil.childTag(Tags.Items.NUGGETS, "aurichalcum");
        public static final TagKey<Item> AURICHALCUM_INGOTS =
                MTUtil.childTag(Tags.Items.INGOTS, "aurichalcum");

        public static final TagKey<Item> DESOLUM_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "desolum");
        public static final TagKey<Item> DESOLUM_NUGGETS =
                MTUtil.childTag(Tags.Items.NUGGETS, "desolum");
        public static final TagKey<Item> DESOLUM_INGOTS =
                MTUtil.childTag(Tags.Items.INGOTS, "desolum");

        public static final TagKey<Item> PROSPRUM_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "prosprum");
        public static final TagKey<Item> PROSPRUM_NUGGETS =
                MTUtil.childTag(Tags.Items.NUGGETS, "prosprum");
        public static final TagKey<Item> PROSPRUM_INGOTS =
                MTUtil.childTag(Tags.Items.INGOTS, "prosprum");

        public static final TagKey<Item> EARTHEN_GUM_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "earthen_gum");
        public static final TagKey<Item> EARTHEN_GUM_ORES =
                MTUtil.childTag(Tags.Items.ORES, "earthen_gum");

        public static final TagKey<Item> GUMBRONZE_BLOCKS =
                MTUtil.childTag(Tags.Items.STORAGE_BLOCKS, "gumbronze");
        public static final TagKey<Item> GUMBRONZE_NUGGETS =
                MTUtil.childTag(Tags.Items.NUGGETS, "gumbronze");
        public static final TagKey<Item> GUMBRONZE_INGOTS =
                MTUtil.childTag(Tags.Items.INGOTS, "gumbronze");
    }

    public static class Blocks {
        public static final TagKey<Block> STYX_ORES =
                MTUtil.childTag(Tags.Blocks.ORES, "styx");

        public static final TagKey<Block> BYZANTIUM_NEODYMIUM_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "byzantium_neodymium");

        public static final TagKey<Block> TECTELLUS_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "tectellus");
        public static final TagKey<Block> TECTELLUS_ORES =
                MTUtil.childTag(Tags.Blocks.ORES, "tectellus");
        public static final TagKey<Block> RAW_TECTELLUS_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "raw_tectellus");

        public static final TagKey<Block> ELEMENT_122_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "element_122");
        public static final TagKey<Block> ELEMENT_122_ORES =
                MTUtil.childTag(Tags.Blocks.ORES, "element_122");
        public static final TagKey<Block> RAW_ELEMENT_122_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "raw_element_122");

        public static final TagKey<Block> AURICHALCUM_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "aurichalcum");

        public static final TagKey<Block> DESOLUM_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "desolum");

        public static final TagKey<Block> PROSPRUM_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "prosprum");

        public static final TagKey<Block> EARTHEN_GUM_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "earthen_gum");
        public static final TagKey<Block> EARTHEN_GUM_ORES =
                MTUtil.childTag(Tags.Blocks.ORES, "earthen_gum");

        public static final TagKey<Block> GUMBRONZE_BLOCKS =
                MTUtil.childTag(Tags.Blocks.STORAGE_BLOCKS, "gumbronze");
    }

    public static class Fluids {
        public static final TagKey<Fluid> STYX =
                FluidTags.create(MTUtil.forgeLocation("styx"));

        public static final TagKey<Fluid> MOLTEN_SCARLET_NEODYMIUM =
                FluidTags.create(MTUtil.forgeLocation("molten_scarlet_neodymium"));

        public static final TagKey<Fluid> MOLTEN_AZURE_NEODYMIUM =
                FluidTags.create(MTUtil.forgeLocation("molten_azure_neodymium"));

        public static final TagKey<Fluid> MOLTEN_BYZANTIUM_NEODYMIUM =
                FluidTags.create(MTUtil.forgeLocation("molten_byzantium_neodymium"));

        public static final TagKey<Fluid> MOLTEN_TECTELLUS =
                FluidTags.create(MTUtil.forgeLocation("molten_tectellus"));

        public static final TagKey<Fluid> MOLTEN_ELEMENT_122 =
                FluidTags.create(MTUtil.forgeLocation("molten_element_122"));

        public static final TagKey<Fluid> MOLTEN_AURICHALCUM =
                FluidTags.create(MTUtil.forgeLocation("molten_aurichalcum"));

        public static final TagKey<Fluid> MOLTEN_DESOLUM =
                FluidTags.create(MTUtil.forgeLocation("molten_desolum"));

        public static final TagKey<Fluid> MOLTEN_PROSPRUM =
                FluidTags.create(MTUtil.forgeLocation("molten_prosprum"));

        public static final TagKey<Fluid> EARTHEN_GUM =
                FluidTags.create(MTUtil.forgeLocation("earthen_gum"));

        public static final TagKey<Fluid> MOLTEN_GUMBRONZE =
                FluidTags.create(MTUtil.forgeLocation("molten_gumbronze"));
    }
}
