package derekahedron.mythictinkers.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;

public class DropFluidAndExperienceBlock extends DropExperienceBlock {
    public final FlowingFluid fluid;

    public DropFluidAndExperienceBlock(FlowingFluid fluid, Properties properties, IntProvider xpRange) {
        super(properties, xpRange);
        this.fluid = fluid;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void spawnAfterBreak(BlockState state, ServerLevel level, BlockPos pos, ItemStack stack, boolean p_222953_) {
        super.spawnAfterBreak(state, level, pos, stack, p_222953_);
        if (level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)
                && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            level.setBlock(pos, fluid.defaultFluidState().createLegacyBlock(), 11);
        }
    }
}
