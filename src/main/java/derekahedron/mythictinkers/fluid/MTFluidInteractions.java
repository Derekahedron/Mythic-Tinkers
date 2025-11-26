package derekahedron.mythictinkers.fluid;

import derekahedron.mythictinkers.block.MTBlocks;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class MTFluidInteractions {

    public static void initialize(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            FluidInteractionRegistry.addInteraction(MTFluidTypes.STYX.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) -> {
                                FluidState relativeState = level.getFluidState(relativePos);
                                return !relativeState.isEmpty() && relativeState.getFluidType() != currentState.getFluidType();
                            },
                            (level, currentPos, relativePos, currentState) -> {
                                level.setBlockAndUpdate(currentPos, ForgeEventFactory.fireFluidPlaceBlockEvent(
                                        level, currentPos, currentPos, MTBlocks.DOMBSTONE.get().defaultBlockState()));
                                StyxFluid.fizz(null, level, currentPos);
                            }));

            FluidInteractionRegistry.addInteraction(MTFluidTypes.MOLTEN_SCARLET_NEODYMIUM.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) ->
                                    level.getFluidState(relativePos).is(MTFluidTags.COOLS_MOLTEN_ORE),
                            Blocks.COBBLESTONE.defaultBlockState()));

            FluidInteractionRegistry.addInteraction(MTFluidTypes.MOLTEN_AZURE_NEODYMIUM.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) ->
                                    level.getFluidState(relativePos).is(MTFluidTags.COOLS_MOLTEN_ORE),
                            Blocks.COBBLESTONE.defaultBlockState()));

            FluidInteractionRegistry.addInteraction(MTFluidTypes.MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) ->
                                    level.getFluidState(relativePos).is(MTFluidTags.COOLS_MOLTEN_ORE),
                            Blocks.COBBLESTONE.defaultBlockState()));

            FluidInteractionRegistry.addInteraction(MTFluidTypes.MOLTEN_TECTELLUS.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) ->
                                    level.getFluidState(relativePos).is(MTFluidTags.COOLS_MOLTEN_ORE),
                            Blocks.COBBLESTONE.defaultBlockState()));

            FluidInteractionRegistry.addInteraction(MTFluidTypes.MOLTEN_ELEMENT_122.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) ->
                                    level.getFluidState(relativePos).is(MTFluidTags.COOLS_MOLTEN_ORE),
                            Blocks.COBBLESTONE.defaultBlockState()));

            FluidInteractionRegistry.addInteraction(MTFluidTypes.MOLTEN_AURICHALCUM.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) ->
                                    level.getFluidState(relativePos).is(MTFluidTags.COOLS_MOLTEN_ORE),
                            Blocks.COBBLESTONE.defaultBlockState()));

            FluidInteractionRegistry.addInteraction(MTFluidTypes.MOLTEN_DESOLUM.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) ->
                                    level.getFluidState(relativePos).is(MTFluidTags.COOLS_MOLTEN_ORE),
                            Blocks.COBBLESTONE.defaultBlockState()));

            FluidInteractionRegistry.addInteraction(MTFluidTypes.MOLTEN_PROSPRUM.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) ->
                                    level.getFluidState(relativePos).is(MTFluidTags.COOLS_MOLTEN_ORE),
                            Blocks.COBBLESTONE.defaultBlockState()));

            FluidInteractionRegistry.addInteraction(MTFluidTypes.MOLTEN_GUMBRONZE.get(),
                    new FluidInteractionRegistry.InteractionInformation(
                            (level, currentPos, relativePos, currentState) ->
                                    level.getFluidState(relativePos).is(MTFluidTags.COOLS_MOLTEN_ORE),
                            Blocks.COBBLESTONE.defaultBlockState()));
        });
    }
}
