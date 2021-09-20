package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

/**
 * This class registers all custom materials.
 * @since 1.0.1
 */
public final class ModMaterials {
    // Item group
    private static final ItemGroup item_group = ModItemGroups.PI_MATERIALS;

    // Items
    public static final Item SALT = new Item(new Item.Properties().group(item_group));
    public static final Item STEEL_INGOT = new Item(new Item.Properties().group(item_group));
    public static final Item STEEL_RIVET = new Item(new Item.Properties().group(item_group));
}
