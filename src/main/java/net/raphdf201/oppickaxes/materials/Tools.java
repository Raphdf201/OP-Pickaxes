package net.raphdf201.oppickaxes.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class Tools {
    public static final ToolMaterial dirt = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, // Block breaking capabilities
            Integer.MAX_VALUE,      // Durability
            Integer.MAX_VALUE,      // Speed
            0,                      // Attack damage
            0,                      // enchantmentValue
            ItemTags.DIRT           // Repair items
    );
}
