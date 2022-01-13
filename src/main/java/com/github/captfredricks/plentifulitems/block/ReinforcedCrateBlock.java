package com.github.captfredricks.plentifulitems.block;

import com.github.captfredricks.plentifulitems.init.ModTileEntityTypes;
import com.github.captfredricks.plentifulitems.tileentity.ReinforcedCrateTileEntity;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.block.*;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.*;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * This class generates and interacts with the reinforced crate block.
 * @since 0.5.0
 */
public class ReinforcedCrateBlock extends ContainerBlock {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final ResourceLocation CONTENTS = new ResourceLocation("contents");

    /**
     * The class constructor.
     * @param properties the properties to pass to super
     */
    public ReinforcedCrateBlock(final Properties properties) {
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
        return ModTileEntityTypes.REINFORCED_CRATE.get().create();
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
    public void setPlacedBy(@Nonnull final World world, @Nonnull final BlockPos pos, @Nonnull final BlockState state, final LivingEntity placer, final ItemStack stack) {
        if(stack.hasCustomHoverName()) {
            TileEntity tileentity = world.getBlockEntity(pos);

            if(tileentity instanceof ReinforcedCrateTileEntity) {
                ((ReinforcedCrateTileEntity)tileentity).setCustomName(stack.getDisplayName());
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
        } else if(player.isSpectator()) {
            return ActionResultType.CONSUME;
        } else {
            TileEntity tileentity = world.getBlockEntity(pos);

            if(tileentity instanceof ReinforcedCrateTileEntity) {
                player.openMenu((ReinforcedCrateTileEntity)tileentity);
                //player.addStat(Stats.OPEN_SHULKER_BOX); // statistics data, not needed right now
                PiglinTasks.angerNearbyPiglins(player, true);

                return ActionResultType.CONSUME;
            } else {
                return ActionResultType.PASS;
            }
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

            if(tileentity instanceof ReinforcedCrateTileEntity) {
                world.updateNeighbourForOutputSignal(pos, state.getBlock());
            }

            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    /**
     * Called when the block is harvested, but before it is turned into air.
     * @param world the current world
     * @param pos the block's position
     * @param state the block state
     * @param player the player
     */
    @Override
    public void playerWillDestroy(final World world, @Nonnull final BlockPos pos, @Nonnull final BlockState state, @Nonnull final PlayerEntity player) {
        TileEntity tileentity = world.getBlockEntity(pos);

        if(tileentity instanceof ReinforcedCrateTileEntity) {
            ReinforcedCrateTileEntity reinforcedcratetileentity = (ReinforcedCrateTileEntity)tileentity;

            if(!world.isClientSide && player.isCreative() && !reinforcedcratetileentity.isEmpty()) {
                ItemStack itemstack = this.getItem(world, pos, state);
                CompoundNBT compoundnbt = reinforcedcratetileentity.saveToNbt(new CompoundNBT());

                if(!compoundnbt.isEmpty()) {
                    itemstack.addTagElement("BlockEntityTag", compoundnbt);
                }

                if(reinforcedcratetileentity.hasCustomName()) {
                    itemstack.setHoverName(reinforcedcratetileentity.getCustomName());
                }

                ItemEntity itementity = new ItemEntity(world, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickUpDelay();
                world.addFreshEntity(itementity);
            } else {
                reinforcedcratetileentity.unpackLootTable(player);
            }
        }

        super.playerWillDestroy(world, pos, state, player);
    }

    /**
     * Get the block's tile drops and do something with them.
     * @param state the block state
     * @param builder the loot context builder
     * @return List<ItemStack>
     */
    @Nonnull
    @Override
    public List<ItemStack> getDrops(@Nonnull final BlockState state, LootContext.Builder builder) {
        TileEntity tileentity = builder.getParameter(LootParameters.BLOCK_ENTITY);

        if(tileentity instanceof ReinforcedCrateTileEntity) {
            ReinforcedCrateTileEntity reinforcedcratetileentity = (ReinforcedCrateTileEntity)tileentity;

            builder = builder.withDynamicDrop(CONTENTS, (context, stackConsumer) -> {
                for(int i = 0; i < reinforcedcratetileentity.getContainerSize(); ++i) {
                    stackConsumer.accept(reinforcedcratetileentity.getItem(i));
                }
            });
        }

        return super.getDrops(state, builder);
    }

    /**
     * Get the block's item stack.
     * @param world the current world
     * @param pos the block's position
     * @param state the block state
     * @return ItemStack
     */
    @Nonnull
    public ItemStack getItem(@Nonnull final IBlockReader world, @Nonnull final BlockPos pos, @Nonnull final BlockState state) {
        ItemStack itemstack = super.getCloneItemStack(world, pos, state);
                //.getItem(world, pos, state);
        ReinforcedCrateTileEntity reinforcedcratetileentity = (ReinforcedCrateTileEntity)world.getBlockEntity(pos);
        CompoundNBT compoundnbt = reinforcedcratetileentity.saveToNbt(new CompoundNBT());

        if(!compoundnbt.isEmpty()) {
            itemstack.addTagElement("BlockEntityTag", compoundnbt);
        }

        return itemstack;
    }

    /**
     * Add the block's contents to the block item's tooltip.
     * @param stack the item stack
     * @param world the current world
     * @param tooltip the tooltip
     * @param flag the tooltip flag
     */
    @Override
    public void appendHoverText(@Nonnull final ItemStack stack, @Nullable final IBlockReader world, @Nonnull final List<ITextComponent> tooltip, @Nonnull final ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        CompoundNBT compoundnbt = stack.getTagElement("BlockEntityTag");

        if(compoundnbt != null) {
            if(compoundnbt.contains("LootTable", 8)) {
                tooltip.add(new StringTextComponent("???????"));
            }

            if(compoundnbt.contains("Items", 9)) {
                NonNullList<ItemStack> nonnulllist = NonNullList.withSize(27, ItemStack.EMPTY);
                ItemStackHelper.loadAllItems(compoundnbt, nonnulllist);
                int i = 0;
                int j = 0;

                for(ItemStack itemstack : nonnulllist) {
                    if(!itemstack.isEmpty()) {
                        ++j;
                        if(i <= 4) {
                            ++i;
                            IFormattableTextComponent iformattabletextcomponent = itemstack.getDisplayName().copy();
                            iformattabletextcomponent.append(" x").append(String.valueOf(itemstack.getCount()));
                            tooltip.add(iformattabletextcomponent);
                        }
                    }
                }

                if(j - i > 0) {
                    tooltip.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).withStyle(TextFormatting.ITALIC));
                }
            }
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
        return Container.getRedstoneSignalFromContainer((IInventory)world.getBlockEntity(pos));
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
