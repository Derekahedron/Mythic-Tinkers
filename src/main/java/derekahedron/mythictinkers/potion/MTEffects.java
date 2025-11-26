package derekahedron.mythictinkers.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MTEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final RegistryObject<MarkedForDeath> MARKED_FOR_DEATH =
            MOB_EFFECTS.register("marked_for_death", MarkedForDeath::new);
}
