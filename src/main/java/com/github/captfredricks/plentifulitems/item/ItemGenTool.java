package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

/**
 * This class generates and registers tool items.
 * @since 0.4.0
 */
public final class ItemGenTool {
    private static final ItemGroup item_group = ModItemGroups.PI_TOOLS;

    /**
     * Generates an axe item.
     * @since 0.4.0
     * @param name the item's name
     * @param tier the item's tier
     * @param damage the base damage of the item
     * @param speed the speed of the item when used
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> genAxe(final String name, final IItemTier tier, final float damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new AxeItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }

    /**
     * Generates a hoe item.
     * @since 0.4.0
     * @param name the item's name
     * @param tier the item's tier
     * @param damage the base damage of the item
     * @param speed the speed of the item when used
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> genHoe(final String name, final IItemTier tier, final int damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new HoeItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }

    /**
     * Generates a pickaxe item.
     * @since 0.4.0
     * @param name the item's name
     * @param tier the item's tier
     * @param damage the base damage of the item
     * @param speed the speed of the item when used
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> genPickaxe(final String name, final IItemTier tier, final int damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new PickaxeItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }

    /**
     * Generates a shovel item.
     * @since 0.4.0
     * @param name the item's name
     * @param tier the item's tier
     * @param damage the base damage of the item
     * @param speed the speed of the item when used
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> genShovel(final String name, final IItemTier tier, final float damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new ShovelItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }
}