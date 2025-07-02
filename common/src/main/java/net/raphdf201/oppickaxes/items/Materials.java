package net.raphdf201.oppickaxes.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

public class Materials {
    public static final ToolMaterial DIRT = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, // Block breaking
            32,                     // Durability
            Integer.MAX_VALUE,      // Speed
            0,                      // Attack damage
            1,                      // enchantmentValue
            ItemTags.DIRT_TOOL_MATERIALS // Repair items
    );

    public static final ToolMaterial COAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, // Block breaking
            128,                    // Durability
            3,                      // Speed
            0,                      // Attack damage
            1,                      // Enchantment
            ItemTags.COAL_TOOL_MATERIALS // Repair items
    );
}
