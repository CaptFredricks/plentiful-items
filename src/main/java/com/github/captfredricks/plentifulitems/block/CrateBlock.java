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

    /**
     * The class constructor.
     * @param properties the properties to pass to super
     */
    public CrateBlock(final Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(FACING, Direction.NORTH).setValue(OPEN, false));
    }

    /**
     * Type of render function to use.
     * @param state the block state
     * @return BlockRenderType
     */
    @Nonnull
    @Override
    public BlockRenderType getRenderShape(@Nonnull final BlockState state) {
        return BlockRenderType.MODEL;
    }

    /**
     * Whether the block has a tile entity.
     * @param state the block state
     * @return boolean
     */
    @Override
    public boolean hasTileEntity(final BlockState state) {
        return true;
    }

    /**
     * Create a tile entity for the block.
     * @param world the current world
     * @return TileEntity
     */
    @Nullable
    @Override
    public TileEntity newBlockEntity(@Nonnull final IBlockReader world) {
        return ModTileEntityTypes.CRATE.get().create();
    }

    /**
     * Called after the block has been placed.
     * @param world the current world
     * @param pos the block's position
     * @param state the block state
     * @param placer the player who placed the block
     * @param stack the item stack
     */
    @Override
    public void setPlacedBy(@Nonnull final World world, @Nonnull final BlockPos pos, @Nonnull final BlockState state, @Nullable final LivingEntity placer, final ItemStack stack) {
        if(stack.hasCustomHoverName()) {
            TileEntity tileentity = world.getBlockEntity(pos);

            if(tileentity instanceof CrateTileEntity) {
                ((CrateTileEntity)tileentity).setCustomName(stack.getDisplayName());
            }
        }
    }

    /**
     * Called when the block is interacted with.
     * @param state the block state
     * @param world the current world
     * @param pos the block's position
     * @param player the player
     * @param hand the hand used to interact with the block
     * @param hit ray trace for the block
     * @return ActionResultType
     */
    @Nonnull
    @Override
    public ActionResultType use(@Nonnull final BlockState state, final World world, @Nonnull final BlockPos pos, @Nonnull final PlayerEntity player, @Nonnull final Hand hand, @Nonnull final BlockRayTraceResult hit) {
        if(world.isClientSide) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity tileentity = world.getBlockEntity(pos);

            if(tileentity instanceof CrateTileEntity) {
                player.openMenu((CrateTileEntity)tileentity);
                //player.awardStat(Stats.OPEN_BARREL); // statistics data, not needed right now
                PiglinTasks.angerNearbyPiglins(player, true);
            }

            return ActionResultType.CONSUME;
        }
    }

    /**
     * Called when the block is broken or replaced.
     * @param state the block state
     * @param world the current world
     * @param pos the block's position
     * @param newState the new block state
     * @param isMoving whether the block is moving
     */
    @Override
    public void onRemove(final BlockState state, @Nonnull final World world, @Nonnull final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if(!state.is(newState.getBlock())) {
            TileEntity tileentity = world.getBlockEntity(pos);

            if(tileentity instanceof IInventory) {
                InventoryHelper.dropContents(world, pos, (IInventory)tileentity);
                world.updateNeighbourForOutputSignal(pos, this);
            }

            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    /**
     * Whether the block should have a comparator input override.
     * @param state the block state
     * @return boolean
     */
    @Override
    public boolean hasAnalogOutputSignal(@Nonnull final BlockState state) {
        return true;
    }

    /**
     * The strength of the redstone input override for comparators.
     * @param state the block state
     * @param world the current world
     * @param pos the block's position
     * @return int
     */
    @Override
    public int getAnalogOutputSignal(@Nonnull final BlockState state, final World world, @Nonnull final BlockPos pos) {
        return Container.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
    }

    /**
     * The current rotation based on the passed block state.
     * @param state the block state
     * @param rot the rotation
     * @return BlockState
     */
    @Nonnull
    @Override
    public BlockState rotate(final BlockState state, final Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    /**
     * The mirror of the current block state.
     * @param state the block state
     * @param mirror the mirrored block state
     * @return BlockState
     */
    @Nonnull
    @Override
    public BlockState mirror(final BlockState state, final Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    /**
     * Pass the block states to the state container builder.
     * @param builder the builder
     */
    @Override
    protected void createBlockStateDefinition(final StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    /**
     * The block state to use when placing the block.
     * @param context the block item use context
     * @return BlockState
     */
    @Override
    public BlockState getStateForPlacement(final BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }
}