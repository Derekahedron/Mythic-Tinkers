package derekahedron.mythictinkers.datagen.tags;

import derekahedron.mythictinkers.tinkers.modifiers.MTModifierIds;
import derekahedron.mythictinkers.tinkers.modifiers.MTModifierTags;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractModifierTagProvider;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.data.ModifierIds;

public class MTModifierTagsProvider extends AbstractModifierTagProvider {

    public MTModifierTagsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, derekahedron.mythictinkers.MythicTinkers.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return String.format("%s Modifier Tags", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addTags() {
        tag(TinkerTags.Modifiers.GENERAL_UPGRADES)
                .add(MTModifierIds.TECTONIC_SHIELD);
        tag(TinkerTags.Modifiers.RANGED_ABILITIES)
                .add(MTModifierIds.DREADSHOT);
        tag(TinkerTags.Modifiers.SPECIAL_DEFENSE)
                .add(MTModifierIds.POLYMER_PLATED);

        tag(MTModifierTags.BOONS)
                .add(MTModifierIds.BYZANTIUM_NEODYMIUM_BOON)
                .add(MTModifierIds.TECTELLUS_BOON)
                .add(MTModifierIds.ELEMENT_122_BOON)
                .add(MTModifierIds.AURICHALCUM_BOON)
                .add(MTModifierIds.PROSPRUM_BOON)
                .add(MTModifierIds.GUMBRONZE_BOON);

        tag(MTModifierTags.FERROMAGNETIC)
                .add(ModifierIds.netherite);
    }
}
