package com.github.captfredricks.plentifulitems.client.event;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.block.ReinforcedCrateBlock;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ShulkerBoxScreen;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * This class registers client-side events and event overrides.
 * @since 1.0.2
 */
@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public final class ClientEvents {
    /**
     * Cancel mouse event for placing reinforced crates in shulker boxes.
     * @param event the event
     */
    @SubscribeEvent
    public static void onPlaceCrateMouseEvent(final GuiScreenEvent.MouseReleasedEvent event) {
        if(Minecraft.getInstance().player != null) {
            boolean isShulkerScreen = (Minecraft.getInstance().screen instanceof ShulkerBoxScreen);
            ItemStack stack = Minecraft.getInstance().player.inventory.getCarried();
            boolean isCrate = (Block.byItem(stack.getItem()) instanceof ReinforcedCrateBlock);
            //boolean isShiftClick = Minecraft.getInstance().player.isSneaking();
            //Minecraft.getInstance().player.inventoryMenu.clicked();

            // NOTE: this only disables the regular drag and drop event, not the shift click event
            if(isShulkerScreen && isCrate) {
                //event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void a(final PlayerInteractEvent event) {

    }

    /*
    private static ModShulkerBoxBlock createShulkerBoxFromColorAndProperties(final DyeColor color, final AbstractBlock.Properties properties) {
        AbstractBlock.IPositionPredicate abstractblock$ipositionpredicate = (state, reader, pos) -> {
            TileEntity tileentity = reader.getTileEntity(pos);

            if(!(tileentity instanceof ModShulkerBoxTileEntity)) {
                return true;
            } else {
                ModShulkerBoxTileEntity shulkerboxtileentity = (ModShulkerBoxTileEntity)tileentity;
                return shulkerboxtileentity.isVisuallyClosed();
            }
        };

        return new ModShulkerBoxBlock(color, properties.hardnessAndResistance(2.0F).variableOpacity().notSolid().setSuffocates(abstractblock$ipositionpredicate).setBlocksVision(abstractblock$ipositionpredicate));
    }

     */
}
