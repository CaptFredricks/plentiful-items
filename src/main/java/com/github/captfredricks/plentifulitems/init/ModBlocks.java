package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModBlocks {
    // Create a deferred register for blocks
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

    // Register standard blocks
    private static final RegistryObject<Block> HALITE = BlockGen.gen(new BlockGen("halite", Material.ROCK, 2.0f, 2.5f, SoundType.BASALT, ToolType.PICKAXE, 1, true));
    private static final RegistryObject<Block> STEEL_BLOCK = BlockGen.gen(new BlockGen("steel_block", Material.IRON, 5.0f, 6.0f, SoundType.METAL, ToolType.PICKAXE, 2, true));

    // Register storage blocks
    public static final RegistryObject<Block> CRATE = BlockGen.gen(new BlockGen("crate", Material.WOOD, 2.5f, 2.5f, SoundType.WOOD));
    public static final RegistryObject<Block> REINFORCED_CRATE = BlockGen.gen(new BlockGen("reinforced_crate", Material.IRON, 4.0f, 6.0f, SoundType.METAL, ToolType.PICKAXE, 2, true));

    // Register group icon
    public static final RegistryObject<Block> BLOCKS_ICON = CRATE;
}
