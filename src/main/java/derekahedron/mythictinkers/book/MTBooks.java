package derekahedron.mythictinkers.book;

import derekahedron.mythictinkers.client.book.ContentModifierTag;
import derekahedron.mythictinkers.util.MTUtil;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.mantle.client.book.transformer.BookTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.*;
import slimeknights.tconstruct.library.client.book.sectiontransformer.materials.TierRangeMaterialSectionTransformer;

import static slimeknights.tconstruct.shared.CommonsClientEvents.unicodeFontRender;

public class MTBooks {
    public static final ResourceLocation MYTHICAL_TINKERING =
            MTUtil.location("mythical_tinkering");

    @OnlyIn(Dist.CLIENT)
    public static void registerBooks() {
        BookLoader.registerPageType(MTUtil.location("modifier_tag"), ContentModifierTag.class);
        ToolSectionTransformer armorTransformer = new ToolSectionTransformer("armor");

        BookData legendaryTinkering = BookLoader.registerBook(MYTHICAL_TINKERING, false, false);
        legendaryTinkering.addRepository(new FileRepository(MYTHICAL_TINKERING.withPrefix("book/")));
        legendaryTinkering.fontRenderer = unicodeFontRender();
        legendaryTinkering.addTransformer(armorTransformer);
        legendaryTinkering.addTransformer(ToolSectionTransformer.INSTANCE);
        legendaryTinkering.addTransformer(BookTransformer.indexTranformer());
        legendaryTinkering.addTransformer(TierRangeMaterialSectionTransformer.INSTANCE);
        legendaryTinkering.addTransformer(BookTransformer.paddingTransformer());
    }
}
