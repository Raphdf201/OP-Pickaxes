package net.raphdf201.oppickaxes.fabric;

import net.raphdf201.oppickaxes.Oppickaxes;
import net.fabricmc.api.ModInitializer;

public final class OppickaxesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Oppickaxes.init();
    }
}
