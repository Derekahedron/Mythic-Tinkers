package derekahedron.mythictinkers.tinkers.modifiers;

import com.github.alexmodguy.alexscaves.server.entity.item.DarkArrowEntity;
import com.github.alexmodguy.alexscaves.server.misc.ACSoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.UsingToolModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileLaunchModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.capability.EntityModifierCapability;
import slimeknights.tconstruct.library.tools.capability.PersistentDataCapability;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

import javax.annotation.Nullable;

public class DreadshotModifier extends NoLevelsModifier implements
        ProjectileLaunchModifierHook,
        UsingToolModifierHook {
    public static final String CHARGE_KEY = "Charge" ;

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.PROJECTILE_LAUNCH,
                ModifierHooks.TOOL_USING);
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public void onProjectileLaunch(
            IToolStackView tool, ModifierEntry modifier, LivingEntity shooter, ItemStack ammo, Projectile projectile,
            @Nullable AbstractArrow arrow, ModDataNBT persistentData, boolean primary) {
        CompoundTag compound = tool.getPersistentData().getCompound(getId());
        float charge = compound.contains(CHARGE_KEY) ? compound.getFloat(CHARGE_KEY) : 1.0F;
        compound.remove(CHARGE_KEY);
        tool.getPersistentData().put(getId(), compound);

        float speed = (float) projectile.getDeltaMovement().length() / 3.0F;
        float inaccuracy = ModifierUtil.getInaccuracy(tool, shooter);

        Level level = shooter.level();

        HitResult hitResult = ProjectileUtil.getHitResultOnViewVector(shooter, Entity::canBeHitByProjectile, 128.0F * charge);
        if (hitResult.getType() == HitResult.Type.MISS) {
            hitResult = ProjectileUtil.getHitResultOnViewVector(shooter, Entity::canBeHitByProjectile, 42.0F * charge);
        }
        Vec3 targetPosition = hitResult.getLocation();

        BlockPos skyPos = new BlockPos.MutableBlockPos(
                targetPosition.x,
                targetPosition.y + 1.5,
                targetPosition.z);
        for (int i = 0; skyPos.getY() < level.getMaxBuildHeight() && level.isEmptyBlock(skyPos) && i < 15; i++) {
            skyPos = skyPos.above();
        }

        launchProjectile(projectile, targetPosition, skyPos, level, speed, inaccuracy);
        if (!primary) return;

        shooter.playSound(ACSoundRegistry.DREADBOW_RELEASE.get());

        if (projectile != arrow || !(ammo.getItem() instanceof ArrowItem arrowItem)) return;
        boolean darkArrows = arrow instanceof DarkArrowEntity;
        double baseDamage = arrow.getBaseDamage();
        boolean wasCritArrow = arrow.isCritArrow();

        arrow.setCritArrow(false);
        ModifierNBT modifiers = tool.getModifiers();

        int numArrows = darkArrows ? 30 : 8;
        for (int i = 0; i < numArrows * charge - 1; i++) {
            AbstractArrow extraArrow = arrowItem.createArrow(level, ammo, shooter);
            extraArrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            extraArrow.setBaseDamage(baseDamage);
            extraArrow.setCritArrow(wasCritArrow);

            extraArrow.getCapability(EntityModifierCapability.CAPABILITY)
                    .ifPresent((cap) -> cap.setModifiers(modifiers));
            ModDataNBT arrowData = PersistentDataCapability.getOrWarn(extraArrow);

            for (ModifierEntry m : modifiers.getModifiers()) {
                if (!(m.getModifier() instanceof DreadshotModifier)) {
                    m.getHook(ModifierHooks.PROJECTILE_LAUNCH).onProjectileLaunch(
                            tool, m, shooter, ammo, extraArrow, extraArrow, arrowData, false);
                }
            }

            extraArrow.setCritArrow(false);
            launchProjectile(extraArrow, targetPosition, skyPos, level, speed, inaccuracy);
            level.addFreshEntity(extraArrow);
        }

        if (darkArrows) {
            level.playSound(null,
                    targetPosition.x, targetPosition.y, targetPosition.z,
                    ACSoundRegistry.DREADBOW_RAIN.get(), SoundSource.PLAYERS,
                    12.0F, 1.0F);
        }
    }

    @Override
    public void onProjectileLaunch(
            IToolStackView tool, ModifierEntry modifier, LivingEntity shooter, Projectile projectile,
            @Nullable AbstractArrow arrow, ModDataNBT persistentData, boolean primary) {
        // Must be empty to implement ProjectileLaunchModifierHook.
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

    public static void launchProjectile(
            Projectile projectile, Vec3 targetPosition, BlockPos skyPos, Level level, float speed, float inaccuracy) {
        Vec3 launchPosition = skyPos.getCenter();
        for (int clearTries = 0; clearTries < 6; clearTries++) {
            Vec3 randomLaunchPosition = skyPos.getCenter().add(
                    level.random.nextFloat() * 16.0F - 8.0F,
                    level.random.nextFloat() * 4.0F - 2.0F,
                    level.random.nextFloat() * 16.0F - 8.0F);
            if (level.isEmptyBlock(BlockPos.containing(randomLaunchPosition))
                    || !level.getFluidState(BlockPos.containing(randomLaunchPosition)).isEmpty()) {
                launchPosition = randomLaunchPosition;
                break;
            }
        }

        projectile.setPos(launchPosition);
        Vec3 arrowDirection = targetPosition.subtract(launchPosition);

        float randomness;
        if (level.random.nextFloat() < 0.25F) {
            randomness = level.random.nextFloat();
        } else if (projectile instanceof DarkArrowEntity) {
            randomness = Mth.lerp(level.random.nextFloat(), 20.0F, 30.0F);
        } else {
            randomness = Mth.lerp(level.random.nextFloat(), 5.0F, 15.0F);
        }

        projectile.shoot(
                arrowDirection.x, arrowDirection.y, arrowDirection.z,
                Mth.lerp(level.random.nextFloat(), 0.5F, 1.5F) * speed,
                randomness * inaccuracy);
    }
}
