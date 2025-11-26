package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.util.MTUtil;
import com.github.alexmodguy.alexscaves.server.block.AcidBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AcidBlock.class)
public class AcidBlockMixin {

    @Inject(at = @At("HEAD"), method = "entityInside", cancellable = true)
    private void saveAcidResistantItem(BlockState blockState, Level level, BlockPos pos, Entity entity, CallbackInfo ci) {
        if (entity instanceof ItemEntity itemEntity && MTUtil.isAcidResistant(itemEntity.getItem())) {
            ci.cancel();
        }
    }
}
