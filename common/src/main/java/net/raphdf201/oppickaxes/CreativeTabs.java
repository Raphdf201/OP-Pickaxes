package net.raphdf201.oppickaxes;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.raphdf201.oppickaxes.items.Items;

import static net.raphdf201.oppickaxes.Oppickaxes.MOD_ID;

public class CreativeTabs {
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static RegistrySupplier<CreativeModeTab> PICKAXES_TAB;
    public static String PICKAXES_TAB_NAME = "pickaxes_tab";

    public static void init() {
        PICKAXES_TAB = TABS.register(PICKAXES_TAB_NAME, () -> CreativeTabRegistry.create(
                Component.translatable("category." + PICKAXES_TAB_NAME),
                () -> new ItemStack(Items.DIRT_PICK)));

        TABS.register();
    }
}
