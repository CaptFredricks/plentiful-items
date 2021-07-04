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
    public static void generateOres(final BiomeLoadingEvent event) {
        if(!event.getCategory().equals(Biome.Category.NETHER) && !event.getCategory().equals(Biome.Category.THEEND)) {
            // Generate halite
            generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.HALITE.get().getDefaultState(), 13, 63, 20);
        }
    }

    private static void generateOre(final BiomeGenerationSettingsBuilder settings, final RuleTest fillerType, final BlockState state, final int size, final int maxHeight, final int amount) {
        settings.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(fillerType, state, size)).range(maxHeight).square().count(amount));
    }
}
