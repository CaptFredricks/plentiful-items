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
    private static final RegistryObject<Item> BANANA = ItemGenFood.gen("banana", ItemGenFood.food(4, 0.6f));
    private static final RegistryObject<Item> MANGO = ItemGenFood.gen("mango", ItemGenFood.food(4, 0.6f));
    private static final RegistryObject<Item> COCONUT = ItemGenFood.gen("coconut", ItemGenFood.food(4, 0.6f));
    private static final RegistryObject<Item> BUTTER = ItemGenFood.gen("butter");
    private static final RegistryObject<Item> CHEESE = ItemGenFood.gen("cheese", ItemGenFood.food(6, 0.8f));
    private static final RegistryObject<Item> SCRAMBLED_EGG = ItemGenFood.gen("scrambled_egg", ItemGenFood.food(8, 1.0f));
    private static final RegistryObject<Item> COCONUT_CREAM_PIE = ItemGenFood.gen("coconut_cream_pie", ItemGenFood.food(8, 0.6f));
    private static final RegistryObject<Item> CRAB = ItemGenFood.gen("crab");
    private static final RegistryObject<Item> COOKED_CRAB = ItemGenFood.gen("cooked_crab", ItemGenFood.food(5, 1.3f));
    private static final RegistryObject<Item> SHRIMP = ItemGenFood.gen("shrimp");
    private static final RegistryObject<Item> COOKED_SHRIMP = ItemGenFood.gen("cooked_shrimp", ItemGenFood.food(3, 1.0f));
    private static final RegistryObject<Item> LOBSTER = ItemGenFood.gen("lobster");
    private static final RegistryObject<Item> COOKED_LOBSTER = ItemGenFood.gen("cooked_lobster", ItemGenFood.food(7, 1.6f));

    // Register materials
    private static final RegistryObject<Item> SALT = ItemGenMaterial.gen("salt");
    private static final RegistryObject<Item> STEEL_INGOT = ItemGenMaterial.gen("steel_ingot");

    // Register tools
    private static final RegistryObject<Item> STEEL_SHOVEL = ItemGenTool.genShovel("steel_shovel", ModItemTier.STEEL, 2.0f, -3.0f);
    private static final RegistryObject<Item> STEEL_PICKAXE = ItemGenTool.genPickaxe("steel_pickaxe", ModItemTier.STEEL, 1, -2.8f);
    private static final RegistryObject<Item> STEEL_AXE = ItemGenTool.genAxe("steel_axe", ModItemTier.STEEL, 6.0f, -3.0f);
    private static final RegistryObject<Item> STEEL_HOE = ItemGenTool.genHoe("steel_hoe", ModItemTier.STEEL, -2, -0.5f);

    // Register weapons
    private static final RegistryObject<Item> STEEL_SWORD = ItemGenWeapon.genSword("steel_sword", ModItemTier.STEEL, 3, -2.4f);

    // Register armor
    private static final RegistryObject<Item> STEEL_HELMET = ItemGenArmor.gen("steel_helmet", ModArmorMaterial.STEEL, EquipmentSlotType.HEAD);
    private static final RegistryObject<Item> STEEL_CHESTPLATE = ItemGenArmor.gen("steel_chestplate", ModArmorMaterial.STEEL, EquipmentSlotType.CHEST);
    private static final RegistryObject<Item> STEEL_LEGGINGS = ItemGenArmor.gen("steel_leggings", ModArmorMaterial.STEEL, EquipmentSlotType.LEGS);
    private static final RegistryObject<Item> STEEL_BOOTS = ItemGenArmor.gen("steel_boots", ModArmorMaterial.STEEL, EquipmentSlotType.FEET);

    // Register group icons
    public static final RegistryObject<Item> FOODS_ICON = COCONUT;
    public static final RegistryObject<Item> MATS_ICON = SALT;
    public static final RegistryObject<Item> TOOLS_ICON = STEEL_AXE;
    public static final RegistryObject<Item> WEAPONS_ICON = STEEL_SWORD;

    // Register materials for item tiers
    public static final RegistryObject<Item> STEEL = STEEL_INGOT;
}