package net.raphdf201.oppickaxes.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import static net.raphdf201.oppickaxes.Oppickaxes.MOD_ID;

public class ItemTags {
    public static final TagKey<Item> DIRT_TOOL_MATERIALS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "dirt_tool_materials"));
    public static final TagKey<Item> COAL_TOOL_MATERIALS = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "dirt_tool_materials"));
}
