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
    public ItemStack dispenseStack(@Nonnull final IBlockSource source, final ItemStack stack) {
        this.setSuccessful(false);
        Item item = stack.getItem();

        if(item instanceof BlockItem) {
            Direction direction = source.getBlockState().get(DispenserBlock.FACING);
            BlockPos blockpos = source.getBlockPos().offset(direction);
            Direction direction1 = source.getWorld().isAirBlock(blockpos.down()) ? direction : Direction.UP;
            this.setSuccessful(((BlockItem)item).tryPlace(new DirectionalPlaceContext(source.getWorld(), blockpos, direction, stack, direction1)).isSuccessOrConsume());
        }

        return stack;
    }
}
