package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import net.minecraft.item.*;

/**
 * This class registers all custom tools.
 * @since 1.0.1
 */
public final class ModTools {
    // Item group
    private static final ItemGroup item_group = ModItemGroups.PI_TOOLS;

    // Items
    public static final Item STEEL_SHOVEL = new ShovelItem(ModItemTier.STEEL, 2.0f, -3.0f, new Item.Properties().tab(item_group));
    public static final Item STEEL_PICKAXE = new PickaxeItem(ModItemTier.STEEL, 1, -2.8f, new Item.Properties().tab(item_group));
    public static final Item STEEL_AXE = new AxeItem(ModItemTier.STEEL, 6.0f, -3.0f, new Item.Properties().tab(item_group));
    public static final Item STEEL_HOE = new HoeItem(ModItemTier.STEEL, -2, -0.5f, new Item.Properties().tab(item_group));
}
