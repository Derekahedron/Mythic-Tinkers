package derekahedron.mythictinkers.tinkers.hooks;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Collection;

public interface LivingDropsModifierHook {

    void onLivingDrops(IToolStackView tool, ModifierEntry modifier, LivingEntity attacker, LivingDropsEvent event);

    record AllMerger(Collection<LivingDropsModifierHook> modules) implements LivingDropsModifierHook {
        public void onLivingDrops(
                IToolStackView tool, ModifierEntry modifier, LivingEntity attacker, LivingDropsEvent event) {
            for (LivingDropsModifierHook module : modules) {
                module.onLivingDrops(tool, modifier, attacker, event);
            }
        }
    }
}
