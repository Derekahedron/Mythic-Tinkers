package derekahedron.mythictinkers.tinkers.modifiers.modules;

import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.library.json.LevelingInt;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.VolatileDataModifierHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.modifiers.modules.util.ModifierCondition;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.ToolDataNBT;

import java.util.List;

public record LevelingModifierSlotModule(SlotType type, LevelingInt count, ModifierCondition<IToolContext> condition)
        implements VolatileDataModifierHook, ModifierModule, ModifierCondition.ConditionalModule<IToolContext> {
    public static final List<ModuleHook<?>> DEFAULT_HOOKS =
            HookProvider.defaultHooks(ModifierHooks.VOLATILE_DATA);
    public static final RecordLoadable<LevelingModifierSlotModule> LOADER =
            RecordLoadable.create(
                    SlotType.LOADABLE.requiredField("name", LevelingModifierSlotModule::type),
                    LevelingInt.LOADABLE.requiredField("count", LevelingModifierSlotModule::count),
                    ModifierCondition.CONTEXT_FIELD, LevelingModifierSlotModule::new);

    public LevelingModifierSlotModule(SlotType type, LevelingInt count) {
        this(type, count, ModifierCondition.ANY_CONTEXT);
    }

    @Override
    public Integer getPriority() {
        return 50;
    }

    @Override
    public void addVolatileData(IToolContext context, ModifierEntry modifier, ToolDataNBT volatileData) {
        if (condition.matches(context, modifier)) {
            volatileData.addSlots(type, count.compute(modifier.getLevel()));
        }
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }

    @Override
    public RecordLoadable<LevelingModifierSlotModule> getLoader() {
        return LOADER;
    }
}
