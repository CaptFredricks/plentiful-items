package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.tileentity.CrateTileEntity;
import com.github.captfredricks.plentifulitems.tileentity.ReinforcedCrateTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * This class defines the custom tile entity types for the mod.
 * @since 0.5.0
 */
public final class ModTileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Main.MODID);

    // Register crates
    public static final RegistryObject<TileEntityType<CrateTileEntity>> CRATE = TILE_ENTITY_TYPES.register("crate", () -> TileEntityType.Builder.create(CrateTileEntity::new, ModBlocks.CRATE.get()).build(null));
    public static final RegistryObject<TileEntityType<ReinforcedCrateTileEntity>> REINFORCED_CRATE = TILE_ENTITY_TYPES.register("reinforced_crate", () -> TileEntityType.Builder.create(ReinforcedCrateTileEntity::new, ModBlocks.REINFORCED_CRATE.get()).build(null));
}
