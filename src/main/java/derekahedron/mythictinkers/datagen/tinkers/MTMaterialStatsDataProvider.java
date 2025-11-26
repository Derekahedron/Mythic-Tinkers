package derekahedron.mythictinkers.datagen.tinkers;

import derekahedron.mythictinkers.tinkers.materials.MTMaterialIds;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Tiers;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

public class MTMaterialStatsDataProvider extends AbstractMaterialStatsDataProvider {

    public MTMaterialStatsDataProvider(PackOutput output, AbstractMaterialDataProvider materials) {
        super(output, materials);
    }

    @Override
    public String getName() {
        return String.format("%s Material Stats", derekahedron.mythictinkers.MythicTinkers.MOD_NAME);
    }

    @Override
    protected void addMaterialStats() {
        addMeleeHarvest();
        addRanged();
        addArmor();
    }

    private void addMeleeHarvest() {
        addMaterialStats(MTMaterialIds.SCARLET_NEODYMIUM,
                new HeadMaterialStats(
                        220,
                        6.0F,
                        Tiers.IRON,
                        1.75F),
                HandleMaterialStats.multipliers()
                        .durability(1.0F)
                        .miningSpeed(1.05F)
                        .attackSpeed(0.95F)
                        .attackDamage(0.95F)
                        .build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(MTMaterialIds.AZURE_NEODYMIUM,
                new HeadMaterialStats(
                        220,
                        6.0F,
                        Tiers.IRON,
                        1.75F),
                HandleMaterialStats.multipliers()
                        .durability(1.0F)
                        .miningSpeed(1.05F)
                        .attackSpeed(0.95F)
                        .attackDamage(0.95F)
                        .build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(MTMaterialIds.BYZANTIUM_NEODYMIUM,
                new HeadMaterialStats(
                        780,
                        7.5F,
                        Tiers.NETHERITE,
                        3.0F),
                HandleMaterialStats.multipliers()
                        .durability(0.95F)
                        .miningSpeed(1.1F)
                        .attackSpeed(1.2F)
                        .attackDamage(1.0F)
                        .build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(MTMaterialIds.TECTELLUS,
                new HeadMaterialStats(
                        1075,
                        8.0F,
                        Tiers.NETHERITE,
                        4.0F),
                HandleMaterialStats.multipliers()
                        .durability(1.05F)
                        .miningSpeed(1.15F)
                        .attackSpeed(0.70F)
                        .attackDamage(1.2F)
                        .build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(MTMaterialIds.ELEMENT_122,
                new HeadMaterialStats(
                        1550,
                        10.0F,
                        Tiers.NETHERITE,
                        5.5F),
                HandleMaterialStats.multipliers()
                        .durability(1.15F)
                        .miningSpeed(1.25F)
                        .attackSpeed(1.25F)
                        .attackDamage(1.35F)
                        .build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(MTMaterialIds.AURICHALCUM,
                new HeadMaterialStats(
                        1000,
                        7.0F,
                        Tiers.NETHERITE,
                        3.5F),
                HandleMaterialStats.multipliers()
                        .durability(1.0F)
                        .miningSpeed(1.0F)
                        .attackSpeed(1.0F)
                        .attackDamage(1.0F)
                        .build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(MTMaterialIds.DESOLUM,
                new HeadMaterialStats(
                        360,
                        4.0F,
                        Tiers.NETHERITE,
                        2.0F),
                HandleMaterialStats.multipliers()
                        .durability(0.9F)
                        .miningSpeed(0.8F)
                        .attackSpeed(1.3F)
                        .attackDamage(1.0F)
                        .build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(MTMaterialIds.PROSPRUM,
                new HeadMaterialStats(
                        1170,
                        6.5F,
                        Tiers.NETHERITE,
                        4.0F),
                HandleMaterialStats.multipliers()
                        .durability(0.95F)
                        .miningSpeed(1.0F)
                        .attackSpeed(1.1F)
                        .attackDamage(1.2F)
                        .build(),
                StatlessMaterialStats.BINDING);

        addMaterialStats(MTMaterialIds.GUMBRONZE,
                new HeadMaterialStats(
                        1800,
                        7.5F,
                        Tiers.NETHERITE,
                        3.0F),
                HandleMaterialStats.multipliers()
                        .durability(1.4F)
                        .miningSpeed(1.05F)
                        .attackSpeed(1.0F)
                        .attackDamage(1.05F)
                        .build(),
                StatlessMaterialStats.BINDING);
    }

    private void addRanged() {
        addMaterialStats(MTMaterialIds.SCARLET_NEODYMIUM,
                new LimbMaterialStats(
                        220,
                        -0.15F,
                        0.05F,
                        0.05F),
                new GripMaterialStats(
                        0.0F,
                        -0.05F,
                        1.75F));

        addMaterialStats(MTMaterialIds.AZURE_NEODYMIUM,
                new LimbMaterialStats(
                        220,
                        -0.15F,
                        0.05F,
                        0.05F),
                new GripMaterialStats(
                        0.0F,
                        -0.05F,
                        1.75F));

        addMaterialStats(MTMaterialIds.BYZANTIUM_NEODYMIUM,
                new LimbMaterialStats(
                        780,
                        0.05F,
                        0.05F,
                        0.15F),
                new GripMaterialStats(
                        -0.05F,
                        -0.2F,
                        3.0F));

        addMaterialStats(MTMaterialIds.TECTELLUS,
                new LimbMaterialStats(
                        1075,
                        -0.35F,
                        0.3F,
                        -0.1F),
                new GripMaterialStats(
                        0.05F,
                        0.05F,
                        4.0F));

        addMaterialStats(MTMaterialIds.ELEMENT_122,
                new LimbMaterialStats(
                        1150,
                        0.25F,
                        0.35F,
                        0.2F),
                new GripMaterialStats(
                        0.15F,
                        0.2F,
                        5.5F));

        addMaterialStats(MTMaterialIds.AURICHALCUM,
                new LimbMaterialStats(
                        1000,
                        0.0F,
                        0.0F,
                        0.0F),
                new GripMaterialStats(
                        0.0F,
                        0.0F,
                        3.5F));

        addMaterialStats(MTMaterialIds.DESOLUM,
                new LimbMaterialStats(
                        360,
                        0.2F,
                        0.25F,
                        -0.2F),
                new GripMaterialStats(
                        -0.1F,
                        -0.15F,
                        2.0F));

        addMaterialStats(MTMaterialIds.SHADOW_SILK,
                StatlessMaterialStats.BOWSTRING);

        addMaterialStats(MTMaterialIds.PROSPRUM,
                new LimbMaterialStats(
                        1170,
                        0.15F,
                        0.25F,
                        0.2F),
                new GripMaterialStats(
                        -0.05F,
                        0.1F,
                        4.0F));

        addMaterialStats(MTMaterialIds.GUMBRONZE,
                new LimbMaterialStats(
                        1800,
                        0.05F,
                        0.05F,
                        0.0F),
                new GripMaterialStats(
                        0.4F,
                        0.0F,
                        3.0F));
    }

    private void addArmor() {
        addArmorShieldStats(MTMaterialIds.SCARLET_NEODYMIUM,
                PlatingMaterialStats.builder()
                        .durabilityFactor(14.0F)
                        .armor(1.0F, 4.0F, 5.0F, 2.0F)
                        .toughness(0.0F)
                        .knockbackResistance(0.0F),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(MTMaterialIds.AZURE_NEODYMIUM,
                PlatingMaterialStats.builder()
                        .durabilityFactor(14.0F)
                        .armor(1.0F, 4.0F, 5.0F, 2.0F)
                        .toughness(0.0F)
                        .knockbackResistance(0.0F),
                StatlessMaterialStats.MAILLE);

        addArmorStats(MTMaterialIds.BYZANTIUM_NEODYMIUM,
                PlatingMaterialStats.builder()
                        .durabilityFactor(28.0F)
                        .armor(2.0F, 5.0F, 7.0F, 2.0F)
                        .toughness(1.0F)
                        .knockbackResistance(0.0F),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(MTMaterialIds.TECTELLUS,
                PlatingMaterialStats.builder()
                        .durabilityFactor(31.0F)
                        .armor(2.0F, 5.0F, 7.0F, 2.0F)
                        .toughness(3.0F)
                        .knockbackResistance(0.15F),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(MTMaterialIds.ELEMENT_122,
                PlatingMaterialStats.builder()
                        .durabilityFactor(40.0F)
                        .armor(3.0F, 6.0F, 8.0F, 3.0F)
                        .toughness(5.0F)
                        .knockbackResistance(0.2F),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(MTMaterialIds.AURICHALCUM,
                PlatingMaterialStats.builder()
                        .durabilityFactor(33.0F)
                        .armor(2.0F, 5.0F, 7.0F, 2.0F)
                        .toughness(2.0F)
                        .knockbackResistance(0.05F),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(MTMaterialIds.DESOLUM,
                PlatingMaterialStats.builder()
                        .durabilityFactor(16.0F)
                        .armor(2.0F, 3.0F, 5.0F, 2.0F)
                        .toughness(0.0F)
                        .knockbackResistance(0.0F),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(MTMaterialIds.PROSPRUM,
                PlatingMaterialStats.builder()
                        .durabilityFactor(34.0F)
                        .armor(2.0F, 5.0F, 7.0F, 2.0F)
                        .toughness(3.0F)
                        .knockbackResistance(0.1F),
                StatlessMaterialStats.MAILLE);

        addArmorShieldStats(MTMaterialIds.GUMBRONZE,
                PlatingMaterialStats.builder()
                        .durabilityFactor(65.0F)
                        .armor(2.0F, 5.0F, 7.0F, 2.0F)
                        .toughness(2.0F)
                        .knockbackResistance(0.2F),
                StatlessMaterialStats.MAILLE);
    }
}
