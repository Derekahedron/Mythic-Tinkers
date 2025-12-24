package derekahedron.mythictinkers.datagen;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.damage.MTDamageTypes;
import derekahedron.mythictinkers.datagen.advancements.MTAdvancementProvider;
import derekahedron.mythictinkers.datagen.loot.MTLootTableProvider;
import derekahedron.mythictinkers.datagen.models.MTBlockStateProvider;
import derekahedron.mythictinkers.datagen.models.MTItemModelProvider;
import derekahedron.mythictinkers.datagen.recipes.MTRecipeProvider;
import derekahedron.mythictinkers.datagen.tags.*;
import derekahedron.mythictinkers.datagen.tinkers.*;
import derekahedron.mythictinkers.worldgen.MTBiomeModifiers;
import derekahedron.mythictinkers.worldgen.MTConfiguredFeatures;
import derekahedron.mythictinkers.worldgen.MTPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MTDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        RegistrySetBuilder registrySetBuilder = new RegistrySetBuilder();
        registrySetBuilder.add(Registries.CONFIGURED_FEATURE, MTConfiguredFeatures::bootstrap);
        registrySetBuilder.add(Registries.PLACED_FEATURE, MTPlacedFeatures::bootstrap);
        registrySetBuilder.add(ForgeRegistries.Keys.BIOME_MODIFIERS, MTBiomeModifiers::bootstrap);
        registrySetBuilder.add(Registries.DAMAGE_TYPE, MTDamageTypes::bootstrap);
        DatapackBuiltinEntriesProvider builtinProvider =
                generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(
                        output, lookupProvider, registrySetBuilder,
                        Set.of(MythicTinkers.MOD_ID)));

        generator.addProvider(event.includeClient(), new MTBlockStateProvider(
                output, existingFileHelper));

        generator.addProvider(event.includeClient(), new MTItemModelProvider(
                output, existingFileHelper));

        AbstractMaterialSpriteProvider materialSpriteProvider = new MTMaterialSpriteProvider();

        generator.addProvider(event.includeClient(), new MTMaterialRenderInfoProvider(
                output, materialSpriteProvider, existingFileHelper));

        BlockTagsProvider blockTagsProvider =
                generator.addProvider(event.includeServer(), new MTBlockTagsProvider(
                        output, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new MTItemTagsProvider(
                output, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(), new MTFluidTagsProvider(
                output, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new MTBiomeTagsProvider(
                output, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new MTDamageTypeTagsProvider(
                output, builtinProvider.getRegistryProvider(), existingFileHelper));

        generator.addProvider(event.includeServer(), new MTLootTableProvider(
                output));

        generator.addProvider(event.includeServer(), new MTRecipeProvider(
                output));

        generator.addProvider(event.includeServer(), new MTModifierRecipeProvider(
                output));

        generator.addProvider(event.includeServer(), new MTSmelteryRecipeProvider(
                output));

        generator.addProvider(event.includeServer(), new MTMaterialRecipeProvider(
                output));

        generator.addProvider(event.includeServer(), new MTModifierProvider(
                output));

        AbstractMaterialDataProvider materialProvider =
                generator.addProvider(event.includeServer(), new MTMaterialDataProvider(
                        output));

        generator.addProvider(event.includeServer(), new MTMaterialStatsDataProvider(
                output,
                materialProvider));

        generator.addProvider(event.includeServer(), new MTMaterialTraitDataProvider(
                output,
                materialProvider));

        generator.addProvider(event.includeServer(), new MTFluidTooltipProvider(
                output));

        generator.addProvider(event.includeServer(), new MTMaterialTagsProvider(
                output,
                existingFileHelper));

        generator.addProvider(event.includeServer(), new MTModifierTagsProvider(
                output,
                existingFileHelper));

        generator.addProvider(event.includeServer(), new MTAdvancementProvider(
                output,
                lookupProvider,
                existingFileHelper));
    }
}
