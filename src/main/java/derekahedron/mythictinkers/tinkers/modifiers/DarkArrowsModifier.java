package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.item.MTItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.ranged.BowAmmoModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class DarkArrowsModifier extends NoLevelsModifier implements ProjectileLaunchModifierHook, BowAmmoModifierHook {
    private @Nullable ItemStack latestStandardAmmo;
    private @Nullable ItemStack latestDarkArrow;

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.PROJECTILE_LAUNCH,
                ModifierHooks.BOW_AMMO);
    }

    @Override
    public void onProjectileLaunch(
            IToolStackView tool, ModifierEntry modifier, LivingEntity shooter, Projectile projectile,
            @Nullable AbstractArrow arrow, ModDataNBT persistentData, boolean primary) {
        if (arrow != null) {
            arrow.setCritArrow(false);
        }
    }

    @Override
    public ItemStack findAmmo(
            IToolStackView tool, ModifierEntry modifier, LivingEntity shooter,
            ItemStack standardAmmo, Predicate<ItemStack> ammoPredicate) {

        if (standardAmmo.isEmpty()
                && ammoPredicate.test(new ItemStack(MTItems.DARK_ARROW.get()))
                && !tool.getVolatileData().getBoolean(SKIP_INVENTORY_AMMO)) {
            standardAmmo = findMatchingArrow(shooter);
        }

        if (standardAmmo.getItem() == Items.ARROW) {
            ItemStack darkArrow = new ItemStack(MTItems.DARK_ARROW.get(), standardAmmo.getCount());
            if (ammoPredicate.test(darkArrow)) {
                latestStandardAmmo = standardAmmo;
                latestDarkArrow = darkArrow;
                return darkArrow;
            }
        }

        return ItemStack.EMPTY;
    }


    @Override
    public void shrinkAmmo(
            IToolStackView tool, ModifierEntry modifier, LivingEntity shooter, ItemStack ammo, int needed) {
        ammo.shrink(needed);
        if (ammo == latestDarkArrow && latestStandardAmmo != null) {
            latestStandardAmmo.setCount(ammo.getCount());
        }
        latestStandardAmmo = null;
        latestDarkArrow = null;
    }

    public static ItemStack findMatchingArrow(LivingEntity entity) {
        for(InteractionHand hand : InteractionHand.values()) {
            ItemStack stack = entity.getItemInHand(hand);
            if (stack.getItem() == Items.ARROW) {
                return stack;
            }
        }

        if (entity instanceof Player player) {
            Inventory inventory = player.getInventory();

            for(int i = 0; i < inventory.getContainerSize(); ++i) {
                ItemStack stack = inventory.getItem(i);
                if (stack.getItem() == Items.ARROW) {
                    return stack;
                }
            }
        }

        return ItemStack.EMPTY;
    }
}
