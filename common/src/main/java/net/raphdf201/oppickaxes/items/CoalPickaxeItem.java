package net.raphdf201.oppickaxes.items;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.raphdf201.oppickaxes.Oppickaxes.MOD_ID;
import static net.raphdf201.oppickaxes.items.Items.ITEMS;

public class CoalPickaxeItem extends Item {
    private static final SimpleParticleType PARTICLE = ParticleTypes.FLAME;
    private static final int COUNT = 5;
    private static final double SPEED = 0.5;

    public CoalPickaxeItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        spawnParticles(context.getLevel(), context.getClickedPos());
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miner) {
        spawnParticles(level, pos);
        return super.mineBlock(stack, level, state, pos, miner);
    }

    private void spawnParticles(Level level, BlockPos pos) {
        if (!level.isClientSide) {
            ((ServerLevel) level).sendParticles(
                    PARTICLE,
                    pos.getX() + 0.5,
                    pos.getY() + 1.0,
                    pos.getZ() + 0.5,
                    COUNT,
                    0.0, 0.0, 0.0,
                    SPEED
            );
        }
    }

    // Static registration helpers
    public static RegistrySupplier<CoalPickaxeItem> register(String name, Supplier<CoalPickaxeItem> item) {
        return ITEMS.register(ResourceLocation.fromNamespaceAndPath(MOD_ID, name), item);
    }
}
