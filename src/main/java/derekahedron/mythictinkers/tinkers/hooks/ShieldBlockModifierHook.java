package derekahedron.mythictinkers.tinkers.hooks;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Collection;

public interface ShieldBlockModifierHook {

    void onShieldBlock(
            IToolStackView tool,
            ModifierEntry modifier,
            LivingEntity entity,
            DamageSource source,
            float damage);

    static void handleShieldBlock(
            IToolStackView tool,
            LivingEntity entity,
            DamageSource source,
            float damage) {
        for (ModifierEntry modifier : tool.getModifiers()) {
            modifier.getHook(MTModifierHooks.SHIELD_BLOCK).onShieldBlock(
                    tool,
                    modifier,
                    entity,
                    source,
                    damage);
        }
    }

    record AllMerger(Collection<ShieldBlockModifierHook> modules) implements ShieldBlockModifierHook {

        public void onShieldBlock(
                IToolStackView tool,
                ModifierEntry modifier,
                LivingEntity entity,
                DamageSource source,
                float damage) {
            for (ShieldBlockModifierHook module : modules) {
                module.onShieldBlock(tool, modifier, entity, source, damage);
            }
        }
    }
}
