package derekahedron.mythictinkers.datagen.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class MTLootTableProvider extends LootTableProvider {

    public MTLootTableProvider(PackOutput output) {
        super(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(MTBlockLoot::new, LootContextParamSets.BLOCK)));
    }
}
