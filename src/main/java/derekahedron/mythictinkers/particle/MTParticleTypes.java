package derekahedron.mythictinkers.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MTParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final RegistryObject<SimpleParticleType> BYZANTIUM_MAGNETIC_ORBIT =
            PARTICLE_TYPES.register("byzantium_magnetic_orbit", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> STYX_TENDRIL =
            PARTICLE_TYPES.register("styx_tendril", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> STYX_SMOKE =
            PARTICLE_TYPES.register("styx_smoke", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> STYX_CLOUD =
            PARTICLE_TYPES.register("styx_cloud", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_MOLTEN_SCARLET_NEODYMIUM =
            PARTICLE_TYPES.register("dripping_molten_scarlet_neodymium", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MOLTEN_SCARLET_NEODYMIUM =
            PARTICLE_TYPES.register("falling_molten_scarlet_neodymium", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_MOLTEN_SCARLET_NEODYMIUM =
            PARTICLE_TYPES.register("landing_molten_scarlet_neodymium", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_MOLTEN_AZURE_NEODYMIUM =
            PARTICLE_TYPES.register("dripping_molten_azure_neodymium", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MOLTEN_AZURE_NEODYMIUM =
            PARTICLE_TYPES.register("falling_molten_azure_neodymium", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_MOLTEN_AZURE_NEODYMIUM =
            PARTICLE_TYPES.register("landing_molten_azure_neodymium", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_MOLTEN_BYZANTIUM_NEODYMIUM =
            PARTICLE_TYPES.register("dripping_molten_byzantium_neodymium", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MOLTEN_BYZANTIUM_NEODYMIUM =
            PARTICLE_TYPES.register("falling_molten_byzantium_neodymium", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_MOLTEN_BYZANTIUM_NEODYMIUM =
            PARTICLE_TYPES.register("landing_molten_byzantium_neodymium", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_MOLTEN_TECTELLUS =
            PARTICLE_TYPES.register("dripping_molten_tectellus", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MOLTEN_TECTELLUS =
            PARTICLE_TYPES.register("falling_molten_tectellus", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_MOLTEN_TECTELLUS =
            PARTICLE_TYPES.register("landing_molten_tectellus", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_MOLTEN_ELEMENT_122 =
            PARTICLE_TYPES.register("dripping_molten_element_122", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MOLTEN_ELEMENT_122 =
            PARTICLE_TYPES.register("falling_molten_element_122", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_MOLTEN_ELEMENT_122 =
            PARTICLE_TYPES.register("landing_molten_element_122", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_MOLTEN_AURICHALCUM =
            PARTICLE_TYPES.register("dripping_molten_aurichalcum", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MOLTEN_AURICHALCUM =
            PARTICLE_TYPES.register("falling_molten_aurichalcum", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_MOLTEN_AURICHALCUM =
            PARTICLE_TYPES.register("landing_molten_aurichalcum", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_MOLTEN_DESOLUM =
            PARTICLE_TYPES.register("dripping_molten_desolum", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MOLTEN_DESOLUM =
            PARTICLE_TYPES.register("falling_molten_desolum", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_MOLTEN_DESOLUM =
            PARTICLE_TYPES.register("landing_molten_desolum", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_MOLTEN_PROSPRUM =
            PARTICLE_TYPES.register("dripping_molten_prosprum", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MOLTEN_PROSPRUM =
            PARTICLE_TYPES.register("falling_molten_prosprum", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_MOLTEN_PROSPRUM =
            PARTICLE_TYPES.register("landing_molten_prosprum", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> DRIPPING_MOLTEN_GUMBRONZE =
            PARTICLE_TYPES.register("dripping_molten_gumbronze", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> FALLING_MOLTEN_GUMBRONZE =
            PARTICLE_TYPES.register("falling_molten_gumbronze", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> LANDING_MOLTEN_GUMBRONZE =
            PARTICLE_TYPES.register("landing_molten_gumbronze", () ->
                    new SimpleParticleType(false));

    public static final RegistryObject<SimpleParticleType> MOLTEN_SCARLET_NEODYMIUM =
            PARTICLE_TYPES.register("molten_scarlet_neodymium", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MOLTEN_AZURE_NEODYMIUM =
            PARTICLE_TYPES.register("molten_azure_neodymium", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MOLTEN_BYZANTIUM_NEODYMIUM =
            PARTICLE_TYPES.register("molten_byzantium_neodymium", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MOLTEN_TECTELLUS =
            PARTICLE_TYPES.register("molten_tectellus", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MOLTEN_ELEMENT_122 =
            PARTICLE_TYPES.register("molten_element_122", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MOLTEN_AURICHALCUM =
            PARTICLE_TYPES.register("molten_aurichalcum", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MOLTEN_DESOLUM =
            PARTICLE_TYPES.register("molten_desolum", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MOLTEN_PROSPRUM =
            PARTICLE_TYPES.register("molten_prosprum", () ->
                    new SimpleParticleType(false));
    public static final RegistryObject<SimpleParticleType> MOLTEN_GUMBRONZE =
            PARTICLE_TYPES.register("molten_gumbronze", () ->
                    new SimpleParticleType(false));
}
