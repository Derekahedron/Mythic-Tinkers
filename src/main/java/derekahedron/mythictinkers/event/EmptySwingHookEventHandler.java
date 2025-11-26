package derekahedron.mythictinkers.event;

import derekahedron.mythictinkers.network.EmptySwingPacket;
import derekahedron.mythictinkers.network.MTPacketHandler;
import derekahedron.mythictinkers.tinkers.hooks.EmptySwingModifierHook;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = derekahedron.mythictinkers.MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EmptySwingHookEventHandler {

    @SubscribeEvent
    public static void swing(PlayerInteractEvent.LeftClickEmpty event) {
        Player player = event.getEntity();
        ItemStack stack = event.getItemStack();
        if (!stack.is(TinkerTags.Items.HELD)) {
            return;
        }
        ToolStack tool = ToolStack.from(stack);
        EmptySwingModifierHook.handleAttack(tool, player, event.getHand());
        if (event.getLevel().isClientSide()) {
            MTPacketHandler.INSTANCE.sendToServer(new EmptySwingPacket(event.getHand()));
        }
    }

    @SubscribeEvent
    public static void swing(PlayerInteractEvent.LeftClickBlock event) {
        if (event.getAction() != PlayerInteractEvent.LeftClickBlock.Action.START) {
            return;
        }
        Player player = event.getEntity();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        ItemStack stack = event.getItemStack();
        if (!stack.is(TinkerTags.Items.HELD)) {
            return;
        }
        ToolStack tool = ToolStack.from(stack);
        if (!stack.getItem().canAttackBlock(level.getBlockState(pos), level, pos, player)) {
            EmptySwingModifierHook.handleAttack(tool, player, event.getHand());
        }
    }
}
