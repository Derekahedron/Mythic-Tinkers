package derekahedron.mythictinkers.worldgen;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class MTBiomeModifiers {
    public static final ResourceKey<BiomeModifier> STYGIAN_DEEPSLATE =
            of("stygian_deepslate");
    public static final ResourceKey<BiomeModifier> OTHERSIDE_STYX =
            of("otherside_styx");
    public static final ResourceKey<BiomeModifier> BYZANTIUM_NEODYMIUM_MAGNETIC_NODE =
            of("byzantium_neodymium_magnetic_node");
    public static final ResourceKey<BiomeModifier> BYZANTIUM_ENERGIZED_GALENA =
            of("byzantium_energized_galena");
    public static final ResourceKey<BiomeModifier> TECTELLUS_ORE =
            of("tectellus_ore");
    public static final ResourceKey<BiomeModifier> ELEMENT_122_ORE =
            of("element_122_ore");
    public static final ResourceKey<BiomeModifier> IMPRISONING_COPROLITH =
            of("imprisoning_coprolith");
    public static final ResourceKey<BiomeModifier> EARTHEN_GUM_ORE =
            of("earthen_gum_ore");

    public static ResourceKey<BiomeModifier> of(String id) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, MTUtil.location(id));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        context.register(STYGIAN_DEEPSLATE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME)
                        .getOrThrow(MTBiomeTags.STYGIAN_DEEPSLATE_GENERATES_IN),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE)
                        .getOrThrow(MTPlacedFeatures.STYGIAN_DEEPSLATE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(OTHERSIDE_STYX, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME)
                        .getOrThrow(MTBiomeTags.OTHERSIDE_STYX_GENERATES_IN),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE)
                        .getOrThrow(MTPlacedFeatures.OTHERSIDE_STYX)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(BYZANTIUM_NEODYMIUM_MAGNETIC_NODE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME)
                        .getOrThrow(MTBiomeTags.BYZANTIUM_NEODYMIUM_MAGNETIC_NODE_GENERATES_IN),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE)
                        .getOrThrow(MTPlacedFeatures.BYZANTIUM_NEODYMIUM_MAGNETIC_NODE)),
                GenerationStep.Decoration.FLUID_SPRINGS));

        context.register(BYZANTIUM_ENERGIZED_GALENA, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME)
                        .getOrThrow(MTBiomeTags.BYZANTIUM_ENERGIZED_GALENA_GENERATES_IN),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE)
                        .getOrThrow(MTPlacedFeatures.BYZANTIUM_ENERGIZED_GALENA)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(TECTELLUS_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME)
                        .getOrThrow(MTBiomeTags.TECTELLUS_ORE_GENERATES_IN),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE)
                        .getOrThrow(MTPlacedFeatures.TECTELLUS_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ELEMENT_122_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME)
                        .getOrThrow(MTBiomeTags.ELEMENT_122_ORE_GENERATES_IN),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE)
                        .getOrThrow(MTPlacedFeatures.ELEMENT_122_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(IMPRISONING_COPROLITH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME)
                        .getOrThrow(MTBiomeTags.IMPRISONING_COPROLITH_GENERATES_IN),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE)
                        .getOrThrow(MTPlacedFeatures.IMPRISONING_COPROLITH)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(EARTHEN_GUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME)
                        .getOrThrow(MTBiomeTags.EARTHEN_GUM_ORE_GENERATES_IN),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE)
                        .getOrThrow(MTPlacedFeatures.EARTHEN_GUM_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }
}
