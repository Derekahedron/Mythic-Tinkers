package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.entity.LivingEntityDuck;
import derekahedron.mythictinkers.event.StyxEventHandler;
import derekahedron.mythictinkers.fluid.MTFluidTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin implements LivingEntityDuck {
    @Unique
    private static final String mythictinkers_$STYX_DAMAGE_KEY = "mythictinkers:STYX_DAMAGE";

    @Unique
    private boolean mythictinkers_$inStyx = false;
    @Unique
    private float mythictinkers_$styxDamage = 0.0F;

    @Shadow protected boolean jumping;
    @Shadow public float xxa;
    @Shadow public float yya;
    @Shadow public float zza;

    @Shadow
    protected abstract boolean isAffectedByFluids();

    @Inject(
            method = "aiStep",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/LivingEntity;serverAiStep()V",
                    shift = At.Shift.AFTER))
    private void restrictMovement(CallbackInfo ci) {
        LivingEntity self = (LivingEntity)(Object) this;
        if (mythictinkers_$inStyx && isAffectedByFluids()) {
            float styxIntensity = StyxEventHandler.getStyxIntensity(mythictinkers_$styxDamage);
            if (jumping &&
                    (self.getFluidTypeHeight(MTFluidTypes.STYX.get()) > self.getFluidJumpThreshold()
                            || styxIntensity >= 1.0F)) {
                jumping = false;
            }
            xxa *= (1.0F - styxIntensity);
            yya *= (1.0F - styxIntensity);
            zza *= (1.0F - styxIntensity);
        }
    }

    @Inject(
            method = "addAdditionalSaveData",
            at = @At("RETURN")
    )
    private void saveCustomAttrs(CompoundTag compound, CallbackInfo ci) {
        compound.putFloat(mythictinkers_$STYX_DAMAGE_KEY, mythictinkers_$styxDamage);
    }

    @Inject(
            method = "readAdditionalSaveData",
            at = @At("RETURN")
    )
    private void loadCustomAttrs(CompoundTag compound, CallbackInfo ci) {
        if (compound.contains(mythictinkers_$STYX_DAMAGE_KEY)) {
            mythictinkers_$styxDamage = compound.getFloat(mythictinkers_$STYX_DAMAGE_KEY);
        }
    }

    @Override
    public boolean mythictinkers_$isInStyx() {
        return mythictinkers_$inStyx;
    }

    @Override
    public void mythictinkers_$setInStyx(boolean inStyx) {
        mythictinkers_$inStyx = inStyx;
    }

    @Override
    public float mythictinkers_$getStyxDamage() {
        return mythictinkers_$styxDamage;
    }

    @Override
    public void mythictinkers_$setStyxDamage(float styxDamage) {
        this.mythictinkers_$styxDamage = styxDamage;
    }
}
