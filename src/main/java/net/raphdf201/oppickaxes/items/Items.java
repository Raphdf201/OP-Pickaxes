package net.raphdf201.oppickaxes.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.raphdf201.oppickaxes.materials.Tools;

import static net.raphdf201.oppickaxes.OPPickaxes.MOD_ID;

public class Items {
    public static final Identifier DIRT_PICK_ID = Identifier.of(MOD_ID, "dirt_pick");
    public static final Identifier COAL_PICK_ID = Identifier.of(MOD_ID, "coal_pick");

    public static final Item DIRT_PICK = register(
            new Item(new Item.Settings()
                    .pickaxe(Tools.dirt, 0, Integer.MAX_VALUE)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, DIRT_PICK_ID))
            ),
            DIRT_PICK_ID
    );

    public static final CoalPickaxeItem COAL_PICK = CoalPickaxeItem.register(
            new CoalPickaxeItem(new Item.Settings()
                    .pickaxe(Tools.coal, 5, -3)
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, COAL_PICK_ID))
            ),
            COAL_PICK_ID
    );

    public static void initialize() {
        register(ItemGroups.TOOLS, DIRT_PICK);
        CoalPickaxeItem.register(ItemGroups.TOOLS, COAL_PICK);
    }

    public static Item register(Item item, Identifier id) {
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void register(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group)
                .register((itemGroup) -> itemGroup.add(item));
    }
}
