package com.github.captfredricks.plentifulitems.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

/**
 * This class registers all custom decoration blocks.
 * @since 1.0.1
 */
public final class ModDecorationBlocks {
    // Blocks
    public static final Block CRATE = new CrateBlock(AbstractBlock.Properties.of(Material.WOOD).strength(2.5f, 2.5f).sound(SoundType.WOOD));
    public static final Block REINFORCED_CRATE = new ReinforcedCrateBlock(AbstractBlock.Properties.of(Material.METAL).strength(4.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2).requiresCorrectToolForDrops());
}
