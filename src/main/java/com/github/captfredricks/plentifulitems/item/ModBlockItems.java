package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

/**
 * This class registers all custom block items.
 * @since 1.0.1
 */
public final class ModBlockItems {
    // Item group
    private static final ItemGroup item_group = ModItemGroups.PI_BLOCKS;

    // Items
    public static final Item.Properties HALITE = new Item.Properties().tab(item_group);
    public static final Item.Properties STEEL_BLOCK = new Item.Properties().tab(item_group);
    public static final Item.Properties CRATE = new Item.Properties().tab(item_group);
    public static final Item.Properties REINFORCED_CRATE = new Item.Properties().stacksTo(1).tab(item_group);
}
