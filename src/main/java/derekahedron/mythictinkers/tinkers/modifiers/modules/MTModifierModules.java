package derekahedron.mythictinkers.tinkers.modifiers.modules;

import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;

@Mod.EventBusSubscriber(modid = derekahedron.mythictinkers.MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MTModifierModules {

    @SubscribeEvent
    static void registerSerializers(RegisterEvent event) {
        if (event.getRegistryKey() == Registries.RECIPE_SERIALIZER) {
            ModifierModule.LOADER.register(MTUtil.location("maximum_destroy_speed"), MaximumDestroySpeedModule.LOADER);
            ModifierModule.LOADER.register(MTUtil.location("half_life"), HalfLifeModule.LOADER);
            ModifierModule.LOADER.register(MTUtil.location("leveling_modifier_slot"), LevelingModifierSlotModule.LOADER);
            ModifierModule.LOADER.register(MTUtil.location("modifier_material"), ModifierMaterialModule.LOADER);
        }
    }
}
