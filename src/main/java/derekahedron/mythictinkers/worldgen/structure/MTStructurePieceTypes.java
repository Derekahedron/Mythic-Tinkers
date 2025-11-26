package derekahedron.mythictinkers.worldgen.structure;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MTStructurePieceTypes {
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES
            = DeferredRegister.create(Registries.STRUCTURE_PIECE, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final RegistryObject<StructurePieceType> ATLANTEAN_RUINS =
            STRUCTURE_PIECE_TYPES.register("atlantean_ruins", () -> AtlanteanRuinsStructurePiece::create);
}
