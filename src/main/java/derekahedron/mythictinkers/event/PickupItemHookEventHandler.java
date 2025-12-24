package derekahedron.mythictinkers.event;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.tinkers.hooks.PickupItemModifierHook;
import com.google.common.collect.ImmutableList;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PickupItemHookEventHandler {

    @SubscribeEvent
    static void pickupItemCheck(EntityItemPickupEvent event) {
        if (event.isCanceled() || event.getResult() == Event.Result.DENY) return;
        Player player = event.getEntity();
        ItemEntity itemEntity = event.getItem();
        ItemStack stack = itemEntity.getItem();

        if (itemEntity.pickupDelay == 0
                && !stack.isEmpty()
                && (itemEntity.target == null || itemEntity.target.equals(player.getUUID()))) {
            ItemStack copy = stack.copy();

            PickupItemModifierHook.pickup(ImmutableList.of(stack), player);

            int numTaken = copy.getCount() - stack.getCount();
            if (numTaken > 0) {
                copy.setCount(numTaken);
                ForgeEventFactory.firePlayerItemPickupEvent(player, itemEntity, copy);
                player.take(itemEntity, numTaken);
                player.awardStat(Stats.ITEM_PICKED_UP.get(copy.getItem()), numTaken);

                if (stack.isEmpty()) {
                    event.setResult(Event.Result.ALLOW);
                }
            }
        }
    }
}
