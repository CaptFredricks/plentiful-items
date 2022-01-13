package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

/**
 * This class registers all custom foods.
 * @since 1.0.1
 */
public final class ModFoods {
    // Item group
    private static final ItemGroup item_group = ModItemGroups.PI_FOODS;

    // Items
    public static final Item BANANA = new Item(new Item.Properties().food(edible(4, 0.6f)).tab(item_group));
    public static final Item MANGO = new Item(new Item.Properties().food(edible(4, 0.6f)).tab(item_group));
    public static final Item COCONUT = new Item(new Item.Properties().food(edible(4, 0.6f)).tab(item_group));
    public static final Item BUTTER = new Item(new Item.Properties().tab(item_group));
    public static final Item CHEESE = new Item(new Item.Properties().food(edible(6, 0.8f)).tab(item_group));
    public static final Item SCRAMBLED_EGG = new Item(new Item.Properties().food(edible(8, 1.3f)).tab(item_group));
    public static final Item COCONUT_CREAM_PIE = new Item(new Item.Properties().food(edible(8, 0.6f)).tab(item_group));
    public static final Item CRAB = new Item(new Item.Properties().tab(item_group));
    public static final Item COOKED_CRAB = new Item(new Item.Properties().food(edible(5, 1.3f)).tab(item_group));
    public static final Item SHRIMP = new Item(new Item.Properties().tab(item_group));
    public static final Item COOKED_SHRIMP = new Item(new Item.Properties().food(edible(3, 1.0f)).tab(item_group));
    public static final Item LOBSTER = new Item(new Item.Properties().tab(item_group));
    public static final Item COOKED_LOBSTER = new Item(new Item.Properties().food(edible(7, 1.6f)).tab(item_group));

    /**
     * Create properties for a food item.
     * @since 0.2.0
     * @param hunger the amount of hunger the food satisfies
     * @param saturation the amount of saturation the food provides
     * @return Food
     */
    public static Food edible(final int hunger, final float saturation) {
        return (new Food.Builder()).nutrition(hunger).saturationMod(saturation).build();
    }
}
