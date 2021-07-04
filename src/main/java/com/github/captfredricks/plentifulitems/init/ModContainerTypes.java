package com.github.captfredricks.plentifulitems.init;

import com.github.captfredricks.plentifulitems.Main;
import com.github.captfredricks.plentifulitems.container.ReinforcedCrateContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModContainerTypes {
    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Main.MODID);

    //public static final RegistryObject<ContainerType<ReinforcedCrateContainer>> REINFORCED_CRATE = CONTAINER_TYPES.register("reinforced_crate", () -> IForgeContainerType.create(ReinforcedCrateContainer::new));
}
