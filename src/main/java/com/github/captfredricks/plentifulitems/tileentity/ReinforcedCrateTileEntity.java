package com.github.captfredricks.plentifulitems.tileentity;

import com.github.captfredricks.plentifulitems.block.ReinforcedCrateBlock;
import com.github.captfredricks.plentifulitems.container.ReinforcedCrateContainer;
import com.github.captfredricks.plentifulitems.init.ModBlocks;
import com.github.captfredricks.plentifulitems.init.ModTileEntityTypes;
import javax.annotation.Nonnull;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * This class generates a tile entity for reinforced crates.
 * @since 0.5.0
 */
public final class ReinforcedCrateTileEntity extends LockableLootTileEntity implements IInventory {
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
    private int numPlayersUsing;

    /**
     * The class constructor.
     */
    public ReinforcedCrateTileEntity() {
        super(ModTileEntityTypes.REINFORCED_CRATE.get());
    }

    /**
     * Read the block's NBT data.
     * @param state the block state
     * @param nbt the NBT data
     */
    @Override
    public void load(@Nonnull final BlockState state, @Nonnull final CompoundNBT nbt) {
        super.load(state, nbt);
        this.loadFromNbt(nbt);
    }

    /**
     * Write the block's NBT data.
     * @param nbt the NBT data
     * @return CompoundNBT
     */
    @Nonnull
    @Override
    public CompoundNBT save(@Nonnull final CompoundNBT nbt) {
        super.save(nbt);
        return this.saveToNbt(nbt);
    }

    /**
     * Fetch the size of the block's inventory.
     * @return int
     */
    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    /**
     * Getter method for the block's contents.
     * @return NonNullList<ItemStack>
     */
    @Nonnull
    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    /**
     * Setter method for the block's contents.
     * @param items the items stored in the block
     */
    @Override
    protected void setItems(@Nonnull final NonNullList<ItemStack> items) {
        this.items = items;
    }

    /**
     * Get the translation-friendly name of the block.
     * @return ITextComponent
     */
    @Nonnull
    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent(ModBlocks.REINFORCED_CRATE.get().getDescriptionId());
    }

    /**
     * Create a menu container for the block.
     * @param id the window id
     * @param playerInventory the player's inventory
     * @return Container
     */
    @Nonnull
    @Override
    protected Container createMenu(final int id, @Nonnull final PlayerInventory playerInventory) {
        return new ReinforcedCrateContainer(id, playerInventory, this);
    }

    /**
     * Called when the inventory is opened.
     * @param player the player
     */
    @Override
    public void startOpen(final PlayerEntity player) {
        if(!player.isSpectator()) {
            if(this.numPlayersUsing < 0) this.numPlayersUsing = 0;

            ++this.numPlayersUsing;
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.numPlayersUsing);

            BlockState blockstate = this.getBlockState();
            boolean flag = blockstate.getValue(ReinforcedCrateBlock.OPEN);

            if(!flag && this.numPlayersUsing == 1) {
                this.playSound(SoundEvents.BARREL_OPEN);
                this.setOpenProperty(blockstate, true);
            }
        }
    }

    /**
     * Called when the inventory is closed.
     * @param player the player
     */
    @Override
    public void stopOpen(final PlayerEntity player) {
        if(!player.isSpectator()) {
            --this.numPlayersUsing;
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.numPlayersUsing);

            BlockState blockstate = this.getBlockState();
            boolean flag = blockstate.getValue(ReinforcedCrateBlock.OPEN);

            if(flag && this.numPlayersUsing <= 0) {
                this.playSound(SoundEvents.BARREL_CLOSE);
                this.setOpenProperty(blockstate, false);
            }
        }
    }

    /**
     * Load the contents from the NBT tag.
     * @param nbt the NBT data
     */
    public void loadFromNbt(final CompoundNBT nbt) {
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);

        if(!this.tryLoadLootTable(nbt) && nbt.contains("Items", 9)) {
            ItemStackHelper.loadAllItems(nbt, this.items);
        }

    }

    /**
     * Save the contents to an NBT tag.
     * @param nbt the NBT data
     * @return CompoundNBT
     */
    public CompoundNBT saveToNbt(final CompoundNBT nbt) {
        if(!this.trySaveLootTable(nbt)) {
            ItemStackHelper.saveAllItems(nbt, this.items, false);
        }

        return nbt;
    }

    /**
     * Whether an item stack can be placed in the slot via automation.
     * @param index the inventory index
     * @param stack the item stack
     * @return boolean
     */
    @Override
    public boolean canPlaceItem(final int index, @Nonnull final ItemStack stack) {
        boolean isCrate = (Block.byItem(stack.getItem()) instanceof ReinforcedCrateBlock);
        boolean isShulker = (Block.byItem(stack.getItem()) instanceof ShulkerBoxBlock);

        return !isCrate && !isShulker;
    }

    /**
     * Toggle the 'open' block state property.
     * @param state the block state
     * @param open the prop to toggle
     */
    private void setOpenProperty(final BlockState state, final boolean open) {
        this.level.setBlock(this.getBlockPos(), state.setValue(ReinforcedCrateBlock.OPEN, open), 3);
    }

    /**
     * Play a sound event.
     * @param sound the sound event to play
     */
    private void playSound(final SoundEvent sound) {
        this.level.playSound((PlayerEntity)null, this.worldPosition, sound, SoundCategory.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
    }
}
