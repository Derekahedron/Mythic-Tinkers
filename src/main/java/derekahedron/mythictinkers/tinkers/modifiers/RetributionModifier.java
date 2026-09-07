package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.entity.LivingEntityDuck;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.OnAttackedModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class RetributionModifier extends NoLevelsModifier implements OnAttackedModifierHook {
    public static final int DURATION = (int) (20 * 4.0F);

    @Override
    @SuppressWarnings("deprecation")
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.ON_ATTACKED);
    }

    @Override
    public void onAttacked(
            IToolStackView tool, ModifierEntry modifier, EquipmentContext context,
            EquipmentSlot slotType, DamageSource source, float amount, boolean isDirectDamage) {
        LivingEntity wearer = context.getEntity();
        if (source.getEntity() instanceof LivingEntity livingEntity) {
            ((LivingEntityDuck) livingEntity).mythictinkers_$markForDeath(wearer, DURATION);
        }
    }
}
