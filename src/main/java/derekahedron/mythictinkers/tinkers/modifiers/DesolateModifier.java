package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.util.MTUtil;
import com.github.alexmodguy.alexscaves.server.entity.ACEntityRegistry;
import com.github.alexmodguy.alexscaves.server.entity.item.DesolateDaggerEntity;
import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ranged.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;

import javax.annotation.Nullable;

public class DesolateModifier extends NoLevelsModifier implements MeleeHitModifierHook, ProjectileHitModifierHook {
    public static final String INACTIVE_KEY = "Inactive";

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.MELEE_HIT,
                ModifierHooks.PROJECTILE_HIT);
    }

    @Override
    public void afterMeleeHit(
            IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            spawnDesolateDagger(target, context.getAttacker());
        }
    }

    @Override
    public boolean onProjectileHitEntity(
            ModifierNBT modifiers, ModDataNBT persistentData, ModifierEntry modifier,
            Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker,
            @Nullable LivingEntity target, boolean notBlocked) {
        if (!notBlocked || MTUtil.shouldBlockHitEffect(projectile, hit)) return false;

        if (target != null) {
            spawnDesolateDagger(target, attacker);
            CompoundTag compound = persistentData.getCompound(getId());
            compound.putBoolean(INACTIVE_KEY, true);
            persistentData.put(getId(), compound);
        }
        return false;
    }

    public static void spawnDesolateDagger(LivingEntity target, @Nullable LivingEntity attacker) {
        DesolateDaggerEntity dagger = ACEntityRegistry.DESOLATE_DAGGER.get().create(target.level());
        if (dagger == null) {
            return;
        }
        if (attacker instanceof Player) {
            dagger.setPlayerId(attacker.getId());
        }
        dagger.setTargetId(target.getId());
        dagger.copyPosition(target);
        dagger.setItemStack(new ItemStack(ACItemRegistry.DESOLATE_DAGGER.get()));
        dagger.orbitFor = 20 + target.getRandom().nextInt(10);
        target.level().addFreshEntity(dagger);
    }
}
