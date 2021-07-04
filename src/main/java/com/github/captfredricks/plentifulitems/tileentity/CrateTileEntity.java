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
    public void read(@Nonnull final BlockState state, @Nonnull final CompoundNBT nbt) {
        super.read(state, nbt);
        this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);

        if(!this.checkLootAndRead(nbt)) {
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
    public CompoundNBT write(@Nonnull final CompoundNBT nbt) {
        super.write(nbt);

        if(!this.checkLootAndWrite(nbt)) {
            ItemStackHelper.saveAllItems(nbt, this.items);
        }

        return nbt;
    }

    /**
     * Fetch the block's inventory size.
     * @return int
     */
    @Override
    public int getSizeInventory() {
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
        return new TranslationTextComponent(ModBlocks.CRATE.get().getTranslationKey());
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
        return ChestContainer.createGeneric9X3(id, playerInventory, this);
    }

    /**
     * Called when the inventory is opened.
     * @param player the player
     */
    @Override
    public void openInventory(final PlayerEntity player) {
        if(!player.isSpectator()) {
            if(this.numPlayersUsing < 0) this.numPlayersUsing = 0;

            ++this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.numPlayersUsing);

            BlockState blockstate = this.getBlockState();
            boolean flag = blockstate.get(CrateBlock.OPEN);

            if(!flag && this.numPlayersUsing == 1) {
                this.playSound(SoundEvents.BLOCK_BARREL_OPEN);
                this.setOpenProperty(blockstate, true);
            }
        }
    }

    /**
     * Called when the inventory is closed.
     * @param player the player
     */
    @Override
    public void closeInventory(final PlayerEntity player) {
        if(!player.isSpectator()) {
            --this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.numPlayersUsing);

            BlockState blockstate = this.getBlockState();
            boolean flag = blockstate.get(CrateBlock.OPEN);

            if(flag && this.numPlayersUsing <= 0) {
                this.playSound(SoundEvents.BLOCK_BARREL_CLOSE);
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
        this.world.setBlockState(this.getPos(), state.with(CrateBlock.OPEN, open), 3);
    }

    /**
     * Play a sound event.
     * @param sound the sound event to play
     */
    private void playSound(final SoundEvent sound) {
        this.world.playSound((PlayerEntity)null, this.pos, sound, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
    }
}