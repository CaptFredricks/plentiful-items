package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.item.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class registers all custom modded items.
 * @since 0.1.0
 */
public final class ModItems {
    // Create a deferred register for items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    // Register foodstuffs
    public static final RegistryObject<Item> BANANA = ItemGenFood.gen("banana", new Item.Properties().food(ItemGenFood.food(4, 0.6f)));
    public static final RegistryObject<Item> MANGO = ItemGenFood.gen("mango", new Item.Properties().food(ItemGenFood.food(4, 0.6f)));
    public static final RegistryObject<Item> COCONUT = ItemGenFood.gen("coconut", new Item.Properties().food(ItemGenFood.food(4, 0.6f)));
    public static final RegistryObject<Item> BUTTER = ItemGenFood.gen("butter");
    public static final RegistryObject<Item> CHEESE = ItemGenFood.gen("cheese", new Item.Properties().food(ItemGenFood.food(6, 0.8f)));
    public static final RegistryObject<Item> SCRAMBLED_EGG = ItemGenFood.gen("scrambled_egg", new Item.Properties().food(ItemGenFood.food(8, 1.3f)));
    public static final RegistryObject<Item> COCONUT_CREAM_PIE = ItemGenFood.gen("coconut_cream_pie", new Item.Properties().food(ItemGenFood.food(8, 0.6f)));
    public static final RegistryObject<Item> CRAB = ItemGenFood.gen("crab");
    public static final RegistryObject<Item> COOKED_CRAB = ItemGenFood.gen("cooked_crab", new Item.Properties().food(ItemGenFood.food(5, 1.3f)));
    public static final RegistryObject<Item> SHRIMP = ItemGenFood.gen("shrimp");
    public static final RegistryObject<Item> COOKED_SHRIMP = ItemGenFood.gen("cooked_shrimp", new Item.Properties().food(ItemGenFood.food(3, 1.0f)));
    public static final RegistryObject<Item> LOBSTER = ItemGenFood.gen("lobster");
    public static final RegistryObject<Item> COOKED_LOBSTER = ItemGenFood.gen("cooked_lobster", new Item.Properties().food(ItemGenFood.food(7, 1.6f)));

    // Register materials
    public static final RegistryObject<Item> SALT = ItemGenMaterial.gen("salt");
    public static final RegistryObject<Item> STEEL_INGOT = ItemGenMaterial.gen("steel_ingot");
    public static final RegistryObject<Item> STEEL_RIVET = ItemGenMaterial.gen("steel_rivet");

    // Register tools
    public static final RegistryObject<Item> STEEL_SHOVEL = ItemGenTool.genShovel("steel_shovel", ModItemTier.STEEL, 2.0f, -3.0f);
    public static final RegistryObject<Item> STEEL_PICKAXE = ItemGenTool.genPickaxe("steel_pickaxe", ModItemTier.STEEL, 1, -2.8f);
    public static final RegistryObject<Item> STEEL_AXE = ItemGenTool.genAxe("steel_axe", ModItemTier.STEEL, 6.0f, -3.0f);
    public static final RegistryObject<Item> STEEL_HOE = ItemGenTool.genHoe("steel_hoe", ModItemTier.STEEL, -2, -0.5f);

    // Register weapons
    public static final RegistryObject<Item> STEEL_SWORD = ItemGenWeapon.genSword("steel_sword", ModItemTier.STEEL, 3, -2.4f);

    // Register armor
    public static final RegistryObject<Item> STEEL_HELMET = ItemGenArmor.gen("steel_helmet", ModArmorMaterial.STEEL, EquipmentSlotType.HEAD);
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ItemGenArmor.gen("steel_chestplate", ModArmorMaterial.STEEL, EquipmentSlotType.CHEST);
    public static final RegistryObject<Item> STEEL_LEGGINGS = ItemGenArmor.gen("steel_leggings", ModArmorMaterial.STEEL, EquipmentSlotType.LEGS);
    public static final RegistryObject<Item> STEEL_BOOTS = ItemGenArmor.gen("steel_boots", ModArmorMaterial.STEEL, EquipmentSlotType.FEET);

    // Register block items
    public static final RegistryObject<BlockItem> HALITE = ItemGenBlock.gen("halite", ModBlocks.HALITE);
    public static final RegistryObject<BlockItem> STEEL_BLOCK = ItemGenBlock.gen("steel_block", ModBlocks.STEEL_BLOCK);
    public static final RegistryObject<BlockItem> CRATE = ItemGenBlock.gen("crate", ModBlocks.CRATE);
    public static final RegistryObject<BlockItem> REINFORCED_CRATE = ItemGenBlock.gen("reinforced_crate", ModBlocks.REINFORCED_CRATE, new Item.Properties().maxStackSize(1));

    // Register group icons
    public static final RegistryObject<Item> FOODS_ICON = COCONUT;
    public static final RegistryObject<Item> MATS_ICON = SALT;
    public static final RegistryObject<Item> TOOLS_ICON = STEEL_AXE;
    public static final RegistryObject<Item> COMBAT_ICON = STEEL_SWORD;

    // Register materials for item tiers
    public static final RegistryObject<Item> STEEL = STEEL_INGOT;
}