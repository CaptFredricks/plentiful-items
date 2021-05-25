package com.github.captfredricks.plentifulitems.item;

/**
 * This class generates and registers weapon items.
 * @since 0.4.0
 */

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

public final class ItemWeapon {
    private static final ItemGroup item_group = ModItemGroups.PI_WEAPONS;

    /**
     * Generates a sword item.
     * @since 0.4.0
     * @param name
     * @param tier
     * @param damage
     * @param speed
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> itemGenSword(final String name, final IItemTier tier, final int damage, final float speed) {
        return ModItems.ITEMS.register(name, () -> new SwordItem(tier, damage, speed, new Item.Properties().group(item_group)));
    }
}
