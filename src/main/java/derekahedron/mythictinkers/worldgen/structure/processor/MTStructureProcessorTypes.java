package derekahedron.mythictinkers.worldgen.structure.processor;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MTStructureProcessorTypes {
    public static final DeferredRegister<StructureProcessorType<?>> STRUCTURE_PROCESSOR_TYPES =
            DeferredRegister.create(Registries.STRUCTURE_PROCESSOR, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final RegistryObject<StructureProcessorType<AtlanteanRuinsProcessor>> ATLANTEAN_RUINS =
            STRUCTURE_PROCESSOR_TYPES.register("atlantean_ruins", () ->
                    () -> AtlanteanRuinsProcessor.CODEC);
}
