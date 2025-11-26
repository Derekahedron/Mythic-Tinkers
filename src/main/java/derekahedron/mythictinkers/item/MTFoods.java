package derekahedron.mythictinkers.item;

import com.github.alexmodguy.alexscaves.server.potion.ACEffectRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;

public class MTFoods {
    public static final FoodProperties EARTHEN_GUM_ORE =
            new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.1F)
                    .effect(() -> new MobEffectInstance(ACEffectRegistry.SUGAR_RUSH.get(), 200), 0.02F)
                    .alwaysEat()
                    .build();
}
