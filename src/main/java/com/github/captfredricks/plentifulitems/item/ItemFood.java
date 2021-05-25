package com.github.captfredricks.plentifulitems.item;

/**
 * This class generates and registers food items.
 * @since 0.4.0
 */

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Food;
import net.minecraftforge.fml.RegistryObject;

public final class ItemFood {
    private static final ItemGroup item_group = ModItemGroups.PI_FOODS;

    /**
     * Generates an edible food item.
     * @since 0.2.0
     * @param name
     * @param food
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> itemGen(final String name, final Food food) {
        return ModItems.ITEMS.register(name, () -> new Item(new Item.Properties().group(item_group).food(food)));
    }

    /**
     * Generates a non-edible food item.
     * @since 0.2.0
     * @param name
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> itemGen(final String name) {
        return ModItems.ITEMS.register(name, () -> new Item(new Item.Properties().group(item_group)));
    }

    /**
     * Creates the properties for the food item.
     * @since 0.2.0
     * @param hunger
     * @param saturation
     * @return Food
     */
    public static Food food(final int hunger, final float saturation) {
        return (new Food.Builder()).hunger(hunger).saturation(saturation).build();
    }
}
