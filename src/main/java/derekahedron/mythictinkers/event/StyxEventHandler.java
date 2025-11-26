package derekahedron.mythictinkers.event;

import derekahedron.mythictinkers.damage.MTDamageTypes;
import derekahedron.mythictinkers.entity.LivingEntityDuck;
import derekahedron.mythictinkers.fluid.MTFluidTypes;
import derekahedron.mythictinkers.network.MTPacketHandler;
import derekahedron.mythictinkers.network.SyncStyxDamagePacket;
import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

@Mod.EventBusSubscriber(modid = derekahedron.mythictinkers.MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class StyxEventHandler {
    public static final float STYX_DAMAGE_CAP = 10.0F;

    @SubscribeEvent
    public static void styxTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        LivingEntityDuck livingEntityDuck = (LivingEntityDuck) entity;

        if (entity.isInFluidType(MTFluidTypes.STYX.get())) {
            livingEntityDuck.mythictinkers_$setInStyx(true);
            boolean underStyx = entity.isEyeInFluidType(MTFluidTypes.STYX.get());

            if (underStyx) {
                livingEntityDuck.mythictinkers_$setStyxDamage(STYX_DAMAGE_CAP);
            }

            if (!entity.level().isClientSide) {
                if (entity.tickCount % 20 == 0) {
                    entity.hurt(new DamageSource(MTUtil.getDamageType(entity, MTDamageTypes.STYX)),
                            Mth.lerp(getStyxIntensity(livingEntityDuck.mythictinkers_$getStyxDamage()),2, 6));
                } else if (underStyx && entity instanceof ServerPlayer player) {
                    MTPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player),
                            new SyncStyxDamagePacket(livingEntityDuck.mythictinkers_$getStyxDamage()));
                }
            }
        } else if (livingEntityDuck.mythictinkers_$isInStyx()
                || livingEntityDuck.mythictinkers_$getStyxDamage() >= 0) {
            livingEntityDuck.mythictinkers_$setInStyx(false);
            livingEntityDuck.mythictinkers_$setStyxDamage(0.0F);
            if (entity instanceof ServerPlayer player) {
                MTPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player),
                        new SyncStyxDamagePacket(livingEntityDuck.mythictinkers_$getStyxDamage()));
            }
        }
    }

    @SubscribeEvent
    public static void takeStyxDamage(LivingHurtEvent event) {
        LivingEntityDuck livingEntityDuck = (LivingEntityDuck) event.getEntity();
        if (livingEntityDuck.mythictinkers_$isInStyx()) {
            livingEntityDuck.mythictinkers_$setStyxDamage(livingEntityDuck.mythictinkers_$getStyxDamage() + event.getAmount());
            if (event.getEntity() instanceof ServerPlayer player) {
                MTPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player),
                        new SyncStyxDamagePacket(livingEntityDuck.mythictinkers_$getStyxDamage()));
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinLevelEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        MTPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player),
                new SyncStyxDamagePacket(((LivingEntityDuck) player).mythictinkers_$getStyxDamage()));
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        MTPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player),
                new SyncStyxDamagePacket(((LivingEntityDuck) player).mythictinkers_$getStyxDamage()));
    }

    public static float getStyxIntensity(float damage) {
        return Mth.clamp(damage / STYX_DAMAGE_CAP, 0.0F, 1.0F);
    }
}
