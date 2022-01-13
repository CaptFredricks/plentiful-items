package com.github.captfredricks.plentifulitems.data;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.block.CrateBlock;
import com.github.captfredricks.plentifulitems.block.ReinforcedCrateBlock;
import com.github.captfredricks.plentifulitems.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * This class generates all block state and block model json files.
 * @since 1.0.1
 */
public final class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper existing_file_helper) {
        super(gen, Main.MODID, existing_file_helper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Building blocks
        simpleBlock(ModBlocks.HALITE.get());
        simpleBlock(ModBlocks.STEEL_BLOCK.get());

        // Decoration blocks
        ModelFile crate = models().cubeAll("crate", modLoc("block/crate"));
        ModelFile crate_open = models().cubeBottomTop("crate_open", modLoc("block/crate"), modLoc("block/crate"), modLoc("block/crate_open"));
        directionalBlock(ModBlocks.CRATE.get(), state -> state.getValue(CrateBlock.OPEN) ? crate_open : crate);

        ModelFile reinforced_crate = models().cubeAll("reinforced_crate", modLoc("block/reinforced_crate"));
        ModelFile reinforced_crate_open = models().cubeBottomTop("reinforced_crate_open", modLoc("block/reinforced_crate"), modLoc("block/reinforced_crate"), modLoc("block/reinforced_crate_open"));
        directionalBlock(ModBlocks.REINFORCED_CRATE.get(), state -> state.getValue(ReinforcedCrateBlock.OPEN) ? reinforced_crate_open : reinforced_crate);
    }
}
