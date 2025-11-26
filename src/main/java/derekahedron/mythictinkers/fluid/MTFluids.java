package derekahedron.mythictinkers.fluid;

import derekahedron.mythictinkers.block.MTBlocks;
import derekahedron.mythictinkers.item.MTItems;
import derekahedron.mythictinkers.particle.MTParticleTypes;
import derekahedron.mythictinkers.util.MTSoundEvents;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MTFluids {

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    // Styx
    public static final RegistryObject<FlowingFluid> STYX =
            FLUIDS.register("styx", () ->
                    new StyxFluid.Source(
                            MTFluidHolders.STYX.properties()
                                    .block(MTBlocks.STYX)
                                    .bucket(MTItems.STYX_BUCKET)));
    public static final RegistryObject<FlowingFluid> STYX_FLOWING =
            FLUIDS.register("styx_flowing", () ->
                    new StyxFluid.Flowing(
                            MTFluidHolders.STYX.properties()
                                    .block(MTBlocks.STYX)
                                    .bucket(MTItems.STYX_BUCKET)));

    // Molten Scarlet Neodymium
    public static final RegistryObject<FlowingFluid> MOLTEN_SCARLET_NEODYMIUM =
            FLUIDS.register("molten_scarlet_neodymium", () ->
                    new MoltenOreFluid.Source(
                            MTFluidHolders.MOLTEN_SCARLET_NEODYMIUM.properties()
                                    .bucket(MTItems.MOLTEN_SCARLET_NEODYMIUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_SCARLET_NEODYMIUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(20),
                            MTParticleTypes.MOLTEN_SCARLET_NEODYMIUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_SCARLET_NEODYMIUM::get,
                            MTSoundEvents.MOLTEN_SCARLET_NEODYMIUM_AMBIENT,
                            MTSoundEvents.MOLTEN_SCARLET_NEODYMIUM_POP));
    public static final RegistryObject<FlowingFluid> MOLTEN_SCARLET_NEODYMIUM_FLOWING =
            FLUIDS.register("molten_scarlet_neodymium_flowing", () ->
                    new MoltenOreFluid.Flowing(
                            MTFluidHolders.MOLTEN_SCARLET_NEODYMIUM.properties()
                                    .bucket(MTItems.MOLTEN_SCARLET_NEODYMIUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_SCARLET_NEODYMIUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(20),
                            MTParticleTypes.MOLTEN_SCARLET_NEODYMIUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_SCARLET_NEODYMIUM::get,
                            MTSoundEvents.MOLTEN_SCARLET_NEODYMIUM_AMBIENT,
                            MTSoundEvents.MOLTEN_SCARLET_NEODYMIUM_POP));

    // Molten Azure Neodymium
    public static final RegistryObject<FlowingFluid> MOLTEN_AZURE_NEODYMIUM =
            FLUIDS.register("molten_azure_neodymium", () ->
                    new MoltenOreFluid.Source(
                            MTFluidHolders.MOLTEN_AZURE_NEODYMIUM.properties()
                                    .bucket(MTItems.MOLTEN_AZURE_NEODYMIUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_AZURE_NEODYMIUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(20),
                            MTParticleTypes.MOLTEN_AZURE_NEODYMIUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_AZURE_NEODYMIUM::get,
                            MTSoundEvents.MOLTEN_AZURE_NEODYMIUM_AMBIENT,
                            MTSoundEvents.MOLTEN_AZURE_NEODYMIUM_POP));
    public static final RegistryObject<FlowingFluid> MOLTEN_AZURE_NEODYMIUM_FLOWING =
            FLUIDS.register("molten_azure_neodymium_flowing", () ->
                    new MoltenOreFluid.Flowing(
                            MTFluidHolders.MOLTEN_AZURE_NEODYMIUM.properties()
                                    .bucket(MTItems.MOLTEN_AZURE_NEODYMIUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_AZURE_NEODYMIUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(20),
                            MTParticleTypes.MOLTEN_AZURE_NEODYMIUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_AZURE_NEODYMIUM::get,
                            MTSoundEvents.MOLTEN_AZURE_NEODYMIUM_AMBIENT,
                            MTSoundEvents.MOLTEN_AZURE_NEODYMIUM_POP));

    // Molten Byzantium Neodymium
    public static final RegistryObject<FlowingFluid> MOLTEN_BYZANTIUM_NEODYMIUM =
            FLUIDS.register("molten_byzantium_neodymium", () ->
                    new MoltenOreFluid.Source(
                            MTFluidHolders.MOLTEN_BYZANTIUM_NEODYMIUM.properties()
                                    .bucket(MTItems.MOLTEN_BYZANTIUM_NEODYMIUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_BYZANTIUM_NEODYMIUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(20),
                            MTParticleTypes.MOLTEN_BYZANTIUM_NEODYMIUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_BYZANTIUM_NEODYMIUM::get,
                            MTSoundEvents.MOLTEN_BYZANTIUM_NEODYMIUM_AMBIENT,
                            MTSoundEvents.MOLTEN_BYZANTIUM_NEODYMIUM_POP));
    public static final RegistryObject<FlowingFluid> MOLTEN_BYZANTIUM_NEODYMIUM_FLOWING =
            FLUIDS.register("molten_byzantium_neodymium_flowing", () ->
                    new MoltenOreFluid.Flowing(
                            MTFluidHolders.MOLTEN_BYZANTIUM_NEODYMIUM.properties()
                                    .bucket(MTItems.MOLTEN_BYZANTIUM_NEODYMIUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_BYZANTIUM_NEODYMIUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(20),
                            MTParticleTypes.MOLTEN_BYZANTIUM_NEODYMIUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_BYZANTIUM_NEODYMIUM::get,
                            MTSoundEvents.MOLTEN_BYZANTIUM_NEODYMIUM_AMBIENT,
                            MTSoundEvents.MOLTEN_BYZANTIUM_NEODYMIUM_POP));

    // Molten Tectellus
    public static final RegistryObject<FlowingFluid> MOLTEN_TECTELLUS =
            FLUIDS.register("molten_tectellus", () ->
                    new MoltenOreFluid.Source(
                            MTFluidHolders.MOLTEN_TECTELLUS.properties()
                                    .bucket(MTItems.MOLTEN_TECTELLUS_BUCKET)
                                    .block(MTBlocks.MOLTEN_TECTELLUS)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(40),
                            MTParticleTypes.MOLTEN_TECTELLUS::get,
                            MTParticleTypes.DRIPPING_MOLTEN_TECTELLUS::get,
                            MTSoundEvents.MOLTEN_TECTELLUS_AMBIENT,
                            MTSoundEvents.MOLTEN_TECTELLUS_POP));
    public static final RegistryObject<FlowingFluid> MOLTEN_TECTELLUS_FLOWING =
            FLUIDS.register("molten_tectellus_flowing", () ->
                    new MoltenOreFluid.Flowing(
                            MTFluidHolders.MOLTEN_TECTELLUS.properties()
                                    .bucket(MTItems.MOLTEN_TECTELLUS_BUCKET)
                                    .block(MTBlocks.MOLTEN_TECTELLUS)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(40),
                            MTParticleTypes.MOLTEN_TECTELLUS::get,
                            MTParticleTypes.DRIPPING_MOLTEN_TECTELLUS::get,
                            MTSoundEvents.MOLTEN_TECTELLUS_AMBIENT,
                            MTSoundEvents.MOLTEN_TECTELLUS_POP));

    // Molten Element 122
    public static final RegistryObject<FlowingFluid> MOLTEN_ELEMENT_122 =
            FLUIDS.register("molten_element_122", () ->
                    new MoltenOreFluid.Source(
                            MTFluidHolders.MOLTEN_ELEMENT_122.properties()
                                    .bucket(MTItems.MOLTEN_ELEMENT_122_BUCKET)
                                    .block(MTBlocks.MOLTEN_ELEMENT_122)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(35),
                            MTParticleTypes.MOLTEN_ELEMENT_122::get,
                            MTParticleTypes.DRIPPING_MOLTEN_ELEMENT_122::get,
                            MTSoundEvents.MOLTEN_ELEMENT_122_AMBIENT,
                            MTSoundEvents.MOLTEN_ELEMENT_122_POP));
    public static final RegistryObject<FlowingFluid> MOLTEN_ELEMENT_122_FLOWING =
            FLUIDS.register("molten_element_122_flowing", () ->
                    new MoltenOreFluid.Flowing(
                            MTFluidHolders.MOLTEN_ELEMENT_122.properties()
                                    .bucket(MTItems.MOLTEN_ELEMENT_122_BUCKET)
                                    .block(MTBlocks.MOLTEN_ELEMENT_122)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(35),
                            MTParticleTypes.MOLTEN_ELEMENT_122::get,
                            MTParticleTypes.DRIPPING_MOLTEN_ELEMENT_122::get,
                            MTSoundEvents.MOLTEN_ELEMENT_122_AMBIENT,
                            MTSoundEvents.MOLTEN_ELEMENT_122_POP));

    // Molten Aurichalcum
    public static final RegistryObject<FlowingFluid> MOLTEN_AURICHALCUM =
            FLUIDS.register("molten_aurichalcum", () ->
                    new MoltenOreFluid.Source(
                            MTFluidHolders.MOLTEN_AURICHALCUM.properties()
                                    .bucket(MTItems.MOLTEN_AURICHALCUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_AURICHALCUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(25),
                            MTParticleTypes.MOLTEN_AURICHALCUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_AURICHALCUM::get,
                            MTSoundEvents.MOLTEN_AURICHALCUM_AMBIENT,
                            MTSoundEvents.MOLTEN_AURICHALCUM_POP));
    public static final RegistryObject<FlowingFluid> MOLTEN_AURICHALCUM_FLOWING =
            FLUIDS.register("molten_aurichalcum_flowing", () ->
                    new MoltenOreFluid.Flowing(
                            MTFluidHolders.MOLTEN_AURICHALCUM.properties()
                                    .bucket(MTItems.MOLTEN_AURICHALCUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_AURICHALCUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(25),
                            MTParticleTypes.MOLTEN_AURICHALCUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_AURICHALCUM::get,
                            MTSoundEvents.MOLTEN_AURICHALCUM_AMBIENT,
                            MTSoundEvents.MOLTEN_AURICHALCUM_POP));

    // Molten Desolum
    public static final RegistryObject<FlowingFluid> MOLTEN_DESOLUM =
            FLUIDS.register("molten_desolum", () ->
                    new MoltenOreFluid.Source(
                            MTFluidHolders.MOLTEN_DESOLUM.properties()
                                    .bucket(MTItems.MOLTEN_DESOLUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_DESOLUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(15),
                            MTParticleTypes.MOLTEN_DESOLUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_DESOLUM::get,
                            MTSoundEvents.MOLTEN_DESOLUM_AMBIENT,
                            MTSoundEvents.MOLTEN_DESOLUM_POP));
    public static final RegistryObject<FlowingFluid> MOLTEN_DESOLUM_FLOWING =
            FLUIDS.register("molten_desolum_flowing", () ->
                    new MoltenOreFluid.Flowing(
                            MTFluidHolders.MOLTEN_DESOLUM.properties()
                                    .bucket(MTItems.MOLTEN_DESOLUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_DESOLUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(15),
                            MTParticleTypes.MOLTEN_DESOLUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_DESOLUM::get,
                            MTSoundEvents.MOLTEN_DESOLUM_AMBIENT,
                            MTSoundEvents.MOLTEN_DESOLUM_POP));

    // Molten Prosprum
    public static final RegistryObject<FlowingFluid> MOLTEN_PROSPRUM =
            FLUIDS.register("molten_prosprum", () ->
                    new MoltenOreFluid.Source(
                            MTFluidHolders.MOLTEN_PROSPRUM.properties()
                                    .bucket(MTItems.MOLTEN_PROSPRUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_PROSPRUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(15),
                            MTParticleTypes.MOLTEN_PROSPRUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_PROSPRUM::get,
                            MTSoundEvents.MOLTEN_PROSPRUM_AMBIENT,
                            MTSoundEvents.MOLTEN_PROSPRUM_POP));
    public static final RegistryObject<FlowingFluid> MOLTEN_PROSPRUM_FLOWING =
            FLUIDS.register("molten_prosprum_flowing", () ->
                    new MoltenOreFluid.Flowing(
                            MTFluidHolders.MOLTEN_PROSPRUM.properties()
                                    .bucket(MTItems.MOLTEN_PROSPRUM_BUCKET)
                                    .block(MTBlocks.MOLTEN_PROSPRUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(15),
                            MTParticleTypes.MOLTEN_PROSPRUM::get,
                            MTParticleTypes.DRIPPING_MOLTEN_PROSPRUM::get,
                            MTSoundEvents.MOLTEN_PROSPRUM_AMBIENT,
                            MTSoundEvents.MOLTEN_PROSPRUM_POP));

    // Earthen Gum
    public static final RegistryObject<FlowingFluid> EARTHEN_GUM =
            FLUIDS.register("liquid_earthen_gum", () ->
                    new EarthenGumFluid.Source(
                            MTFluidHolders.EARTHEN_GUM.properties()
                                    .bucket(MTItems.EARTHEN_GUM_BUCKET)
                                    .block(MTBlocks.EARTHEN_GUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(30)));
    public static final RegistryObject<FlowingFluid> EARTHEN_GUM_FLOWING =
            FLUIDS.register("liquid_earthen_gum_flowing", () ->
                    new EarthenGumFluid.Flowing(
                            MTFluidHolders.EARTHEN_GUM.properties()
                                    .bucket(MTItems.EARTHEN_GUM_BUCKET)
                                    .block(MTBlocks.EARTHEN_GUM)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(30)));

    // Molten Gumbronze
    public static final RegistryObject<FlowingFluid> MOLTEN_GUMBRONZE =
            FLUIDS.register("molten_gumbronze", () ->
                    new MoltenOreFluid.Source(
                            MTFluidHolders.MOLTEN_GUMBRONZE.properties()
                                    .bucket(MTItems.MOLTEN_GUMBRONZE_BUCKET)
                                    .block(MTBlocks.MOLTEN_GUMBRONZE)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(50),
                            MTParticleTypes.MOLTEN_GUMBRONZE::get,
                            MTParticleTypes.DRIPPING_MOLTEN_GUMBRONZE::get,
                            MTSoundEvents.MOLTEN_GUMBRONZE_AMBIENT,
                            MTSoundEvents.MOLTEN_GUMBRONZE_POP));
    public static final RegistryObject<FlowingFluid> MOLTEN_GUMBRONZE_FLOWING =
            FLUIDS.register("molten_gumbronze_flowing", () ->
                    new MoltenOreFluid.Flowing(
                            MTFluidHolders.MOLTEN_GUMBRONZE.properties()
                                    .bucket(MTItems.MOLTEN_GUMBRONZE_BUCKET)
                                    .block(MTBlocks.MOLTEN_GUMBRONZE)
                                    .slopeFindDistance(2)
                                    .levelDecreasePerBlock(2)
                                    .tickRate(50),
                            MTParticleTypes.MOLTEN_GUMBRONZE::get,
                            MTParticleTypes.DRIPPING_MOLTEN_GUMBRONZE::get,
                            MTSoundEvents.MOLTEN_GUMBRONZE_AMBIENT,
                            MTSoundEvents.MOLTEN_GUMBRONZE_POP));
}
