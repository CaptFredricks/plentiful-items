package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

/**
 * This class generates and registers weapon items.
 * @since 0.4.0
 */
public final class ItemGenWeapon {
    private static final ItemGroup item_group = ModItemGroups.PI_WEAPONS;

    /**
     * Generates a sword item.
     * @since 0.4.0
     * @param name the item's name
     * @param tier the item's tier
     * @param damage the base damage of the item
     * @param speed the speed of the item when used
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> genSword(final String name, final IItemTier tier, final int damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new SwordItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }
}