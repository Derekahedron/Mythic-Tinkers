package derekahedron.mythictinkers.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MTSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final RegistryObject<SoundEvent> STYX_EXTINGUISH =
            register("block.styx.extinguish");

    public static final RegistryObject<SoundEvent> MOLTEN_SCARLET_NEODYMIUM_AMBIENT =
            register("block.molten_scarlet_neodymium.ambient");
    public static final RegistryObject<SoundEvent> MOLTEN_SCARLET_NEODYMIUM_POP =
            register("block.molten_scarlet_neodymium.pop");

    public static final RegistryObject<SoundEvent> MOLTEN_AZURE_NEODYMIUM_AMBIENT =
            register("block.molten_azure_neodymium.ambient");
    public static final RegistryObject<SoundEvent> MOLTEN_AZURE_NEODYMIUM_POP =
            register("block.molten_azure_neodymium.pop");

    public static final RegistryObject<SoundEvent> MOLTEN_BYZANTIUM_NEODYMIUM_AMBIENT =
            register("block.molten_byzantium_neodymium.ambient");
    public static final RegistryObject<SoundEvent> MOLTEN_BYZANTIUM_NEODYMIUM_POP =
            register("block.molten_byzantium_neodymium.pop");

    public static final RegistryObject<SoundEvent> MOLTEN_TECTELLUS_AMBIENT =
            register("block.molten_tectellus.ambient");
    public static final RegistryObject<SoundEvent> MOLTEN_TECTELLUS_POP =
            register("block.molten_tectellus.pop");

    public static final RegistryObject<SoundEvent> MOLTEN_ELEMENT_122_AMBIENT =
            register("block.molten_element_122.ambient");
    public static final RegistryObject<SoundEvent> MOLTEN_ELEMENT_122_POP =
            register("block.molten_element_122.pop");

    public static final RegistryObject<SoundEvent> MOLTEN_AURICHALCUM_AMBIENT =
            register("block.molten_aurichalcum.ambient");
    public static final RegistryObject<SoundEvent> MOLTEN_AURICHALCUM_POP =
            register("block.molten_aurichalcum.pop");

    public static final RegistryObject<SoundEvent> MOLTEN_DESOLUM_AMBIENT =
            register("block.molten_desolum.ambient");
    public static final RegistryObject<SoundEvent> MOLTEN_DESOLUM_POP =
            register("block.molten_desolum.pop");

    public static final RegistryObject<SoundEvent> MOLTEN_PROSPRUM_AMBIENT =
            register("block.molten_prosprum.ambient");
    public static final RegistryObject<SoundEvent> MOLTEN_PROSPRUM_POP =
            register("block.molten_prosprum.pop");

    public static final RegistryObject<SoundEvent> MOLTEN_GUMBRONZE_AMBIENT =
            register("block.molten_gumbronze.ambient");
    public static final RegistryObject<SoundEvent> MOLTEN_GUMBRONZE_POP =
            register("block.molten_gumbronze.pop");


    public static RegistryObject<SoundEvent> register(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(MTUtil.location(name)));
    }
}
