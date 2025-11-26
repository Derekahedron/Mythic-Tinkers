package derekahedron.mythictinkers.worldgen;

import derekahedron.mythictinkers.block.MTBlockTags;
import derekahedron.mythictinkers.block.MTBlocks;
import derekahedron.mythictinkers.util.MTUtil;
import derekahedron.mythictinkers.worldgen.feature.MTFeatures;
import com.github.alexmodguy.alexscaves.server.block.ACBlockRegistry;
import com.github.alexmodguy.alexscaves.server.level.feature.ACFeatureRegistry;
import com.github.alexmodguy.alexscaves.server.level.feature.config.MagneticNodeFeatureConfiguration;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class MTConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> STYGIAN_DEEPSLATE =
            of("stygian_deepslate");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OTHERSIDE_STYX =
            of("otherside_styx");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BYZANTIUM_NEODYMIUM_MAGNETIC_NODE =
            of("byzantium_neodymium_magnetic_node");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BYZANTIUM_ENERGIZED_GALENA =
            of("byzantium_energized_galena");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TECTELLUS_ORE =
            of("tectellus_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ELEMENT_122_ORE =
            of("element_122_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IMPRISONING_COPROLITH =
            of("imprisoning_coprolith");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EARTHEN_GUM_ORE =
            of("earthen_gum_ore");

    public static ResourceKey<ConfiguredFeature<?, ?>> of(String id) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, MTUtil.location(id));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        context.register(STYGIAN_DEEPSLATE, new ConfiguredFeature<>(
                Feature.REPLACE_SINGLE_BLOCK,
                new ReplaceBlockConfiguration(
                        Blocks.DEEPSLATE.defaultBlockState(),
                        MTBlocks.STYGIAN_DEEPSLATE.get().defaultBlockState())));

        context.register(OTHERSIDE_STYX, new ConfiguredFeature<>(
                Feature.REPLACE_SINGLE_BLOCK,
                new ReplaceBlockConfiguration(ImmutableList.of(
                        OreConfiguration.target(
                                new TagMatchTest(MTBlockTags.SCULK_STONE),
                                MTBlocks.STYGIAN_SCULK_STONE.get().defaultBlockState()),
                        OreConfiguration.target(
                                new TagMatchTest(MTBlockTags.GLOOMSLATE),
                                MTBlocks.STYGIAN_GLOOMSLATE.get().defaultBlockState())))));

        context.register(BYZANTIUM_NEODYMIUM_MAGNETIC_NODE, new ConfiguredFeature<>(
                ACFeatureRegistry.MAGNETIC_NODE.get(),
                new MagneticNodeFeatureConfiguration(
                        BlockStateProvider.simple(MTBlocks.BYZANTIUM_NEODYMIUM_PILLAR.get()),
                        BlockStateProvider.simple(MTBlocks.BYZANTIUM_NEODYMIUM_NODE.get()))));

        context.register(BYZANTIUM_ENERGIZED_GALENA, new ConfiguredFeature<>(
                Feature.ORE,
                new OreConfiguration(
                        new TagMatchTest(MTBlockTags.ENERGIZED_GALENA),
                        MTBlocks.BYZANTIUM_ENERGIZED_GALENA.get().defaultBlockState(),
                        30)));

        context.register(TECTELLUS_ORE, new ConfiguredFeature<>(
                Feature.ORE,
                new OreConfiguration(
                        new BlockMatchTest(ACBlockRegistry.LIMESTONE.get()),
                        MTBlocks.DORMANT_TECTELLUS_ORE.get().defaultBlockState(),
                        6)));

        context.register(ELEMENT_122_ORE, new ConfiguredFeature<>(
                Feature.ORE,
                new OreConfiguration(
                        new BlockMatchTest(ACBlockRegistry.RADROCK.get()),
                        MTBlocks.ELEMENT_122_ORE.get().defaultBlockState(),
                        12)));

        context.register(IMPRISONING_COPROLITH, new ConfiguredFeature<>(
                MTFeatures.REPLACE_UNEXPOSED_BLOCK.get(),
                new ReplaceBlockConfiguration(
                        ACBlockRegistry.COPROLITH.get().defaultBlockState(),
                        MTBlocks.IMPRISONING_COPROLITH.get().defaultBlockState())));

        context.register(EARTHEN_GUM_ORE, new ConfiguredFeature<>(
                Feature.ORE,
                new OreConfiguration(
                        new BlockMatchTest(ACBlockRegistry.CAKE_LAYER.get()),
                        MTBlocks.EARTHEN_GUM_ORE.get().defaultBlockState(),
                        24,
                        0.8F)));
    }
}
