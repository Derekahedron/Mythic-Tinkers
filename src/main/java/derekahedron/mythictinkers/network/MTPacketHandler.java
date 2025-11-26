package derekahedron.mythictinkers.network;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class MTPacketHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            MTUtil.location("main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    private static int id = 0;

    public static int getId() {
        return id++;
    }

    public static void initialize(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            INSTANCE.registerMessage(getId(),
                    EmptySwingPacket.class,
                    EmptySwingPacket::toBytes,
                    EmptySwingPacket::new,
                    EmptySwingPacket::handle);
            INSTANCE.registerMessage(getId(),
                    SyncStyxDamagePacket.class,
                    SyncStyxDamagePacket::toBytes,
                    SyncStyxDamagePacket::new,
                    SyncStyxDamagePacket::handle);
            INSTANCE.registerMessage(getId(),
                    StyxEvaporatePacket.class,
                    StyxEvaporatePacket::toBytes,
                    StyxEvaporatePacket::new,
                    StyxEvaporatePacket::handle);
        });
    }
}
