package derekahedron.mythictinkers.tinkers.modifiers;

import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.StaticModifier;

public class MTModifiers {
    public static final ModifierDeferredRegister MODIFIERS =
            ModifierDeferredRegister.create(derekahedron.mythictinkers.MythicTinkers.MOD_ID);

    public static final StaticModifier<TesseractedModifier> TESSERACTED =
            MODIFIERS.register("tesseracted", TesseractedModifier::new);

    public static final StaticModifier<TectonicShieldModifier> TECTONIC_SHIELD =
            MODIFIERS.register("tectonic_shield", TectonicShieldModifier::new);

    public static final StaticModifier<AeroformingModifier> AEROFORMING =
            MODIFIERS.register("aeroforming", AeroformingModifier::new);
    public static final StaticModifier<TerraformidableModifier> TERRAFORMIDABLE =
            MODIFIERS.register("terraformidable", TerraformidableModifier::new);

    public static final StaticModifier<RadioactiveModifier> RADIOACTIVE =
            MODIFIERS.register("radioactive", RadioactiveModifier::new);

    public static final StaticModifier<DesolateModifier> DESOLATE =
            MODIFIERS.register("desolate", DesolateModifier::new);
    public static final StaticModifier<DarknessProtectionModifier> DARKNESS_PROTECTION =
            MODIFIERS.register("darkness_protection", DarknessProtectionModifier::new);

    public static final StaticModifier<DarkArrowsModifier> DARK_ARROWS =
            MODIFIERS.register("dark_arrows", DarkArrowsModifier::new);

    public static final StaticModifier<DreadshotModifier> DREADSHOT =
            MODIFIERS.register("dreadshot", DreadshotModifier::new);

    public static final StaticModifier<VengefulStrikeModifier> VENGEFUL_STRIKE =
            MODIFIERS.register("vengeful_strike", VengefulStrikeModifier::new);
    public static final StaticModifier<VengefulShotModifier> VENGEFUL_SHOT =
            MODIFIERS.register("vengeful_shot", VengefulShotModifier::new);
    public static final StaticModifier<RetributionModifier> RETRIBUTION =
            MODIFIERS.register("retribution", RetributionModifier::new);

    public static final StaticModifier<GumbreakableModifier> GUMBREAKABLE =
            MODIFIERS.register("gumbreakable", GumbreakableModifier::new);
}
