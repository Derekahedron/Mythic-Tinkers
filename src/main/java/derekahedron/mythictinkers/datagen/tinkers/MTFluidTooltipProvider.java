package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.fluid.MTFluidTags;
import derekahedron.mythictinkers.recipe.MTFluidValues;
import net.minecraft.data.PackOutput;
import slimeknights.mantle.fluid.tooltip.AbstractFluidTooltipProvider;

public class MTFluidTooltipProvider extends AbstractFluidTooltipProvider {

    public MTFluidTooltipProvider(PackOutput output) {
        super(output, MythicTinkers.MOD_ID);
    }

    @Override
    public String getName() {
        return String.format("%s Fluid Tooltip Provider", MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addFluids() {
        add("metals", MTFluidTags.GUM_TOOLTIPS)
                .addUnit("block", MTFluidValues.GUM_BLOCK)
                .addUnit("wad", MTFluidValues.GUM_WAD);
    }
}
