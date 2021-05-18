package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Food;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems {
    // Create a deferred register for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    // Register food items
    private static final RegistryObject<Item> BANANA =
            itemGenerator("banana", ModItemGroups.PI_ITEMS, foodGenerator(4, 0.6f));
    private static final RegistryObject<Item> MANGO =
            itemGenerator("mango", ModItemGroups.PI_ITEMS, foodGenerator(4, 0.6f));
    private static final RegistryObject<Item> COCONUT =
            itemGenerator("coconut", ModItemGroups.PI_ITEMS, foodGenerator(4, 0.6f));
    private static final RegistryObject<Item> CHEESE =
            itemGenerator("cheese", ModItemGroups.PI_ITEMS, foodGenerator(6, 0.8f));
    private static final RegistryObject<Item> COCONUT_CREAM_PIE =
            itemGenerator("coconut_cream_pie", ModItemGroups.PI_ITEMS, foodGenerator(8, 0.6f));

    // Register other items
    private static final RegistryObject<Item> BUTTER =
            itemGenerator("butter", ModItemGroups.PI_ITEMS, null);
    private static final RegistryObject<Item> SALT =
            itemGenerator("salt", ModItemGroups.PI_ITEMS, null);

    // Register group icon
    public static final RegistryObject<Item> GROUP_ICON = COCONUT;

    /**
     * Generates a food item.
     * @since 0.2.0
     */
    public static Food foodGenerator(final int hunger, final float saturation) {
        return (new Food.Builder()).hunger(hunger).saturation(saturation).build();
    }

    /**
     * Generates an item.
     * @since 0.2.0
     */
    public static RegistryObject<Item> itemGenerator(final String name, final ItemGroup item_group, final Food food) {
        if(food != null) {
            return ITEMS.register(name, () -> new Item(new Item.Properties().group(item_group).food(food)));
        } else {
            return ITEMS.register(name, () -> new Item(new Item.Properties().group(item_group)));
        }
    }
}