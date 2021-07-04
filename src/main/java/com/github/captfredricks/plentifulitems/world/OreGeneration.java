package com.github.captfredricks.plentifulitems.world;

import com.github.captfredricks.plentifulitems.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

/**
 * Generates custom ores.
 * @since 0.6.0
 */
public final class OreGeneration {
    /**
     * Register all custom ores.
     * @param event the biome loading event
     */
    public static void generateOres(final BiomeLoadingEvent event) {
        if(!event.getCategory().equals(Biome.Category.NETHER) && !event.getCategory().equals(Biome.Category.THEEND)) {
            // Generate halite
            generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.HALITE.get().getDefaultState(), 13, 63, 20);
        }
    }

    /**
     * Register a new ore.
     * @param settings the biome generation builder settings
     * @param fillerType the filler block type
     * @param state the block state
     * @param size the size of the ore veins
     * @param maxHeight the max generation height
     * @param amount the number of ore veins to try to generate
     */
    private static void generateOre(final BiomeGenerationSettingsBuilder settings, final RuleTest fillerType, final BlockState state, final int size, final int maxHeight, final int amount) {
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, size)).range(maxHeight).square().count(amount));
    }
}
