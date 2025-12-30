package derekahedron.mythictinkers.datagen.advancements;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.item.MTItems;
import derekahedron.mythictinkers.tinkers.materials.MTMaterialIds;
import derekahedron.mythictinkers.util.MTUtil;
import com.google.common.collect.ImmutableSet;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import slimeknights.tconstruct.library.json.predicate.tool.HasMaterialPredicate;
import slimeknights.tconstruct.library.json.predicate.tool.ToolStackItemPredicate;

import java.util.function.Consumer;

public class MTAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {
    public static final ResourceLocation FOLDER = MTUtil.location(MythicTinkers.MOD_ID + "/");

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
        Advancement root = Advancement.Builder.advancement()
                .display(
                        MTItems.MYTHICAL_TINKERING.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".root.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".root.description"),
                        MTUtil.location("textures/gui/advancements/backgrounds/" + MythicTinkers.MOD_ID + ".png"),
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "get_legendary_tinkering",
                        InventoryChangeTrigger.TriggerInstance.hasItems(MTItems.MYTHICAL_TINKERING.get()))
                .save(saver, FOLDER.withSuffix("root").toString());

        Advancement.Builder.advancement()
                .parent(root)
                .display(
                        MTItems.STYX_BUCKET.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".find_styx.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".find_styx.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "get_styx_bucket",
                        InventoryChangeTrigger.TriggerInstance.hasItems(MTItems.STYX_BUCKET.get()))
                .save(saver, FOLDER.withSuffix("find_styx").toString());

        Advancement.Builder.advancement()
                .parent(root)
                .display(
                        MTItems.DOMBSTONE.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_dombstone.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_dombstone.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "get_dombstone",
                        InventoryChangeTrigger.TriggerInstance.hasItems(MTItems.DOMBSTONE.get()))
                .save(saver, FOLDER.withSuffix("mine_dombstone").toString());

        Advancement mineByzantiumNeodymium = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        MTItems.RAW_BYZANTIUM_NEODYMIUM.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_byzantium_neodymium.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_byzantium_neodymium.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "has_byzantium_neodymium",
                        InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(
                                null,
                                ImmutableSet.of(
                                        MTItems.RAW_BYZANTIUM_NEODYMIUM.get(),
                                        MTItems.BYZANTIUM_NEODYMIUM_NODE.get(),
                                        MTItems.BYZANTIUM_NEODYMIUM_PILLAR.get()),
                                MinMaxBounds.Ints.ANY,
                                MinMaxBounds.Ints.ANY,
                                EnchantmentPredicate.NONE,
                                EnchantmentPredicate.NONE,
                                null,
                                NbtPredicate.ANY)))
                .save(saver, FOLDER.withSuffix("mine_byzantium_neodymium").toString());

        Advancement.Builder.advancement()
                .parent(mineByzantiumNeodymium)
                .display(
                        MTItems.BYZANTIUM_NEODYMIUM_INGOT.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".byzantium_neodymium_tool.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".byzantium_neodymium_tool.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "has_byzantium_neodymium_tool",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ToolStackItemPredicate.ofContext(new HasMaterialPredicate(MTMaterialIds.BYZANTIUM_NEODYMIUM))))
                .save(saver, FOLDER.withSuffix("byzantium_neodymium_tool").toString());

        Advancement mineTectellus = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        MTItems.RAW_TECTELLUS.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_tectellus.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_tectellus.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "get_tectellus",
                        InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(
                                null,
                                ImmutableSet.of(
                                        MTItems.TECTELLUS_ORE.get(),
                                        MTItems.RAW_TECTELLUS.get()),
                                MinMaxBounds.Ints.ANY,
                                MinMaxBounds.Ints.ANY,
                                EnchantmentPredicate.NONE,
                                EnchantmentPredicate.NONE,
                                null,
                                NbtPredicate.ANY)))
                .save(saver, FOLDER.withSuffix("mine_tectellus").toString());

        Advancement.Builder.advancement()
                .parent(mineTectellus)
                .display(
                        MTItems.TECTELLUS_INGOT.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".tectellus_tool.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".tectellus_tool.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "craft_tectellus_tool",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ToolStackItemPredicate.ofContext(new HasMaterialPredicate(MTMaterialIds.TECTELLUS))))
                .save(saver, FOLDER.withSuffix("tectellus_tool").toString());

        Advancement mineElement122 = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        MTItems.RAW_ELEMENT_122.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_element_122.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_element_122.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "get_raw_element_122",
                        InventoryChangeTrigger.TriggerInstance.hasItems(MTItems.RAW_ELEMENT_122.get()))
                .save(saver, FOLDER.withSuffix("mine_element_122").toString());

        Advancement.Builder.advancement()
                .parent(mineElement122)
                .display(
                        MTItems.ELEMENT_122_INGOT.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".element_122_tool.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".element_122_tool.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "craft_element_122_tool",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ToolStackItemPredicate.ofContext(new HasMaterialPredicate(MTMaterialIds.ELEMENT_122))))
                .save(saver, FOLDER.withSuffix("element_122_tool").toString());

        Advancement findAtlanteanRuins = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        MTItems.ATLANTEAN_BRICKS.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".find_atlantean_ruins.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".find_atlantean_ruins.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "atlantean_ruins",
                        PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(ResourceKey.create(Registries.STRUCTURE, MTUtil.location("atlantean_ruins")))))
                .save(saver, FOLDER.withSuffix("find_atlantean_ruins").toString());

        Advancement.Builder.advancement()
                .parent(findAtlanteanRuins)
                .display(
                        MTItems.AURICHALCUM_INGOT.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".aurichalcum_tool.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".aurichalcum_tool.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "craft_aurichalcum_tool",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ToolStackItemPredicate.ofContext(new HasMaterialPredicate(MTMaterialIds.AURICHALCUM))))
                .save(saver, FOLDER.withSuffix("aurichalcum_tool").toString());

        Advancement minePureLight = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        MTItems.PURE_LIGHT.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_pure_light.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_pure_light.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "get_pure_light",
                        InventoryChangeTrigger.TriggerInstance.hasItems(MTItems.PURE_LIGHT.get()))
                .save(saver, FOLDER.withSuffix("mine_pure_light").toString());

        Advancement purifyDesolum = Advancement.Builder.advancement()
                .parent(minePureLight)
                .display(
                        MTItems.PROSPRUM_INGOT.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".purify_desolum.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".purify_desolum.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "get_prosprum_ingot",
                        InventoryChangeTrigger.TriggerInstance.hasItems(MTItems.PROSPRUM_INGOT.get()))
                .save(saver, FOLDER.withSuffix("purify_desolum").toString());

        Advancement.Builder.advancement()
                .parent(purifyDesolum)
                .display(
                        MTItems.PROSPRUM_INGOT.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".prosprum_tool.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".prosprum_tool.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "craft_prosprum_tool",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ToolStackItemPredicate.ofContext(new HasMaterialPredicate(MTMaterialIds.PROSPRUM))))
                .save(saver, FOLDER.withSuffix("prosprum_tool").toString());

        Advancement mineEarthenGum = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        MTItems.EARTHEN_GUM_WAD.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_earthen_gum.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".mine_earthen_gum.description"),
                        null,
                        FrameType.TASK,
                        true,
                        true,
                        false)
                .addCriterion(
                        "get_earthen_gum",
                        InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(
                                null,
                                ImmutableSet.of(
                                        MTItems.EARTHEN_GUM_ORE.get(),
                                        MTItems.EARTHEN_GUM_WAD.get()),
                                MinMaxBounds.Ints.ANY,
                                MinMaxBounds.Ints.ANY,
                                EnchantmentPredicate.NONE,
                                EnchantmentPredicate.NONE,
                                null,
                                NbtPredicate.ANY)))
                .save(saver, FOLDER.withSuffix("mine_earthen_gum").toString());

        Advancement.Builder.advancement()
                .parent(mineEarthenGum)
                .display(
                        MTItems.GUMBRONZE_INGOT.get(),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".gumbronze_tool.title"),
                        Component.translatable("advancements." + MythicTinkers.MOD_ID + ".gumbronze_tool.description"),
                        null,
                        FrameType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion(
                        "craft_gumbronze_tool",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ToolStackItemPredicate.ofContext(new HasMaterialPredicate(MTMaterialIds.GUMBRONZE))))
                .save(saver, FOLDER.withSuffix("gumbronze_tool").toString());
    }
}
