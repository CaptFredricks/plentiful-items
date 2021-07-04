package com.github.captfredricks.plentifulitems.container;

import javax.annotation.Nonnull;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.ShulkerBoxSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

/**
 * This class generates a container for reinforced crates.
 * @since 0.6.0
 */
public final class ReinforcedCrateContainer extends Container {
    private final IInventory inventory;

    public ReinforcedCrateContainer(final int id, final PlayerInventory playerInventory) {
        this(id, playerInventory, new Inventory(27));
    }

    public ReinforcedCrateContainer(final int id, final PlayerInventory playerInventory, final IInventory inventory) {
        super(ContainerType.SHULKER_BOX, id);
        assertInventorySize(inventory, 27);
        this.inventory = inventory;
        inventory.openInventory(playerInventory.player);

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                //this.addSlot(new ShulkerBoxSlot(inventory, j + i * 9, 8 + j * 18, 18 + i * 18));
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

    @Override
    public boolean canInteractWith(@Nonnull final PlayerEntity player) {
        return this.inventory.isUsableByPlayer(player);
    }

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

    @Override
    public void onContainerClosed(@Nonnull final PlayerEntity player) {
        super.onContainerClosed(player);
        this.inventory.closeInventory(player);
    }
}
