package derekahedron.mythictinkers.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import slimeknights.tconstruct.library.modifiers.impl.ComposableModifier;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;
import slimeknights.tconstruct.library.module.WithHooks;

import java.util.List;

@Mixin(ComposableModifier.class)
public interface ComposableModifierAccessor {

    @Accessor(value = "modules", remap = false)
    List<WithHooks<ModifierModule>> mythictinkers$getModules();
}
