package derekahedron.mythictinkers.client.book;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.data.content.PageContent;
import slimeknights.mantle.client.book.data.element.ImageData;
import slimeknights.mantle.client.book.data.element.TextData;
import slimeknights.mantle.client.screen.book.ArrowButton;
import slimeknights.mantle.client.screen.book.BookScreen;
import slimeknights.mantle.client.screen.book.element.BookElement;
import slimeknights.mantle.client.screen.book.element.ImageElement;
import slimeknights.mantle.client.screen.book.element.TextElement;
import slimeknights.mantle.recipe.helper.RecipeHelper;
import slimeknights.mantle.util.ItemStackList;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.client.book.content.ContentModifier;
import slimeknights.tconstruct.library.client.book.elements.TinkerItemElement;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierManager;
import slimeknights.tconstruct.library.recipe.TinkerRecipeTypes;
import slimeknights.tconstruct.library.recipe.modifiers.adding.IDisplayModifierRecipe;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContentModifierTag extends PageContent {
    private static final String KEY_EFFECTS = TConstruct.makeTranslationKey("book", "modifiers.effect");
    private @Nullable List<IDisplayModifierRecipe> recipes;
    private @Nullable transient TagKey<Item> toolFilterTag;
    private transient int currentRecipe = 0;
    private final transient List<BookElement> parts = new ArrayList<>();
    private @Nullable transient List<Modifier> modifiers;
    public @Nullable TextData[] text;
    public @Nullable String title;
    public @Nullable String[] effects;
    public boolean more_text_space = false;
    @SerializedName("tool_filter")
    public @Nullable String toolFilter = null;
    @SerializedName("modifiers")
    public @Nullable String modifiersTagId;

    public List<Modifier> getModifiers() {
        if (modifiers == null) {
            modifiers = modifiersTagId == null
                    ? List.of()
                    : ModifierManager.getTagValues(ModifierManager.getTag(new ResourceLocation(modifiersTagId)));
        }

        return modifiers;
    }

    @Nullable
    public TagKey<Item> getToolFilterTag() {
        if (toolFilter == null) {
            return null;
        } else {
            if (toolFilterTag == null) {
                toolFilterTag = TagKey.create(Registries.ITEM, new ResourceLocation(toolFilter));
            }

            return toolFilterTag;
        }
    }

    @Override
    public String getTitle() {
        return title != null ? title : "";
    }

    @Override
    public void load() {
        if (recipes == null) {
            recipes = new ArrayList<>();
            Level level = Minecraft.getInstance().level;
            assert level != null;
            for (Modifier modifier : getModifiers()) {
                recipes.addAll(RecipeHelper.getJEIRecipes(
                        level.registryAccess(),
                        level.getRecipeManager(),
                        TinkerRecipeTypes.TINKER_STATION.get(),
                        IDisplayModifierRecipe.class
                ).stream()
                        .filter((recipe) -> recipe.getDisplayResult().matches(modifier))
                        .toList());
            }
        }
    }

    @Override
    public void build(BookData book, ArrayList<BookElement> list, boolean brightSide) {
        Objects.requireNonNull(recipes);
        addTitle(list, getTitle(), false);
        int y = getTitleHeight();
        int h = more_text_space ? 70 : 50;
        if (text != null) {
            list.add(new TextElement(5, y, 172, h, text));
        }
        if (effects != null && effects.length > 0) {
            TextData head = new TextData(I18n.get(KEY_EFFECTS));
            head.underlined = true;
            list.add(new TextElement(5, y + h, 86, 176 - h - 20, head));
            List<TextData> effectData = Lists.newArrayList();

            for (String effect : effects) {
                effectData.add(new TextData("● "));
                effectData.add(new TextData(effect));
                effectData.add(new TextData("\n"));
            }

            list.add(new TextElement(5, y + 14 + h, 96, 176 - h - 20, effectData));
        }

        int size = recipes.size();
        if (size > 0) {
            if (size > 1) {
                int col = book.appearance.structureButtonColor;
                int colHover = book.appearance.structureButtonColorHovered;
                list.add(new CycleRecipeTagElement(
                        182 - ArrowButton.ArrowType.RIGHT.w - 32,
                        160, ArrowButton.ArrowType.RIGHT,
                        col,
                        colHover,
                        this,
                        book,
                        list));
            }

            buildAndAddRecipeDisplay(book, list, recipes.get(currentRecipe), null);
        }
    }

    public void buildAndAddRecipeDisplay(
            BookData book, ArrayList<BookElement> list, @Nullable IDisplayModifierRecipe recipe, @Nullable BookScreen parent) {
        if (recipe != null) {
            int inputs = recipe.getInputCount();
            ImageData img = ContentModifier.IMG_SLOTS[Math.min(inputs - 1, 4)];
            if (inputs > 5) {
                TConstruct.LOG.warn("Too many inputs in recipe {}, size {}", recipe, inputs);
            }

            int[] slotsX = ContentModifier.SLOTS_X;
            int[] slotsY = ContentModifier.SLOTS_Y;
            if (inputs == 4) {
                slotsX = ContentModifier.SLOTS_X_4;
                slotsY = ContentModifier.SLOTS_Y_4;
            }

            int imgX = 111;
            int imgY = 118;
            imgX += 29 - img.width / 2;
            imgY += 20 - img.height / 2;
            ImageElement table = new ImageElement(
                    imgX + (img.width - ContentModifier.IMG_TABLE.width) / 2,
                    imgY - 24,
                    -1,
                    -1,
                    ContentModifier.IMG_TABLE);
            table.parent = parent;
            parts.add(table);
            list.add(table);
            ImageElement slot = new ImageElement(
                    imgX,
                    imgY,
                    -1,
                    -1,
                    img,
                    book.appearance.slotColor);
            slot.parent = parent;
            parts.add(slot);
            list.add(slot);
            List<ItemStack> demo = recipe.getToolWithModifier();
            TagKey<Item> filterTag = getToolFilterTag();
            if (filterTag != null) {
                demo = demo.stream().filter((stack) -> stack.is(filterTag)).toList();
            }

            if (!demo.isEmpty()) {
                TinkerItemElement demoTools = new TinkerItemElement(
                        imgX + (img.width - 16) / 2,
                        imgY - 24,
                        1.0F,
                        getDemoTools(demo));
                demoTools.parent = parent;
                parts.add(demoTools);
                list.add(demoTools);
            }

            ImageElement image = new ImageElement(
                    imgX + (img.width - 22) / 2,
                    imgY - 27,
                    -1,
                    -1,
                    ContentModifier.IMG_SLOTS[0],
                    0xFFFFFF);
            image.parent = parent;
            parts.add(image);
            list.add(image);

            for (int i = 0; i < Math.min(inputs, 5); ++i) {
                TinkerItemElement part = new TinkerItemElement(
                        imgX + slotsX[i],
                        imgY + slotsY[i],
                        1.0F,
                        recipe.getDisplayItems(i));
                if (parent != null) {
                    part.parent = parent;
                }

                parts.add(part);
                list.add(part);
            }
        }

    }

    protected ItemStackList getDemoTools(List<ItemStack> stacks) {
        ItemStackList demo = ItemStackList.withSize(stacks.size());

        for (int i = 0; i < stacks.size(); ++i) {
            demo.set(i, stacks.get(i));
        }

        return demo;
    }

    public void nextRecipe(BookData book, ArrayList<BookElement> list) {
        Objects.requireNonNull(recipes);
        if (!recipes.isEmpty()) {
            currentRecipe++;
            if (currentRecipe >= recipes.size()) {
                currentRecipe = 0;
            }

            BookScreen parent = parts.get(0).parent;

            for (BookElement element : parts) {
                list.remove(element);
            }

            parts.clear();
            buildAndAddRecipeDisplay(book, list, recipes.get(currentRecipe), parent);
        }
    }
}
