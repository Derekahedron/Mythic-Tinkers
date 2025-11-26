package derekahedron.mythictinkers.tinkers.modifiers;

import derekahedron.mythictinkers.potion.MTEffects;
import derekahedron.mythictinkers.tinkers.hooks.EmptySwingModifierHook;
import derekahedron.mythictinkers.tinkers.hooks.MTModifierHooks;
import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.mantle.util.OffhandCooldownTracker;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.combat.MeleeHitModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolAttackUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.tools.TinkerModifiers;

import java.util.List;

public class VengefulStrikeModifier extends NoLevelsModifier implements GeneralInteractionModifierHook, MeleeHitModifierHook, EmptySwingModifierHook {
    public static final double CURSE_RADIUS = 7.0D;
    public static final int DURATION = (int) (20 * 4.0F);

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.MELEE_HIT,
                ModifierHooks.GENERAL_INTERACT,
                MTModifierHooks.EMPTY_SWING);
    }

    @Override
    public int getPriority() {
        return 101;  // One above offhand attack
    }

    @Override
    public void afterMeleeHit(IToolStackView tool, ModifierEntry modifier, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            target.addEffect(new MobEffectInstance(MTEffects.MARKED_FOR_DEATH.get(), DURATION));
        }
    }

    @Override
    public void onEmptySwing(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand) {
        if (player.level().isClientSide() || tool.isBroken()) {
            return;
        }
        List<Entity> entities = MTUtil.getEntitiesInRadius(
                player, CURSE_RADIUS,
                entity -> entity instanceof LivingEntity livingEntity
                        && livingEntity.isAlive()
                        && livingEntity.hasEffect(MTEffects.MARKED_FOR_DEATH.get()));
        if (entities.isEmpty()) {
            return;
        }

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingEntity) {
                ToolAttackUtil.attackEntity(tool, player, hand, entity, ToolAttackUtil.getCooldownFunction(player, hand), false, InteractionSource.RIGHT_CLICK.getSlot(hand));
                livingEntity.removeEffect(MTEffects.MARKED_FOR_DEATH.get());
                ((ServerLevel) player.level()).sendParticles(ParticleTypes.SWEEP_ATTACK,
                        entity.getX(), entity.getY(0.5D), entity.getZ(),
                        0, 0.0D, 0.0D, 0.0D, 0.0D);
            }
        }

        player.sweepAttack();
        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 1.0F, 1.0F);
    }

    @Override
    public InteractionResult onToolUse(
            IToolStackView tool, ModifierEntry modifier,
            Player player, InteractionHand hand, InteractionSource source) {
        if (tool.getModifierLevel(TinkerModifiers.offhandAttack.get()) > 0
                && !tool.isBroken()
                && hand == InteractionHand.OFF_HAND
                && OffhandCooldownTracker.isAttackReady(player)) {
            onEmptySwing(tool, modifier, player, hand);
        }
        return InteractionResult.PASS;
    }
}
