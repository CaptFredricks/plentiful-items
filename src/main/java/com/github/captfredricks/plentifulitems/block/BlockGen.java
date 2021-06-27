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
    private final String name;
    private final Material material;
    private final float hardness;
    private final float resistance;
    private final SoundType sound;
    private final ToolType tool;
    private final int level;
    private final boolean requires_tool;

    /**
     * Class constructor (tool specific block).
     * @since 0.5.0
     * @param name the block's name
     * @param material the block's material type
     * @param hardness the block's hardness (durability)
     * @param resistance the block's blast resistance
     * @param sound the sound the block makes when placed
     * @param tool the ideal tool to break the block
     * @param level the tool level required to break the block and receive it as an item
     * @param requires_tool whether the specified tool is required in order to receive the block item
     */
    public BlockGen(final String name, final Material material, final float hardness, final float resistance, final SoundType sound, final ToolType tool, final int level, final boolean requires_tool) {
        this.name = name;
        this.material = material;
        this.hardness = hardness;
        this.resistance = resistance;
        this.sound = sound;
        this.tool = tool;
        this.level = level;
        this.requires_tool = requires_tool;
    }

    /**
     * Class constructor (non-tool specific block).
     * @since 0.5.0
     * @param name the block's name
     * @param material the block's material type
     * @param hardness the block's hardness (durability)
     * @param resistance the block's blast resistance
     * @param sound the sound the block makes when placed
     */
    public BlockGen(final String name, final Material material, final float hardness, final float resistance, final SoundType sound) {
        this.name = name;
        this.material = material;
        this.hardness = hardness;
        this.resistance = resistance;
        this.sound = sound;
        this.tool = null;
        this.level = -1;
        this.requires_tool = false;
    }

    /**
     * Class constructor (non-sound specific block).
     * @since 0.5.0
     * @param name the block's name
     * @param material the block's material type
     * @param hardness the block's hardness (durability)
     * @param resistance the block's blast resistance
     */
    public BlockGen(final String name, final Material material, final float hardness, final float resistance) {
        this.name = name;
        this.material = material;
        this.hardness = hardness;
        this.resistance = resistance;
        this.sound = null;
        this.tool = null;
        this.level = -1;
        this.requires_tool = false;
    }

    /**
     * Generates a block.
     * @since 0.5.0
     * @param props the block's properties
     * @return RegistryObject<Block>
     */
    public static RegistryObject<Block> gen(final BlockGen props) {
        AbstractBlock.Properties properties = AbstractBlock.Properties.create(props.material).hardnessAndResistance(props.hardness, props.resistance);
        if(props.sound != null) properties.sound(props.sound);
        if(props.tool != null && props.level != -1) properties.harvestTool(props.tool).harvestLevel(props.level);
        if(props.tool != null && props.requires_tool) properties.setRequiresTool();

        if(props.name.equals("crate")) {
            return ModBlocks.BLOCKS.register(props.name, () -> new CrateBlock(properties));
        } else if(props.name.equals("reinforced_crate")) {
            return ModBlocks.BLOCKS.register(props.name, () -> new ReinforcedCrateBlock(properties));
        } else {
            return ModBlocks.BLOCKS.register(props.name, () -> new Block(properties));
        }
    }
}
