package net.raphdf201.oppickaxes.items;

import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemUtils {
    public static void spawnParticle(ItemUsageContext context, SimpleParticleType particle, int count, double speed) {
        World world = context.getWorld();
        if (!world.isClient) {
            ((ServerWorld) world).spawnParticles(particle,
                    context.getBlockPos().getX() + .5,
                    context.getBlockPos().getY() + 1,
                    context.getBlockPos().getZ() + .5,
                    count, 0, 0, 0, speed);
        }
    }

    public static void spawnParticle(World world, BlockPos pos, SimpleParticleType particle, int count, double speed) {
        if (!world.isClient) {
            ((ServerWorld) world).spawnParticles(particle,
                    pos.getX() + .5,
                    pos.getY() + 1,
                    pos.getZ() + .5,
                    count, 0, 0, 0, speed);
        }
    }
}
