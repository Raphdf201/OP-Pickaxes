package net.raphdf201.oppickaxes.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.raphdf201.oppickaxes.Items;

import java.util.concurrent.CompletableFuture;

public class Recipes extends FabricRecipeProvider {
    public Recipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShaped(RecipeCategory.TOOLS, Items.DIRT_PICK)
                        .pattern("ddd")
                        .pattern(" s ")
                        .pattern(" s ")
                        .input('d', net.minecraft.item.Items.DIRT)
                        .input('s', net.minecraft.item.Items.STICK)
                        .criterion(
                                hasItem(net.minecraft.item.Items.DIRT),
                                conditionsFromItem(net.minecraft.item.Items.DIRT))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Recipes";
    }
}
