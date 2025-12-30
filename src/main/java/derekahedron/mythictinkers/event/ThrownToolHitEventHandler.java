package derekahedron.mythictinkers.event;

import derekahedron.mythictinkers.MythicTinkers;
import derekahedron.mythictinkers.tinkers.hooks.MTModifierHooks;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.tools.entity.ThrownTool;

@Mod.EventBusSubscriber(modid = MythicTinkers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ThrownToolHitEventHandler {

    @SubscribeEvent
    public static void onProjectileHit(ProjectileImpactEvent event) {
        if (!(event.getProjectile() instanceof ThrownTool thrownTool)) return;
        if (!(thrownTool.getOwner() instanceof LivingEntity owner)) return;

        ItemStack stack = thrownTool.getDisplayTool();
        if (!(stack.getItem() instanceof IModifiable)) return;

        ToolStack tool = ToolStack.from(stack);

        HitResult hitResult = event.getRayTraceResult();
        if (hitResult instanceof EntityHitResult entityHit) {
            for (ModifierEntry modifier : tool.getModifiers()) {
                modifier.getHook(MTModifierHooks.THROWN_TOOL_HIT).onThrownToolHitEntity(
                        tool,
                        modifier,
                        thrownTool,
                        owner,
                        entityHit.getEntity(),
                        entityHit.getEntity() instanceof LivingEntity livingEntity ? livingEntity : null);
            }
        }
    }
}
