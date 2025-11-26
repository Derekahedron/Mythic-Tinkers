package derekahedron.mythictinkers.tinkers.modifiers;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.ModifyDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.armor.ProtectionModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class TerraformidableModifier extends NoLevelsModifier implements ProtectionModifierHook, ModifyDamageModifierHook {
    public static final float PROTECTION_PER_LEVEL = 2.5F;
    public static final float DAMAGE_MULTIPLIER = 1.5F;

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.PROTECTION,
                ModifierHooks.MODIFY_DAMAGE);
    }

    @Override
    public float getProtectionModifier(
            IToolStackView tool, ModifierEntry modifier, EquipmentContext context,
            EquipmentSlot slotType, DamageSource source, float modifierValue) {
        if (!isPickaxeAttack(source)) {
            modifierValue += PROTECTION_PER_LEVEL * modifier.getEffectiveLevel();
        }

        return modifierValue;
    }

    @Override
    public float modifyDamageTaken(
            IToolStackView tool, ModifierEntry modifier, EquipmentContext context,
            EquipmentSlot slotType, DamageSource source, float amount, boolean isDirectDamage) {
        return isPickaxeAttack(source) ? amount * DAMAGE_MULTIPLIER : amount;
    }

    public static boolean isPickaxeAttack(DamageSource source) {
        return !source.isIndirect()
                && source.getEntity() instanceof LivingEntity livingEntity
                && livingEntity.getMainHandItem().isCorrectToolForDrops(Blocks.STONE.defaultBlockState());
    }
}
