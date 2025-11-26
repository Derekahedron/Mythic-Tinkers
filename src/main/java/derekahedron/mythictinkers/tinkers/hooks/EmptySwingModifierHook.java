package derekahedron.mythictinkers.tinkers.hooks;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Collection;

public interface EmptySwingModifierHook {

    void onEmptySwing(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand);

    static void handleAttack(IToolStackView tool, Player player, InteractionHand hand) {
        for (ModifierEntry modifier : tool.getModifiers()) {
            modifier.getHook(MTModifierHooks.EMPTY_SWING).onEmptySwing(tool, modifier, player, hand);
        }
    }

    record AllMerger(Collection<EmptySwingModifierHook> modules) implements EmptySwingModifierHook {

        public void onEmptySwing(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand) {
            for (EmptySwingModifierHook module : modules) {
                module.onEmptySwing(tool, modifier, player, hand);
            }
        }
    }
}
