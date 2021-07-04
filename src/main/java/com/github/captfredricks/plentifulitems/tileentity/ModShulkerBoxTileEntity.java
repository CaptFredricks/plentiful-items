package com.github.captfredricks.plentifulitems.tileentity;

import com.github.captfredricks.plentifulitems.block.ModShulkerBoxBlock;
import com.github.captfredricks.plentifulitems.block.ReinforcedCrateBlock;
import com.github.captfredricks.plentifulitems.container.ModShulkerBoxContainer;
import java.util.List;
import java.util.stream.IntStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public final class ModShulkerBoxTileEntity extends LockableLootTileEntity implements ISidedInventory, ITickableTileEntity {
    private static final int[] SLOTS = IntStream.range(0, 27).toArray();
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);
    private int openCount;
    private ModShulkerBoxTileEntity.AnimationStatus animationStatus = ModShulkerBoxTileEntity.AnimationStatus.CLOSED;
    private float progress;
    private float progressOld;
    @Nullable
    private DyeColor color;
    private boolean needsColorFromWorld;

    public ModShulkerBoxTileEntity(@Nullable DyeColor colorIn) {
        super(TileEntityType.SHULKER_BOX);
        this.color = colorIn;
    }

    public ModShulkerBoxTileEntity() {
        this((DyeColor)null);
        this.needsColorFromWorld = true;
    }

    @Override
    public void tick() {
        this.updateAnimation();
        if(this.animationStatus == ModShulkerBoxTileEntity.AnimationStatus.OPENING || this.animationStatus == ModShulkerBoxTileEntity.AnimationStatus.CLOSING) {
            this.moveCollidedEntities();
        }

    }

    protected void updateAnimation() {
        this.progressOld = this.progress;
        switch(this.animationStatus) {
            case CLOSED:
                this.progress = 0.0F;
                break;
            case OPENING:
                this.progress += 0.1F;
                if (this.progress >= 1.0F) {
                    this.moveCollidedEntities();
                    this.animationStatus = ModShulkerBoxTileEntity.AnimationStatus.OPENED;
                    this.progress = 1.0F;
                    this.func_213975_v();
                }
                break;
            case CLOSING:
                this.progress -= 0.1F;
                if (this.progress <= 0.0F) {
                    this.animationStatus = ModShulkerBoxTileEntity.AnimationStatus.CLOSED;
                    this.progress = 0.0F;
                    this.func_213975_v();
                }
                break;
            case OPENED:
                this.progress = 1.0F;
        }

    }

    public ModShulkerBoxTileEntity.AnimationStatus getAnimationStatus() {
        return this.animationStatus;
    }

    public AxisAlignedBB getBoundingBox(BlockState state) {
        return this.getBoundingBox(state.get(ModShulkerBoxBlock.FACING));
    }

    public AxisAlignedBB getBoundingBox(Direction direction) {
        float f = this.getProgress(1.0F);
        return VoxelShapes.fullCube().getBoundingBox().expand((double)(0.5F * f * (float)direction.getXOffset()), (double)(0.5F * f * (float)direction.getYOffset()), (double)(0.5F * f * (float)direction.getZOffset()));
    }

    private AxisAlignedBB getTopBoundingBox(Direction directionIn) {
        Direction direction = directionIn.getOpposite();
        return this.getBoundingBox(directionIn).contract((double)direction.getXOffset(), (double)direction.getYOffset(), (double)direction.getZOffset());
    }

    private void moveCollidedEntities() {
        BlockState blockstate = this.world.getBlockState(this.getPos());
        if(blockstate.getBlock() instanceof ModShulkerBoxBlock) {
            Direction direction = blockstate.get(ModShulkerBoxBlock.FACING);
            AxisAlignedBB axisalignedbb = this.getTopBoundingBox(direction).offset(this.pos);
            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity((Entity)null, axisalignedbb);
            if(!list.isEmpty()) {
                for(int i = 0; i < list.size(); ++i) {
                    Entity entity = list.get(i);
                    if(entity.getPushReaction() != PushReaction.IGNORE) {
                        double d0 = 0.0D;
                        double d1 = 0.0D;
                        double d2 = 0.0D;
                        AxisAlignedBB axisalignedbb1 = entity.getBoundingBox();
                        switch(direction.getAxis()) {
                            case X:
                                if(direction.getAxisDirection() == Direction.AxisDirection.POSITIVE) {
                                    d0 = axisalignedbb.maxX - axisalignedbb1.minX;
                                } else {
                                    d0 = axisalignedbb1.maxX - axisalignedbb.minX;
                                }

                                d0 = d0 + 0.01D;
                                break;
                            case Y:
                                if(direction.getAxisDirection() == Direction.AxisDirection.POSITIVE) {
                                    d1 = axisalignedbb.maxY - axisalignedbb1.minY;
                                } else {
                                    d1 = axisalignedbb1.maxY - axisalignedbb.minY;
                                }

                                d1 = d1 + 0.01D;
                                break;
                            case Z:
                                if(direction.getAxisDirection() == Direction.AxisDirection.POSITIVE) {
                                    d2 = axisalignedbb.maxZ - axisalignedbb1.minZ;
                                } else {
                                    d2 = axisalignedbb1.maxZ - axisalignedbb.minZ;
                                }

                                d2 = d2 + 0.01D;
                        }

                        entity.move(MoverType.SHULKER_BOX, new Vector3d(d0 * (double)direction.getXOffset(), d1 * (double)direction.getYOffset(), d2 * (double)direction.getZOffset()));
                    }
                }

            }
        }
    }

    @Override
    public int getSizeInventory() {
        return this.items.size();
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if(id == 1) {
            this.openCount = type;
            if(type == 0) {
                this.animationStatus = ModShulkerBoxTileEntity.AnimationStatus.CLOSING;
                this.func_213975_v();
            }

            if(type == 1) {
                this.animationStatus = ModShulkerBoxTileEntity.AnimationStatus.OPENING;
                this.func_213975_v();
            }

            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }

    private void func_213975_v() {
        this.getBlockState().updateNeighbours(this.getWorld(), this.getPos(), 3);
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if(!player.isSpectator()) {
            if(this.openCount < 0) {
                this.openCount = 0;
            }

            ++this.openCount;
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);
            if(this.openCount == 1) {
                this.world.playSound((PlayerEntity)null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_OPEN, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
            }
        }

    }

    @Override
    public void closeInventory(PlayerEntity player) {
        if(!player.isSpectator()) {
            --this.openCount;
            this.world.addBlockEvent(this.pos, this.getBlockState().getBlock(), 1, this.openCount);
            if(this.openCount <= 0) {
                this.world.playSound((PlayerEntity)null, this.pos, SoundEvents.BLOCK_SHULKER_BOX_CLOSE, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
            }
        }

    }

    @Nonnull
    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.shulkerBox");
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        super.read(state, nbt);
        this.loadFromNbt(nbt);
    }

    @Nonnull
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        return this.saveToNbt(compound);
    }

    public void loadFromNbt(CompoundNBT compound) {
        this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if(!this.checkLootAndRead(compound) && compound.contains("Items", 9)) {
            ItemStackHelper.loadAllItems(compound, this.items);
        }

    }

    public CompoundNBT saveToNbt(CompoundNBT compound) {
        if(!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.items, false);
        }

        return compound;
    }

    @Override
    public boolean isItemValidForSlot(final int index, @Nonnull final ItemStack stack) {
        boolean isCrate = (Block.getBlockFromItem(stack.getItem()) instanceof ReinforcedCrateBlock);
        boolean isShulker = (Block.getBlockFromItem(stack.getItem()) instanceof ModShulkerBoxBlock);

        return !isCrate && !isShulker;
    }

    @Nonnull
    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }

    @Nonnull
    @Override
    public int[] getSlotsForFace(Direction side) {
        return SLOTS;
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        boolean isCrate = (Block.getBlockFromItem(itemStackIn.getItem()) instanceof ReinforcedCrateBlock);
        boolean isShulker = (Block.getBlockFromItem(itemStackIn.getItem()) instanceof ModShulkerBoxBlock);

        return !isCrate && !isShulker;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return true;
    }

    public float getProgress(float progress) {
        return MathHelper.lerp(progress, this.progressOld, this.progress);
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public DyeColor getColor() {
        if (this.needsColorFromWorld) {
            this.color = ModShulkerBoxBlock.getColorFromBlock(this.getBlockState().getBlock());
            this.needsColorFromWorld = false;
        }

        return this.color;
    }

    @Nonnull
    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new ModShulkerBoxContainer(id, player, this);
    }

    public boolean isVisuallyClosed() {
        return this.animationStatus == ModShulkerBoxTileEntity.AnimationStatus.CLOSED;
    }

    @Nonnull
    @Override
    protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
        return new net.minecraftforge.items.wrapper.SidedInvWrapper(this, Direction.UP);
    }

    public static enum AnimationStatus {
        CLOSED,
        OPENING,
        OPENED,
        CLOSING;
    }
}
