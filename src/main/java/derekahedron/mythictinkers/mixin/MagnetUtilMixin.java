package derekahedron.mythictinkers.mixin;

import derekahedron.mythictinkers.util.MTUtil;
import com.github.alexmodguy.alexscaves.server.entity.util.MagnetUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;
import java.util.stream.Stream;

@Mixin(MagnetUtil.class)
public class MagnetUtilMixin {

    @ModifyVariable(
            method = "tickMagnetism",
            at = @At("STORE"),
            ordinal = 0,
            remap = false)
    private static Stream<BlockPos> getNearbyAttractingEntities(Stream<BlockPos> positions, Entity entity) {
        List<Player> attractingPlayers = MTUtil.getPlayersInRadius(
                entity, 5,
                (player) -> MTUtil.getMagneticAttractiveness(player) > 0);
        if (!attractingPlayers.isEmpty()) {
            return Stream.concat(positions, attractingPlayers.stream().map(Entity::blockPosition));
        }
        return positions;
    }

    @ModifyVariable(
            method = "tickMagnetism",
            at = @At("STORE"),
            ordinal = 1,
            remap = false)
    private static Stream<BlockPos> getNearbyRepellingEntities(Stream<BlockPos> positions, Entity entity) {
        List<Player> repellingPlayers = MTUtil.getPlayersInRadius(
                entity, 5,
                (player) -> MTUtil.getMagneticAttractiveness(player) < 0);
        if (!repellingPlayers.isEmpty()) {
            return Stream.concat(positions, repellingPlayers.stream().map(Entity::blockPosition));
        }
        return positions;
    }
}
