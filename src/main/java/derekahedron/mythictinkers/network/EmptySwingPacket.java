package derekahedron.mythictinkers.network;

import derekahedron.mythictinkers.tinkers.hooks.EmptySwingModifierHook;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.function.Supplier;

public record EmptySwingPacket(InteractionHand hand) {

    public EmptySwingPacket(FriendlyByteBuf buffer) {
        this(InteractionHand.values()[buffer.readInt()]);
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeInt(hand.ordinal());
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            ServerPlayer player = context.get().getSender();
            if (player == null) {
                return;
            }
            ItemStack stack = player.getItemInHand(hand);
            if (!stack.is(TinkerTags.Items.HELD)) {
                return;
            }
            ToolStack tool = ToolStack.from(stack);
            EmptySwingModifierHook.handleAttack(tool, player, hand);
        });
    }
}
