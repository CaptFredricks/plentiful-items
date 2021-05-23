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

    // Register foodstuffs
    private static final RegistryObject<Item> BANANA =
            itemGenerator("banana", ModItemGroups.PI_FOODS, foodGenerator(4, 0.6f));
    private static final RegistryObject<Item> MANGO =
            itemGenerator("mango", ModItemGroups.PI_FOODS, foodGenerator(4, 0.6f));
    private static final RegistryObject<Item> COCONUT =
            itemGenerator("coconut", ModItemGroups.PI_FOODS, foodGenerator(4, 0.6f));
    private static final RegistryObject<Item> BUTTER =
            itemGenerator("butter", ModItemGroups.PI_FOODS);
    private static final RegistryObject<Item> CHEESE =
            itemGenerator("cheese", ModItemGroups.PI_FOODS, foodGenerator(6, 0.8f));
    private static final RegistryObject<Item> SCRAMBLED_EGG =
            itemGenerator("scrambled_egg", ModItemGroups.PI_FOODS, foodGenerator(8, 1.0f));
    private static final RegistryObject<Item> COCONUT_CREAM_PIE =
            itemGenerator("coconut_cream_pie", ModItemGroups.PI_FOODS, foodGenerator(8, 0.6f));
    private static final RegistryObject<Item> CRAB =
            itemGenerator("crab", ModItemGroups.PI_FOODS);
    private static final RegistryObject<Item> COOKED_CRAB =
            itemGenerator("cooked_crab", ModItemGroups.PI_FOODS, foodGenerator(5, 1.3f));
    private static final RegistryObject<Item> SHRIMP =
            itemGenerator("shrimp", ModItemGroups.PI_FOODS);
    private static final RegistryObject<Item> COOKED_SHRIMP =
            itemGenerator("cooked_shrimp", ModItemGroups.PI_FOODS, foodGenerator(3, 1.0f));
    private static final RegistryObject<Item> LOBSTER =
            itemGenerator("lobster", ModItemGroups.PI_FOODS);
    private static final RegistryObject<Item> COOKED_LOBSTER =
            itemGenerator("cooked_lobster", ModItemGroups.PI_FOODS, foodGenerator(7, 1.6f));

    // Register materials
    private static final RegistryObject<Item> SALT =
            itemGenerator("salt", ModItemGroups.PI_MATERIALS);
    private static final RegistryObject<Item> STEEL_INGOT =
            itemGenerator("steel_ingot", ModItemGroups.PI_MATERIALS);

    // Register group icons
    public static final RegistryObject<Item> FOODS_ICON = COCONUT;
    public static final RegistryObject<Item> MATS_ICON = SALT;

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
    private static RegistryObject<Item> itemGenerator(final String name, final ItemGroup item_group, final Food food) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().group(item_group).food(food)));
    }

    private static RegistryObject<Item> itemGenerator(final String name, final ItemGroup item_group) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().group(item_group)));
    }
}