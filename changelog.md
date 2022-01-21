# Plentiful Items Changelog

*Legend: N - new file, D - deprecated file, R - renamed file, X - removed file, M - minor change*<br>
*Versions: X.x.x (major releases), x.X.x (standard releases), x.x.X (minor releases), x.x.x.X (patches)*

## Version 1.0.2 (2022-01-12)

- Added more internal documentation
- Updated Forge version to `1.16.5-36.2.20`
- Created a `ClientEvents` class to handle client-side events
- Removed several unused files
- Switched back to the official Mojang mappings
- Switched MCP methods to the official ones in all files
- Renamed a method in the `ModFoods` class

**Modified files:**
- build.gradle
- src/main/java/.../Main.java (M)
- src/main/java/.../block/CrateBlock.java
- src/main/java/.../block/ModBuildingBlocks.java
- src/main/java/.../block/ModDecorationBlocks.java
- src/main/java/.../block/ModShulkerBoxBlock.java (X)
- src/main/java/.../block/ReinforcedCrateBlock.java
- src/main/java/.../client/event/ClientEvents.java (N)
- src/main/java/.../container/ModShulkerBoxContainer.java (X)
- src/main/java/.../container/ModShulkerBoxSlot.java (X)
- src/main/java/.../container/ReinforcedCrateContainer.java
- src/main/java/.../container/ReinforcedCrateSlot.java
- src/main/java/.../data/ModBlockStateProvider.java
- src/main/java/.../data/ModLootTableProvider.java
- src/main/java/.../data/ModRecipeProvider.java
- src/main/java/.../dispenser/CrateDispenseBehavior.java
- src/main/java/.../init/ModBlocksVanilla.java (X)
- src/main/java/.../init/ModFishingLoot.java
- src/main/java/.../init/ModItemGroups.java
- src/main/java/.../init/ModItemsVanilla.java (X)
- src/main/java/.../init/ModJungleLeavesLoot.java
- src/main/java/.../init/ModTileEntityTypes.java
- src/main/java/.../item/ModArmor.java
- src/main/java/.../item/ModArmorMaterial.java
- src/main/java/.../item/ModBlockItems.java
- src/main/java/.../item/ModFoods.java
- src/main/java/.../item/ModItemTier.java
- src/main/java/.../item/ModMaterials.java
- src/main/java/.../item/ModTools.java
- src/main/java/.../item/ModWeapons.java
- src/main/java/.../tileentity/CrateTileEntity.java
- src/main/java/.../tileentity/ModShulkerBoxTileEntity.java (X)
- src/main/java/.../tileentity/ReinforcedCrateTileEntity.java
- src/main/java/.../world/OreGeneration.java

## Version 1.0.1 (2021-09-19)

- Removed lorem ipsum text in the mod's description
- Added licensing information to the mod's description
- Updated Forge version to `1.16.5-36.2.0`
- Code cleanup in all block and item registry classes
- Block state and model json files are now dynamically generated
- Loot table json files are now dynamically generated
- Recipe json files are now dynamically generated
- Imported the Just Enough Items mod for easier recipe testing
- Added the `generated` directory to the `.gitignore` file

**Known issues:**
- Reinforced crates can be placed inside shulker boxes, essentially creating infinite storage

**Modified files:**
- .gitignore (M)
- META-INF/MANIFEST.MF (N)
- build.gradle
- src/main/java/.../ModEventSubscriber.java (M)
- src/main/java/.../block/BlockGen.java (X)
- src/main/java/.../block/ModBuildingBlocks.java (N)
- src/main/java/.../block/ModDecorationBlocks.java (N)
- src/main/java/.../data/DataGenerators.java (N)
- src/main/java/.../data/ModBlockStateProvider.java (N)
- src/main/java/.../data/ModItemModelProvider.java (N)
- src/main/java/.../data/ModLootTableProvider.java (N)
- src/main/java/.../data/ModRecipeProvider.java (N)
- src/main/java/.../init/ModBlocks.java
- src/main/java/.../init/ModItems.java
- src/main/java/.../item/ItemGenArmor.java (X)
- src/main/java/.../item/ItemGenBlock.java (X)
- src/main/java/.../item/ItemGenFood.java (X)
- src/main/java/.../item/ItemGenMaterial.java (X)
- src/main/java/.../item/ItemGenTool.java (X)
- src/main/java/.../item/ItemGenWeapon.java (X)
- src/main/java/.../item/ModArmor.java (N)
- src/main/java/.../item/ModBlockItems.java (N)
- src/main/java/.../item/ModFoods.java (N)
- src/main/java/.../item/ModMaterials.java (N)
- src/main/java/.../item/ModTools.java (N)
- src/main/java/.../item/ModWeapons.java (N)
- src/main/resources/META-INF/mods.toml
- src/main/resources/assets/.../blockstates/* (X)
- src/main/resources/assets/.../models/* (X)
- src/main/resources/data/.../advancements/* (X)
- src/main/resources/data/.../loot_tables/blocks/* (X)
- src/main/resources/data/.../recipes/* (X)

## Version 1.0.0 (2021-07-04) &ndash; The Steel & Sustenance Update

- Official release
- Code cleanup
- Added more internal documentation
- Tweaked the mango texture
- Tweaked formatting in the changelog and item index files
- Removed an unused class
- Henceforth, the `build.gradle` will be omitted from the list of modified files if only the mod's version is incremented

**Modified files:**
- build.gradle (M)
- index.md (M)
- src/main/java/.../Main.java
- src/main/java/.../ModEventSubscriber.java
- src/main/java/.../block/CrateBlock.java
- src/main/java/.../block/ReinforcedCrateBlock.java
- src/main/java/.../container/ReinforcedCrateContainer.java
- src/main/java/.../container/ReinforcedCrateSlot.java
- src/main/java/.../dispenser/CrateDispenseBehavior.java
- src/main/java/.../init/ModBlocks.java (M)
- src/main/java/.../init/ModContainerTypes.java (X)
- src/main/java/.../init/ModItemGroups.java
- src/main/java/.../init/ModJungleLeavesLoot.java (M)
- src/main/java/.../init/ModTileEntityTypes.java (M)
- src/main/java/.../tileentity/CrateTileEntity.java
- src/main/java/.../tileentity/ReinforcedCrateTileEntity.java
- src/main/java/.../world/OreGeneration.java
- src/main/resources/assets/.../textures/item/mango.png (M)

## Version 0.6.0 (2021-07-03)

- Block items are now registered in the `ModItems` class to allow for easier property manipulation
- General cleanup of various classes and methods
- Crates and reinforced crates are now placed when fired from a dispenser
- Reinforced crates can not have shulker boxes or other reinforced crates placed inside them
  - Shulker boxes still allow reinforced crates to be placed inside them (fix coming later)
- Halite now generates naturally in the world between y-0 and y-63
- Scrambled eggs are now made by crafting instead of smelting/cooking (recipe: 2 eggs and 1 butter)
- Custom recipes now unlock properly in the recipe book
- Added new item:
  - `steel_rivet` &ndash; used to craft reinforced crates
- Reinforced crates now require 1 crate, 4 steel ingots, and 4 steel rivets to craft (the old recipe was 1 crate + 4 steel ingots)
- Mangoes have a new texture
- Crab and cooked crab now have textures
- Lobster and cooked lobster now have textures
- Reinforced crates have a new texture
- Moved the `index.md` file to the root directory
- Minor code refactoring
- Added more details and a missing item to the item index
- Created a simple README
- Added the GNU General Public License v3.0

**Modified files:**
- LICENSE.md (N)
- README.md (N)
- build.gradle (M)
- index.md
- src/main/java/.../Main.java
- src/main/java/.../ModEventSubscriber.java
- src/main/java/.../block/BlockGen.java
- src/main/java/.../block/ModShulkerBoxBlock.java (N)
- src/main/java/.../block/ReinforcedCrateBlock.java
- src/main/java/.../container/ModShulkerBoxContainer.java (N)
- src/main/java/.../container/ModShulkerBoxSlot.java (N)
- src/main/java/.../container/ReinforcedCrateContainer.java (N)
- src/main/java/.../container/ReinforcedCrateSlot.java (N)
- src/main/java/.../dispenser/CrateDispenseBehavior.java (N)
- src/main/java/.../init/ModBlocks.java
- src/main/java/.../init/ModBlocksVanilla.java (N)
- src/main/java/.../init/ModContainerTypes.java (N)
- src/main/java/.../init/ModItemGroups.java (M)
- src/main/java/.../init/ModItems.java
- src/main/java/.../init/ModItemsVanilla.java (N)
- src/main/java/.../item/ItemGenArmor.java
- src/main/java/.../item/ItemGenBlock.java (N)
- src/main/java/.../item/ItemGenFood.java
- src/main/java/.../item/ItemGenMaterial.java
- src/main/java/.../item/ItemGenTool.java
- src/main/java/.../item/ItemGenWeapon.java
- src/main/java/.../tileentity/ModShulkerBoxTileEntity.java (N)
- src/main/java/.../tileentity/ReinforcedCrateTileEntity.java
- src/main/java/.../world/OreGeneration.java (N)
- src/main/resources/assets/.../lang/en_us.json
- src/main/resources/assets/.../models/item/steel_rivet.json (N)
- src/main/resources/assets/.../textures/block/reinforced_crate.png
- src/main/resources/assets/.../textures/block/reinforced_crate_open.png
- src/main/resources/assets/.../textures/item/cooked_crab.png (N)
- src/main/resources/assets/.../textures/item/cooked_lobster.png (N)
- src/main/resources/assets/.../textures/item/crab.png (N)
- src/main/resources/assets/.../textures/item/lobster.png (N)
- src/main/resources/assets/.../textures/item/mango.png
- src/main/resources/assets/.../textures/item/steel_rivet.png (N)
- src/main/resources/data/.../advancements/recipes/building_blocks/steel_block.json (N)
- src/main/resources/data/.../advancements/recipes/combat/steel_boots_smithing.json (N)
- src/main/resources/data/.../advancements/recipes/combat/steel_chestplate_smithing.json (N)
- src/main/resources/data/.../advancements/recipes/combat/steel_helmet_smithing.json (N)
- src/main/resources/data/.../advancements/recipes/combat/steel_leggings_smithing.json (N)
- src/main/resources/data/.../advancements/recipes/combat/steel_sword_smithing.json (N)
- src/main/resources/data/.../advancements/recipes/decorations/crate.json (N)
- src/main/resources/data/.../advancements/recipes/decorations/reinforced_crate.json (N)
- src/main/resources/data/.../advancements/recipes/food/butter.json (N)
- src/main/resources/data/.../advancements/recipes/food/cheese.json (N)
- src/main/resources/data/.../advancements/recipes/food/coconut_cream_pie.json (N)
- src/main/resources/data/.../advancements/recipes/food/cooked_crab.json (N)
- src/main/resources/data/.../advancements/recipes/food/cooked_crab_from_campfire_cooking.json (N)
- src/main/resources/data/.../advancements/recipes/food/cooked_crab_from_smoking.json (N)
- src/main/resources/data/.../advancements/recipes/food/cooked_lobster.json (N)
- src/main/resources/data/.../advancements/recipes/food/cooked_lobster_from_campfire_cooking.json (N)
- src/main/resources/data/.../advancements/recipes/food/cooked_lobster_from_smoking.json (N)
- src/main/resources/data/.../advancements/recipes/food/cooked_shrimp.json (N)
- src/main/resources/data/.../advancements/recipes/food/cooked_shrimp_from_campfire_cooking.json (N)
- src/main/resources/data/.../advancements/recipes/food/cooked_shrimp_from_smoking.json (N)
- src/main/resources/data/.../advancements/recipes/food/scrambled_egg.json (N)
- src/main/resources/data/.../advancements/recipes/misc/steel_ingot.json (N)
- src/main/resources/data/.../advancements/recipes/misc/steel_ingot_from_blasting.json (N)
- src/main/resources/data/.../advancements/recipes/misc/steel_ingot_from_steel_block.json (N)
- src/main/resources/data/.../advancements/recipes/misc/steel_rivet.json (N)
- src/main/resources/data/.../advancements/recipes/tools/steel_axe_smithing.json (N)
- src/main/resources/data/.../advancements/recipes/tools/steel_hoe_smithing.json (N)
- src/main/resources/data/.../advancements/recipes/tools/steel_pickaxe_smithing.json (N)
- src/main/resources/data/.../advancements/recipes/tools/steel_shovel_smithing.json (N)
- src/main/resources/data/.../recipes/reinforced_crate.json
- src/main/resources/data/.../recipes/scrambled_egg.json
- src/main/resources/data/.../recipes/scrambled_egg_from_campfire_cooking.json (X)
- src/main/resources/data/.../recipes/scrambled_egg_from_smoking.json (X)
- src/main/resources/data/.../recipes/steel_rivet.json (N)

## Version 0.5.0 (2021-06-26)

- Created a modified loot table for jungle leaves
- Bananas, mangoes, and coconuts now have a chance to drop from jungle leaves
- Raw shrimp, raw crabs, and raw lobster now have a chance to drop from fishing loot
- Crates and reinforced crates are now functional
  - Crates function like barrels
  - Reinforced crates function like shulker boxes, keeping their inventory when broken
  - Added an "open" texture and block state for both crate variants
- Added missing documentation in multiple files
- General cleanup
- Renamed multiple classes and methods

**Modified files:**
- src/main/index.md
- src/main/java/.../Main.java (M)
- src/main/java/.../ModEventSubscriber.java (M)
- src/main/java/.../block/BlockGen.java (N)
- src/main/java/.../block/CrateBlock.java (N)
- src/main/java/.../block/ReinforcedCrateBlock.java (N)
- src/main/java/.../init/ModBlocks.java
- src/main/java/.../init/ModFishingLoot.java
- src/main/java/.../init/ModItems.java
- src/main/java/.../init/ModJungleLeavesLoot.java (N)
- src/main/java/.../init/ModTileEntityTypes.java (N)
- src/main/java/.../item/ItemGenArmor.java (R)
- src/main/java/.../item/ItemGenFood.java (R)
- src/main/java/.../item/ItemGenMaterial.java (R)
- src/main/java/.../item/ItemGenTool.java (R)
- src/main/java/.../item/ItemGenWeapon.java (R)
- src/main/java/.../item/ModArmorMaterial.java (M)
- src/main/java/.../item/ModItemTier.java (M)
- src/main/java/.../tileentity/CrateTileEntity.java (N)
- src/main/java/.../tileentity/ReinforcedCrateTileEntity.java (N)
- src/main/resources/assets/.../blockstates/crate.json
- src/main/resources/assets/.../blockstates/reinforced_crate.json
- src/main/resources/assets/.../models/block/crate_open.json (N)
- src/main/resources/assets/.../models/block/reinforced_crate_open.json (N)
- src/main/resources/assets/.../textures/block/crate_open.png (N)
- src/main/resources/assets/.../textures/block/reinforced_crate_open.png (N)
- src/main/resources/data/forge/loot_modifiers/global_loot_modifiers.json
- src/main/resources/data/plentifulitems/loot_modifiers/fishing.json
- src/main/resources/data/plentifulitems/loot_modifiers/jungle_leaves.json (N)
- src/main/resources/data/plentifulitems/loot_tables/blocks/reinforced_crate.json
- src/main/resources/data/plentifulitems/loot_tables/gameplay/fishing/crustaceans.json

## Version 0.4.0 (2021-05-25)

- Reinforced crates are now crafted with 4 steel ingots and 1 crate
- Modified previous entries in the changelog
- Cleaned up code in the `ModItems` class and created separate classes for item groups
- Added documentation to new and existing classes
- Added new items:
  - Tools: `steel_axe`, `steel_hoe`, `steel_pickaxe`, `steel_shovel`
  - Weapons: `steel_sword`
  - Armor: `steel_boots`, `steel_chestplate`, `steel_helmet`, `steel_leggings`
- Created a custom tier for steel tools and weapons
- Created a custom material for steel armor
- Shrimp and cooked shrimp have new, unique textures
- Scrambled eggs now have a texture
- Added more information to the block/item `index.md` file

**Modified files:**
- build.gradle (M)
- src/main/index.md
- src/main/java/.../init/ModItemGroups.java
- src/main/java/.../init/ModItems.java
- src/main/java/.../item/ItemArmor.java (N)
- src/main/java/.../item/ItemFood.java (N)
- src/main/java/.../item/ItemMaterial.java (N)
- src/main/java/.../item/ItemTool.java (N)
- src/main/java/.../item/ItemWeapon.java (N)
- src/main/java/.../item/ModArmorMaterial.java (N)
- src/main/java/.../item/ModItemTier.java (N)
- src/main/resources/assets/.../lang/en_us.json
- src/main/resources/assets/.../models/item/steel_axe.json (N)
- src/main/resources/assets/.../models/item/steel_boots.json (N)
- src/main/resources/assets/.../models/item/steel_chestplate.json (N)
- src/main/resources/assets/.../models/item/steel_helmet.json (N)
- src/main/resources/assets/.../models/item/steel_hoe.json (N)
- src/main/resources/assets/.../models/item/steel_leggings.json (N)
- src/main/resources/assets/.../models/item/steel_pickaxe.json (N)
- src/main/resources/assets/.../models/item/steel_shovel.json (N)
- src/main/resources/assets/.../models/item/steel_sword.json (N)
- src/main/resources/assets/.../textures/item/cooked_shrimp.png
- src/main/resources/assets/.../textures/item/scrambled_egg.png (N)
- src/main/resources/assets/.../textures/item/shrimp.png
- src/main/resources/assets/.../textures/item/steel_axe.png (N)
- src/main/resources/assets/.../textures/item/steel_boots.png (N)
- src/main/resources/assets/.../textures/item/steel_chestplate.png (N)
- src/main/resources/assets/.../textures/item/steel_helmet.png (N)
- src/main/resources/assets/.../textures/item/steel_hoe.png (N)
- src/main/resources/assets/.../textures/item/steel_leggings.png (N)
- src/main/resources/assets/.../textures/item/steel_pickaxe.png (N)
- src/main/resources/assets/.../textures/item/steel_shovel.png (N)
- src/main/resources/assets/.../textures/item/steel_sword.png (N)
- src/main/resources/assets/.../textures/models/armor/steel_layer_1.png (N)
- src/main/resources/assets/.../textures/models/armor/steel_layer_2.png (N)
- src/main/resources/data/.../recipes/reinforced_crate.json
- src/main/resources/data/.../recipes/steel_axe_smithing.json (N)
- src/main/resources/data/.../recipes/steel_boots_smithing.json (N)
- src/main/resources/data/.../recipes/steel_chestplate_smithing.json (N)
- src/main/resources/data/.../recipes/steel_helmet_smithing.json (N)
- src/main/resources/data/.../recipes/steel_hoe_smithing.json (N)
- src/main/resources/data/.../recipes/steel_leggings_smithing.json (N)
- src/main/resources/data/.../recipes/steel_pickaxe_smithing.json (N)
- src/main/resources/data/.../recipes/steel_shovel_smithing.json (N)
- src/main/resources/data/.../recipes/steel_sword_smithing.json (N)

## Version 0.3.0 (2021-05-22)

- Tweaked previous entries in the changelog
- Added new block:
  - `steel_block` &ndash; crafted with 9 steel ingots
- Added new items:
  - `crab` &ndash; item that drops from fishing (not yet functional; no texture yet)
  - `shrimp` &ndash; item that drops from fishing (not yet functional)
  - `lobster` &ndash; item that drops from fishing (not yet functional; no texture yet)
  - `cooked_crab` &ndash; food item made from cooking crab (no texture yet)
  - `cooked_shrimp` &ndash; food item made from cooking shrimp (shares shrimp's texture)
  - `cooked_lobster` &ndash; food item made from cooking lobster (no texture yet)
  - `scrambled_egg` &ndash; food item made from cooking an egg (no texture yet)
  - `steel_ingot` &ndash; made by smelting iron ingots
- Added a new creative tab labelled "Plentiful Materials"
- Reinforced crates are now crafted with 4 steel ingots and 4 wooden slabs
- Reinforced crates now have their own unique texture
- Added a file that indexes all items and blocks added with the mod (this file plays no functional role and is merely informational)
- Cleaned up code in the `ModBlocks` and `ModItems` classes
- Butter now has a texture
- Attempted to implement fishing loot unsuccessfully (will be implemented in a future update)

**Modified files:**
- src/main/index.md (N)
- src/main/java/.../Main.java (M)
- src/main/java/.../ModEventSubscriber.java
- src/main/java/.../init/ModBlocks.java
- src/main/java/.../init/ModFishingLoot.java (N)
- src/main/java/.../init/ModItemGroups.java
- src/main/java/.../init/ModItems.java
- src/main/resources/assets/.../blockstates/steel_block.json (N)
- src/main/resources/assets/.../lang/en_us.json
- src/main/resources/assets/.../models/block/reinforced_crate.json (M)
- src/main/resources/assets/.../models/block/steel_block.json (N)
- src/main/resources/assets/.../models/item/banana.json (M)
- src/main/resources/assets/.../models/item/butter.json (M)
- src/main/resources/assets/.../models/item/cheese.json (M)
- src/main/resources/assets/.../models/item/coconut.json (M)
- src/main/resources/assets/.../models/item/coconut_cream_pie.json (M)
- src/main/resources/assets/.../models/item/cooked_crab.json (N)
- src/main/resources/assets/.../models/item/cooked_lobster.json (N)
- src/main/resources/assets/.../models/item/cooked_shrimp (N)
- src/main/resources/assets/.../models/item/crab.json (N)
- src/main/resources/assets/.../models/item/lobster.json (N)
- src/main/resources/assets/.../models/item/mango.json (M)
- src/main/resources/assets/.../models/item/salt.json (M)
- src/main/resources/assets/.../models/item/scrambled_egg.json (N)
- src/main/resources/assets/.../models/item/shrimp.json (N)
- src/main/resources/assets/.../models/item/steel_block.json (N)
- src/main/resources/assets/.../models/item/steel_ingot.json (N)
- src/main/resources/assets/.../textures/block/reinforced_crate.png (N)
- src/main/resources/assets/.../textures/block/steel_block.png (N)
- src/main/resources/assets/.../textures/item/butter.png (N)
- src/main/resources/assets/.../textures/item/cooked_shrimp.png (N)
- src/main/resources/assets/.../textures/item/shrimp.png (N)
- src/main/resources/assets/.../textures/item/steel_ingot.png (N)
- src/main/resources/data/forge/loot_modifiers/global_loot_modifiers.json (N)
- src/main/resources/data/plentifulitems/loot_modifiers/fishing.json (N)
- src/main/resources/data/plentifulitems/loot_tables/blocks/steel_block.json (N)
- src/main/resources/data/plentifulitems/loot_tables/gameplay/fishing.json (N)
- src/main/resources/data/plentifulitems/loot_tables/gameplay/fishing/crustaceans.json (N)
- src/main/resources/data/plentifulitems/recipes/cooked_crab.json (N)
- src/main/resources/data/plentifulitems/recipes/cooked_crab_from_campfire_cooking.json (N)
- src/main/resources/data/plentifulitems/recipes/cooked_crab_from_smoking.json (N)
- src/main/resources/data/plentifulitems/recipes/cooked_lobster.json (N)
- src/main/resources/data/plentifulitems/recipes/cooked_lobster_from_campfire_cooking.json (N)
- src/main/resources/data/plentifulitems/recipes/cooked_lobster_from_smoking.json (N)
- src/main/resources/data/plentifulitems/recipes/cooked_shrimp.json (N)
- src/main/resources/data/plentifulitems/recipes/cooked_shrimp_from_campfire_cooking.json (N)
- src/main/resources/data/plentifulitems/recipes/cooked_shrimp_from_smoking.json (N)
- src/main/resources/data/plentifulitems/recipes/reinforced_crate.json (M)
- src/main/resources/data/plentifulitems/recipes/scrambled_egg.json (N)
- src/main/resources/data/plentifulitems/recipes/scrambled_egg_from_campfire_cooking.json (N)
- src/main/resources/data/plentifulitems/recipes/scrambled_egg_from_smoking.json (N)
- src/main/resources/data/plentifulitems/recipes/steel_block.json (N)
- src/main/resources/data/plentifulitems/recipes/steel_ingot.json (N)
- src/main/resources/data/plentifulitems/recipes/steel_ingot_from_blasting.json (N)
- src/main/resources/data/plentifulitems/recipes/steel_ingot_from_steel_block.json (N)

## Version 0.2.0 (2021-05-15)

- Switched mappings to MCP
- `coconut` has received a new texture
- `coconut_cream_pie` now has a texture
- `cheese` has received a new texture
- Added new blocks:
  - `crate` &ndash; a storage container, similar to barrels (not yet functional)
  - `reinforced_crate` &ndash; a crate reinforced with iron (not yet functional; shares crate's texture)
- `banana`, `mango`, `coconut`, `cheese`, and `coconut_cream_pie` can now be eaten
- Created several methods in the `ModBlocks` and `ModItems` classes for easier block and item registration
- Added some documentation to core files

**Modified files:**
- build.gradle (M)
- src/main/java/.../ModEventSubscriber.java (M)
- src/main/java/.../init/ModBlocks.java
- src/main/java/.../init/ModItemGroups.java
- src/main/java/.../init/ModItems.java
- src/main/resources/assets/.../blockstates/crate.json (N)
- src/main/resources/assets/.../blockstates/reinforced_crate.json (N)
- src/main/resources/assets/.../lang/en_us.json
- src/main/resources/assets/.../models/block/crate.json (N)
- src/main/resources/assets/.../models/block/halite.json (M)
- src/main/resources/assets/.../models/block/reinforced_crate.json (N)
- src/main/resources/assets/.../models/item/crate.json (N)
- src/main/resources/assets/.../models/item/reinforced_crate.json (N)
- src/main/resources/assets/.../textures/block/crate.png (N)
- src/main/resources/assets/.../textures/item/cheese.png
- src/main/resources/assets/.../textures/item/coconut.png
- src/main/resources/assets/.../textures/item/coconut_cream_pie.png (N)
- src/main/resources/data/.../loot_tables/blocks/crate.json (N)
- src/main/resources/data/.../loot_tables/blocks/reinforced_crate.json (N)
- src/main/resources/data/.../recipes/crate.json (N)
- src/main/resources/data/.../recipes/reinforced_crate.json (N)

## Version 0.1.0 (2021-05-14)

- Set up core files
- Created functions for registering custom items and blocks
- Added new block:
  - `halite` &ndash; works like ore blocks and drops 3-5 salt when mined
- Added new items:
  - `banana` &ndash; food item that will drop from jungle leaves (not yet functional)
  - `butter` &ndash; food item that is crafted from 1 milk bucket and 1 salt (no texture yet)
  - `cheese` &ndash; food item that is crafted from 2 milk buckets and 2 salt
  - `coconut` &ndash; food item that will drop from jungle leaves (not yet functional) and is used to craft coconut cream pies
  - `coconut_cream_pie` &ndash; food item that is crafted from 1 coconut, 1 milk bucket, and 1 sugar (no texture yet)
  - `mango` &ndash; food item that will drop from jungle leaves (not yet functional)
  - `salt` &ndash; crafting ingredient used to make butter and cheese

**Modified files:**
- .gitattributes (N)
- .gitignore (N)
- build.gradle (N)
- changelog.md (N)
- gradle.properties (N)
- gradle/wrapper/gradle-wrapper.jar (N)
- gradle/wrapper/gradle-wrapper.properties (N)
- gradlew (N)
- gradlew.bat (N)
- settings.gradle (N)
- src/main/java/.../Main.java (N)
- src/main/java/.../ModEventSubscriber.java (N)
- src/main/java/.../init/ModBlocks.java (N)
- src/main/java/.../init/ModItemGroups.java (N)
- src/main/java/.../init/ModItems.java (N)
- src/main/resources/META-INF/mods.toml (N)
- src/main/resources/assets/.../blockstates/halite.json (N)
- src/main/resources/assets/.../lang/en_us.json (N)
- src/main/resources/assets/.../models/block/halite.json (N)
- src/main/resources/assets/.../models/item/banana.json (N)
- src/main/resources/assets/.../models/item/butter.json (N)
- src/main/resources/assets/.../models/item/cheese.json (N)
- src/main/resources/assets/.../models/item/coconut.json (N)
- src/main/resources/assets/.../models/item/coconut_cream_pie.json (N)
- src/main/resources/assets/.../models/item/halite.json (N)
- src/main/resources/assets/.../models/item/mango.json (N)
- src/main/resources/assets/.../models/item/salt.json (N)
- src/main/resources/assets/.../textures/block/halite.png (N)
- src/main/resources/assets/.../textures/item/banana.png (N)
- src/main/resources/assets/.../textures/item/cheese.png (N)
- src/main/resources/assets/.../textures/item/coconut.png (N)
- src/main/resources/assets/.../textures/item/mango.png (N)
- src/main/resources/assets/.../textures/item/salt.png (N)
- src/main/resources/data/.../loot_tables/blocks/halite.json (N)
- src/main/resources/data/.../recipes/butter.json (N)
- src/main/resources/data/.../recipes/cheese.json (N)
- src/main/resources/data/.../recipes/coconut_cream_pie.json (N)
- src/main/resources/pack.mcmeta (N)