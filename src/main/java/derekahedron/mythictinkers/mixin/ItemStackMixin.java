package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.util.MTUtil;
import com.github.alexmodguy.alexscaves.server.misc.ACTagRegistry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Inject(
            method = "is(Lnet/minecraft/tags/TagKey;)Z",
            at = @At("HEAD"),
            cancellable = true)
    public void is(TagKey<Item> tag, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = (ItemStack) (Object) this;
        if (tag == ACTagRegistry.MAGNETIC_ITEMS && MTUtil.isMagneticTool(stack)) {
            cir.setReturnValue(true);
        }
    }
}
