package derekahedron.mythictinkers.potion;

import net.minecraft.world.effect.MobEffectCategory;
import slimeknights.tconstruct.tools.modifiers.effect.NoMilkEffect;

public class MarkedForDeath extends NoMilkEffect {

    public MarkedForDeath() {
        super(MobEffectCategory.HARMFUL, 0xC2FFF1, true);
    }
}
