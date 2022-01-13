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
        checkContainerSize(inventory, 27);
        this.inventory = inventory;
        inventory.startOpen(playerInventory.player);

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
    public boolean stillValid(@Nonnull final PlayerEntity player) {
        return this.inventory.stillValid(player);
    }

    /**
     * Handles shift-clicking item stacks between inventories.
     * @param player the player
     * @param index the item slot index
     * @return ItemStack
     */
    @Nonnull
    @Override
    public ItemStack quickMoveStack(@Nonnull final PlayerEntity player, final int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if(slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if(index < this.inventory.getContainerSize()) {
                if(!this.moveItemStackTo(itemstack1, this.inventory.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if(!this.moveItemStackTo(itemstack1, 0, this.inventory.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if(itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     * @param player the player
     */
    @Override
    public void removed(@Nonnull final PlayerEntity player) {
        super.removed(player);
        this.inventory.stopOpen(player);
    }
}
