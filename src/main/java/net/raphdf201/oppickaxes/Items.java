package net.raphdf201.oppickaxes;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.raphdf201.oppickaxes.materials.Tools;

import static net.raphdf201.oppickaxes.OPPickaxes.MOD_ID;

public class Items {
    public static final Identifier DIRT_PICK_ID = Identifier.of(MOD_ID, "dirt_pick");
    public static final Item DIRT_PICK = Registry.register(Registries.ITEM, DIRT_PICK_ID, new PickaxeItem(Tools.dirt, 0, Integer.MAX_VALUE, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, DIRT_PICK_ID))));

    public static void initialize() {
        register(ItemGroups.TOOLS, DIRT_PICK);
    }

    /**
     * Register an item in the {@link net.minecraft.registry.Registry}
     * @param item the item to register
     * @param id the id of the item
     * @return registered item
     */
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(MOD_ID, id);

        // Register and return the item!
        return Registry.register(Registries.ITEM, itemID, item);
    }

    /**
     * Register an item in an itemGroup
     * @param group target group
     * @param item item to add
     */
    public static void register(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group)
                .register((itemGroup) -> itemGroup.add(item));
    }
}
