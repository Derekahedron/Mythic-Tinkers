package derekahedron.mythictinkers.datagen.tags;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.fluid.MTFluidTags;
import derekahedron.mythictinkers.fluid.MTFluids;
import derekahedron.mythictinkers.util.ForgeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class MTFluidTagsProvider extends FluidTagsProvider {

    public MTFluidTagsProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MythicTinkers.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return String.format("%s Fluid Tags", MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        tag(MTFluidTags.STYX)
                .add(MTFluids.STYX.get())
                .add(MTFluids.STYX_FLOWING.get());
        tag(ForgeTags.Fluids.STYX)
                .addTag(MTFluidTags.STYX);

        tag(MTFluidTags.MOLTEN_SCARLET_NEODYMIUM)
                .add(MTFluids.MOLTEN_SCARLET_NEODYMIUM.get())
                .add(MTFluids.MOLTEN_SCARLET_NEODYMIUM_FLOWING.get());
        tag(ForgeTags.Fluids.MOLTEN_SCARLET_NEODYMIUM)
                .addTag(MTFluidTags.MOLTEN_SCARLET_NEODYMIUM);

        tag(MTFluidTags.MOLTEN_AZURE_NEODYMIUM)
                .add(MTFluids.MOLTEN_AZURE_NEODYMIUM.get())
                .add(MTFluids.MOLTEN_AZURE_NEODYMIUM_FLOWING.get());
        tag(ForgeTags.Fluids.MOLTEN_AZURE_NEODYMIUM)
                .addTag(MTFluidTags.MOLTEN_AZURE_NEODYMIUM);

        tag(MTFluidTags.MOLTEN_BYZANTIUM_NEODYMIUM)
                .add(MTFluids.MOLTEN_BYZANTIUM_NEODYMIUM.get())
                .add(MTFluids.MOLTEN_BYZANTIUM_NEODYMIUM_FLOWING.get());
        tag(ForgeTags.Fluids.MOLTEN_BYZANTIUM_NEODYMIUM)
                .addTag(MTFluidTags.MOLTEN_BYZANTIUM_NEODYMIUM);

        tag(MTFluidTags.MOLTEN_TECTELLUS)
                .add(MTFluids.MOLTEN_TECTELLUS.get())
                .add(MTFluids.MOLTEN_TECTELLUS_FLOWING.get());
        tag(ForgeTags.Fluids.MOLTEN_TECTELLUS)
                .addTag(MTFluidTags.MOLTEN_TECTELLUS);

        tag(MTFluidTags.MOLTEN_ELEMENT_122)
                .add(MTFluids.MOLTEN_ELEMENT_122.get())
                .add(MTFluids.MOLTEN_ELEMENT_122_FLOWING.get());
        tag(ForgeTags.Fluids.MOLTEN_ELEMENT_122)
                .addTag(MTFluidTags.MOLTEN_ELEMENT_122);

        tag(MTFluidTags.MOLTEN_AURICHALCUM)
                .add(MTFluids.MOLTEN_AURICHALCUM.get())
                .add(MTFluids.MOLTEN_AURICHALCUM_FLOWING.get());
        tag(ForgeTags.Fluids.MOLTEN_AURICHALCUM)
                .addTag(MTFluidTags.MOLTEN_AURICHALCUM);

        tag(MTFluidTags.MOLTEN_DESOLUM)
                .add(MTFluids.MOLTEN_DESOLUM.get())
                .add(MTFluids.MOLTEN_DESOLUM_FLOWING.get());
        tag(ForgeTags.Fluids.MOLTEN_DESOLUM)
                .addTag(MTFluidTags.MOLTEN_DESOLUM);

        tag(MTFluidTags.MOLTEN_PROSPRUM)
                .add(MTFluids.MOLTEN_PROSPRUM.get())
                .add(MTFluids.MOLTEN_PROSPRUM_FLOWING.get());
        tag(ForgeTags.Fluids.MOLTEN_PROSPRUM)
                .addTag(MTFluidTags.MOLTEN_PROSPRUM);

        tag(MTFluidTags.EARTHEN_GUM)
                .add(MTFluids.EARTHEN_GUM.get())
                .add(MTFluids.EARTHEN_GUM_FLOWING.get());
        tag(ForgeTags.Fluids.EARTHEN_GUM)
                .addTag(MTFluidTags.EARTHEN_GUM);

        tag(MTFluidTags.MOLTEN_GUMBRONZE)
                .add(MTFluids.MOLTEN_GUMBRONZE.get())
                .add(MTFluids.MOLTEN_GUMBRONZE_FLOWING.get());
        tag(ForgeTags.Fluids.MOLTEN_GUMBRONZE)
                .addTag(MTFluidTags.MOLTEN_GUMBRONZE);

        tag(MTFluidTags.COOLS_MOLTEN_ORE)
                .addTag(FluidTags.WATER);

        tag(MTFluidTags.GUM_TOOLTIPS)
                .addTag(MTFluidTags.EARTHEN_GUM);

        tag(TinkerTags.Fluids.METAL_TOOLTIPS)
                .addTag(ForgeTags.Fluids.MOLTEN_SCARLET_NEODYMIUM)
                .addTag(ForgeTags.Fluids.MOLTEN_AZURE_NEODYMIUM)
                .addTag(ForgeTags.Fluids.MOLTEN_BYZANTIUM_NEODYMIUM)
                .addTag(ForgeTags.Fluids.MOLTEN_TECTELLUS)
                .addTag(ForgeTags.Fluids.MOLTEN_ELEMENT_122)
                .addTag(ForgeTags.Fluids.MOLTEN_AURICHALCUM)
                .addTag(ForgeTags.Fluids.MOLTEN_DESOLUM)
                .addTag(ForgeTags.Fluids.MOLTEN_PROSPRUM)
                .addTag(ForgeTags.Fluids.MOLTEN_GUMBRONZE);
    }
}
