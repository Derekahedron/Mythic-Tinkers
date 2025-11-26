package derekahedron.mythictinkers.client.event;

import derekahedron.mythictinkers.fluid.MTFluidType;
import com.mojang.blaze3d.shaders.FogShape;
import net.minecraft.client.Camera;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = derekahedron.mythictinkers.MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class FluidFogEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void updateFluidFogDistance(ViewportEvent.RenderFog event) {
        if (event.isCanceled()) return;
        if (getCameraFluidType(event.getCamera()) instanceof MTFluidType fluidType) {
            if (fluidType.fogStart >= 0.0F) {
                event.setNearPlaneDistance(fluidType.fogStart);
            }
            if (fluidType.fogEnd >= 0.0F) {
                event.setFarPlaneDistance(fluidType.fogEnd);
            }
            event.setFogShape(FogShape.SPHERE);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void updateFluidFogColor(ViewportEvent.ComputeFogColor event) {
        if (getCameraFluidType(event.getCamera()) instanceof MTFluidType fluidType) {
            event.setRed(fluidType.fogColor.getRed() / 255.0F);
            event.setGreen(fluidType.fogColor.getGreen() / 255.0F);
            event.setBlue(fluidType.fogColor.getBlue() / 255.0F);
        }
    }

    @Nullable
    public static FluidType getCameraFluidType(Camera camera) {
        if (camera.isInitialized()) {
            Level level = camera.getEntity().level();
            Vec3 cameraPos = camera.getPosition();
            BlockPos cameraBlockPos = camera.getBlockPosition();

            FluidState cameraFluidState = level.getFluidState(cameraBlockPos);
            if (cameraFluidState.is(FluidTags.WATER)
                    && cameraPos.y < cameraBlockPos.getY() + cameraFluidState.getHeight(level, cameraBlockPos)) {
                return cameraFluidState.getFluidType();
            }

            Camera.NearPlane nearPlane = camera.getNearPlane();
            for (Vec3 cornerPos : new Vec3[] {
                    nearPlane.getTopLeft(),
                    nearPlane.getTopRight(),
                    nearPlane.getBottomLeft(),
                    nearPlane.getBottomRight()}) {
                Vec3 pos = cameraPos.add(cornerPos);
                BlockPos blockPos = BlockPos.containing(pos);
                FluidState fluidState = level.getFluidState(blockPos);
                if (!fluidState.isEmpty() && pos.y <= (fluidState.getHeight(level, blockPos) + blockPos.getY())) {
                    return fluidState.getFluidType();
                }
            }
        }

        return null;
    }
}
