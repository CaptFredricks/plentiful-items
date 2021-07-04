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

public final class CrateDispenseBehavior extends OptionalDispenseBehavior {
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
