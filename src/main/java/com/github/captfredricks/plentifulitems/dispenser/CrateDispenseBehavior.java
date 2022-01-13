package com.github.captfredricks.plentifulitems.dispenser;

import javax.annotation.Nonnull;
import net.minecraft.block.DispenserBlock;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.OptionalDispenseBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DirectionalPlaceContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;

/**
 * This class defines dispenser behavior for crates.
 * @since 0.6.0
 */
public final class CrateDispenseBehavior extends OptionalDispenseBehavior {
    /**
     * Dispense the specified stack.
     * @param source the block source
     * @param stack the item stack
     * @return ItemStack
     */
    @Nonnull
    @Override
    public ItemStack execute(@Nonnull final IBlockSource source, final ItemStack stack) {
        this.setSuccess(false);
        Item item = stack.getItem();

        if(item instanceof BlockItem) {
            Direction direction = source.getBlockState().getValue(DispenserBlock.FACING);
            BlockPos blockpos = source.getPos().relative(direction);
            Direction direction1 = source.getLevel().isEmptyBlock(blockpos.below()) ? direction : Direction.UP;
            this.setSuccess(((BlockItem)item).place(new DirectionalPlaceContext(source.getLevel(), blockpos, direction, stack, direction1)).consumesAction());
        }

        return stack;
    }
}
