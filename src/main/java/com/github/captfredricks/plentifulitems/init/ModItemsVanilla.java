package com.github.captfredricks.plentifulitems.init;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class registers all vanilla modded items.
 * @since 0.6.0
 */
public final class ModItemsVanilla {
    // Create a deferred register for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    // Register items
    public static final RegistryObject<BlockItem> SHULKER_BOX = ITEMS.register("shulker_box", () -> new BlockItem(ModBlocksVanilla.SHULKER_BOX.get(), (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<BlockItem> WHITE_SHULKER_BOX = ITEMS.register("white_shulker_box", () -> new BlockItem(ModBlocksVanilla.WHITE_SHULKER_BOX.get(), (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    public static final RegistryObject<BlockItem> ORANGE_SHULKER_BOX = ITEMS.register("orange_shulker_box", () -> new BlockItem(ModBlocksVanilla.ORANGE_SHULKER_BOX.get(), (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> MAGENTA_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.MAGENTA_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> LIGHT_BLUE_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.LIGHT_BLUE_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> YELLOW_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.YELLOW_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> LIME_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.LIME_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> PINK_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.PINK_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> GRAY_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.GRAY_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> LIGHT_GRAY_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.LIGHT_GRAY_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> CYAN_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.CYAN_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> PURPLE_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.PURPLE_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> BLUE_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.BLUE_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> BROWN_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.BROWN_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> GREEN_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.GREEN_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> RED_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.RED_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
    //public static final RegistryObject<BlockItem> BLACK_SHULKER_BOX = ITEMS.register(new BlockItem(Blocks.BLACK_SHULKER_BOX, (new Item.Properties()).maxStackSize(1).group(ItemGroup.DECORATIONS)));
}
