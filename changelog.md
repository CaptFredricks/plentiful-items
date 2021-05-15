# Plentiful Items Changelog

----------------------------------------------------------------------------------------------------
*Legend: N - new file, D - deprecated file, R - renamed file, X - removed file, M - minor change*<br>
*Versions: X.x.x (major releases), x.X.x (minor releases), x.x.X (patches)*

----------------------------------------------------------------------------------------------------
## Version 0.1.0 (2021-05-14)

- Set up core files
- Created functions for registering custom items and blocks
- Added new block:
  - `halite` &ndash; works like ore blocks and drops 3-5 `salt` when mined
- Added new items:
  - `banana` &ndash; food item that will drop from `jungle_leaves` (not yet functional)
  - `butter` &ndash; food item that is crafted from `milk_bucket` and `salt` (no texture yet)
  - `cheese` &ndash; food item that is crafted from `milk_bucket` \[x2] and `salt` \[x2]
  - `coconut` &ndash; food item that will drop from `jungle_leaves` (not yet functional) and is used to craft `coconut_cream_pie`
  - `coconut_cream_pie` &ndash; food item that is crafted from `coconut`, `milk_bucket`, and `sugar` (no texture yet)
  - `mango` &ndash; food item that will drop from `jungle_leaves` (not yet functional)
  - `salt` &ndash; crafting ingredient used to make `butter` and `cheese`

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