package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

/**
 * This class registers all custom armor.
 * @since 1.0.1
 */
public final class ModArmor {
    // Item group
    private static final ItemGroup item_group = ModItemGroups.PI_COMBAT;

    // Items
    public static final Item STEEL_HELMET = new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.HEAD, new Item.Properties().group(item_group));
    public static final Item STEEL_CHESTPLATE = new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.CHEST, new Item.Properties().group(item_group));
    public static final Item STEEL_LEGGINGS = new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.LEGS, new Item.Properties().group(item_group));
    public static final Item STEEL_BOOTS = new ArmorItem(ModArmorMaterial.STEEL, EquipmentSlotType.FEET, new Item.Properties().group(item_group));
}
