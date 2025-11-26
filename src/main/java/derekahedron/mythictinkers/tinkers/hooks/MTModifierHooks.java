package derekahedron.mythictinkers.tinkers.hooks;

import derekahedron.mythictinkers.util.MTUtil;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.module.ModuleHook;

public class MTModifierHooks {

    public static final ModuleHook<LivingDropsModifierHook> LIVING_DROPS =
            ModifierHooks.register(
                    MTUtil.location("living_drops"),
                    LivingDropsModifierHook.class,
                    LivingDropsModifierHook.AllMerger::new,
                    (tool, modifier, attacker, event) -> {});

    public static final ModuleHook<PickupItemModifierHook> PICKUP_ITEM =
            ModifierHooks.register(
                    MTUtil.location("pickup_item"),
                    PickupItemModifierHook.class,
                    PickupItemModifierHook.AllMerger::new,
                    (tool, modifier, player, slot, stacks) -> {});

    public static final ModuleHook<DestroySpeedModifierHook> DESTROY_SPEED =
            ModifierHooks.register(
                    MTUtil.location("destroy_speed"),
                    DestroySpeedModifierHook.class,
                    DestroySpeedModifierHook.AllMerger::new,
                    (tool, modifier, player, state, baseSpeed, correctForDrops, level, pos) -> baseSpeed);

    public static final ModuleHook<EmptySwingModifierHook> EMPTY_SWING =
            ModifierHooks.register(
                    MTUtil.location("empty_swing"),
                    EmptySwingModifierHook.class,
                    EmptySwingModifierHook.AllMerger::new,
                    (tool, modifier, player, hand) -> {});
}
