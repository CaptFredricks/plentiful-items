package com.github.captfredricks.plentifulitems;

import com.github.captfredricks.plentifulitems.dispenser.CrateDispenseBehavior;
import com.github.captfredricks.plentifulitems.init.*;
import com.github.captfredricks.plentifulitems.world.OreGeneration;
import net.minecraft.block.DispenserBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main class for the Plentiful Items mod.
 * @since 0.1.0
 */
@Mod(Main.MODID)
public final class Main {
    public static final String MODID = "plentifulitems";
    private static final Logger LOGGER = LogManager.getLogger(MODID);

    /**
     * The class constructor.
     */
    public Main() {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register deferred registers
        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        //ModBlocksVanilla.BLOCKS.register(bus); // needs more testing
        //ModItemsVanilla.ITEMS.register(bus); // needs more testing
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(bus);

        // Add a listener for the setup method
        bus.addListener(this::setup);

        // Add a listener for the ore generator class
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
    }

    /**
     * Register events during the FMLCommonSetupEvent phase.
     * @param event the event
     */
    private void setup(final FMLCommonSetupEvent event) {
        // Modify dispenser behavior for crates
        DispenserBlock.registerDispenseBehavior(ModItems.CRATE.get(), new CrateDispenseBehavior());
        DispenserBlock.registerDispenseBehavior(ModItems.REINFORCED_CRATE.get(), new CrateDispenseBehavior());
    }
}
