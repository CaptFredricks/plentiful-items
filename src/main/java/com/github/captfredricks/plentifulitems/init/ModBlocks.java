package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.block.*;
import net.minecraft.block.Block;
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

    // Building blocks
    public static final RegistryObject<Block> HALITE = reg("halite", ModBuildingBlocks.HALITE);
    public static final RegistryObject<Block> STEEL_BLOCK = reg("steel_block", ModBuildingBlocks.STEEL_BLOCK);

    // Decoration blocks
    public static final RegistryObject<Block> CRATE = reg("crate", ModDecorationBlocks.CRATE);
    public static final RegistryObject<Block> REINFORCED_CRATE = reg("reinforced_crate", ModDecorationBlocks.REINFORCED_CRATE);

    // Group icon
    public static final RegistryObject<Block> BLOCKS_ICON = CRATE;

    /**
     * Register custom blocks.
     * @since 1.0.1
     * @param name the block's name
     * @param block the block
     * @return RegistryObject<Block>
     */
    private static RegistryObject<Block> reg(final String name, final Block block) {
        return BLOCKS.register(name, () -> block);
    }
}
