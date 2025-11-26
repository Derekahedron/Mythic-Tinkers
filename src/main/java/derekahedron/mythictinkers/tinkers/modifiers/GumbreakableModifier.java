package derekahedron.mythictinkers.tinkers.modifiers;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.behavior.ToolDamageModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nullable;

public class GumbreakableModifier extends NoLevelsModifier implements ToolDamageModifierHook {
    public static final int MAX_FOOD_LEVEL = 18;
    public static final int MIN_FOOD_LEVEL = 6;

    @Override
    protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
        super.registerHooks(hookBuilder);
        hookBuilder.addHook(this,
                ModifierHooks.TOOL_DAMAGE);
    }

    @Override
    public int onDamageTool(IToolStackView tool, ModifierEntry modifier, int amount, @Nullable LivingEntity holder) {
        if (!(holder instanceof Player player)) return amount;
        int foodLevel = player.getFoodData().getFoodLevel();
        if (foodLevel >= MAX_FOOD_LEVEL) return 0;
        else if (foodLevel <= MIN_FOOD_LEVEL) return amount;

        float scaledAmount = amount * (foodLevel - MIN_FOOD_LEVEL) / (float) (MAX_FOOD_LEVEL - MIN_FOOD_LEVEL);
        int damageReduced = (int) scaledAmount;
        float chance = scaledAmount - damageReduced;
        if (chance > 0 && player.getRandom().nextFloat() < chance) {
            damageReduced++;
        }
        return amount - damageReduced;
    }
}
