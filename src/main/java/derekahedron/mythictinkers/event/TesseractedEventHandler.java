package derekahedron.mythictinkers.event;

import derekahedron.mythictinkers.tinkers.modifiers.MTModifierIds;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.tools.item.armor.ModifiableArmorItem;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = derekahedron.mythictinkers.MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TesseractedEventHandler {

    @SubscribeEvent
    public static void swing(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        if (!(stack.getItem() instanceof ModifiableArmorItem)) return;
        ToolStack tool = ToolStack.from(stack);
        ModifierEntry modifier = tool.getModifier(MTModifierIds.TESSERACTED);

        if (modifier.getLevel() > 0) {
            InteractionResult result = modifier.getHook(ModifierHooks.BLOCK_INTERACT).beforeBlockUse(
                    tool,
                    modifier,
                    new UseOnContext(event.getEntity(), event.getHand(), event.getHitVec()),
                    InteractionSource.RIGHT_CLICK);

            if (result.consumesAction()) {
                event.setCancellationResult(result);
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void swing(PlayerInteractEvent.RightClickItem event) {
        ItemStack stack = event.getItemStack();
        if (!(stack.getItem() instanceof ModifiableArmorItem)) return;
        ToolStack tool = ToolStack.from(stack);
        ModifierEntry modifier = tool.getModifier(MTModifierIds.TESSERACTED);

        if (modifier.getLevel() > 0) {
            InteractionResult result = modifier.getHook(ModifierHooks.GENERAL_INTERACT).onToolUse(
                    tool,
                    modifier,
                    event.getEntity(),
                    event.getHand(),
                    InteractionSource.RIGHT_CLICK);

            if (result.consumesAction()) {
                event.setCancellationResult(result);
                event.setCanceled(true);
            }
        }
    }
}
