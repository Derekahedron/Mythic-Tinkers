package derekahedron.mythictinkers.tinkers.modifiers;

import com.github.alexmodguy.alexscaves.server.entity.ACEntityRegistry;
import com.github.alexmodguy.alexscaves.server.entity.item.DinosaurSpiritEntity;
import com.github.alexmodguy.alexscaves.server.misc.ACSoundRegistry;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.UsingToolModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class TectonicShieldModifier extends Modifier implements UsingToolModifierHook {

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.TOOL_USING);
    }

    @Override
    public void onUsingTick(
            IToolStackView tool, ModifierEntry modifier, LivingEntity entity,
            int useDuration, int timeLeft, ModifierEntry activeModifier) {
        if (useDuration == timeLeft && !entity.level().isClientSide() && entity instanceof Player player) {
            spawnGrottoHeads(player, 3 + modifier.getLevel() - 1);
        }
    }

    public static void spawnGrottoHeads(Player player, int grottoHeads) {
        player.level().playSound(null, player, ACSoundRegistry.EXTINCTION_SPEAR_SUMMON.get(),
                SoundSource.PLAYERS, 1.0F, 1.0F);

        for (int i = 0; i < grottoHeads; i++) {
            DinosaurSpiritEntity dinosaurSpirit = ACEntityRegistry.DINOSAUR_SPIRIT.get().create(player.level());

            if (dinosaurSpirit == null) {
                continue;
            }
            dinosaurSpirit.copyPosition(player);
            dinosaurSpirit.setDinosaurType(DinosaurSpiritEntity.DinosaurType.GROTTOCERATOPS);
            dinosaurSpirit.setPlayerUUID(player.getUUID());
            dinosaurSpirit.setRotateOffset(360.0F * i / (float) grottoHeads);
            player.level().addFreshEntity(dinosaurSpirit);
        }
    }
}
