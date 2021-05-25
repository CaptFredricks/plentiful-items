package com.github.captfredricks.plentifulitems.item;

/**
 * This class generates and registers material items.
 * @since 0.4.0
 */

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public final class ItemMaterial {
    private static final ItemGroup item_group = ModItemGroups.PI_MATERIALS;

    /**
     * Generates a material item.
     * @since 0.2.0
     * @param name
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> itemGen(final String name) {
        return ModItems.ITEMS.register(name, () -> new Item(new Item.Properties().group(item_group)));
    }
}
