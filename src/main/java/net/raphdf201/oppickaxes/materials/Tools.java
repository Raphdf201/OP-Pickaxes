package net.raphdf201.oppickaxes.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class Tools {
    /**
     * Dirt material, netherite blockTag, low durability and high speed.
     * Hard to enchant, use dirt to repair
     */
    public static final ToolMaterial dirt = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, // Block breaking capabilities
            32,                     // Durability
            Integer.MAX_VALUE,      // Speed
            0,                      // Attack damage
            1,                      // enchantmentValue
            ItemTags.DIRT           // Repair items
    );
}
