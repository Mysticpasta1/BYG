package voronoiaoc.byg.common.world.feature.features.overworld.trees.zelkova;

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

public class ZelkovaTree3 extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {
    //BYGBlockRenders used for the tree.
    private static final BlockState LOG = BYGBlockList.ZELKOVA_LOG.defaultBlockState();
    private static final BlockState LEAVES = BYGBlockList.ZELKOVA_LEAVES.defaultBlockState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.defaultBlockState();
    Random random = new Random();

    public ZelkovaTree3(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }


    public boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {

        int randTreeHeight = rand.nextInt(5) + 22;
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
                    this.treelog(changedBlocks, worldIn, blockpos2.below(6).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.below(6).north(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.below(4).south(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.below(4).east(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.below(10).west(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.below(10).north(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.below(8).south(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.below(8).east(), boundsIn);

                    this.treelog(changedBlocks, worldIn, blockpos2.below(14).south(), boundsIn);
                    this.treelog(changedBlocks, worldIn, blockpos2.below(14).east(), boundsIn);
                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 1;
                        int posZ2 = posZ1 + 1;

                        //Bottom Leaves
//                        this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX1 + posXLeafWidth - 2, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
//                        this.leafs(worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            this.leafs(worldIn, posX1 + posXLeafWidth, topTrunkHeight - 14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);


                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                        }

                        //Bottom Leaves
                        this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 3, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 4, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 5, posZ1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 3, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight, posZ1 + 1, boundsIn, changedBlocks);

                        //--
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 1, posZ1 + 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 2, boundsIn, changedBlocks);

                        //---
                        this.leafs(worldIn, posX1 + 3, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 - 3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 3, posZ1 + 3, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 3, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 - 3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 4, posZ1 + 3, boundsIn, changedBlocks);
                        //---
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 5, posZ1 + 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 6, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 6, posZ1 + 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 7, posZ1 + 2, boundsIn, changedBlocks);
                        //---
                        this.leafs(worldIn, posX1 + 3, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 8, posZ1 - 3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 8, posZ1 + 3, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 3, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 9, posZ1 - 3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 9, posZ1 + 3, boundsIn, changedBlocks);
                        //---
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 9, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 9, posZ1 + 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 10, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 10, posZ1 + 2, boundsIn, changedBlocks);
                        //---

                        this.leafs(worldIn, posX1 + 3, topTrunkHeight - 12, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight - 12, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 12, posZ1 - 3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 12, posZ1 + 3, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 3, topTrunkHeight - 13, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 3, topTrunkHeight - 13, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 13, posZ1 - 3, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 13, posZ1 + 3, boundsIn, changedBlocks);
                        //---
                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 13, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 13, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 13, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 13, posZ1 + 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 14, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 14, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 14, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 14, posZ1 + 2, boundsIn, changedBlocks);

                        this.leafs(worldIn, posX1 + 2, topTrunkHeight - 15, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 2, topTrunkHeight - 15, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 15, posZ1 - 2, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 15, posZ1 + 2, boundsIn, changedBlocks);
                        //---
                        this.leafs(worldIn, posX1 + 1, topTrunkHeight - 16, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1 - 1, topTrunkHeight - 16, posZ1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 16, posZ1 - 1, boundsIn, changedBlocks);
                        this.leafs(worldIn, posX1, topTrunkHeight - 16, posZ1 + 1, boundsIn, changedBlocks);
                        //------
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
            int distance = 0;

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
            this.setFinalBlockState(blockPos, reader, blockpos, LEAVES, boundingBox);
        }
    }
}