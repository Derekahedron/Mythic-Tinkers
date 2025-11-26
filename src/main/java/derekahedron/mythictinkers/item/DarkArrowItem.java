package derekahedron.mythictinkers.item;

import com.github.alexmodguy.alexscaves.server.entity.item.DarkArrowEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DarkArrowItem extends ArrowItem {

    public DarkArrowItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter) {
        DarkArrowEntity arrow = new DarkArrowEntity(level, shooter);
        arrow.setShadowArrowDamage(3.0F);
        return arrow;
    }
}
