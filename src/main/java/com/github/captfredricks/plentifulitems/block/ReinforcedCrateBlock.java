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
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(OPEN, false));
    }

    /**
     * Type of render function to use.
     * @param state the block state
     * @return BlockRenderType
     */
    @Nonnull
    @Override
    public BlockRenderType getRenderType(@Nonnull final BlockState state) {
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
    public TileEntity createNewTileEntity(@Nonnull final IBlockReader world) {
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
    public void onBlockPlacedBy(@Nonnull final World world, @Nonnull final BlockPos pos, @Nonnull final BlockState state, final LivingEntity placer, final ItemStack stack) {
        if(stack.hasDisplayName()) {
            TileEntity tileentity = world.getTileEntity(pos);

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
    public ActionResultType onBlockActivated(@Nonnull final BlockState state, final World world, @Nonnull final BlockPos pos, @Nonnull final PlayerEntity player, @Nonnull final Hand hand, @Nonnull final BlockRayTraceResult hit) {
        if(world.isRemote) {
            return ActionResultType.SUCCESS;
        } else if(player.isSpectator()) {
            return ActionResultType.CONSUME;
        } else {
            TileEntity tileentity = world.getTileEntity(pos);

            if(tileentity instanceof ReinforcedCrateTileEntity) {
                player.openContainer((ReinforcedCrateTileEntity)tileentity);
                //player.addStat(Stats.OPEN_SHULKER_BOX);
                PiglinTasks.func_234478_a_(player, true);

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
    public void onReplaced(final BlockState state, @Nonnull final World world, @Nonnull final BlockPos pos, final BlockState newState, final boolean isMoving) {
        if(!state.matchesBlock(newState.getBlock())) {
            TileEntity tileentity = world.getTileEntity(pos);

            if(tileentity instanceof ReinforcedCrateTileEntity) {
                world.updateComparatorOutputLevel(pos, state.getBlock());
            }

            super.onReplaced(state, world, pos, newState, isMoving);
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
    public void onBlockHarvested(final World world, @Nonnull final BlockPos pos, @Nonnull final BlockState state, @Nonnull final PlayerEntity player) {
        TileEntity tileentity = world.getTileEntity(pos);

        if(tileentity instanceof ReinforcedCrateTileEntity) {
            ReinforcedCrateTileEntity reinforcedcratetileentity = (ReinforcedCrateTileEntity)tileentity;

            if(!world.isRemote && player.isCreative() && !reinforcedcratetileentity.isEmpty()) {
                ItemStack itemstack = this.getItem(world, pos, state);
                CompoundNBT compoundnbt = reinforcedcratetileentity.saveToNbt(new CompoundNBT());

                if(!compoundnbt.isEmpty()) {
                    itemstack.setTagInfo("BlockEntityTag", compoundnbt);
                }

                if(reinforcedcratetileentity.hasCustomName()) {
                    itemstack.setDisplayName(reinforcedcratetileentity.getCustomName());
                }

                ItemEntity itementity = new ItemEntity(world, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, itemstack);
                itementity.setDefaultPickupDelay();
                world.addEntity(itementity);
            } else {
                reinforcedcratetileentity.fillWithLoot(player);
            }
        }

        super.onBlockHarvested(world, pos, state, player);
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
        TileEntity tileentity = builder.get(LootParameters.BLOCK_ENTITY);

        if(tileentity instanceof ReinforcedCrateTileEntity) {
            ReinforcedCrateTileEntity reinforcedcratetileentity = (ReinforcedCrateTileEntity)tileentity;

            builder = builder.withDynamicDrop(CONTENTS, (context, stackConsumer) -> {
                for(int i = 0; i < reinforcedcratetileentity.getSizeInventory(); ++i) {
                    stackConsumer.accept(reinforcedcratetileentity.getStackInSlot(i));
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
    @Override
    public ItemStack getItem(@Nonnull final IBlockReader world, @Nonnull final BlockPos pos, @Nonnull final BlockState state) {
        ItemStack itemstack = super.getItem(world, pos, state);
        ReinforcedCrateTileEntity reinforcedcratetileentity = (ReinforcedCrateTileEntity)world.getTileEntity(pos);
        CompoundNBT compoundnbt = reinforcedcratetileentity.saveToNbt(new CompoundNBT());

        if(!compoundnbt.isEmpty()) {
            itemstack.setTagInfo("BlockEntityTag", compoundnbt);
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
    public void addInformation(@Nonnull final ItemStack stack, @Nullable final IBlockReader world, @Nonnull final List<ITextComponent> tooltip, @Nonnull final ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        CompoundNBT compoundnbt = stack.getChildTag("BlockEntityTag");

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
                            IFormattableTextComponent iformattabletextcomponent = itemstack.getDisplayName().deepCopy();
                            iformattabletextcomponent.appendString(" x").appendString(String.valueOf(itemstack.getCount()));
                            tooltip.add(iformattabletextcomponent);
                        }
                    }
                }

                if(j - i > 0) {
                    tooltip.add((new TranslationTextComponent("container.shulkerBox.more", j - i)).mergeStyle(TextFormatting.ITALIC));
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
    public boolean hasComparatorInputOverride(@Nonnull final BlockState state) {
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
    public int getComparatorInputOverride(@Nonnull final BlockState state, final World world, @Nonnull final BlockPos pos) {
        return Container.calcRedstoneFromInventory((IInventory)world.getTileEntity(pos));
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
        return state.with(FACING, rot.rotate(state.get(FACING)));
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
        return state.rotate(mirror.toRotation(state.get(FACING)));
    }

    /**
     * Pass the block states to the state container builder.
     * @param builder the builder
     */
    @Override
    protected void fillStateContainer(final StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }

    /**
     * The block state to use when placing the block.
     * @param context the block item use context
     * @return BlockState
     */
    @Override
    public BlockState getStateForPlacement(final BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, context.getNearestLookingDirection().getOpposite());
    }
}
