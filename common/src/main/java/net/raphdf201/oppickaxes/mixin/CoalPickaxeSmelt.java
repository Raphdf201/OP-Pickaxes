package net.raphdf201.oppickaxes.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.raphdf201.oppickaxes.items.CoalPickaxeItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(Block.class)
public class CoalPickaxeSmelt {
    // Minecraft 26.1 and 26.2 declare playerDestroy(Level, Player, ...)
    @Inject(
            method = "playerDestroy(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/item/ItemStack;)V",
            at = @At("HEAD"), cancellable = true, require = 0)
    private void injectAfterBreakLegacy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {
        smeltInstead(level, pos, state, tool, ci);
    }

    // Minecraft 26.3 narrowed the parameters to playerDestroy(ServerLevel, ServerPlayer, ...)
    @Inject(
            method = "playerDestroy(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/item/ItemStack;)V",
            at = @At("HEAD"), cancellable = true, require = 0)
    private void injectAfterBreak(ServerLevel level, ServerPlayer player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {
        smeltInstead(level, pos, state, tool, ci);
    }

    private static void smeltInstead(Level level, BlockPos pos, BlockState state, ItemStack tool, CallbackInfo ci) {
        if (!level.isClientSide() && tool.getItem() instanceof CoalPickaxeItem) {
            Block block = state.getBlock();

            ItemStack input = new ItemStack(block.asItem());
            SingleRecipeInput container = new SingleRecipeInput(input);

            Optional<RecipeHolder<SmeltingRecipe>> recipeOpt = ((ServerLevel) level).getServer().getRecipeManager()
                    .getRecipeFor(RecipeType.SMELTING, container, level);

            if (recipeOpt.isPresent()) {
                ItemStack result = recipeOpt.get().value().assemble(container);

                if (!result.isEmpty()) {
                    ItemEntity entity = new ItemEntity(
                            level,
                            pos.getX() + 0.5,
                            pos.getY() + 0.5,
                            pos.getZ() + 0.5,
                            result.copy()
                    );
                    level.addFreshEntity(entity);

                    // Block.dropResources(state, level, pos); // Original drop (not smelted)

                    ci.cancel();
                }
            }
        }
    }
}
