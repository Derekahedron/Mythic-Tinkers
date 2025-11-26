package derekahedron.mythictinkers.client.network;

import derekahedron.mythictinkers.fluid.StyxFluid;
import derekahedron.mythictinkers.network.StyxEvaporatePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.player.Player;

public class StyxEvaporatePacketHandler {

    public static void handlePacket(StyxEvaporatePacket packet) {
        ClientLevel level = Minecraft.getInstance().level;
        Player player = Minecraft.getInstance().player;
        if (level == null || player == null) return;

        StyxFluid.fizz(player, level, packet.blockPos());
    }
}
