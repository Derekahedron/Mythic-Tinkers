package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.tinkers.hooks.MTModifierHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mixin(BlockBehaviour.class)
public class BlockBehaviorMixin {

    @ModifyVariable(
            method = "getDestroyProgress",
            at = @At("STORE"))
    private float getNewDestroySpeed(float destroySpeed, BlockState state, Player player, BlockGetter world, BlockPos pos) {
        ItemStack stack = player.getMainHandItem();
        if (stack.getItem() instanceof IModifiable) {
            ToolStack tool = ToolStack.from(stack);
            boolean correctForDrops = ForgeHooks.isCorrectToolForDrops(state, player);
            for (ModifierEntry modifier : tool.getModifiers()) {
                destroySpeed = modifier.getHook(MTModifierHooks.DESTROY_SPEED).onDestroySpeed(
                        tool, modifier, player, state, destroySpeed, correctForDrops, world, pos);
            }
        }
        return destroySpeed;
    }
}
