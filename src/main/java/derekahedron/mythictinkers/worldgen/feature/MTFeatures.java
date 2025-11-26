package derekahedron.mythictinkers.worldgen.feature;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MTFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(ForgeRegistries.FEATURES, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final RegistryObject<ReplaceUnexposedBlockFeature> REPLACE_UNEXPOSED_BLOCK =
            FEATURES.register("replace_unexposed_block", () ->
                    new ReplaceUnexposedBlockFeature(ReplaceBlockConfiguration.CODEC));
}
