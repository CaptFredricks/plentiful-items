package com.github.captfredricks.plentifulitems;

import com.github.captfredricks.plentifulitems.init.ModBlocks;
import com.github.captfredricks.plentifulitems.init.ModFishingLoot;
import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModJungleLeavesLoot;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;

@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {
    private static final Logger LOGGER = LogManager.getLogger(Main.MODID + " ModEventSubscriber");

    /*
    @SubscribeEvent
    public static void onRegisterItems(@Nonnull final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        // Automatically register BlockItems for all custom blocks
        ModBlocks.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .forEach(block -> {
                    // Set the block's properties
                    final Item.Properties properties = new Item.Properties().group(ModItemGroups.PI_BLOCKS);
                    // Create the new BlockItem with the block
                    final BlockItem blockItem = new BlockItem(block, properties);
                    // Set the new BlockItem's registry name to the block's registry name
                    blockItem.setRegistryName(block.getRegistryName());
                    // Register the BlockItem
                    registry.register(blockItem);
                });

        LOGGER.debug("Registered BlockItems");
    }*/

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        final IForgeRegistry<GlobalLootModifierSerializer<?>> registry = event.getRegistry();

        registry.register(new ModFishingLoot.Serializer().setRegistryName(new ResourceLocation(Main.MODID, "fishing")));
        registry.register(new ModJungleLeavesLoot.Serializer().setRegistryName(new ResourceLocation(Main.MODID, "jungle_leaves")));

        LOGGER.debug("Registered ModifierSerializers");
    }
}
