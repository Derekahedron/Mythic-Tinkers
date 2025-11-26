package derekahedron.mythictinkers.tinkers.hooks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Collection;

public interface DestroySpeedModifierHook {

    float onDestroySpeed(
            IToolStackView tool, ModifierEntry modifier,
            Player player, BlockState state,
            float baseSpeed, boolean correctForDrops,
            BlockGetter level, BlockPos pos);

    record AllMerger(Collection<DestroySpeedModifierHook> modules) implements DestroySpeedModifierHook {

        public float onDestroySpeed(
                IToolStackView tool, ModifierEntry modifier,
                Player player, BlockState state,
                float baseSpeed, boolean correctForDrops,
                BlockGetter level, BlockPos pos) {
            for (DestroySpeedModifierHook module : modules) {
                baseSpeed = module.onDestroySpeed(tool, modifier, player, state, baseSpeed, correctForDrops, level, pos);
            }
            return baseSpeed;
        }
    }
}
