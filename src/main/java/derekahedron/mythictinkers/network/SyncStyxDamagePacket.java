package derekahedron.mythictinkers.network;

import derekahedron.mythictinkers.client.network.SyncStyxDamagePacketHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record SyncStyxDamagePacket(float styxDamage) {

    public SyncStyxDamagePacket(FriendlyByteBuf buffer) {
        this(buffer.readFloat());
    }

    public void toBytes(FriendlyByteBuf buffer) {
        buffer.writeFloat(styxDamage);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() ->
                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () ->
                        SyncStyxDamagePacketHandler.handlePacket(this)));
        context.get().setPacketHandled(true);
    }
}
