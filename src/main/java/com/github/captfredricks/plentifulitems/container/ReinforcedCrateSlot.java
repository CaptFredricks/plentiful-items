package com.github.captfredricks.plentifulitems.container;

import com.github.captfredricks.plentifulitems.block.ReinforcedCrateBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

/**
 * This class defines restrictions for reinforced crate inventory slots.
 * @since 0.6.0
 */
public class ReinforcedCrateSlot extends Slot {
    /**
     * The class constructor.
     * @param inventory the inventory
     * @param slotIndex the slot's index
     * @param xPosition the slot's x-axis position
     * @param yPosition the slot's y-axis position
     */
    public ReinforcedCrateSlot(final IInventory inventory, final int slotIndex, final int xPosition, final int yPosition) {
        super(inventory, slotIndex, xPosition, yPosition);
    }

    /**
     * Whether an item stack can be placed in the slot.
     * @param stack the item stack
     * @return boolean
     */
    @Override
    public boolean isItemValid(final ItemStack stack) {
        boolean isCrate = (Block.getBlockFromItem(stack.getItem()) instanceof ReinforcedCrateBlock);
        boolean isShulker = (Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock);

        return !isCrate && !isShulker;
    }
}