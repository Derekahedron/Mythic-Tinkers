package derekahedron.mythictinkers.item;

import com.github.alexmodguy.alexscaves.server.item.ACItemRegistry;
import com.github.alexmodguy.alexscaves.server.misc.ACCreativeTabRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class MTCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MYTHIC_TINKERS_TAB =
            CREATIVE_MODE_TABS.register("mythic_tinkers", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.mythictinkers.mythic_tinkers"))
                            .icon(() -> MTItems.MYTHICAL_TINKERING.get().getDefaultInstance())
                            .displayItems((parameters, output) -> {
                                // Styx
                                output.accept(MTItems.MYTHICAL_TINKERING.get());
                                output.accept(MTItems.STYGIAN_DEEPSLATE.get());
                                if (ModList.get().isLoaded("deeperdarker")) {
                                    output.accept(MTItems.STYGIAN_SCULK_STONE.get());
                                    output.accept(MTItems.STYGIAN_GLOOMSLATE.get());
                                }

                                // Dombstone
                                output.accept(MTItems.DOMBSTONE.get());
                                output.accept(MTItems.DOMBSTONE_STAIRS.get());
                                output.accept(MTItems.DOMBSTONE_SLAB.get());
                                output.accept(MTItems.DOMBSTONE_WALL.get());
                                output.accept(MTItems.DOMBSTONE_BRICKS.get());
                                output.accept(MTItems.DOMBSTONE_BRICK_STAIRS.get());
                                output.accept(MTItems.DOMBSTONE_BRICK_SLAB.get());
                                output.accept(MTItems.DOMBSTONE_BRICK_WALL.get());

                                // Byzantium Neodymium
                                output.accept(MTItems.BYZANTIUM_ENERGIZED_GALENA.get());
                                output.accept(MTItems.BYZANTIUM_NEODYMIUM_NODE.get());
                                output.accept(MTItems.BYZANTIUM_NEODYMIUM_PILLAR.get());
                                output.accept(MTItems.BYZANTIUM_NEODYMIUM_BLOCK.get());
                                output.accept(MTItems.RAW_BYZANTIUM_NEODYMIUM.get());
                                output.accept(MTItems.BYZANTIUM_NEODYMIUM_NUGGET.get());
                                output.accept(MTItems.BYZANTIUM_NEODYMIUM_INGOT.get());

                                // Tectellus
                                output.accept(MTItems.TECTELLUS_BLOCK.get());
                                output.accept(MTItems.DORMANT_TECTELLUS_ORE.get());
                                output.accept(MTItems.TECTELLUS_ORE.get());
                                output.accept(MTItems.RAW_TECTELLUS_BLOCK.get());
                                output.accept(MTItems.RAW_TECTELLUS.get());
                                output.accept(MTItems.TECTELLUS_NUGGET.get());
                                output.accept(MTItems.TECTELLUS_INGOT.get());

                                // Element 122
                                output.accept(MTItems.ELEMENT_122_BLOCK.get());
                                output.accept(MTItems.ELEMENT_122_ORE.get());
                                output.accept(MTItems.RAW_ELEMENT_122_BLOCK.get());
                                output.accept(MTItems.RAW_ELEMENT_122.get());
                                output.accept(MTItems.ELEMENT_122_NUGGET.get());
                                output.accept(MTItems.ELEMENT_122_INGOT.get());

                                // Atlantean
                                output.accept(MTItems.ATLANTEAN_BRICKS.get());
                                output.accept(MTItems.CRACKED_ATLANTEAN_BRICKS.get());
                                output.accept(MTItems.ATLANTEAN_BRICK_STAIRS.get());
                                output.accept(MTItems.ATLANTEAN_BRICK_SLAB.get());
                                output.accept(MTItems.ATLANTEAN_BRICK_WALL.get());
                                output.accept(MTItems.ATLANTEAN_TILES.get());
                                output.accept(MTItems.CRACKED_ATLANTEAN_TILES.get());
                                output.accept(MTItems.ATLANTEAN_TILE_STAIRS.get());
                                output.accept(MTItems.ATLANTEAN_TILE_SLAB.get());
                                output.accept(MTItems.ATLANTEAN_TILE_WALL.get());
                                output.accept(MTItems.ATLANTEAN_PILLAR.get());
                                output.accept(MTItems.CRACKED_ATLANTEAN_PILLAR.get());

                                // Aurichalcum
                                output.accept(MTItems.AURICHALCUM_BLOCK.get());
                                output.accept(MTItems.AURICHALCUM_NUGGET.get());
                                output.accept(MTItems.AURICHALCUM_INGOT.get());

                                // Desolum
                                output.accept(MTItems.DESOLUM_BLOCK.get());
                                output.accept(MTItems.DESOLUM_NUGGET.get());
                                output.accept(MTItems.DESOLUM_INGOT.get());

                                // Pure Light
                                output.accept(MTItems.IMPRISONING_COPROLITH.get());
                                output.accept(MTItems.PURE_LIGHT.get());

                                // Prosprum
                                output.accept(MTItems.PROSPRUM_BLOCK.get());
                                output.accept(MTItems.PROSPRUM_NUGGET.get());
                                output.accept(MTItems.PROSPRUM_INGOT.get());

                                // Earthen Gum
                                output.accept(MTItems.EARTHEN_GUM_BLOCK.get());
                                output.accept(MTItems.EARTHEN_GUM_ORE.get());
                                output.accept(MTItems.EARTHEN_GUM_WAD.get());

                                // Gumbronze
                                output.accept(MTItems.GUMBRONZE_BLOCK.get());
                                output.accept(MTItems.GUMBRONZE_NUGGET.get());
                                output.accept(MTItems.GUMBRONZE_INGOT.get());

                                // Buckets
                                output.accept(MTItems.STYX_BUCKET.get());
                                output.accept(MTItems.MOLTEN_SCARLET_NEODYMIUM_BUCKET.get());
                                output.accept(MTItems.MOLTEN_AZURE_NEODYMIUM_BUCKET.get());
                                output.accept(MTItems.MOLTEN_BYZANTIUM_NEODYMIUM_BUCKET.get());
                                output.accept(MTItems.MOLTEN_TECTELLUS_BUCKET.get());
                                output.accept(MTItems.MOLTEN_ELEMENT_122_BUCKET.get());
                                output.accept(MTItems.MOLTEN_AURICHALCUM_BUCKET.get());
                                output.accept(MTItems.MOLTEN_DESOLUM_BUCKET.get());
                                output.accept(MTItems.MOLTEN_PROSPRUM_BUCKET.get());
                                output.accept(MTItems.EARTHEN_GUM_BUCKET.get());
                                output.accept(MTItems.MOLTEN_GUMBRONZE_BUCKET.get());
                            }).build());

    public static void initialize(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == ACCreativeTabRegistry.MAGNETIC_CAVES.getKey()) {
            event.getEntries().putBefore(
                    new ItemStack(ACItemRegistry.SCARLET_NEODYMIUM_INGOT.get()),
                    new ItemStack(MTItems.SCARLET_NEODYMIUM_NUGGET.get()),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putBefore(
                    new ItemStack(ACItemRegistry.AZURE_NEODYMIUM_INGOT.get()),
                    new ItemStack(MTItems.AZURE_NEODYMIUM_NUGGET.get()),
                    CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
