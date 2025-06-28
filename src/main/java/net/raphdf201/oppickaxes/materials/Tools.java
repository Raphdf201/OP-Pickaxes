package net.raphdf201.oppickaxes.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static net.raphdf201.oppickaxes.OPPickaxes.MOD_ID;

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

    public static final ToolMaterial coal = new ToolMaterial(
            TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "coal_pickaxe_mineable")), // Block breaking
            128,                                                                                // Durability
            4,                                                                                  // Speed
            0,                                                                                  // Attack damage
            1,                                                                                  // Enchantment
            ItemTags.STONE_TOOL_MATERIALS                                                       // Repair items
    );
}
