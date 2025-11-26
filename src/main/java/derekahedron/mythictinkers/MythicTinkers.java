package derekahedron.mythictinkers;

import derekahedron.mythictinkers.block.MTBlocks;
import derekahedron.mythictinkers.dispenser.MTDispenserBehavior;
import derekahedron.mythictinkers.fluid.MTFluidInteractions;
import derekahedron.mythictinkers.fluid.MTFluidTypes;
import derekahedron.mythictinkers.fluid.MTFluids;
import derekahedron.mythictinkers.item.MTItems;
import derekahedron.mythictinkers.item.MTCreativeTabs;
import derekahedron.mythictinkers.network.MTPacketHandler;
import derekahedron.mythictinkers.particle.MTParticleTypes;
import derekahedron.mythictinkers.potion.MTEffects;
import derekahedron.mythictinkers.recipe.MTRecipeSerializers;
import derekahedron.mythictinkers.tinkers.modifiers.MTModifiers;
import derekahedron.mythictinkers.util.MTSoundEvents;
import derekahedron.mythictinkers.worldgen.feature.MTFeatures;
import derekahedron.mythictinkers.worldgen.structure.MTStructurePieceTypes;
import derekahedron.mythictinkers.worldgen.structure.MTStructureTypes;
import derekahedron.mythictinkers.worldgen.structure.processor.MTStructureProcessorTypes;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MythicTinkers.MOD_ID)
public class MythicTinkers
{
    public static final String MOD_ID = "mythictinkers";
    public static final String MOD_NAME = "Mythic Tinkers";
    private static final Logger LOGGER = LogUtils.getLogger();


    @SuppressWarnings("forremoval")
    public MythicTinkers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MTBlocks.BLOCKS.register(modEventBus);
        MTItems.ITEMS.register(modEventBus);
        MTFluidTypes.FLUID_TYPES.register(modEventBus);
        MTFluids.FLUIDS.register(modEventBus);
        MTCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        MTModifiers.MODIFIERS.register(modEventBus);
        MTEffects.MOB_EFFECTS.register(modEventBus);
        MTParticleTypes.PARTICLE_TYPES.register(modEventBus);
        MTRecipeSerializers.RECIPE_SERIALIZERS.register(modEventBus);
        MTFeatures.FEATURES.register(modEventBus);
        MTSoundEvents.SOUND_EVENTS.register(modEventBus);
        MTStructureTypes.STRUCTURE_TYPES.register(modEventBus);
        MTStructurePieceTypes.STRUCTURE_PIECE_TYPES.register(modEventBus);
        MTStructureProcessorTypes.STRUCTURE_PROCESSOR_TYPES.register(modEventBus);

        modEventBus.addListener(MTFluidInteractions::initialize);
        modEventBus.addListener(MTPacketHandler::initialize);
        modEventBus.addListener(MTCreativeTabs::initialize);
        modEventBus.addListener(MTDispenserBehavior::initialize);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
