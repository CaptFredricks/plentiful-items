package com.github.captfredricks.plentifulitems.tileentity;

import com.github.captfredricks.plentifulitems.block.ReinforcedCrateBlock;
import com.github.captfredricks.plentifulitems.container.ReinforcedCrateContainer;
import com.github.captfredricks.plentifulitems.init.ModBlocks;
import com.github.captfredricks.plentifulitems.init.ModTileEntityTypes;
import java.util.stream.IntStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
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
    private static final int[] SLOTS = IntStream.range(0, 27).toArray();
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
    private int numPlayersUsing;

    public ReinforcedCrateTileEntity() {
        super(ModTileEntityTypes.REINFORCED_CRATE.get());
    }

    @Override
    public void read(@Nonnull final BlockState state, @Nonnull final CompoundNBT nbt) {
        super.read(state, nbt);
        this.loadFromNbt(nbt);
    }

    @Nonnull
    @Override
    public CompoundNBT write(@Nonnull final CompoundNBT compound) {
        super.write(compound);
        return this.saveToNbt(compound);
    }

    @Override
    public int getSizeInventory() {
        return this.items.size();
    }

    @Nonnull
    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(@Nonnull final NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Nonnull
    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent(ModBlocks.REINFORCED_CRATE.get().getTranslationKey());
    }

    @Nonnull
    @Override
    protected Container createMenu(final int id, @Nonnull final PlayerInventory player) {
        //return new ShulkerBoxContainer(id, player, this);
        return new ReinforcedCrateContainer(id, player, this);
    }

    @Override
    public void openInventory(final PlayerEntity player) {
        if(!player.isSpectator()) {
            if(this.numPlayersUsing < 0) this.numPlayersUsing = 0;

            ++this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.numPlayersUsing);

            BlockState blockstate = this.getBlockState();
            boolean flag = blockstate.get(ReinforcedCrateBlock.OPEN);

            if(!flag && this.numPlayersUsing == 1) {
                this.playSound(SoundEvents.BLOCK_BARREL_OPEN);
                this.setOpenProperty(blockstate, true);
            }
        }
    }

    @Override
    public void closeInventory(final PlayerEntity player) {
        if(!player.isSpectator()) {
            --this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.numPlayersUsing);

            BlockState blockstate = this.getBlockState();
            boolean flag = blockstate.get(ReinforcedCrateBlock.OPEN);

            if(flag && this.numPlayersUsing <= 0) {
                this.playSound(SoundEvents.BLOCK_BARREL_CLOSE);
                this.setOpenProperty(blockstate, false);
            }
        }
    }

    public void loadFromNbt(final CompoundNBT compound) {
        this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);

        if(!this.checkLootAndRead(compound) && compound.contains("Items", 9)) {
            ItemStackHelper.loadAllItems(compound, this.items);
        }

    }

    public CompoundNBT saveToNbt(final CompoundNBT compound) {
        if(!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.items, false);
        }

        return compound;
    }

    @Override
    public boolean isItemValidForSlot(final int index, @Nonnull final ItemStack stack) {
        boolean isCrate = (Block.getBlockFromItem(stack.getItem()) instanceof ReinforcedCrateBlock);
        boolean isShulker = (Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock);

        return !isCrate && !isShulker;
    }
    /*
    @Nonnull
    @Override
    public int[] getSlotsForFace(@Nonnull final Direction side) {
        return SLOTS;
    }

    @Override
    public boolean canInsertItem(final int index, final ItemStack stack, @Nullable final Direction direction) {
        boolean isCrate = (Block.getBlockFromItem(stack.getItem()) instanceof ReinforcedCrateBlock);
        boolean isShulker = (Block.getBlockFromItem(stack.getItem()) instanceof ShulkerBoxBlock);

        return !isCrate && !isShulker;
    }

    @Override
    public boolean canExtractItem(final int index, @Nonnull final ItemStack stack, @Nonnull final Direction direction) {
        return true;
    }*/

    /**
     * Toggle the 'open' block state property.
     * @param state the block state
     * @param open the prop to toggle
     */
    private void setOpenProperty(final BlockState state, final boolean open) {
        this.world.setBlockState(this.getPos(), state.with(ReinforcedCrateBlock.OPEN, open), 3);
    }

    /**
     * Play a sound event.
     * @param sound the sound event to play
     */
    private void playSound(final SoundEvent sound) {
        this.world.playSound((PlayerEntity)null, this.pos, sound, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
    }
}
