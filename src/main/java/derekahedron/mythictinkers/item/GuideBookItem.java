package derekahedron.mythictinkers.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.BookScreenOpener;
import slimeknights.mantle.item.AbstractBookItem;

import java.util.Objects;

public class GuideBookItem extends AbstractBookItem {
    public final ResourceLocation book;

    public GuideBookItem(ResourceLocation book, Properties properties) {
        super(properties);
        this.book = book;
    }

    @Override
    public BookScreenOpener getBook(ItemStack stack) {
        return Objects.requireNonNull(BookLoader.getBook(book));
    }
}
