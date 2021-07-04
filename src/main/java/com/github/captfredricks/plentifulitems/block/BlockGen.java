package com.github.captfredricks.plentifulitems.block;

import com.github.captfredricks.plentifulitems.init.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

/**
 * This class generates and registers blocks.
 * @since 0.5.0
 */
public final class BlockGen {
    /**
     * Generates a block with custom properties.
     * @since 0.6.0
     * @param name the block's name
     * @param props the block's properties
     * @return RegistryObject<Block>
     */
    public static RegistryObject<Block> gen(final String name, final AbstractBlock.Properties props) {
        if(name.equals("crate")) {
            return ModBlocks.BLOCKS.register(name, () -> new CrateBlock(props));
        } else if(name.equals("reinforced_crate")) {
            return ModBlocks.BLOCKS.register(name, () -> new ReinforcedCrateBlock(props));
        } else {
            return ModBlocks.BLOCKS.register(name, () -> new Block(props));
        }
    }

    /**
     * Generates a block with default properties.
     * @since 0.6.0
     * @param name the block's name
     * @param material the block's material type
     * @return RegistryObject<Block>
     */
    public static RegistryObject<Block> gen(final String name, final Material material) {
        if(name.equals("crate")) {
            return ModBlocks.BLOCKS.register(name, () -> new CrateBlock(AbstractBlock.Properties.create(material)));
        } else if(name.equals("reinforced_crate")) {
            return ModBlocks.BLOCKS.register(name, () -> new ReinforcedCrateBlock(AbstractBlock.Properties.create(material)));
        } else {
            return ModBlocks.BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material)));
        }
    }
}
