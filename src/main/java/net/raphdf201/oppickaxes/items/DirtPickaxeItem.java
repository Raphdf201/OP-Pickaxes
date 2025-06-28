package net.raphdf201.oppickaxes.items;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.ToggleableFeature;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.raphdf201.oppickaxes.items.ItemUtils.spawnParticle;

public class DirtPickaxeItem extends Item implements ToggleableFeature, ItemConvertible, FabricItem {
    public DirtPickaxeItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        spawnParticle(context, ParticleTypes.FLAME, 5, .5);
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        spawnParticle(world, pos, ParticleTypes.FLAME, 5, .5);
        return super.postMine(stack, world, state, pos, miner);
    }

    public static DirtPickaxeItem register(DirtPickaxeItem item, Identifier id) {
        return Registry.register(Registries.ITEM, id, item);
    }
}
