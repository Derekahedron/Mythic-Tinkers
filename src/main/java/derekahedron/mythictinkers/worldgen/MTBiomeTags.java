package derekahedron.mythictinkers.worldgen;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class MTBiomeTags {
    public static final TagKey<Biome> STYGIAN_DEEPSLATE_GENERATES_IN =
            create(MTUtil.location("stygian_deepslate_generates_in"));
    public static final TagKey<Biome> OTHERSIDE_STYX_GENERATES_IN =
            create(MTUtil.location("otherside_styx_generates_in"));
    public static final TagKey<Biome> BYZANTIUM_NEODYMIUM_MAGNETIC_NODE_GENERATES_IN =
            create(MTUtil.location("byzantium_neodymium_magnetic_node_generates_in"));
    public static final TagKey<Biome> BYZANTIUM_ENERGIZED_GALENA_GENERATES_IN =
            create(MTUtil.location("byzantium_energized_galena_generates_in"));
    public static final TagKey<Biome> TECTELLUS_ORE_GENERATES_IN =
            create(MTUtil.location("tectellus_ore_generates_in"));
    public static final TagKey<Biome> ELEMENT_122_ORE_GENERATES_IN =
            create(MTUtil.location("element_122_ore_generates_in"));
    public static final TagKey<Biome> ATLANTEAN_RUINS_GENERATES_IN =
            create(MTUtil.location("atlantean_ruins_generates_in"));
    public static final TagKey<Biome> IMPRISONING_COPROLITH_GENERATES_IN =
            create(MTUtil.location("imprisoning_coprolith_generates_in"));
    public static final TagKey<Biome> EARTHEN_GUM_ORE_GENERATES_IN =
            create(MTUtil.location("earthen_gum_ore_generates_in"));

    public static TagKey<Biome> create(ResourceLocation location) {
        return TagKey.create(Registries.BIOME, location);
    }
}
