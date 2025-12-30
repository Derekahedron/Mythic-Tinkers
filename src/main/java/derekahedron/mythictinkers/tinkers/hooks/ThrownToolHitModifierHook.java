package derekahedron.mythictinkers.tinkers.hooks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.entity.ThrownTool;

import javax.annotation.Nullable;
import java.util.Collection;

public interface ThrownToolHitModifierHook {

    default void onThrownToolHitEntity(
            IToolStackView tool, ModifierEntry modifier, ThrownTool thrownTool,
            LivingEntity attacker, Entity target, @Nullable LivingEntity livingTarget) {}

    default boolean onThrownToolHitsBlock(
            IToolStackView tool, ModifierEntry modifier, ThrownTool thrownTool,
            LivingEntity owner, BlockPos pos) {
        return false;
    }

    record AllMerger(Collection<ThrownToolHitModifierHook> modules) implements ThrownToolHitModifierHook {
        public void onThrownToolHitEntity(
                IToolStackView tool, ModifierEntry modifier, ThrownTool thrownTool,
                LivingEntity attacker, Entity target, @Nullable LivingEntity livingTarget) {
            for (ThrownToolHitModifierHook module : this.modules) {
                module.onThrownToolHitEntity(tool, modifier, thrownTool, attacker, target, livingTarget);
            }
        }

        public boolean onThrownToolHitsBlock(
                IToolStackView tool, ModifierEntry modifier, ThrownTool thrownTool,
                LivingEntity owner, BlockPos target) {
            for (ThrownToolHitModifierHook module : this.modules) {
                if (module.onThrownToolHitsBlock(tool, modifier, thrownTool, owner, target)) {
                    return true;
                }
            }
            return false;
        }
    }
}
