package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.fluid.MTFluidType;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow(remap = false)
    protected Object2DoubleMap<FluidType> forgeFluidTypeHeight;

    @Inject(
            method = "baseTick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/Entity;updateInWaterStateAndDoFluidPushing()Z",
                    shift = At.Shift.AFTER))
    private void tickInMoltenFluid(CallbackInfo ci) {
        Entity self = (Entity) (Object) this;
        if (self.fireImmune() || !self.isInFluidType()) return;

        forgeFluidTypeHeight.keySet().forEach((fluidType) -> {
            if (fluidType instanceof MTFluidType) {
                ((MTFluidType) fluidType).onEntityInside(self);
            }
        });
    }
}
