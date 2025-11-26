package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.block.MTBlocks;
import com.github.alexmodguy.alexscaves.server.entity.living.TremorzillaEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;

@Mixin(TremorzillaEntity.class)
public class TremorzillaEntityMixin {

    @Inject(
            method = "breakBlocksAround",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/Block;getExplosionResistance()F",
                    remap = true),
            remap = false,
            locals = LocalCapture.CAPTURE_FAILSOFT)
    private void spawnRawElement122(
            Vec3 center, float radius, boolean square, boolean triggerExplosions, float dropChance,
            CallbackInfoReturnable<Boolean> cir,
            boolean flag, Iterator<BlockPos> var7, BlockPos blockpos, BlockState blockstate) {
        if (blockstate.getBlock() == MTBlocks.ELEMENT_122_ORE.get()) {
            Level level = ((TremorzillaEntity) (Object) this).level();
            level.destroyBlock(blockpos, true);
        }
    }
}
