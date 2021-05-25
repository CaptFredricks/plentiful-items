package com.github.captfredricks.plentifulitems.item;

/**
 * This class generates and registers tool items.
 * @since 0.4.0
 */

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

public final class ItemTool {
    private static final ItemGroup item_group = ModItemGroups.PI_TOOLS;

    /**
     * Generates an axe item.
     * @since 0.4.0
     * @param name
     * @param tier
     * @param damage
     * @param speed
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> itemGenAxe(final String name, final IItemTier tier, final float damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new AxeItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }

    /**
     * Generates a hoe item.
     * @since 0.4.0
     * @param name
     * @param tier
     * @param damage
     * @param speed
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> itemGenHoe(final String name, final IItemTier tier, final int damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new HoeItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }

    /**
     * Generates a pickaxe item.
     * @since 0.4.0
     * @param name
     * @param tier
     * @param damage
     * @param speed
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> itemGenPickaxe(final String name, final IItemTier tier, final int damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new PickaxeItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }

    /**
     * Generates a shovel item.
     * @since 0.4.0
     * @param name
     * @param tier
     * @param damage
     * @param speed
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> itemGenShovel(final String name, final IItemTier tier, final float damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new ShovelItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }
}
