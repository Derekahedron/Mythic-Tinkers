package derekahedron.mythictinkers.datagen.tags;

import derekahedron.mythictinkers.worldgen.MTBiomeTags;
import com.github.alexmodguy.alexscaves.server.level.biome.ACBiomeRegistry;
import com.kyanite.deeperdarker.world.otherside.OthersideBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class MTBiomeTagsProvider extends BiomeTagsProvider {

    public MTBiomeTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, derekahedron.mythictinkers.MythicTinkers.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return String.format("%s Biome Tags", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        tag(MTBiomeTags.STYGIAN_DEEPSLATE_GENERATES_IN)
                .add(Biomes.DEEP_DARK);
        tag(MTBiomeTags.OTHERSIDE_STYX_GENERATES_IN)
                .addOptional(OthersideBiomes.DEEPLANDS.location())
                .addOptional(OthersideBiomes.ECHOING_FOREST.location())
                .addOptional(OthersideBiomes.BLOOMING_CAVERNS.location())
                .addOptional(OthersideBiomes.OVERCAST_COLUMNS.location());
        tag(MTBiomeTags.BYZANTIUM_NEODYMIUM_MAGNETIC_NODE_GENERATES_IN)
                .addOptional(ACBiomeRegistry.MAGNETIC_CAVES.location());
        tag(MTBiomeTags.BYZANTIUM_ENERGIZED_GALENA_GENERATES_IN)
                .addOptional(ACBiomeRegistry.MAGNETIC_CAVES.location());
        tag(MTBiomeTags.TECTELLUS_ORE_GENERATES_IN)
                .addOptional(ACBiomeRegistry.PRIMORDIAL_CAVES.location());
        tag(MTBiomeTags.ELEMENT_122_ORE_GENERATES_IN)
                .addOptional(ACBiomeRegistry.TOXIC_CAVES.location());
        tag(MTBiomeTags.ATLANTEAN_RUINS_GENERATES_IN)
                .addOptional(ACBiomeRegistry.ABYSSAL_CHASM.location());
        tag(MTBiomeTags.IMPRISONING_COPROLITH_GENERATES_IN)
                .addOptional(ACBiomeRegistry.FORLORN_HOLLOWS.location());
        tag(MTBiomeTags.EARTHEN_GUM_ORE_GENERATES_IN)
                .addOptional(ACBiomeRegistry.CANDY_CAVITY.location());
    }
}
