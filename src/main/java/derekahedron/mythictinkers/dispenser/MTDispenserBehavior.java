package derekahedron.mythictinkers.dispenser;

import derekahedron.mythictinkers.item.MTItems;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

public class MTDispenserBehavior {

    public static void initialize(FMLLoadCompleteEvent event) {
        event.enqueueWork(() -> {
            DispenserBlock.registerBehavior(MTItems.STYX_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.MOLTEN_SCARLET_NEODYMIUM_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.MOLTEN_AZURE_NEODYMIUM_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.MOLTEN_BYZANTIUM_NEODYMIUM_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.MOLTEN_TECTELLUS_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.MOLTEN_ELEMENT_122_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.MOLTEN_AURICHALCUM_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.MOLTEN_DESOLUM_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.MOLTEN_PROSPRUM_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.EARTHEN_GUM_BUCKET::get, new BucketDispenserBehvaior());
            DispenserBlock.registerBehavior(MTItems.MOLTEN_GUMBRONZE_BUCKET::get, new BucketDispenserBehvaior());
        });
    }
}
