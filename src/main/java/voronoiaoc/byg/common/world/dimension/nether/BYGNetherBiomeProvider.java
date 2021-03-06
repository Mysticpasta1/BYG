package voronoiaoc.byg.common.world.dimension.nether;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import voronoiaoc.byg.core.byglists.BYGBiomeList;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.Registry;
import net.minecraft.resources.RegistryLookupCodec;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.newbiome.layer.Layer;

public class BYGNetherBiomeProvider extends BiomeSource {
    public static final Codec<BYGNetherBiomeProvider> BYGNETHERCODEC = RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.create(Registry.BIOME_REGISTRY).forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry), Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed)).apply(instance, instance.stable(BYGNetherBiomeProvider::new)));


    private final Layer biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;


    public BYGNetherBiomeProvider(Registry<Biome> registry, long seed) {
        super(biomeList);
        this.seed = seed;
        this.biomeLayer = BYGNetherLayerProvider.stackLayers(seed);
        biomeRegistry = registry;
    }

    @Override
    public Biome getNoiseBiome(int biomeX, int biomeY, int biomeZ) {
        //TODO: REIMPLEMENT BIOME LAYERS
        return biomeLayer.get(biomeRegistry, biomeX, biomeZ);
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return BYGNETHERCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new BYGNetherBiomeProvider(biomeRegistry, seed);
    }

    public static List<Biome> biomeList = new ArrayList<>();

    public static void addNetherBiomesForProvider() {
        biomeList.add(BYGBiomeList.SYTHIANTORRIDS);
    }
}
