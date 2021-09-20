package com.github.captfredricks.plentifulitems.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

/**
 * This class registers all custom building blocks.
 * @since 1.0.1
 */
public final class ModBuildingBlocks {
    // Blocks
    public static final Block HALITE = new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(2.0f, 2.5f).sound(SoundType.BASALT).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool());
    public static final Block STEEL_BLOCK = new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool());
}
