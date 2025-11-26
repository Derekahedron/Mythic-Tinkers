package derekahedron.mythictinkers.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class EarthenGumOreBlockItem extends BlockItem {

    public EarthenGumOreBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack remainingStack = super.finishUsingItem(stack, level, entity);
        if (entity instanceof Player player && !player.isCreative()) {
            ItemStack gumStack = new ItemStack(MTItems.EARTHEN_GUM_WAD.get());
            if (remainingStack.isEmpty()) {
                return gumStack;
            } else if (!player.getInventory().add(gumStack)) {
                player.drop(gumStack, false);
            }
        }
        return remainingStack;
    }
}
