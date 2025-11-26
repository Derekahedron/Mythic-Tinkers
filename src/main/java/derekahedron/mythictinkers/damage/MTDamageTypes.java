package derekahedron.mythictinkers.damage;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class MTDamageTypes {
    public static final ResourceKey<DamageType> STYX =
            of("styx");

    public static final ResourceKey<DamageType> MOLTEN_SCARLET_NEODYMIUM =
            of("molten_scarlet_neodymium");

    public static final ResourceKey<DamageType> MOLTEN_AZURE_NEODYMIUM =
            of("molten_azure_neodymium");

    public static final ResourceKey<DamageType> MOLTEN_BYZANTIUM_NEODYMIUM =
            of("molten_byzantium_neodymium");

    public static final ResourceKey<DamageType> MOLTEN_TECTELLUS =
            of("molten_tectellus");

    public static final ResourceKey<DamageType> MOLTEN_ELEMENT_122 =
            of("molten_element_122");

    public static final ResourceKey<DamageType> MOLTEN_AURICHALCUM =
            of("molten_aurichalcum");

    public static final ResourceKey<DamageType> MOLTEN_DESOLUM =
            of("molten_desolum");

    public static final ResourceKey<DamageType> MOLTEN_PROSPRUM =
            of("molten_prosprum");

    public static final ResourceKey<DamageType> MOLTEN_GUMBRONZE =
            of("molten_gumbronze");

    public static ResourceKey<DamageType> of(String id) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, MTUtil.location(id));
    }

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(STYX, new DamageType(
                String.format("%s.styx", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
        context.register(MOLTEN_SCARLET_NEODYMIUM, new DamageType(
                String.format("%s.molten_scarlet_neodymium", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
        context.register(MOLTEN_AZURE_NEODYMIUM, new DamageType(
                String.format("%s.molten_azure_neodymium", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
        context.register(MOLTEN_BYZANTIUM_NEODYMIUM, new DamageType(
                String.format("%s.molten_byzantium_neodymium", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
        context.register(MOLTEN_TECTELLUS, new DamageType(
                String.format("%s.molten_tectellus", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
        context.register(MOLTEN_ELEMENT_122, new DamageType(
                String.format("%s.molten_element_122", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
        context.register(MOLTEN_AURICHALCUM, new DamageType(
                String.format("%s.molten_aurichalcum", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
        context.register(MOLTEN_DESOLUM, new DamageType(
                String.format("%s.molten_desolum", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
        context.register(MOLTEN_PROSPRUM, new DamageType(
                String.format("%s.molten_prosprum", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
        context.register(MOLTEN_GUMBRONZE, new DamageType(
                String.format("%s.molten_gumbronze", MythicTinkers.MOD_ID),
                DamageScaling.NEVER,
                0.1F,
                DamageEffects.HURT));
    }
}
