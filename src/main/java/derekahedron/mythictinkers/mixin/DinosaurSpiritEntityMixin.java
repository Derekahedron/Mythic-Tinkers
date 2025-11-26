package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.tinkers.modifiers.MTModifiers;
import com.github.alexmodguy.alexscaves.server.entity.item.DinosaurSpiritEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

@Mixin(DinosaurSpiritEntity.class)
public class DinosaurSpiritEntityMixin {

    @Inject(
            method = "tickGrottoceratops",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/github/alexmodguy/alexscaves/server/entity/item/DinosaurSpiritEntity;setFading(Z)V"),
            cancellable = true,
            remap = false)
    private void preventFading(Player player, CallbackInfo ci) {
        if (ModifierUtil.getModifierLevel(player.getUseItem(), MTModifiers.TECTONIC_SHIELD.getId()) > 0 ) {
            ci.cancel();
        }
    }
}
