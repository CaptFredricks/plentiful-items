package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

/**
 * This class registers all custom weapons.
 * @since 1.0.1
 */
public final class ModWeapons {
    // Item group
    private static final ItemGroup item_group = ModItemGroups.PI_COMBAT;

    // Items
    public static final Item STEEL_SWORD = new SwordItem(ModItemTier.STEEL, 3, -2.4f, new Item.Properties().group(item_group));
}
