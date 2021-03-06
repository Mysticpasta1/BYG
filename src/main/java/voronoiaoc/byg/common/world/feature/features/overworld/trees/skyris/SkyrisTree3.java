package voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class SkyrisTree3 extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {
    //BYGBlockRenders used for the tree.
    private static final BlockState LOG = BYGBlockList.SKYRIS_LOG.defaultBlockState();
    private static final BlockState LEAVES = BYGBlockList.SKYRIS_LEAVES.defaultBlockState();
    private static final BlockState LEAVES2 = BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE.defaultBlockState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.defaultBlockState();
    Random random = new Random();

    public SkyrisTree3(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.SKYRIS_SAPLING);
    }


    public boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {

        int randTreeHeight = rand.nextInt(2) + 6;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {


                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);//Crashes on 0.
                int posY1 = 2 - rand.nextInt(1);//Crashes on 0.
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;
                int topTrunkHeight2 = posY + randTreeHeight + randTreeHeight - 1;
                int topTrunkHeight3 = posY + randTreeHeight + randTreeHeight + 8;
                int topTrunkHeight4 = posY + randTreeHeight + randTreeHeight + 10;
                int topTrunkHeight5 = posY + randTreeHeight + randTreeHeight + 11;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) { //Unknown
                        posX1 += direction.getStepX();
                        posZ1 += direction.getStepZ();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    this.treelog(changedBlocks, worldIn, blockpos1, boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.east(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(2).above(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).above(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).above(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).above(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).above(5), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).above(6), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(4).above(6), boundsIn);


                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).above(7).south(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).above(8).south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).above(9).south(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.east(3).above(10).south(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.south().above(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.south(2).above(2), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.north().west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().west().above(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().west().above(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().west().above(3), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().west().above(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north().west().above(5), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.north().west(2).above(6), boundsIn);


                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).above(4), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).above(5), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).above(6), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).above(7), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.north(3).above(7), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(4).above(8), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(5).above(9), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).above(8).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).above(9).west(2), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.north(2).above(10).west(3), boundsIn);

                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1;
                        int posZ2 = posZ1 + 2;

                        int posX3 = posX1 + 1;
                        int posZ3 = posZ1 - 5;

                        int posX4 = posX1 + 5;
                        int posZ4 = posZ1;

                        int posX5 = posX1 + 4;
                        int posZ5 = posZ1;

                        int posX6 = posX1 - 1;
                        int posZ6 = posZ1 - 1;

                        int posX7 = posX1 + 4;
                        int posZ7 = posZ1 + 2;

                        int posX8 = posX1 - 2;
                        int posZ8 = posZ1 - 2;

                        //Top Leaves
                        this.leafs(worldIn, posX4 + posXLeafWidth - 2, topTrunkHeight4 - 10, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth, topTrunkHeight4 - 10, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 10, posZ4 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 10, posZ4 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

//                        Middle Leaves
                        this.leafs(worldIn, posX5 + posXLeafWidth - 2, topTrunkHeight5 - 15, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth, topTrunkHeight5 - 15, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 15, posZ5 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 15, posZ5 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

//                        Bottom Leaves
                        this.leafs(worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight3 - 12, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafWidth, topTrunkHeight3 - 12, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight3 - 12, posZ2 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight3 - 12, posZ2 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX3 - 1 + posXLeafWidth, topTrunkHeight3 - 5, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 1 + posXLeafWidth, topTrunkHeight3 - 5, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX6 + posXLeafWidth - 2, topTrunkHeight5 - 11, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 + posXLeafWidth, topTrunkHeight5 - 11, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight5 - 11, posZ6 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight5 - 11, posZ6 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX7 + posXLeafWidth - 2, topTrunkHeight5 - 7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + posXLeafWidth, topTrunkHeight5 - 7, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ7 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ7 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX8 + posXLeafWidth - 2, topTrunkHeight5 - 7, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX8 + posXLeafWidth, topTrunkHeight5 - 7, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX8 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ8 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX8 + posXLeafWidth - 1, topTrunkHeight5 - 7, posZ8 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            this.leafs(worldIn, posX4 + posXLeafWidth - 1, topTrunkHeight4 - 9, posZ4 + posZLeafWidthL0, boundsIn, changedBlocks); //Top

                            this.leafs(worldIn, posX5 + posXLeafWidth - 1, topTrunkHeight5 - 14, posZ5 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle

                            this.leafs(worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight3 - 11, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks); //Bottom

                            this.leafs(worldIn, posX3 + posXLeafWidth - 1, topTrunkHeight3 - 4, posZ3 + posZLeafWidthL0, boundsIn, changedBlocks); //Bottom

                            this.leafs(worldIn, posX6 + posXLeafWidth - 1, topTrunkHeight5 - 10, posZ6 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle

                            this.leafs(worldIn, posX7 + posXLeafWidth - 1, topTrunkHeight5 - 6, posZ7 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle

                            this.leafs(worldIn, posX8 + posXLeafWidth - 1, topTrunkHeight5 - 6, posZ8 + posZLeafWidthL0, boundsIn, changedBlocks); //Middle


                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                        }


                        //Top Leaves
                        this.leafs(worldIn, posX4 - 1, topTrunkHeight4 - 9, posZ4 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 - 3, topTrunkHeight4 - 9, posZ4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 + 1, topTrunkHeight4 - 9, posZ4, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX4 - 1, topTrunkHeight4 - 9, posZ4 - 2, boundsIn, changedBlocks);

                        //Middle Leaves
                        this.leafs(worldIn, posX5 - 1, topTrunkHeight5 - 14, posZ5 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 - 3, topTrunkHeight5 - 14, posZ5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 + 1, topTrunkHeight5 - 14, posZ5, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX5 - 1, topTrunkHeight5 - 14, posZ5 - 2, boundsIn, changedBlocks);

                        //Bottom Leaves
                        this.leafs(worldIn, posX2 - 1, topTrunkHeight3 - 11, posZ2 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 3, topTrunkHeight3 - 11, posZ2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 - 1, topTrunkHeight3 - 11, posZ2 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX2 + 1, topTrunkHeight3 - 11, posZ2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX3 - 1, topTrunkHeight3 - 4, posZ3 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 3, topTrunkHeight3 - 4, posZ3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 - 1, topTrunkHeight3 - 4, posZ3 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX3 + 1, topTrunkHeight3 - 4, posZ3, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX6 - 1, topTrunkHeight5 - 10, posZ6 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 - 3, topTrunkHeight5 - 10, posZ6, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 + 1, topTrunkHeight5 - 10, posZ6, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX6 - 1, topTrunkHeight5 - 10, posZ6 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX7 - 1, topTrunkHeight5 - 6, posZ7 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 - 3, topTrunkHeight5 - 6, posZ7, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 + 1, topTrunkHeight5 - 6, posZ7, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX7 - 1, topTrunkHeight5 - 6, posZ7 - 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX8 - 1, topTrunkHeight5 - 6, posZ8 + 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX8 - 3, topTrunkHeight5 - 6, posZ8, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX8 + 1, topTrunkHeight5 - 6, posZ8, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX8 - 1, topTrunkHeight5 - 6, posZ8 - 2, boundsIn, changedBlocks);

                    }
                }
            }

            return true;
            //}
        } else {
            return false;
        }
    }

    private boolean doesTreeFit(LevelSimulatedReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 4;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHere(reader, pos.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Log Placement
    private void treelog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHere(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, LOG, boundingBox);
        }

    }

    //Leaves Placement
    private void leafs(WorldGenLevel reader, int x, int y, int z, BoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, this.randomizer(), boundingBox);
        }

    }

    private BlockState randomizer() {
        return (random.nextInt(25) == 0) ? LEAVES2 : LEAVES;
    }
}