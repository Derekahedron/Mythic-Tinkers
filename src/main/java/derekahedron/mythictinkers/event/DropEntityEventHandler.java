package derekahedron.mythictinkers.event;

import derekahedron.mythictinkers.tinkers.hooks.MTModifierHooks;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.capability.EntityModifierCapability;
import slimeknights.tconstruct.library.tools.capability.PersistentDataCapability;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.*;

@Mod.EventBusSubscriber(modid = derekahedron.mythictinkers.MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DropEntityEventHandler {

    @SubscribeEvent
    public static void dropsTools(LivingDropsEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;

        if (!event.getSource().isIndirect()) {
            ItemStack stack = attacker.getMainHandItem();

            if (stack.getItem() instanceof IModifiable) {
                ToolStack tool = ToolStack.from(stack);

                for (ModifierEntry modifier : tool.getModifiers()) {
                    modifier.getHook(MTModifierHooks.LIVING_DROPS).onLivingDrops(tool, modifier, attacker, event);
                }
            }
        } else if (event.getSource().getDirectEntity() instanceof Projectile projectile) {
            ModifierNBT modifiers = EntityModifierCapability.getOrEmpty(projectile);

            if (!modifiers.isEmpty()) {
                ModDataNBT persistentData = projectile.getCapability(PersistentDataCapability.CAPABILITY).orElseGet(ModDataNBT::new);
                IToolStackView dummyTool = new DummyToolStack(Items.AIR, modifiers, persistentData);

                for (ModifierEntry modifier : modifiers) {
                    modifier.getHook(MTModifierHooks.LIVING_DROPS).onLivingDrops(dummyTool, modifier, attacker, event);
                }
            }
        }
    }
}
