package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.block.*;
import com.github.captfredricks.plentifulitems.tileentity.ModShulkerBoxTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class registers all custom modded blocks.
 * @since 0.1.0
 */
public final class ModBlocks {
    // Create a deferred register for blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    // Register standard blocks
    public static final RegistryObject<Block> HALITE = BlockGen.gen("halite", AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.5f).sound(SoundType.BASALT).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool());
    public static final RegistryObject<Block> STEEL_BLOCK = BlockGen.gen("steel_block", AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool());

    // Register storage blocks
    public static final RegistryObject<Block> CRATE = BlockGen.gen("crate", AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2.5f, 2.5f).sound(SoundType.WOOD));
    public static final RegistryObject<Block> REINFORCED_CRATE = BlockGen.gen("reinforced_crate", AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(4.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool());

    // Register group icon
    public static final RegistryObject<Block> BLOCKS_ICON = CRATE;
}
