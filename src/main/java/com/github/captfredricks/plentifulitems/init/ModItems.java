package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    // Foods
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new Item(new Item.Properties().tab(ModItemGroups.PI_ITEMS)));
    public static final RegistryObject<Item> BUTTER = ITEMS.register("butter", () -> new Item(new Item.Properties().tab(ModItemGroups.PI_ITEMS)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new Item(new Item.Properties().tab(ModItemGroups.PI_ITEMS)));
    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut", () -> new Item(new Item.Properties().tab(ModItemGroups.PI_ITEMS)));
    public static final RegistryObject<Item> COCONUT_CREAM_PIE = ITEMS.register("coconut_cream_pie", () -> new Item(new Item.Properties().tab(ModItemGroups.PI_ITEMS)));
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango", () -> new Item(new Item.Properties().tab(ModItemGroups.PI_ITEMS)));

    // Ingredients
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties().tab(ModItemGroups.PI_ITEMS)));
}