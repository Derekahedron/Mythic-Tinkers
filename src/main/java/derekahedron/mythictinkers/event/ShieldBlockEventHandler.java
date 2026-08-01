package derekahedron.mythictinkers.event;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.tinkers.hooks.ShieldBlockModifierHook;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

@Mod.EventBusSubscriber(modid = MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ShieldBlockEventHandler {

    @SubscribeEvent
    public static void onShieldBlock(ShieldBlockEvent event) {
        LivingEntity entity = event.getEntity();
        ItemStack stack = entity.getUseItem();
        if (!stack.is(TinkerTags.Items.MODIFIABLE)) return;
        ToolStack tool = ToolStack.from(stack);

        ShieldBlockModifierHook.handleShieldBlock(tool, entity, event.getDamageSource(), event.getBlockedDamage());
    }
}
