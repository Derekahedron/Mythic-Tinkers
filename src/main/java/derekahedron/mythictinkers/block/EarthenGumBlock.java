package derekahedron.mythictinkers.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class EarthenGumBlock extends Block {

    public EarthenGumBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isStickyBlock(BlockState state) {
        return true;
    }

    @Override
    public boolean canStickTo(BlockState state, BlockState other) {
        return (super.canStickTo(state, other) && (other.getBlock() == this || !other.isStickyBlock()));
    }
}
