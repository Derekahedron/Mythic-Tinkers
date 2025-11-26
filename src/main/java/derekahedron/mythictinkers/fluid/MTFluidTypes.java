package derekahedron.mythictinkers.fluid;

import derekahedron.mythictinkers.damage.MTDamageTypes;
import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class MTFluidTypes {
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    // Styx
    public static final RegistryObject<FluidType> STYX =
            FLUID_TYPES.register("styx", () ->
                    new StyxFluidType(
                            MTUtil.location("block/styx_still"),
                            MTUtil.location("block/styx_flow"),
                            new Color(0x000503),
                            0.0F,
                            1.0F,
                            FluidType.Properties.create()
                                    .motionScale(0.007)
                                    .fallDistanceModifier(0.0F)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.DAMAGE_OTHER)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                                    .lightLevel(6)
                                    .density(1024)
                                    .temperature(2300)
                                    .viscosity(1024)));

    // Molten Scarlet Neodymium
    public static final RegistryObject<FluidType> MOLTEN_SCARLET_NEODYMIUM =
            FLUID_TYPES.register("molten_scarlet_neodymium", () ->
                    new MoltenOreFluidType(
                            MTUtil.location("block/molten_scarlet_neodymium_still"),
                            MTUtil.location("block/molten_scarlet_neodymium_flow"),
                            new Color(0xA50C0C),
                            0.0F,
                            1.0F,
                            MTDamageTypes.MOLTEN_SCARLET_NEODYMIUM,
                            4.0F,
                            15,
                            FluidType.Properties.create()
                                    .motionScale(0.0023D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.LAVA)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .lightLevel(12)
                                    .density(1024)
                                    .temperature(1100)
                                    .viscosity(1024)));

    // Molten Azure Neodymium
    public static final RegistryObject<FluidType> MOLTEN_AZURE_NEODYMIUM =
            FLUID_TYPES.register("molten_azure_neodymium", () ->
                    new MoltenOreFluidType(
                            MTUtil.location("block/molten_azure_neodymium_still"),
                            MTUtil.location("block/molten_azure_neodymium_flow"),
                            new Color(0x001FA5),
                            0.0F,
                            1.0F,
                            MTDamageTypes.MOLTEN_AZURE_NEODYMIUM,
                            4.0F,
                            15,
                            FluidType.Properties.create()
                                    .motionScale(0.0023D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.LAVA)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .lightLevel(12)
                                    .density(1024)
                                    .temperature(1100)
                                    .viscosity(1024)));

    // Molten Byzantium Neodymium
    public static final RegistryObject<FluidType> MOLTEN_BYZANTIUM_NEODYMIUM =
            FLUID_TYPES.register("molten_byzantium_neodymium", () ->
                    new MoltenOreFluidType(
                            MTUtil.location("block/molten_byzantium_neodymium_still"),
                            MTUtil.location("block/molten_byzantium_neodymium_flow"),
                            new Color(0x5F105C),
                            0.0F,
                            1.0F,
                            MTDamageTypes.MOLTEN_BYZANTIUM_NEODYMIUM,
                            4.0F,
                            15,
                            FluidType.Properties.create()
                                    .motionScale(0.0023D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.LAVA)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .lightLevel(12)
                                    .density(1024)
                                    .temperature(2015)
                                    .viscosity(1024)));


    // Molten Tectellus
    public static final RegistryObject<FluidType> MOLTEN_TECTELLUS =
            FLUID_TYPES.register("molten_tectellus", () ->
                    new MoltenOreFluidType(
                            MTUtil.location("block/molten_tectellus_still"),
                            MTUtil.location("block/molten_tectellus_flow"),
                            new Color(0xFA500B),
                            0.0F,
                            1.0F,
                            MTDamageTypes.MOLTEN_TECTELLUS,
                            8.0F,
                            60,
                            FluidType.Properties.create()
                                    .motionScale(0.0023D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.LAVA)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .lightLevel(15)
                                    .density(1024)
                                    .temperature(2300)
                                    .viscosity(1024)));

    // Molten Element 122
    public static final RegistryObject<FluidType> MOLTEN_ELEMENT_122 =
            FLUID_TYPES.register("molten_element_122", () ->
                    new MoltenOreFluidType(
                            MTUtil.location("block/molten_element_122_still"),
                            MTUtil.location("block/molten_element_122_flow"),
                            new Color(0x969D00),
                            0.0F,
                            1.0F,
                            MTDamageTypes.MOLTEN_ELEMENT_122,
                            6.0F,
                            30,
                            FluidType.Properties.create()
                                    .motionScale(0.0023D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.LAVA)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .lightLevel(15)
                                    .density(1024)
                                    .temperature(2200)
                                    .viscosity(1024)));

    // MOlten Aurichalcum
    public static final RegistryObject<FluidType> MOLTEN_AURICHALCUM =
            FLUID_TYPES.register("molten_aurichalcum", () ->
                    new MoltenOreFluidType(
                            MTUtil.location("block/molten_aurichalcum_still"),
                            MTUtil.location("block/molten_aurichalcum_flow"),
                            new Color(0xF7AB3C),
                            0.0F,
                            1.0F,
                            MTDamageTypes.MOLTEN_AURICHALCUM,
                            4.0F,
                            15,
                            FluidType.Properties.create()
                                    .motionScale(0.0023D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.LAVA)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .lightLevel(14)
                                    .density(1024)
                                    .temperature(1850)
                                    .viscosity(1024)));

    // Molten Desolum
    public static final RegistryObject<FluidType> MOLTEN_DESOLUM =
            FLUID_TYPES.register("molten_desolum", () ->
                    new MoltenOreFluidType(
                            MTUtil.location("block/molten_desolum_still"),
                            MTUtil.location("block/molten_desolum_flow"),
                            new Color(0x433744),
                            0.0F,
                            1.0F,
                            MTDamageTypes.MOLTEN_DESOLUM,
                            4.0F,
                            15,
                            FluidType.Properties.create()
                                    .motionScale(0.0023D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.LAVA)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .lightLevel(4)
                                    .density(1024)
                                    .temperature(1666)
                                    .viscosity(1024)));

    // Molten Prosprum
    public static final RegistryObject<FluidType> MOLTEN_PROSPRUM =
            FLUID_TYPES.register("molten_prosprum", () ->
                    new MoltenOreFluidType(
                            MTUtil.location("block/molten_prosprum_still"),
                            MTUtil.location("block/molten_prosprum_flow"),
                            new Color(0x93FCF3),
                            0.0F,
                            1.0F,
                            MTDamageTypes.MOLTEN_PROSPRUM,
                            4.0F,
                            15,
                            FluidType.Properties.create()
                                    .motionScale(0.0023D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.LAVA)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .lightLevel(15)
                                    .density(1024)
                                    .temperature(2077)
                                    .viscosity(1024)));

    // Earthen Gum
    public static final RegistryObject<FluidType> EARTHEN_GUM =
            FLUID_TYPES.register("earthen_gum", () ->
                    new EarthenGumFluidType(
                            MTUtil.location("block/earthen_gum_still"),
                            MTUtil.location("block/earthen_gum_flow"),
                            new Color(0xF875CE),
                            0.0F,
                            0.2F,
                            FluidType.Properties.create()
                                    .motionScale(0.0002D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.BLOCKED)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .density(1024)
                                    .temperature(300)
                                    .viscosity(1024)));

    // Molten Gumbronze
    public static final RegistryObject<FluidType> MOLTEN_GUMBRONZE =
            FLUID_TYPES.register("molten_gumbronze", () ->
                    new MoltenOreFluidType(
                            MTUtil.location("block/molten_gumbronze_still"),
                            MTUtil.location("block/molten_gumbronze_flow"),
                            new Color(0xFF8CEB),
                            0.0F,
                            1.0F,
                            MTDamageTypes.MOLTEN_GUMBRONZE,
                            4.0F,
                            15,
                            FluidType.Properties.create()
                                    .motionScale(0.0023D)
                                    .canSwim(false)
                                    .canDrown(false)
                                    .pathType(BlockPathTypes.LAVA)
                                    .adjacentPathType(BlockPathTypes.DANGER_OTHER)
                                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                                    .lightLevel(1)
                                    .density(1024)
                                    .temperature(2100)
                                    .viscosity(1024)));
}
