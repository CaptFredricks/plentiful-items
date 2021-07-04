package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.block.ModShulkerBoxBlock;
import com.github.captfredricks.plentifulitems.tileentity.ModShulkerBoxTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class registers all vanilla modded blocks.
 * @since 0.6.0
 */
public final class ModBlocksVanilla {
    private static final String VANID = "minecraft";

    // Create a deferred register for blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VANID);

    // Register blocks
    public static final RegistryObject<Block> SHULKER_BOX = BLOCKS.register("shulker_box",() -> createShulkerBoxFromColorAndProperties((DyeColor)null, AbstractBlock.Properties.create(Material.SHULKER)));
    public static final RegistryObject<Block> WHITE_SHULKER_BOX = BLOCKS.register("white_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.WHITE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.SNOW)));
    public static final RegistryObject<Block> ORANGE_SHULKER_BOX = BLOCKS.register("orange_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.ADOBE)));
    //public static final RegistryObject<Block> MAGENTA_SHULKER_BOX = BLOCKS.register("magenta_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.MAGENTA)));
    //public static final RegistryObject<Block> LIGHT_BLUE_SHULKER_BOX = BLOCKS.register("light_blue_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.LIGHT_BLUE)));
    //public static final RegistryObject<Block> YELLOW_SHULKER_BOX = BLOCKS.register("yellow_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.YELLOW)));
    //public static final RegistryObject<Block> LIME_SHULKER_BOX = BLOCKS.register("lime_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.LIME, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.LIME)));
    //public static final RegistryObject<Block> PINK_SHULKER_BOX = BLOCKS.register("pink_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.PINK, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.PINK)));
    //public static final RegistryObject<Block> GRAY_SHULKER_BOX = BLOCKS.register("gray_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.GRAY, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.GRAY)));
    //public static final RegistryObject<Block> LIGHT_GRAY_SHULKER_BOX = BLOCKS.register("light_gray_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.LIGHT_GRAY)));
    //public static final RegistryObject<Block> CYAN_SHULKER_BOX = BLOCKS.register("cyan_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.CYAN, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.CYAN)));
    //public static final RegistryObject<Block> PURPLE_SHULKER_BOX = BLOCKS.register("purple_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.PURPLE_TERRACOTTA)));
    //public static final RegistryObject<Block> BLUE_SHULKER_BOX = BLOCKS.register("blue_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.BLUE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.BLUE)));
    //public static final RegistryObject<Block> BROWN_SHULKER_BOX = BLOCKS.register("brown_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.BROWN, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.BROWN)));
    //public static final RegistryObject<Block> GREEN_SHULKER_BOX = BLOCKS.register("green_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.GREEN, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.GREEN)));
    //public static final RegistryObject<Block> RED_SHULKER_BOX = BLOCKS.register("red_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.RED, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.RED)));
    //public static final RegistryObject<Block> BLACK_SHULKER_BOX = BLOCKS.register("black_shulker_box", () -> createShulkerBoxFromColorAndProperties(DyeColor.BLACK, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.BLACK)));

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
}
