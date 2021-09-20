package com.github.captfredricks.plentifulitems.data;

import com.github.captfredricks.plentifulitems.Main;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * This class registers all data generators.
 * @since 1.0.1
 */
@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class DataGenerators {
    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existing_file_helper = event.getExistingFileHelper();

        if(event.includeClient()) {
            // Block states and models
            gen.addProvider(new ModBlockStateProvider(gen, existing_file_helper));

            // Item models
            gen.addProvider(new ModItemModelProvider(gen, existing_file_helper));
        }
        if(event.includeServer()) {
            // Loot tables
            gen.addProvider(new ModLootTableProvider(gen));

            // Recipes
            gen.addProvider(new ModRecipeProvider(gen));
        }
    }
}
