package derekahedron.mythictinkers.tinkers.modifiers.modules;

import derekahedron.mythictinkers.tinkers.hooks.DestroySpeedModifierHook;
import derekahedron.mythictinkers.tinkers.hooks.MTModifierHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import slimeknights.mantle.data.loadable.primitive.FloatLoadable;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.mantle.data.predicate.IJsonPredicate;
import slimeknights.mantle.data.predicate.block.BlockPredicate;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public record MaximumDestroySpeedModule(float destroySpeed, IJsonPredicate<BlockState> block) implements ModifierModule, DestroySpeedModifierHook {
    public static final List<ModuleHook<?>> DEFAULT_HOOKS =
            HookProvider.defaultHooks(MTModifierHooks.DESTROY_SPEED);
    public static final RecordLoadable<MaximumDestroySpeedModule> LOADER =
            RecordLoadable.create(
                    FloatLoadable.FROM_ZERO.requiredField("break_speed", MaximumDestroySpeedModule::destroySpeed),
                    BlockPredicate.LOADER.defaultField("block", MaximumDestroySpeedModule::block),
                    MaximumDestroySpeedModule::new);

    public float onDestroySpeed(IToolStackView tool, ModifierEntry modifier, Player player, BlockState state,
                                float baseSpeed, boolean correctForDrops, BlockGetter level, BlockPos pos) {
        return (correctForDrops && baseSpeed > destroySpeed && block.matches(state))
                ? destroySpeed
                : baseSpeed;
    }

    @Override
    public RecordLoadable<MaximumDestroySpeedModule> getLoader() {
        return LOADER;
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }
}
