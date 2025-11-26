package derekahedron.mythictinkers.tinkers.modifiers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.ProtectionModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class DarknessProtectionModifier extends Modifier implements ProtectionModifierHook {
    public static final float PROTECTION_PER_LEVEL = 2.0F;

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.PROTECTION);
    }

    @Override
    public float getProtectionModifier(
            IToolStackView tool, ModifierEntry modifier, EquipmentContext context,
            EquipmentSlot slotType, DamageSource source, float modifierValue) {
        LivingEntity entity = context.getEntity();
        BlockPos pos = entity.blockPosition();
        Level level = entity.level();
        BlockState blockState = level.getBlockState(pos);

        // If inside solid block (like soul sand) use the above position
        if (!blockState.getBlock().propagatesSkylightDown(blockState, level, pos)) {
            pos = pos.above();
        }
        int lightLevel = level.getRawBrightness(pos, 0);
        if (lightLevel < 15) {
            modifierValue += PROTECTION_PER_LEVEL * modifier.getEffectiveLevel() * (15 - lightLevel) / 15.0F;
        }

        return modifierValue;
    }
}
