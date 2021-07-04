package com.github.captfredricks.plentifulitems.container;

import com.github.captfredricks.plentifulitems.block.ReinforcedCrateBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReinforcedCrateSlot extends Slot {
    private static final Logger LOGGER = LogManager.getLogger("CrateSlot");

    public ReinforcedCrateSlot(final IInventory inventory, final int slotIndex, final int xPosition, final int yPosition) {
        super(inventory, slotIndex, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(final ItemStack stack) {
        boolean isCrate = (Block.getBlockFromItem(stack.getItem()) instanceof ReinforcedCrateBlock);
        boolean isShulker = (Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock);

        return !isCrate && !isShulker;
    }
}