package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.item.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    // Create a deferred register for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    // Register foodstuffs
    private static final RegistryObject<Item> BANANA = ItemFood.itemGen("banana", ItemFood.food(4, 0.6f));
    private static final RegistryObject<Item> MANGO = ItemFood.itemGen("mango", ItemFood.food(4, 0.6f));
    private static final RegistryObject<Item> COCONUT = ItemFood.itemGen("coconut", ItemFood.food(4, 0.6f));
    private static final RegistryObject<Item> BUTTER = ItemFood.itemGen("butter");
    private static final RegistryObject<Item> CHEESE = ItemFood.itemGen("cheese", ItemFood.food(6, 0.8f));
    private static final RegistryObject<Item> SCRAMBLED_EGG = ItemFood.itemGen("scrambled_egg", ItemFood.food(8, 1.0f));
    private static final RegistryObject<Item> COCONUT_CREAM_PIE = ItemFood.itemGen("coconut_cream_pie", ItemFood.food(8, 0.6f));
    private static final RegistryObject<Item> CRAB = ItemFood.itemGen("crab");
    private static final RegistryObject<Item> COOKED_CRAB = ItemFood.itemGen("cooked_crab", ItemFood.food(5, 1.3f));
    private static final RegistryObject<Item> SHRIMP = ItemFood.itemGen("shrimp");
    private static final RegistryObject<Item> COOKED_SHRIMP = ItemFood.itemGen("cooked_shrimp", ItemFood.food(3, 1.0f));
    private static final RegistryObject<Item> LOBSTER = ItemFood.itemGen("lobster");
    private static final RegistryObject<Item> COOKED_LOBSTER = ItemFood.itemGen("cooked_lobster", ItemFood.food(7, 1.6f));

    // Register materials
    private static final RegistryObject<Item> SALT = ItemMaterial.itemGen("salt");
    private static final RegistryObject<Item> STEEL_INGOT = ItemMaterial.itemGen("steel_ingot");

    // Register tools
    private static final RegistryObject<Item> STEEL_SHOVEL = ItemTool.itemGenShovel("steel_shovel", ModItemTier.STEEL, 2.0f, -3.0f);
    private static final RegistryObject<Item> STEEL_PICKAXE = ItemTool.itemGenPickaxe("steel_pickaxe", ModItemTier.STEEL, 1, -2.8f);
    private static final RegistryObject<Item> STEEL_AXE = ItemTool.itemGenAxe("steel_axe", ModItemTier.STEEL, 6.0f, -3.0f);
    private static final RegistryObject<Item> STEEL_HOE = ItemTool.itemGenHoe("steel_hoe", ModItemTier.STEEL, -2, -0.5f);

    // Register weapons
    private static final RegistryObject<Item> STEEL_SWORD = ItemWeapon.itemGenSword("steel_sword", ModItemTier.STEEL, 3, -2.4f);

    // Register armor
    private static final RegistryObject<Item> STEEL_HELMET = ItemArmor.itemGen("steel_helmet", ModArmorMaterial.STEEL, EquipmentSlotType.HEAD);
    private static final RegistryObject<Item> STEEL_CHESTPLATE = ItemArmor.itemGen("steel_chestplate", ModArmorMaterial.STEEL, EquipmentSlotType.CHEST);
    private static final RegistryObject<Item> STEEL_LEGGINGS = ItemArmor.itemGen("steel_leggings", ModArmorMaterial.STEEL, EquipmentSlotType.LEGS);
    private static final RegistryObject<Item> STEEL_BOOTS = ItemArmor.itemGen("steel_boots", ModArmorMaterial.STEEL, EquipmentSlotType.FEET);

    // Register group icons
    public static final RegistryObject<Item> FOODS_ICON = COCONUT;
    public static final RegistryObject<Item> MATS_ICON = SALT;
    public static final RegistryObject<Item> TOOLS_ICON = STEEL_AXE;
    public static final RegistryObject<Item> WEAPONS_ICON = STEEL_SWORD;

    // Register materials for item tiers
    public static final RegistryObject<Item> STEEL = STEEL_INGOT;
}