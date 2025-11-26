package derekahedron.mythictinkers.worldgen;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class MTPlacedFeatures {
    public static final ResourceKey<PlacedFeature> STYGIAN_DEEPSLATE =
            of("stygian_deepslate");
    public static final ResourceKey<PlacedFeature> OTHERSIDE_STYX =
            of("otherside_styx");
    public static final ResourceKey<PlacedFeature> BYZANTIUM_NEODYMIUM_MAGNETIC_NODE =
            of("byzantium_neodymium_magnetic_node");
    public static final ResourceKey<PlacedFeature> BYZANTIUM_ENERGIZED_GALENA =
            of("byzantium_energized_galena");
    public static final ResourceKey<PlacedFeature> TECTELLUS_ORE =
            of("tectellus_ore");
    public static final ResourceKey<PlacedFeature> ELEMENT_122_ORE =
            of("element_122_ore");
    public static final ResourceKey<PlacedFeature> IMPRISONING_COPROLITH =
            of("imprisoning_coprolith");
    public static final ResourceKey<PlacedFeature> EARTHEN_GUM_ORE =
            of("earthen_gum_ore");

    public static ResourceKey<PlacedFeature> of(String id) {
        return ResourceKey.create(Registries.PLACED_FEATURE, MTUtil.location(id));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        context.register(STYGIAN_DEEPSLATE, new PlacedFeature(
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(MTConfiguredFeatures.STYGIAN_DEEPSLATE),
                List.of(
                        CountPlacement.of(1),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(1),
                                VerticalAnchor.aboveBottom(4)),
                        InSquarePlacement.spread(),
                        BiomeFilter.biome())));

        context.register(OTHERSIDE_STYX, new PlacedFeature(
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(MTConfiguredFeatures.OTHERSIDE_STYX),
                List.of(
                        CountPlacement.of(6),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(0),
                                VerticalAnchor.belowTop(0)),
                        InSquarePlacement.spread(),
                        BiomeFilter.biome())));

        context.register(BYZANTIUM_NEODYMIUM_MAGNETIC_NODE, new PlacedFeature(
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(MTConfiguredFeatures.BYZANTIUM_NEODYMIUM_MAGNETIC_NODE),
                List.of(
                        CountPlacement.of(3),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(0),
                                VerticalAnchor.absolute(256)),
                        InSquarePlacement.spread(),
                        SurfaceRelativeThresholdFilter.of(
                                Heightmap.Types.OCEAN_FLOOR_WG,
                                Integer.MIN_VALUE,
                                -13),
                        BiomeFilter.biome())));

        context.register(BYZANTIUM_ENERGIZED_GALENA, new PlacedFeature(
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(MTConfiguredFeatures.BYZANTIUM_ENERGIZED_GALENA),
                List.of(
                        CountPlacement.of(5),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(0),
                                VerticalAnchor.absolute(256)),
                        InSquarePlacement.spread(),
                        BiomeFilter.biome())));

        context.register(TECTELLUS_ORE, new PlacedFeature(
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(MTConfiguredFeatures.TECTELLUS_ORE),
                List.of(
                        CountPlacement.of(10),
                        HeightRangePlacement.triangle(
                                VerticalAnchor.aboveBottom(0),
                                VerticalAnchor.absolute(32)),
                        InSquarePlacement.spread(),
                        BiomeFilter.biome())));

        context.register(ELEMENT_122_ORE, new PlacedFeature(
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(MTConfiguredFeatures.ELEMENT_122_ORE),
                List.of(
                        CountPlacement.of(2),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(0),
                                VerticalAnchor.absolute(256)),
                        InSquarePlacement.spread(),
                        BiomeFilter.biome())));

        context.register(IMPRISONING_COPROLITH, new PlacedFeature(
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(MTConfiguredFeatures.IMPRISONING_COPROLITH),
                List.of(
                        CountPlacement.of(1),
                        HeightRangePlacement.triangle(
                                VerticalAnchor.aboveBottom(-32),
                                VerticalAnchor.absolute(32)),
                        InSquarePlacement.spread(),
                        SurfaceRelativeThresholdFilter.of(
                                Heightmap.Types.OCEAN_FLOOR_WG,
                                Integer.MIN_VALUE,
                                -10),
                        BiomeFilter.biome())));

        context.register(EARTHEN_GUM_ORE, new PlacedFeature(
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(MTConfiguredFeatures.EARTHEN_GUM_ORE),
                List.of(
                        CountPlacement.of(2),
                        HeightRangePlacement.uniform(
                                VerticalAnchor.aboveBottom(0),
                                VerticalAnchor.absolute(32)),
                        InSquarePlacement.spread(),
                        BiomeFilter.biome())));
    }
}
