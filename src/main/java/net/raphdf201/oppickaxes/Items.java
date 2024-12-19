package net.raphdf201.oppickaxes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.raphdf201.oppickaxes.materials.Tools;

import static net.raphdf201.oppickaxes.OPPickaxes.MOD_ID;

public class Items {
    public static final Item DIRT_PICK = register(new PickaxeItem(Tools.dirt, 0, Integer.MAX_VALUE, new Item.Settings()), "dirt_pick");

    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(MOD_ID, id);

        // Register and return the item!
        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {
    }
}
