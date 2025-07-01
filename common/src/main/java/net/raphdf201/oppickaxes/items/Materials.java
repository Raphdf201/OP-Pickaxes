package net.raphdf201.oppickaxes.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;

import static net.raphdf201.oppickaxes.Oppickaxes.MOD_ID;

public class Materials {
    public static final ToolMaterial DIRT = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, // Block breaking
            32,                     // Durability
            Integer.MAX_VALUE,      // Speed
            0,                      // Attack damage
            1,                      // enchantmentValue
            ItemTags.DIRT           // Repair items
    );

    public static final ToolMaterial COAL = new ToolMaterial(
            TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "coal_pickaxe_mineable")), // Block breaking
            128,                    // Durability
            3,                      // Speed
            0,                      // Attack damage
            1,                      // Enchantment
            ItemTags.COALS          // Repair items
    );
}
