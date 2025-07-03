package net.raphdf201.oppickaxes.items;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.raphdf201.oppickaxes.CreativeTabs;

import java.util.function.Supplier;

import static net.raphdf201.oppickaxes.Oppickaxes.MOD_ID;

public class Items {
    protected static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);

    public static RegistrySupplier<Item> DIRT_PICK;
    public static final String DIRT_PICK_NAME = "dirt_pick";

    public static RegistrySupplier<CoalPickaxeItem> COAL_PICK;
    public static final String COAL_PICK_NAME = "coal_pick";

    public static void init() {
        DIRT_PICK = registerItem(DIRT_PICK_NAME, () -> new PickaxeItem(
                Materials.DIRT,
                0,
                Integer.MIN_VALUE,
                baseProperties(DIRT_PICK_NAME)
                .arch$tab(CreativeTabs.PICKAXES_TAB)));

        COAL_PICK = CoalPickaxeItem.register(COAL_PICK_NAME, () -> new CoalPickaxeItem(baseProperties(COAL_PICK_NAME)
                .arch$tab(CreativeTabs.PICKAXES_TAB)));

        ITEMS.register();
    }

    private static RegistrySupplier<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(ResourceLocation.fromNamespaceAndPath(MOD_ID, name), item);
    }

    private static Item.Properties baseProperties(String name) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, name)));
    }
}
