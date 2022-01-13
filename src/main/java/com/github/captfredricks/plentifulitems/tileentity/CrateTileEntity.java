package com.github.captfredricks.plentifulitems.tileentity;

import com.github.captfredricks.plentifulitems.block.CrateBlock;
import com.github.captfredricks.plentifulitems.init.ModBlocks;
import com.github.captfredricks.plentifulitems.init.ModTileEntityTypes;
import javax.annotation.Nonnull;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * This class generates a tile entity for crates.
 * @since 0.5.0
 */
public class CrateTileEntity extends LockableLootTileEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
    private int numPlayersUsing;

    /**
     * The class constructor.
     */
    public CrateTileEntity() {
        super(ModTileEntityTypes.CRATE.get());
    }

    /**
     * Read the block's NBT data.
     * @param state the block state
     * @param nbt the NBT data
     */
    @Override
    public void load(@Nonnull final BlockState state, @Nonnull final CompoundNBT nbt) {
        super.load(state, nbt);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);

        if(!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.items);
        }
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

        if(!this.trySaveLootTable(nbt)) {
            ItemStackHelper.saveAllItems(nbt, this.items);
        }

        return nbt;
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
        return new TranslationTextComponent(ModBlocks.CRATE.get().getDescriptionId());
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
        return ChestContainer.threeRows(id, playerInventory, this);
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
            //this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.numPlayersUsing);

            BlockState blockstate = this.getBlockState();
            boolean flag = blockstate.getValue(CrateBlock.OPEN);

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
            //this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.numPlayersUsing);

            BlockState blockstate = this.getBlockState();
            boolean flag = blockstate.getValue(CrateBlock.OPEN);

            if(flag && this.numPlayersUsing <= 0) {
                this.playSound(SoundEvents.BARREL_CLOSE);
                this.setOpenProperty(blockstate, false);
            }
        }
    }

    /**
     * Toggle the 'open' block state property.
     * @param state the block state
     * @param open the prop to toggle
     */
    private void setOpenProperty(final BlockState state, final boolean open) {
        this.level.setBlock(this.getBlockPos(), state.setValue(CrateBlock.OPEN, open), 3);
        //this.world.setBlockState(this.getPos(), state.with(CrateBlock.OPEN, open), 3);
    }

    /**
     * Play a sound event.
     * @param sound the sound event to play
     */
    private void playSound(final SoundEvent sound) {
        this.level.playSound((PlayerEntity)null, this.worldPosition, sound, SoundCategory.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
        //this.world.playSound((PlayerEntity)null, this.pos, sound, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
    }
}