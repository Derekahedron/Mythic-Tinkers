package derekahedron.mythictinkers.client.network;

import derekahedron.mythictinkers.entity.LivingEntityDuck;
import derekahedron.mythictinkers.network.SyncStyxDamagePacket;
import net.minecraft.client.Minecraft;

public class SyncStyxDamagePacketHandler {

    public static void handlePacket(SyncStyxDamagePacket packet) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null) {
            ((LivingEntityDuck) minecraft.player).mythictinkers_$setStyxDamage(packet.styxDamage());
        }
    }
}
