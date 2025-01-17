package net.raphdf201.oppickaxes;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OPPickaxes implements ModInitializer {
    public static final String MOD_ID = "oppickaxes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Starting " + MOD_ID + " initialization");
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        Items.initialize();

        LOGGER.info("Finished " + MOD_ID + " initialization");
    }
}