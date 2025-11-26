package derekahedron.mythictinkers.event;

import derekahedron.mythictinkers.tinkers.modifiers.MTModifiers;
import com.github.alexmodguy.alexscaves.server.item.ExtinctionSpearItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

@Mod.EventBusSubscriber(modid = derekahedron.mythictinkers.MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TectonicShieldEventHandler {

    @SubscribeEvent
    public static void livingHurt(LivingDamageEvent event) {
        if (event.getEntity() instanceof Player player
                && ModifierUtil.getModifierLevel(player.getUseItem(), MTModifiers.TECTONIC_SHIELD.getId()) > 0
                && ExtinctionSpearItem.killGrottoGhostsFor(player, true)) {
            event.setCanceled(true);
            player.playSound(SoundEvents.SHIELD_BLOCK);
        }
    }
}
