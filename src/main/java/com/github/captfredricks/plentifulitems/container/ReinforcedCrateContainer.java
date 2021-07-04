package com.github.captfredricks.plentifulitems.container;

import javax.annotation.Nonnull;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

/**
 * This class generates a container for reinforced crates.
 * @since 0.6.0
 */
public final class ReinforcedCrateContainer extends Container {
    private final IInventory inventory;

    /**
     * The class constructor.
     * @param id the window id
     * @param playerInventory the player's inventory
     * @param inventory the container's inventory
     */
    public ReinforcedCrateContainer(final int id, final PlayerInventory playerInventory, final IInventory inventory) {
        super(ContainerType.SHULKER_BOX, id);
        assertInventorySize(inventory, 27);
        this.inventory = inventory;
        inventory.openInventory(playerInventory.player);

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new ReinforcedCrateSlot(inventory, j + i * 9, 8 + j * 18, 18 + i * 18));
            }
        }

        for(int k = 0; k < 3; ++k) {
            for(int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + k * 9 + 9, 8 + l * 18, 84 + k * 18));
            }
        }

        for(int m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

    }

    /**
     * Whether the player can use the container.
     * @param player the player
     * @return boolean
     */
    @Override
    public boolean canInteractWith(@Nonnull final PlayerEntity player) {
        return this.inventory.isUsableByPlayer(player);
    }

    /**
     * Handles shift-clicking item stacks between inventories.
     * @param player the player
     * @param index the item slot index
     * @return ItemStack
     */
    @Nonnull
    @Override
    public ItemStack transferStackInSlot(@Nonnull final PlayerEntity player, final int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if(slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if(index < this.inventory.getSizeInventory()) {
                if(!this.mergeItemStack(itemstack1, this.inventory.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if(!this.mergeItemStack(itemstack1, 0, this.inventory.getSizeInventory(), false)) {
                return ItemStack.EMPTY;
            }

            if(itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     * @param player the player
     */
    @Override
    public void onContainerClosed(@Nonnull final PlayerEntity player) {
        super.onContainerClosed(player);
        this.inventory.closeInventory(player);
    }
}
