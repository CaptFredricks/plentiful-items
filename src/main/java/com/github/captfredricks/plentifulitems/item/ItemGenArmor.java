package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

/**
 * This class generates and registers armor items.
 * @since 0.4.0
 */
public final class ItemGenArmor {
    private static final ItemGroup item_group = ModItemGroups.PI_WEAPONS;

    /**
     * Generates an armor item.
     * @since 0.4.0
     * @param name the item's name
     * @param material the item's material type
     * @param slot the slot the item should occupy when equipped
     * @return RegistryObject<Item>
     */
    public static RegistryObject<Item> gen(final String name, final IArmorMaterial material, final EquipmentSlotType slot) {
        return ModItems.ITEMS.register(name, () -> new ArmorItem(material, slot, new Item.Properties().group(item_group)));
    }
}
