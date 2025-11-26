package derekahedron.mythictinkers.datagen.models;

import derekahedron.mythictinkers.item.MTItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MTItemModelProvider extends ItemModelProvider {

    public MTItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, derekahedron.mythictinkers.MythicTinkers.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(MTItems.MYTHICAL_TINKERING.get());

        basicItem(MTItems.STYX_BUCKET.get());

        basicItem(MTItems.SCARLET_NEODYMIUM_NUGGET.get());
        basicItem(MTItems.MOLTEN_SCARLET_NEODYMIUM_BUCKET.get());

        basicItem(MTItems.AZURE_NEODYMIUM_NUGGET.get());
        basicItem(MTItems.MOLTEN_AZURE_NEODYMIUM_BUCKET.get());

        basicItem(MTItems.RAW_BYZANTIUM_NEODYMIUM.get());
        basicItem(MTItems.BYZANTIUM_NEODYMIUM_NUGGET.get());
        basicItem(MTItems.BYZANTIUM_NEODYMIUM_INGOT.get());
        basicItem(MTItems.MOLTEN_BYZANTIUM_NEODYMIUM_BUCKET.get());

        basicItem(MTItems.RAW_TECTELLUS.get());
        basicItem(MTItems.TECTELLUS_NUGGET.get());
        basicItem(MTItems.TECTELLUS_INGOT.get());
        basicItem(MTItems.MOLTEN_TECTELLUS_BUCKET.get());

        basicItem(MTItems.RAW_ELEMENT_122.get());
        basicItem(MTItems.ELEMENT_122_NUGGET.get());
        basicItem(MTItems.ELEMENT_122_INGOT.get());
        basicItem(MTItems.MOLTEN_ELEMENT_122_BUCKET.get());

        basicItem(MTItems.AURICHALCUM_NUGGET.get());
        basicItem(MTItems.AURICHALCUM_INGOT.get());
        basicItem(MTItems.MOLTEN_AURICHALCUM_BUCKET.get());

        basicItem(MTItems.DESOLUM_NUGGET.get());
        basicItem(MTItems.DESOLUM_INGOT.get());
        basicItem(MTItems.MOLTEN_DESOLUM_BUCKET.get());

        basicItem(MTItems.PURE_LIGHT.get());

        basicItem(MTItems.PROSPRUM_NUGGET.get());
        basicItem(MTItems.PROSPRUM_INGOT.get());
        basicItem(MTItems.MOLTEN_PROSPRUM_BUCKET.get());

        basicItem(MTItems.EARTHEN_GUM_WAD.get());
        basicItem(MTItems.EARTHEN_GUM_BUCKET.get());

        basicItem(MTItems.GUMBRONZE_NUGGET.get());
        basicItem(MTItems.GUMBRONZE_INGOT.get());
        basicItem(MTItems.MOLTEN_GUMBRONZE_BUCKET.get());

        basicItem(MTItems.DARK_ARROW.get());
    }
}
