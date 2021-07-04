package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

/**
 * This class generates and registers material items.
 * @since 0.4.0
 */
public final class ItemGenMaterial {
    private static final ItemGroup item_group = ModItemGroups.PI_MATERIALS;

    /**
     * Generates a material item with custom properties.
     * @since 0.6.0
     * @param name the item's name
     * @param props the item's properties
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> gen(final String name, final Item.Properties props) {
        return ModItems.ITEMS.register(name, () -> new Item(props.group(item_group)));
    }

    /**
     * Generates a material item with default properties.
     * @since 0.2.0
     * @param name the item's name
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> gen(final String name) {
        return ModItems.ITEMS.register(name, () -> new Item(new Item.Properties().group(item_group)));
    }
}
