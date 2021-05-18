package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModBlocks {
    // Create a deferred register for blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    // Register standard blocks

    private static final RegistryObject<Block> HALITE =
            blockGenerator("halite", Material.ROCK, 2.0f, 2.5f, ToolType.PICKAXE, 1, true);

    // Register storage blocks

    private static final RegistryObject<Block> CRATE =
            blockGenerator("crate", Material.WOOD, 2.5f, 2.5f, null, 0, false);
    private static final RegistryObject<Block> REINFORCED_CRATE =
            blockGenerator("reinforced_crate", Material.IRON, 4.0f, 6.0f, ToolType.PICKAXE, 2, true);

    // Register group icon
    public static final RegistryObject<Block> GROUP_ICON = CRATE;

    /**
     * Generates a block.
     * @since 0.2.0
     */
    public static RegistryObject<Block> blockGenerator(final String name, final Material material, final float hardness, final float resistance, final ToolType tool_type, final int level, final boolean requires_tool) {
        if(tool_type != null) {
            if(requires_tool != false) {
                return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).hardnessAndResistance(hardness, resistance).harvestTool(tool_type).harvestLevel(level).setRequiresTool()));
            } else {
                return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).hardnessAndResistance(hardness, resistance).harvestTool(tool_type).harvestLevel(level)));
            }
        } else {
            return BLOCKS.register(name, () -> new Block(AbstractBlock.Properties.create(material).hardnessAndResistance(hardness, resistance)));
        }
    }
}
