package derekahedron.mythictinkers.fluid;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.fluids.FluidType;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.function.Consumer;

public class MTFluidType extends FluidType {
    public final ResourceLocation stillTexture;
    public final ResourceLocation flowingTexture;
    public final @Nullable ResourceLocation renderOverlayTexture;
    public final Color fogColor;
    public final float fogStart;
    public final float fogEnd;

    public MTFluidType(
            ResourceLocation stillTexture, ResourceLocation flowingTexture,
            @Nullable ResourceLocation renderOverlayTexture,
            Color fogColor, float fogStart, float fogEnd, Properties properties) {
        super(properties);
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
        this.renderOverlayTexture = renderOverlayTexture;
        this.fogColor = fogColor;
        this.fogStart = fogStart;
        this.fogEnd = fogEnd;
    }

    public MTFluidType(
            ResourceLocation stillTexture, ResourceLocation flowingTexture,
            Color fogColor, float fogStart, float fogEnd, Properties properties) {
        this(stillTexture, flowingTexture, null, fogColor, fogStart, fogEnd, properties);
    }

    public void onEntityInside(Entity entity) {}

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new MTClientFluidTypeExtensions());
    }

    public class MTClientFluidTypeExtensions implements IClientFluidTypeExtensions {

        @Override
        public ResourceLocation getStillTexture() {
            return stillTexture;
        }

        @Override
        public ResourceLocation getFlowingTexture() {
            return flowingTexture;
        }

        @Override
        @Nullable
        public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
            return renderOverlayTexture;
        }
    }
}
