package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.block.MTBlockTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.UsingToolModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

import javax.annotation.Nullable;

public class AeroformingModifier extends NoLevelsModifier implements
        ProjectileLaunchModifierHook,
        ProjectileHitModifierHook,
        UsingToolModifierHook {
    public static final String CHARGED_KEY = "Charged";
    public static final String CHARGE_KEY = "Charge";

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.PROJECTILE_LAUNCH,
                ModifierHooks.PROJECTILE_HIT,
                ModifierHooks.TOOL_USING);
    }

    @Override
    public void onProjectileLaunch(
            IToolStackView tool, ModifierEntry modifier, LivingEntity shooter,
            Projectile projectile, @Nullable AbstractArrow arrow,
            ModDataNBT persistentData, boolean primary) {
        CompoundTag toolComponent = tool.getPersistentData().getCompound(getId());
        float charge = toolComponent.contains(CHARGE_KEY) ? toolComponent.getFloat(CHARGE_KEY) : 1.0F;
        if (charge >= 1.0) {
            CompoundTag arrowCompound = new CompoundTag();
            arrowCompound.putBoolean(CHARGED_KEY, true);
            persistentData.put(getId(), arrowCompound);
        }
    }

    @Override
    public void onProjectileHitBlock(
            ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier,
            Projectile projectile, BlockHitResult hit, @Nullable LivingEntity attacker) {
        BlockState state = projectile.level().getBlockState(hit.getBlockPos());
        CompoundTag compound = persistentData.getCompound(getId());
        if (!compound.isEmpty() && compound.getBoolean(CHARGED_KEY)) {
            if (state.getDestroySpeed(projectile.level(), hit.getBlockPos()) >= 0.0F
                    && state.is(MTBlockTags.TERRAFORMABLE)) {
                projectile.level().destroyBlock(hit.getBlockPos(), true, projectile);
                projectile.discard();
            } else {
                persistentData.remove(getId());
            }
        }
    }

    @Override
    public void beforeReleaseUsing(
            IToolStackView tool, ModifierEntry modifier, LivingEntity entity,
            int useDuration, int timeLeft, ModifierEntry activeModifier) {
        float charge = GeneralInteractionModifierHook.getToolCharge(tool, useDuration - timeLeft);
        CompoundTag compound = tool.getPersistentData().getCompound(getId());
        compound.putFloat(CHARGE_KEY, charge);
        tool.getPersistentData().put(getId(), compound);
    }
}
