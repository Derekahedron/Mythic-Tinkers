package derekahedron.mythictinkers.worldgen.structure;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MTStructureTypes {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES =
            DeferredRegister.create(Registries.STRUCTURE_TYPE, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final RegistryObject<StructureType<AtlanteanRuinsStructure>> ATLANTEAN_RUINS =
            STRUCTURE_TYPES.register("atlantean_ruins", () ->
                    () -> AtlanteanRuinsStructure.CODEC);
}
