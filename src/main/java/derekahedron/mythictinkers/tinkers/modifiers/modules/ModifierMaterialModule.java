package derekahedron.mythictinkers.tinkers.modifiers.modules;

import derekahedron.mythictinkers.util.MTUtil;
import slimeknights.mantle.data.loadable.record.RecordLoadable;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.ModifierTraitHook;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.HookProvider;
import slimeknights.tconstruct.library.module.ModuleHook;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;

import java.util.List;

public record ModifierMaterialModule(MaterialId material) implements ModifierModule, ModifierTraitHook {
    public static final List<ModuleHook<?>> DEFAULT_HOOKS =
            HookProvider.defaultHooks(ModifierHooks.MODIFIER_TRAITS);
    public static final RecordLoadable<ModifierMaterialModule> LOADER =
            RecordLoadable.create(
                    MaterialId.PARSER.tryDirectField("material_id", ModifierMaterialModule::material),
                    ModifierMaterialModule::new);

    @Override
    public RecordLoadable<ModifierMaterialModule> getLoader() {
        return LOADER;
    }

    @Override
    public void addTraits(IToolContext context, ModifierEntry self, ModifierTraitHook.TraitBuilder builder, boolean firstEncounter) {
        builder.add(MTUtil.getMaterialModifiers(material, context.getDefinition()));
    }

    @Override
    public List<ModuleHook<?>> getDefaultHooks() {
        return DEFAULT_HOOKS;
    }
}
