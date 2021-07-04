package com.github.captfredricks.plentifulitems.item;

import com.github.captfredricks.plentifulitems.init.ModItemGroups;
import com.github.captfredricks.plentifulitems.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

/**
 * This class generates and registers block items.
 * @since 0.6.0
 */
public final class ItemGenBlock {
    private static final ItemGroup item_group = ModItemGroups.PI_BLOCKS;

    /**
     * Generates a block item with custom properties.
     * @since 0.6.0
     * @param name the item's name
     * @param block the block the item is associated with
     * @param props the item's properties
     * @return RegistryObject<BlockItem>
     */
    public static RegistryObject<BlockItem> gen(final String name, final RegistryObject<Block> block, final Item.Properties props) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), props.group(item_group)));
    }

    /**
     * Generates a block item with default properties.
     * @since 0.6.0
     * @param name the item's name
     * @param block the block the item is associated with
     * @return RegistryObject<BlockItem>
     */
    public static RegistryObject<BlockItem> gen(final String name, final RegistryObject<Block> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(item_group)));
    }
}
