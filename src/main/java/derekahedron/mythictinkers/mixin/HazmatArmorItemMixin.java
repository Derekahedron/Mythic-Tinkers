package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.tinkers.modifiers.MTModifierIds;
import com.github.alexmodguy.alexscaves.server.item.HazmatArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

@Mixin(HazmatArmorItem.class)
public class HazmatArmorItemMixin {

    @Inject(
            method = "getWornAmount",
            at = @At("RETURN"),
            cancellable = true,
            remap = false)
    private static void getWornAmount(LivingEntity entity, CallbackInfoReturnable<Integer> cir) {
        int i = cir.getReturnValue();

        if (ModifierUtil.getModifierLevel(entity.getItemBySlot(EquipmentSlot.HEAD), MTModifierIds.POLYMER_PLATED) > 0) {
            i++;
        }

        if (ModifierUtil.getModifierLevel(entity.getItemBySlot(EquipmentSlot.CHEST), MTModifierIds.POLYMER_PLATED) > 0) {
            i++;
        }

        if (ModifierUtil.getModifierLevel(entity.getItemBySlot(EquipmentSlot.LEGS), MTModifierIds.POLYMER_PLATED) > 0) {
            i++;
        }

        if (ModifierUtil.getModifierLevel(entity.getItemBySlot(EquipmentSlot.FEET), MTModifierIds.POLYMER_PLATED) > 0) {
            i++;
        }

        i = Math.min(i, 4);

        if (i != cir.getReturnValue()) {
            cir.setReturnValue(i);
        }
    }
}
