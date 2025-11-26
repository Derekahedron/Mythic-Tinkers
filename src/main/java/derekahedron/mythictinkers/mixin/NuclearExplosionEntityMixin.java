package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.block.MTBlocks;
import com.github.alexmodguy.alexscaves.server.entity.item.NuclearExplosionEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(NuclearExplosionEntity.class)
public class NuclearExplosionEntityMixin {

    @Inject(
            method = "removeChunk",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/github/alexmodguy/alexscaves/server/entity/item/NuclearExplosionEntity;isDestroyable(Lnet/minecraft/world/level/block/state/BlockState;)Z"
            ),
            remap = false,
            locals = LocalCapture.CAPTURE_FAILSOFT)
    private void spawnRawElement122(
            int radius,
            CallbackInfo ci,
            BlockPos chunkCorner, BlockPos.MutableBlockPos carve, BlockPos.MutableBlockPos carveBelow,
            float itemDropModifier, int x, int z, int y, boolean canSetToFire, float widthSimplexNoise1,
            double yDist, double distToCenter, double targetRadius, BlockState state) {
        if (state.getBlock() == MTBlocks.ELEMENT_122_ORE.get()) {
            Level level = ((NuclearExplosionEntity) (Object) this).level();
            level.destroyBlock(carve, true);
        }
    }
}
