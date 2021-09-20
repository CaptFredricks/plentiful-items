package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.item.*;
import net.minecraft.block.Block;
import net.minecraft.item.*;
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

    // Building blocks
    public static final RegistryObject<BlockItem> HALITE = reg("halite", ModBlocks.HALITE, ModBlockItems.HALITE);
    public static final RegistryObject<BlockItem> STEEL_BLOCK = reg("steel_block", ModBlocks.STEEL_BLOCK, ModBlockItems.STEEL_BLOCK);

    // Decoration blocks
    public static final RegistryObject<BlockItem> CRATE = reg("crate", ModBlocks.CRATE, ModBlockItems.CRATE);
    public static final RegistryObject<BlockItem> REINFORCED_CRATE = reg("reinforced_crate", ModBlocks.REINFORCED_CRATE, ModBlockItems.REINFORCED_CRATE);

    // Foods
    public static final RegistryObject<Item> BANANA = reg("banana", ModFoods.BANANA);
    public static final RegistryObject<Item> MANGO = reg("mango", ModFoods.MANGO);
    public static final RegistryObject<Item> COCONUT = reg("coconut", ModFoods.COCONUT);
    public static final RegistryObject<Item> BUTTER = reg("butter", ModFoods.BUTTER);
    public static final RegistryObject<Item> CHEESE = reg("cheese", ModFoods.CHEESE);
    public static final RegistryObject<Item> SCRAMBLED_EGG = reg("scrambled_egg", ModFoods.SCRAMBLED_EGG);
    public static final RegistryObject<Item> COCONUT_CREAM_PIE = reg("coconut_cream_pie", ModFoods.COCONUT_CREAM_PIE);
    public static final RegistryObject<Item> CRAB = reg("crab", ModFoods.CRAB);
    public static final RegistryObject<Item> COOKED_CRAB = reg("cooked_crab", ModFoods.COOKED_CRAB);
    public static final RegistryObject<Item> SHRIMP = reg("shrimp", ModFoods.SHRIMP);
    public static final RegistryObject<Item> COOKED_SHRIMP = reg("cooked_shrimp", ModFoods.COOKED_SHRIMP);
    public static final RegistryObject<Item> LOBSTER = reg("lobster", ModFoods.LOBSTER);
    public static final RegistryObject<Item> COOKED_LOBSTER = reg("cooked_lobster", ModFoods.COOKED_LOBSTER);

    // Materials
    public static final RegistryObject<Item> SALT = reg("salt", ModMaterials.SALT);
    public static final RegistryObject<Item> STEEL_INGOT = reg("steel_ingot", ModMaterials.STEEL_INGOT);
    public static final RegistryObject<Item> STEEL_RIVET = reg("steel_rivet", ModMaterials.STEEL_RIVET);

    // Tools
    public static final RegistryObject<Item> STEEL_SHOVEL = reg("steel_shovel", ModTools.STEEL_SHOVEL);
    public static final RegistryObject<Item> STEEL_PICKAXE = reg("steel_pickaxe", ModTools.STEEL_PICKAXE);
    public static final RegistryObject<Item> STEEL_AXE = reg("steel_axe", ModTools.STEEL_AXE);
    public static final RegistryObject<Item> STEEL_HOE = reg("steel_hoe", ModTools.STEEL_HOE);

    // Weapons
    public static final RegistryObject<Item> STEEL_SWORD = reg("steel_sword", ModWeapons.STEEL_SWORD);

    // Armor
    public static final RegistryObject<Item> STEEL_HELMET = reg("steel_helmet", ModArmor.STEEL_HELMET);
    public static final RegistryObject<Item> STEEL_CHESTPLATE = reg("steel_chestplate", ModArmor.STEEL_CHESTPLATE);
    public static final RegistryObject<Item> STEEL_LEGGINGS = reg("steel_leggings", ModArmor.STEEL_LEGGINGS);
    public static final RegistryObject<Item> STEEL_BOOTS = reg("steel_boots", ModArmor.STEEL_BOOTS);

    // Group icons
    public static final RegistryObject<Item> FOODS_ICON = COCONUT;
    public static final RegistryObject<Item> MATS_ICON = SALT;
    public static final RegistryObject<Item> TOOLS_ICON = STEEL_AXE;
    public static final RegistryObject<Item> COMBAT_ICON = STEEL_SWORD;

    // Materials for item tiers
    public static final RegistryObject<Item> STEEL = STEEL_INGOT;

    /**
     * Register custom block items.
     * @since 1.0.1
     * @param name the block item's name
     * @param block the block
     * @param props the block item's props
     * @return RegistryObject<BlockItem>
     */
    private static RegistryObject<BlockItem> reg(final String name, final RegistryObject<Block> block, final Item.Properties props) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), props));
    }

    /**
     * Register custom items.
     * @since 1.0.1
     * @param name the item's name
     * @param item the item
     * @return RegistryObject<Item>
     */
    private static RegistryObject<Item> reg(final String name, final Item item) {
        return ITEMS.register(name, () -> item);
    }
}