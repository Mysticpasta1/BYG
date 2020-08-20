package voronoiaoc.byg.common.world.feature.biomefeatures;//package voronoiaoc.byg.common.world.feature.biomefeatures;
//

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import voronoiaoc.byg.core.byglists.BYGConfiguredFeatures;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class BYGFeaturesInVanilla {
    public static void addFeatures() {
        for (Biome biome : WorldGenRegistries.field_243657_i) {
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NONE) {
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.ORE_ROCKY_STONE);
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.ORE_SCORIA_STONE);
                addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, BYGConfiguredFeatures.ORE_SOAP_STONE);
            }
        }
    }


//    public static void addSpawnEntries() {
//        for (Biome biome : WorldGenRegistries.field_243657_i) {
//            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND && biome.getCategory() != Biome.Category.NONE) {
//                addMobSpawnToBiome(biome, EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 100, 100, 100));
//            }
//        }
//    }
//
//
//    public static void addMobSpawnToBiome(Biome biome, EntityClassification classification, MobSpawnInfo.Spawners... spawnInfos) {
//        convertImmutableSpawners(biome);
//        List<MobSpawnInfo.Spawners> spawnersList = new ArrayList<>(biome.func_242433_b().field_242554_e.get(classification));
//        spawnersList.addAll(Arrays.asList(spawnInfos));
//        biome.func_242433_b().field_242554_e.put(classification, spawnersList);
//    }
//
//
//    private static void convertImmutableSpawners(Biome biome) {
//        if (biome.func_242433_b().field_242554_e instanceof ImmutableMap) {
//            biome.func_242433_b().field_242554_e = new HashMap<>(biome.func_242433_b().field_242554_e);
//        }
//    }


    //Use these to add our features to vanilla's biomes.
    public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration feature, ConfiguredFeature<?, ?> configuredFeature) {
        ConvertImmutableFeatures(biome);
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = biome.func_242440_e().field_242484_f;
        while (biomeFeatures.size() <= feature.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }
        biomeFeatures.get(feature.ordinal()).add(() -> configuredFeature);

    }



    private static void ConvertImmutableFeatures(Biome biome) {
        if (biome.func_242440_e().field_242484_f instanceof ImmutableList) {
            biome.func_242440_e().field_242484_f = biome.func_242440_e().field_242484_f.stream().map(Lists::newArrayList).collect(Collectors.toList());
        }
    }
}
