package com.github.captfredricks.plentifulitems.block;

import com.github.captfredricks.plentifulitems.init.ModTileEntityTypes;
import com.github.captfredricks.plentifulitems.tileentity.CrateTileEntity;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * This class generates and interacts with the crate block.
 * @since 0.5.0
 */
public class CrateBlock extends ContainerBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public CrateBlock(final Properties properties) {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(OPEN, false));
    }

    @Override
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(final IBlockReader world) {
        return ModTileEntityTypes.CRATE.get().create();
    }

    @Nonnull
    @Override
    public ActionResultType onBlockActivated(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockRayTraceResult hit) {
        if(world.isRemote) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity tileentity = world.getTileEntity(pos);

            if(tileentity instanceof CrateTileEntity) {
                player.openContainer((CrateTileEntity)tileentity);
                //player.addStat(Stats.OPEN_BARREL); statistics data, not needed right now
                PiglinTasks.func_234478_a_(player, true);
            }

            return ActionResultType.CONSUME;
        }
    }

    @Override
    public void onBlockPlacedBy(final World world, final BlockPos pos, final BlockState state, @Nullable final LivingEntity placer, final ItemStack stack) {
        if(stack.hasDisplayName()) {
            TileEntity tileentity = world.getTileEntity(pos);

            if(tileentity instanceof CrateTileEntity) {
                ((CrateTileEntity)tileentity).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public void onReplaced(final BlockState state, final World world, final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if(!state.matchesBlock(newState.getBlock())) {
            TileEntity tileentity = world.getTileEntity(pos);

            if(tileentity instanceof IInventory) {
                InventoryHelper.dropInventoryItems(world, pos, (IInventory)tileentity);
                world.updateComparatorOutputLevel(pos, this);
            }

            super.onReplaced(state, world, pos, newState, isMoving);
        }
    }

    @Nonnull
    @Override
    public BlockRenderType getRenderType(final BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean hasComparatorInputOverride(final BlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(final BlockState blockState, final World world, final BlockPos pos) {
        return Container.calcRedstone(world.getTileEntity(pos));
    }

    @Nonnull
    @Override
    public BlockState rotate(final BlockState state, final Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(final BlockState state, final Mirror mirror) {
        return state.rotate(mirror.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(final StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    @Override
    public BlockState getStateForPlacement(final BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
    }
}