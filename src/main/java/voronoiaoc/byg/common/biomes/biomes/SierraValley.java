package voronoiaoc.byg.common.biomes.biomes;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import voronoiaoc.byg.common.biomes.BiomeTools;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatures;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGTreeFeatures;
import voronoiaoc.byg.core.byglists.BYGBiomeList;
import voronoiaoc.byg.core.byglists.BYGSBList;

import javax.annotation.Nullable;
import java.util.Random;

public class SierraValley extends Biome implements BiomeTools {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = new ConfiguredSurfaceBuilder<>(BYGSBList.SIERRA_VALLEY_SB, SurfaceBuilder.GRASS_CONFIG);
    static final Precipitation PRECIPATATION = Precipitation.RAIN;
    static final Category CATEGORY = Category.PLAINS;
    static final double DEPTH = 0.2F;
    static final double SCALE = 0.1F;
    static final float TEMPERATURE = 1.2F;
    static final float DOWNFALL = 0.1F;
    static final int WATER_COLOR = 4159204;
    static final int WATER_FOG_COLOR = 329011;
    static final String PARENT = null;

    public SierraValley() {
        super(new Settings().configureSurfaceBuilder(SURFACE_BUILDER).precipitation(PRECIPATATION).category(CATEGORY).depth((float) DEPTH).scale((float) SCALE).temperature(TEMPERATURE).downfall(DOWNFALL).parent(PARENT).effects((new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build()));
        ////StructureFeature.VILLAGE.configure(new StructurePoolFeatureConfig(new Identifier("village/plains/town_centers"), 6));
//        //this.add//StructureFeature(DefaultBiomeFeatures.PILLAGER_OUTPOST);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(this);
        DefaultBiomeFeatures.addLandCarvers(this);

        DefaultBiomeFeatures.addDungeons(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addExtraGoldOre(this);
        DefaultBiomeFeatures.addEmeraldOre(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addDefaultVegetation(this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);
        BYGFeatures.addTerracottaBoulder(this);
        DefaultBiomeFeatures.addBadlandsGrass(this);
        BYGTreeFeatures.addPaloVerdeTrees(this);
        BYGFeatures.addBYGMushrooms(this);
        BYGFeatures.addFirecracker(this);

        this.addSpawn(SpawnGroup.CREATURE, new SpawnEntry(EntityType.RABBIT, 4, 2, 3));
        this.addSpawn(SpawnGroup.AMBIENT, new SpawnEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.HUSK, 95, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(SpawnGroup.MONSTER, new SpawnEntry(EntityType.WITCH, 5, 1, 1));
    }

    @Override
    public int getGrassColorAt(double x, double z) {
        return 10855786;
    }

    @Override
    public int getFoliageColor() {
        return 10855786;
    }

    @Nullable
    @Override
    public Biome getRiver() {
        return Biomes.RIVER;
    }

    @Nullable
    @Override
    public Biome getHill() {
        Random random = new Random();
        return randomSubBiome(random);
    }

    @Nullable
    @Override
    public Biome getEdge() {
        return null;
    }

    @Nullable
    @Override
    public Biome getBeach() {
        return null;
    }

    @Nullable
    @Override
    public Biome getMutation() {
        return null;
    }

    public Biome randomSubBiome(Random random) {
        int randomPicker = random.nextInt(4);
        if (randomPicker == 0)
            return BYGBiomeList.SIERRARANGE;
        else if (randomPicker == 1)
            return BYGBiomeList.SIERRARANGE;
        else if (randomPicker == 2)
            return BYGBiomeList.SIERRARANGE;
        else
            return BYGBiomeList.FRESHWATERLAKE;
    }
}
