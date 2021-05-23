# Plentiful Items Changelog

----------------------------------------------------------------------------------------------------
*Legend: N - new file, D - deprecated file, R - renamed file, X - removed file, M - minor change*<br>
*Versions: X.x.x (major releases), x.X.x (minor releases), x.x.X (patches)*

----------------------------------------------------------------------------------------------------
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
- Reinforced crates are now crafted with steel ingots and wooden slabs
- Reinforced crates now have their own unique texture
- Added a file that indexes all items and blocks added with the mod (this file plays no functional role and is merely informational)
- Cleaned up code in the `ModBlocks` and `ModItems` classes
- Butter now has a texture
- Attempted to implement fishing loot unsuccessfully (will be implemented in a future update)

**Modified files:**
- src/main/index.md (N)
- src/main/java/.../plentifulitems/Main.java (M)
- src/main/java/.../plentifulitems/ModEventSubscriber.java
- src/main/java/.../plentifulitems/init/ModBlocks.java
- src/main/java/.../plentifulitems/init/ModFishingLoot.java (N)
- src/main/java/.../plentifulitems/init/ModItemGroups.java
- src/main/java/.../plentifulitems/init/ModItems.java
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

----------------------------------------------------------------------------------------------------
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
- src/main/java/.../plentifulitems/ModEventSubscriber.java (M)
- src/main/java/.../plentifulitems/init/ModBlocks.java
- src/main/java/.../plentifulitems/init/ModItemGroups.java
- src/main/java/.../plentifulitems/init/ModItems.java
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

----------------------------------------------------------------------------------------------------
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
- src/main/java/.../plentifulitems/Main.java (N)
- src/main/java/.../plentifulitems/ModEventSubscriber.java (N)
- src/main/java/.../plentifulitems/init/ModBlocks.java (N)
- src/main/java/.../plentifulitems/init/ModItemGroups.java (N)
- src/main/java/.../plentifulitems/init/ModItems.java (N)
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