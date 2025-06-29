package net.raphdf201.oppickaxes.mixin;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.raphdf201.oppickaxes.items.CoalPickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(Block.class)
public class CoalPickaxeSmelt {
    @Inject(method = "afterBreak", at = @At("HEAD"), cancellable = true)
    private void injectAfterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {
        if (!world.isClient() && tool.getItem() instanceof CoalPickaxeItem) {
            Block block = state.getBlock();

            if (block == Blocks.NETHER_QUARTZ_ORE) return;

            // Create a SingleStackRecipeInput instead of SimpleInventory
            ItemStack input = new ItemStack(block.asItem());
            SingleStackRecipeInput recipeInput = new SingleStackRecipeInput(input);

            Optional<RecipeEntry<SmeltingRecipe>> recipeOpt = ((ServerWorld) world).getRecipeManager()
                    .getFirstMatch(RecipeType.SMELTING, recipeInput, world);

            if (recipeOpt.isPresent()) {
                ItemStack result = recipeOpt.get().value().craft(recipeInput, world.getRegistryManager());

                if (!result.isEmpty()) {
                    ItemEntity entity = new ItemEntity(
                            world,
                            pos.getX() + 0.5,
                            pos.getY() + 0.5,
                            pos.getZ() + 0.5,
                            result.copy()
                    );
                    world.spawnEntity(entity);

                    state.onStacksDropped((ServerWorld) world, pos, ItemStack.EMPTY, true);
                    ci.cancel();
                }
            }
        }
    }
}
