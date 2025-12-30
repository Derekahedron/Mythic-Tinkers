package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.tinkers.hooks.MTModifierHooks;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.tools.entity.ThrownTool;

@Mixin(AbstractArrow.class)
public class AbstractArrowMixin {

    @Inject(
            method = "onHitBlock",
        at = @At("HEAD"),
        cancellable = true)
    private void onHitBlock(BlockHitResult hitResult, CallbackInfo ci) {
        AbstractArrow self  = (AbstractArrow) (Object) this;
        if (self instanceof ThrownTool thrownTool) {
            if (!(thrownTool.getOwner() instanceof LivingEntity owner)) return;

            ItemStack stack = thrownTool.getDisplayTool();
            if (!(stack.getItem() instanceof IModifiable)) return;

            ToolStack tool = ToolStack.from(stack);
            for (ModifierEntry modifier : tool.getModifiers()) {
                if (modifier.getHook(MTModifierHooks.THROWN_TOOL_HIT).onThrownToolHitsBlock(
                        tool,
                        modifier,
                        thrownTool,
                        owner,
                        hitResult.getBlockPos())) {
                    ci.cancel();
                    return;
                }
            }
        }
    }
}
