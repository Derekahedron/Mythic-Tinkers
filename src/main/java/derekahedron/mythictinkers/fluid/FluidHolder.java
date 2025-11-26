package derekahedron.mythictinkers.fluid;

import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.mantle.registration.object.FluidObject;

import java.util.Objects;

public class FluidHolder<F extends Fluid> {
    public final RegistryObject<FluidType> fluidType;
    public final RegistryObject<F> stillFluid;
    public final RegistryObject<F> flowingFluid;
    public final FluidObject<F> fluidObject;

    public FluidHolder(RegistryObject<FluidType> fluidType, RegistryObject<F> stillFluid, RegistryObject<F> flowingFluid) {
        Objects.requireNonNull(fluidType.getId());
        this.fluidType = fluidType;
        this.stillFluid = stillFluid;
        this.flowingFluid = flowingFluid;
        this.fluidObject = new FluidObject<>(
                fluidType.getId(),
                fluidType.getId().getPath(),
                fluidType,
                stillFluid);
    }

    public ForgeFlowingFluid.Properties properties() {
        return new ForgeFlowingFluid.Properties(fluidType, stillFluid, flowingFluid);
    }
}
