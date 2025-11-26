package derekahedron.mythictinkers.mixin.client;

import derekahedron.mythictinkers.client.player.LocalPlayerDuck;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin implements LocalPlayerDuck {

    @Unique
    private float mythictinkers_$styxIntensity = 0.0F;

    @Override
    public float mythictinkers_$getStyxIntensity() {
        return mythictinkers_$styxIntensity;
    }

    @Override
    public void mythictinkers_$setStyxIntensity(float styxIntensity) {
        mythictinkers_$styxIntensity = styxIntensity;
    }
}
