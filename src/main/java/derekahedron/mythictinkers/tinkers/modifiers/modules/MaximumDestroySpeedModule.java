package derekahedron.mythictinkers.tinkers.modifiers.modules;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.entity.player.PlayerEvent;
import slimeknights.mantle.data.loadable.primitive.FloatLoadable;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.mantle.data.predicate.IJsonPredicate;
import slimeknights.mantle.data.predicate.block.BlockPredicate;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedContext;
import slimeknights.tconstruct.library.modifiers.hook.mining.BreakSpeedModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.List;

public record MaximumDestroySpeedModule(float destroySpeed, IJsonPredicate<BlockState> block) implements ModifierModule, BreakSpeedModifierHook {
    public static final List<ModuleHook<?>> DEFAULT_HOOKS =
            HookProvider.defaultHooks(ModifierHooks.BREAK_SPEED);
    public static final RecordLoadable<MaximumDestroySpeedModule> LOADER =
            RecordLoadable.create(
                    FloatLoadable.FROM_ZERO.requiredField("break_speed", MaximumDestroySpeedModule::destroySpeed),
                    BlockPredicate.LOADER.defaultField("block", MaximumDestroySpeedModule::block),
                    MaximumDestroySpeedModule::new);

    public void onBreakSpeed(IToolStackView var1, ModifierEntry var2, PlayerEvent.BreakSpeed var3, Direction var4, boolean var5, float var6) {}

    public float modifyBreakSpeed(
            IToolStackView tool, ModifierEntry modifier, BreakSpeedContext context, float speed) {
        BlockPos pos = context.pos();
        if (pos == null) return speed;
        if (!ForgeHooks.isCorrectToolForDrops(context.state(), context.player())) return speed;

        float destroySpeed = context.state().getDestroySpeed(context.player().level(), pos);
        if (this.destroySpeed > destroySpeed) return speed;
        if (!block.matches(context.state())) return speed;

        return speed * destroySpeed / this.destroySpeed;
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
