package net.raphdf201.oppickaxes.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoalPickaxeItem extends Item {
    private static final SimpleParticleType particle = ParticleTypes.FLAME;
    private static final int count = 5;
    private static final double speed = .5;

    public CoalPickaxeItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        spawnParticle(context);
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        spawnParticle(world, pos);
        return super.postMine(stack, world, state, pos, miner);
    }

    private void spawnParticle(ItemUsageContext context) {
        World world = context.getWorld();
        if (!world.isClient) {
            ((ServerWorld) world).spawnParticles(CoalPickaxeItem.particle,
                    context.getBlockPos().getX() + .5,
                    context.getBlockPos().getY() + 1,
                    context.getBlockPos().getZ() + .5,
                    count, 0, 0, 0, speed);
        }
    }

    private void spawnParticle(World world, BlockPos pos) {
        if (!world.isClient) {
            ((ServerWorld) world).spawnParticles(CoalPickaxeItem.particle,
                    pos.getX() + .5,
                    pos.getY() + 1,
                    pos.getZ() + .5,
                    count, 0, 0, 0, speed);
        }
    }

    public static CoalPickaxeItem register(CoalPickaxeItem item, Identifier id) {
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void register(RegistryKey<ItemGroup> group, CoalPickaxeItem item) {
        ItemGroupEvents.modifyEntriesEvent(group)
                .register((itemGroup) -> itemGroup.add(item));
    }
}
