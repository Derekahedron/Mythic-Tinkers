package derekahedron.mythictinkers.client.event;

import derekahedron.mythictinkers.client.player.LocalPlayerDuck;
import derekahedron.mythictinkers.entity.LivingEntityDuck;
import derekahedron.mythictinkers.event.StyxEventHandler;
import derekahedron.mythictinkers.fluid.MTFluidTypes;
import derekahedron.mythictinkers.particle.MTParticleTypes;
import derekahedron.mythictinkers.util.MTUtil;
import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.awt.*;

@Mod.EventBusSubscriber(modid = derekahedron.mythictinkers.MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class StyxIntensityEventHandler {
    public static final ResourceLocation STYX_OUTLINE_LOCATION =
            MTUtil.location("textures/misc/styx_outline.png");
    public static final ResourceLocation STYX_VIGNETTE_LOCATION =
            MTUtil.location("textures/misc/styx_vignette.png");
    public static final Color FOG_COLOR = new Color(0x000503);
    public static final double STYX_SMOKE_SPREAD = 0.05D;

    @SubscribeEvent
    public static void updateStyxIntensity(TickEvent.RenderTickEvent event) {
        if (event.isCanceled()) return;
        if (event.phase == TickEvent.Phase.START) {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null) return;

            float styxIntensity = getStyxIntensity(minecraft.player);
            float desiredIntensity = StyxEventHandler.getStyxIntensity(
                    ((LivingEntityDuck) minecraft.player).mythictinkers_$getStyxDamage());

            if (desiredIntensity == styxIntensity) {
                return;
            } else if (desiredIntensity > styxIntensity) {
                styxIntensity = Math.min(desiredIntensity + 0.2F, 1.0F);
            } else if (Math.abs(desiredIntensity - styxIntensity) < 0.001F) {
                styxIntensity = desiredIntensity;
            } else {
                styxIntensity = Mth.lerp(0.1F, styxIntensity, desiredIntensity);
            }

            ((LocalPlayerDuck) minecraft.player).mythictinkers_$setStyxIntensity(styxIntensity);
        }
    }

    @SubscribeEvent
    public static void renderStyxOverlay(RenderGuiOverlayEvent.Pre event) {
        if (event.isCanceled() || event.getOverlay() != VanillaGuiOverlay.VIGNETTE.type()) return;
        Minecraft minecraft = Minecraft.getInstance();
        float styxIntensity = getStyxIntensity(minecraft.player);

        if (styxIntensity > 0.0F) {
            GuiGraphics guiGraphics = event.getGuiGraphics();
            int width = minecraft.getWindow().getGuiScaledWidth();
            int height = minecraft.getWindow().getGuiScaledHeight();
            RenderSystem.enableBlend();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            guiGraphics.setColor(1.0F, 1.0F, 1.0F, styxIntensity);
            guiGraphics.blit(
                    STYX_OUTLINE_LOCATION, 0, 0, -90,
                    0.0F, 0.0F, width, height, width, height);
            guiGraphics.setColor(
                    FOG_COLOR.getRed() / 255F,
                    FOG_COLOR.getGreen() / 255F,
                    FOG_COLOR.getBlue() / 255F,
                    styxIntensity);
            guiGraphics.blit(
                    STYX_VIGNETTE_LOCATION, 0, 0, -90,
                    0.0F, 0.0F, width, height, width, height);
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    @SubscribeEvent
    public static void updateStyxFogColor(ViewportEvent.ComputeFogColor event) {
        float styxIntensity = getStyxIntensity(Minecraft.getInstance().player);

        if (styxIntensity > 0.0F && FluidFogEventHandler.getCameraFluidType(event.getCamera()) != MTFluidTypes.STYX.get()) {
            event.setRed(Mth.lerp(styxIntensity, event.getRed(), FOG_COLOR.getRed() / 255F));
            event.setGreen(Mth.lerp(styxIntensity, event.getGreen(), FOG_COLOR.getGreen() / 255F));
            event.setBlue(Mth.lerp(styxIntensity, event.getBlue(), FOG_COLOR.getBlue() / 255F));
        }
    }

    @SubscribeEvent
    public static void updateStyxFogDistance(ViewportEvent.RenderFog event) {
        if (event.isCanceled()) return;
        float styxIntensity = getStyxIntensity(Minecraft.getInstance().player);

        if (styxIntensity > 0.0F) {
            event.setNearPlaneDistance(
                    Mth.lerp(styxIntensity, event.getNearPlaneDistance(), 32));
            event.setFarPlaneDistance(
                    Mth.lerp(styxIntensity, event.getFarPlaneDistance(), 64));
            event.setFogShape(FogShape.SPHERE);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void updateStyxFOV(ViewportEvent.ComputeFov event) {
        if (event.isCanceled()) return;
        Minecraft minecraft = Minecraft.getInstance();
        float styxIntensity = getStyxIntensity(minecraft.player);

        if (styxIntensity > 0.0F) {
            event.setFOV(Mth.lerp(
                    styxIntensity * minecraft.options.fovEffectScale().get(),
                    event.getFOV(), event.getFOV() / 2));
        }
    }

    @SubscribeEvent
    public static void addStyxParticles(TickEvent.ClientTickEvent event) {
        if (event.isCanceled() || event.phase != TickEvent.Phase.END) return;
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.isPaused()) return;

        LocalPlayer player = minecraft.player;
        float styxIntensity = getStyxIntensity(player);

        if (styxIntensity > 0.0f && player != null) {
            RandomSource random = player.getRandom();

            for (int i = 0; i < 60 * styxIntensity; i++) {
                double x = random.nextDouble();
                double z = random.nextDouble();
                BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(
                        player.getX() + random.nextInt(-16, 16),
                        player.getY() + random.nextInt(-16, 16),
                        player.getZ() + random.nextInt(-16, 16));
                int originalY = pos.getY();
                double levelY = 0.0;
                boolean inGround = true;

                for (int tries = 0; tries < 6; tries++) {
                    BlockState state = player.level().getBlockState(pos);
                    VoxelShape shape = state.getCollisionShape(player.level(), pos);

                    double maxY = pos.getY() + shape.max(Direction.Axis.Y, z, x);

                    if (tries == 0) {
                        levelY = maxY;
                    } else {
                        if (levelY == Double.NEGATIVE_INFINITY) {
                            inGround = false;
                            levelY = maxY;
                            pos.move(Direction.DOWN);
                        } else if (levelY < pos.getY() + shape.min(Direction.Axis.Y, z, x)) {
                            inGround = false;
                            break;
                        } else {
                            levelY = maxY;
                            pos.move(Direction.UP);
                        }
                    }
                }

                if (levelY == Double.NEGATIVE_INFINITY) {
                    player.level().addParticle(
                            MTParticleTypes.STYX_CLOUD.get(),
                            pos.getX() + x,
                            originalY + random.nextDouble(),
                            pos.getZ() + z,
                            0.0, 0.0, 0.0);
                } else if (inGround) {
                    player.level().addParticle(
                            MTParticleTypes.STYX_TENDRIL.get(),
                            pos.getX() + x, levelY, pos.getZ() + z,
                            0.0D, 0.5D, 0.0D);
                } else {
                    for (int j = 0; j < 3; j++) {
                        player.level().addParticle(
                                MTParticleTypes.STYX_SMOKE.get(),
                                pos.getX() + x, levelY + 0.2, pos.getZ() + z,
                                STYX_SMOKE_SPREAD * (random.nextDouble() - 0.5D),
                                0.0,
                                STYX_SMOKE_SPREAD * (random.nextDouble() - 0.5D));
                    }
                }
            }
        }
    }

    public static float getStyxIntensity(@Nullable LocalPlayer player) {
        if (player != null) {
            return ((LocalPlayerDuck) player).mythictinkers_$getStyxIntensity();
        } else {
            return 0.0F;
        }
    }
}
