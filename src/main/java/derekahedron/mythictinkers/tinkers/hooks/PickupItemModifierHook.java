package derekahedron.mythictinkers.tinkers.hooks;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Collection;
import java.util.List;

public interface PickupItemModifierHook {
    List<EquipmentSlot> SLOT_ORDER = List.of(
            EquipmentSlot.MAINHAND,
            EquipmentSlot.OFFHAND,
            EquipmentSlot.HEAD,
            EquipmentSlot.CHEST,
            EquipmentSlot.LEGS,
            EquipmentSlot.FEET);

    void onPickupItem(
            IToolStackView tool, ModifierEntry modifier,
            Player player, EquipmentSlot slot,
            ImmutableList<ItemStack> stacks);

    record AllMerger(Collection<PickupItemModifierHook> modules) implements PickupItemModifierHook {

        public void onPickupItem(
                IToolStackView tool, ModifierEntry modifier,
                Player player, EquipmentSlot slot,
                ImmutableList<ItemStack> stacks) {
            for (PickupItemModifierHook module : modules) {
                module.onPickupItem(tool, modifier, player, slot, stacks);
            }
        }
    }

    static void pickup(ImmutableList<ItemStack> stacks, Player player) {
        for (EquipmentSlot slot : SLOT_ORDER) {
            ItemStack equipmentStack = player.getItemBySlot(slot);

            if (equipmentStack.getItem() instanceof IModifiable) {
                ToolStack tool = ToolStack.from(equipmentStack);

                for (ModifierEntry modifier : tool.getModifiers()) {
                    modifier.getHook(MTModifierHooks.PICKUP_ITEM)
                            .onPickupItem(tool, modifier, player, slot, stacks);
                }
            }
        }
    }
}
