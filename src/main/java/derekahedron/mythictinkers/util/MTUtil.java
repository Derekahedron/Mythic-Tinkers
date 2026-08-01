package derekahedron.mythictinkers.util;

import derekahedron.mythictinkers.item.MTItemTags;
import derekahedron.mythictinkers.tinkers.materials.MTMaterialTags;
import derekahedron.mythictinkers.tinkers.modifiers.MTModifierIds;
import derekahedron.mythictinkers.tinkers.modifiers.MTModifierTags;
import com.github.alexmodguy.alexscaves.server.entity.item.SeekingArrowEntity;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.Unmodifiable;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.materials.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.IMaterial;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.materials.definition.MaterialVariant;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsId;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierManager;
import slimeknights.tconstruct.library.tools.definition.ToolDefinition;
import slimeknights.tconstruct.library.tools.definition.module.material.ToolMaterialHook;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.part.IMaterialItem;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MTUtil {

    public static ResourceLocation location(String path) {
        return new ResourceLocation(derekahedron.mythictinkers.MythicTinkers.MOD_ID, path);
    }

    public static Holder<DamageType> getDamageType(Entity entity, ResourceKey<DamageType> damageType) {
        return entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType);
    }

    public static <T> TagKey<T> childTag(TagKey<T> parentTag, String suffix) {
        return TagKey.create(parentTag.registry(), parentTag.location().withSuffix("/" + suffix));
    }

    public static List<Entity> getEntitiesInRadius(
            Entity baseEntity,
            double radius,
            @Nullable Predicate<Entity> predicate) {
        return getEntitiesInRadius(baseEntity, baseEntity.level(), baseEntity.getX(), baseEntity.getY(), baseEntity.getZ(), radius, predicate);
    }

    public static List<Entity> getEntitiesInRadius(
            @Nullable Entity baseEntity,
            Level level,
            double x, double y, double z,
            double radius,
            @Nullable Predicate<Entity> predicate) {
        double radiusSquared = radius * radius;
        return level.getEntities(
                baseEntity,
                new AABB(
                        x - radius,
                        y - radius,
                        z - radius,
                        x + radius,
                        y + radius,
                        z + radius),
                (entity) -> {
                    if (predicate == null || predicate.test(entity)) {
                        double diffX = entity.getX() - x;
                        double diffY = entity.getY() - y;
                        double diffZ = entity.getZ() - z;
                        return diffX * diffX + diffY * diffY + diffZ * diffZ <= radiusSquared;
                    }
                    return false;
                }
        );
    }

    @Unmodifiable
    public static List<Player> getPlayersInRadius(
            Entity baseEntity,
            double radius,
            @Nullable Predicate<Player> predicate) {
        return getPlayersInRadius(
                baseEntity,
                baseEntity.level(),
                baseEntity.getX(), baseEntity.getY(), baseEntity.getZ(),
                radius,
                predicate);
    }

    @Unmodifiable
    public static List<Player> getPlayersInRadius(
            @Nullable Entity baseEntity,
            Level level,
            double x, double y, double z,
            double radius,
            @Nullable Predicate<Player> predicate) {
        double radiusSquared = radius * radius;
        AABB bounds = new AABB(
                x - radius,
                y - radius,
                z - radius,
                x + radius,
                y + radius,
                z + radius);
        return level.players().stream().filter((player) -> {
            if (player != baseEntity
                    && !player.isSpectator()
                    && bounds.contains(player.position())
                    && (predicate == null || predicate.test(player))) {
                double diffX = player.getX() - x;
                double diffY = player.getY() - y;
                double diffZ = player.getZ() - z;
                return diffX * diffX + diffY * diffY + diffZ * diffZ <= radiusSquared;
            }
            return false;
        }).map(player -> (Player) player).toList();
    }

    public static boolean shouldBlockHitEffect(Projectile projectile, EntityHitResult hitResult) {
        if (!(projectile instanceof SeekingArrowEntity arrow)) return false;

        Entity target = hitResult.getEntity();
        if (target instanceof LivingEntity && target.invulnerableTime > 10) return true;

        Entity attacker = arrow.getOwner();
        DamageSource damageSource = arrow.damageSources().arrow(arrow, attacker == null ? arrow : attacker);
        return target.isInvulnerableTo(damageSource);
    }

    public static boolean isMagneticTool(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        } else if (stack.is(TinkerTags.Items.MODIFIABLE)) {
            ToolStack tool = ToolStack.from(stack);
            for (MaterialVariant material : tool.getMaterials().getList()) {
                if (MaterialRegistry.getInstance().isInTag(material.getId(), MTMaterialTags.FERROMAGNETIC)) {
                    return true;
                }
            }
            for (ModifierEntry modifier : tool.getModifiers()) {
                if (ModifierManager.isInTag(modifier.getId(), MTModifierTags.FERROMAGNETIC)) {
                    return true;
                }
            }
        } else if (stack.getItem() instanceof IMaterialItem materialItem) {
            MaterialId materialId = materialItem.getMaterial(stack).getId();
            return MaterialRegistry.getInstance().isInTag(materialId, MTMaterialTags.FERROMAGNETIC);
        }
        return false;
    }

    public static int getMagneticAttractiveness(LivingEntity entity) {
        int attractiveness = 0;
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            ItemStack stack = entity.getItemBySlot(slot);
            attractiveness += ModifierUtil.getModifierLevel(stack, MTModifierIds.ATTRACTIVE);
            attractiveness -= ModifierUtil.getModifierLevel(stack, MTModifierIds.REPULSIVE);
        }
        return attractiveness;
    }

    public static List<ModifierEntry> getMaterialModifiers(MaterialId materialId, ToolDefinition toolDefinition) {
        List<ModifierEntry> modifierEntries = new ArrayList<>();

        if (MaterialRegistry.getInstance().getMaterial(materialId) == IMaterial.UNKNOWN) {
            return modifierEntries;
        }

        boolean addedDefaultTraits = false;

        for (MaterialStatsId statId : ToolMaterialHook.stats(toolDefinition)) {

            if (!MaterialRegistry.getInstance().hasUniqueTraits(materialId, statId)) {
                if (addedDefaultTraits) {
                    continue;
                } else {
                    addedDefaultTraits = true;
                }
            }

            for (ModifierEntry modifierEntry : MaterialRegistry.getInstance().getTraits(materialId, statId)) {
                boolean inList = false;

                for (int i = 0; i < modifierEntries.size(); i++) {
                    ModifierEntry existingEntry = modifierEntries.get(i);
                    if (existingEntry.matches(modifierEntry.getId())) {
                        if (existingEntry.getLevel() < modifierEntry.getLevel()) {
                            modifierEntries.set(i, modifierEntry);
                        }
                        inList = true;
                        break;
                    }
                }

                if (!inList) {
                    modifierEntries.add(modifierEntry);
                }
            }
        }

        return modifierEntries;
    }

    public static boolean isAcidResistant(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        } else if (stack.is(MTItemTags.ACID_RESISTANT)) {
            return true;
        } else if (stack.is(TinkerTags.Items.MODIFIABLE)) {
            ToolStack tool = ToolStack.from(stack);
            for (MaterialVariant material : tool.getMaterials().getList()) {
                if (MaterialRegistry.getInstance().isInTag(material.getId(), MTMaterialTags.ACID_RESISTANT)) {
                    return true;
                }
            }
        } else if (stack.getItem() instanceof IMaterialItem materialItem) {
            MaterialId materialId = materialItem.getMaterial(stack).getId();
            return MaterialRegistry.getInstance().isInTag(materialId, MTMaterialTags.ACID_RESISTANT);
        }
        return false;
    }
}
