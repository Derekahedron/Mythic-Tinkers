package derekahedron.mythictinkers.client;

import derekahedron.mythictinkers.book.MTBooks;
import derekahedron.mythictinkers.client.particle.*;
import derekahedron.mythictinkers.fluid.MTFluids;
import derekahedron.mythictinkers.particle.MTParticleTypes;
import derekahedron.mythictinkers.tinkers.MTSlotTypes;
import net.minecraft.client.particle.LavaParticle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.awt.*;

@Mod.EventBusSubscriber(modid = derekahedron.mythictinkers.MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MythicTinkersClient {

    @SubscribeEvent
    static void clientSetup(final FMLClientSetupEvent event) {
        MTBooks.registerBooks();
        MTSlotTypes.registerTextures();
    }

    @SubscribeEvent
    public static void registerParticleProvidersEvent(RegisterParticleProvidersEvent event) {
        event.registerSpecial(
                MTParticleTypes.BYZANTIUM_MAGNETIC_ORBIT.get(),
                new ByzantiumMagneticOrbitParticle.Provider());
        event.registerSpriteSet(
                MTParticleTypes.STYX_TENDRIL.get(),
                StyxTendrilParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.STYX_SMOKE.get(),
                StyxSmokeParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.STYX_CLOUD.get(),
                StyxCloudParticle.Provider::new);

        event.registerSprite(
                MTParticleTypes.DRIPPING_MOLTEN_SCARLET_NEODYMIUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.CoolingDripHandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_SCARLET_NEODYMIUM.get(),
                                MTParticleTypes.FALLING_MOLTEN_SCARLET_NEODYMIUM.get(),
                                new Color(0xA50C0C),
                                new Color(0xFF4D4D)));
        event.registerSprite(
                MTParticleTypes.FALLING_MOLTEN_SCARLET_NEODYMIUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.FallAndLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_SCARLET_NEODYMIUM.get(),
                                MTParticleTypes.LANDING_MOLTEN_SCARLET_NEODYMIUM.get(),
                                new Color(0xA50C0C)));
        event.registerSprite(
                MTParticleTypes.LANDING_MOLTEN_SCARLET_NEODYMIUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.DripLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_SCARLET_NEODYMIUM.get(),
                                new Color(0xA50C0C)));

        event.registerSprite(
                MTParticleTypes.DRIPPING_MOLTEN_AZURE_NEODYMIUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.CoolingDripHandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_AZURE_NEODYMIUM.get(),
                                MTParticleTypes.FALLING_MOLTEN_AZURE_NEODYMIUM.get(),
                                new Color(0x001FA5),
                                new Color(0x764BE4)));
        event.registerSprite(
                MTParticleTypes.FALLING_MOLTEN_AZURE_NEODYMIUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.FallAndLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_AZURE_NEODYMIUM.get(),
                                MTParticleTypes.LANDING_MOLTEN_AZURE_NEODYMIUM.get(),
                                new Color(0x001FA5)));
        event.registerSprite(
                MTParticleTypes.LANDING_MOLTEN_AZURE_NEODYMIUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.DripLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_AZURE_NEODYMIUM.get(),
                                new Color(0x001FA5)));

        event.registerSprite(
                MTParticleTypes.DRIPPING_MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.CoolingDripHandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                                MTParticleTypes.FALLING_MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                                new Color(0x5F105C),
                                new Color(0xE446C4)));
        event.registerSprite(
                MTParticleTypes.FALLING_MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.FallAndLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                                MTParticleTypes.LANDING_MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                                new Color(0x5F105C)));
        event.registerSprite(
                MTParticleTypes.LANDING_MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.DripLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                                new Color(0x5F105C)));

        event.registerSprite(
                MTParticleTypes.DRIPPING_MOLTEN_TECTELLUS.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.CoolingDripHandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_TECTELLUS.get(),
                                MTParticleTypes.FALLING_MOLTEN_TECTELLUS.get(),
                                new Color(0xFA500B),
                                new Color(0xFFB476)));
        event.registerSprite(
                MTParticleTypes.FALLING_MOLTEN_TECTELLUS.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.FallAndLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_TECTELLUS.get(),
                                MTParticleTypes.LANDING_MOLTEN_TECTELLUS.get(),
                                new Color(0xFA500B)));
        event.registerSprite(
                MTParticleTypes.LANDING_MOLTEN_TECTELLUS.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.DripLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_TECTELLUS.get(),
                                new Color(0xFA500B)));

        event.registerSprite(
                MTParticleTypes.DRIPPING_MOLTEN_ELEMENT_122.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.CoolingDripHandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_ELEMENT_122.get(),
                                MTParticleTypes.FALLING_MOLTEN_ELEMENT_122.get(),
                                new Color(0x969D00),
                                new Color(0xEDD463)));
        event.registerSprite(
                MTParticleTypes.FALLING_MOLTEN_ELEMENT_122.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.FallAndLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_ELEMENT_122.get(),
                                MTParticleTypes.LANDING_MOLTEN_ELEMENT_122.get(),
                                new Color(0x969D00)));
        event.registerSprite(
                MTParticleTypes.LANDING_MOLTEN_ELEMENT_122.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.DripLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_ELEMENT_122.get(),
                                new Color(0x969D00)));

        event.registerSprite(
                MTParticleTypes.DRIPPING_MOLTEN_AURICHALCUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.CoolingDripHandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_AURICHALCUM.get(),
                                MTParticleTypes.FALLING_MOLTEN_AURICHALCUM.get(),
                                new Color(0xF7AB3C),
                                new Color(0xFFE9D5)));
        event.registerSprite(
                MTParticleTypes.FALLING_MOLTEN_AURICHALCUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.FallAndLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_AURICHALCUM.get(),
                                MTParticleTypes.LANDING_MOLTEN_AURICHALCUM.get(),
                                new Color(0xF7AB3C)));
        event.registerSprite(
                MTParticleTypes.LANDING_MOLTEN_AURICHALCUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.DripLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_AURICHALCUM.get(),
                                new Color(0xF7AB3C)));

        event.registerSprite(
                MTParticleTypes.DRIPPING_MOLTEN_DESOLUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.CoolingDripHandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_DESOLUM.get(),
                                MTParticleTypes.FALLING_MOLTEN_DESOLUM.get(),
                                new Color(0x433744),
                                new Color(0xD8C3D1)));
        event.registerSprite(
                MTParticleTypes.FALLING_MOLTEN_DESOLUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.FallAndLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_DESOLUM.get(),
                                MTParticleTypes.LANDING_MOLTEN_DESOLUM.get(),
                                new Color(0x433744)));
        event.registerSprite(
                MTParticleTypes.LANDING_MOLTEN_DESOLUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.DripLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_DESOLUM.get(),
                                new Color(0x433744)));

        event.registerSprite(
                MTParticleTypes.DRIPPING_MOLTEN_PROSPRUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.CoolingDripHandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_PROSPRUM.get(),
                                MTParticleTypes.FALLING_MOLTEN_PROSPRUM.get(),
                                new Color(0x93FCF3),
                                new Color(0xD6FFD9)));
        event.registerSprite(
                MTParticleTypes.FALLING_MOLTEN_PROSPRUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.FallAndLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_PROSPRUM.get(),
                                MTParticleTypes.LANDING_MOLTEN_PROSPRUM.get(),
                                new Color(0x93FCF3)));
        event.registerSprite(
                MTParticleTypes.LANDING_MOLTEN_PROSPRUM.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.DripLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_PROSPRUM.get(),
                                new Color(0x93FCF3)));

        event.registerSprite(
                MTParticleTypes.DRIPPING_MOLTEN_GUMBRONZE.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.CoolingDripHandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_GUMBRONZE.get(),
                                MTParticleTypes.FALLING_MOLTEN_GUMBRONZE.get(),
                                new Color(0xFF8CEB),
                                new Color(0xFFC2DC)));
        event.registerSprite(
                MTParticleTypes.FALLING_MOLTEN_GUMBRONZE.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.FallAndLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_GUMBRONZE.get(),
                                MTParticleTypes.LANDING_MOLTEN_GUMBRONZE.get(),
                                new Color(0xFF8CEB)));
        event.registerSprite(
                MTParticleTypes.LANDING_MOLTEN_GUMBRONZE.get(),
                (type, level, x, y, z, xd, yd, zd) ->
                        new MTDripParticle.DripLandParticle(
                                level, x, y, z,
                                MTFluids.MOLTEN_GUMBRONZE.get(),
                                new Color(0xFF8CEB)));

        event.registerSpriteSet(
                MTParticleTypes.MOLTEN_SCARLET_NEODYMIUM.get(),
                LavaParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.MOLTEN_AZURE_NEODYMIUM.get(),
                LavaParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.MOLTEN_BYZANTIUM_NEODYMIUM.get(),
                LavaParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.MOLTEN_TECTELLUS.get(),
                LavaParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.MOLTEN_ELEMENT_122.get(),
                LavaParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.MOLTEN_AURICHALCUM.get(),
                LavaParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.MOLTEN_DESOLUM.get(),
                LavaParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.MOLTEN_PROSPRUM.get(),
                LavaParticle.Provider::new);
        event.registerSpriteSet(
                MTParticleTypes.MOLTEN_GUMBRONZE.get(),
                LavaParticle.Provider::new);
    }
}
