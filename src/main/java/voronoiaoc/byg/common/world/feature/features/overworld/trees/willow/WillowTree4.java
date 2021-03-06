package voronoiaoc.byg.common.world.feature.features.overworld.trees.willow;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedRW;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

public class WillowTree4 extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {

    public WillowTree4(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    protected boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 13 + rand.nextInt(8);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);
        BlockPos.MutableBlockPos mainmutable2 = new BlockPos.MutableBlockPos().set(pos.relative(Direction.NORTH));
        BlockPos.MutableBlockPos mainmutable3 = new BlockPos.MutableBlockPos().set(pos.relative(Direction.SOUTH));
        BlockPos.MutableBlockPos mainmutable4 = new BlockPos.MutableBlockPos().set(pos.relative(Direction.WEST));
        BlockPos.MutableBlockPos mainmutable5 = new BlockPos.MutableBlockPos().set(pos.relative(Direction.EAST));

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                for (int buildTrunk = 3; buildTrunk <= randTreeHeight; buildTrunk++) {
                    if (buildTrunk == 3)
                        mainmutable.move(Direction.UP, 3);
                    if (buildTrunk == 3) {
                        mainmutable2.move(Direction.UP, 4);
                        mainmutable3.move(Direction.UP, 4);
                        mainmutable4.move(Direction.UP, 4);
                        mainmutable5.move(Direction.UP, 4);
                    }
                    this.treeLog(changedBlocks, worldIn, mainmutable, boundsIn);

                    if (buildTrunk <= randTreeHeight - 3) {
                        this.treeLog(changedBlocks, worldIn, mainmutable2, boundsIn);
                        this.treeLog(changedBlocks, worldIn, mainmutable3, boundsIn);
                        this.treeLog(changedBlocks, worldIn, mainmutable4, boundsIn);
                        this.treeLog(changedBlocks, worldIn, mainmutable5, boundsIn);
                    }

                    mainmutable.move(Direction.UP);
                    mainmutable2.move(Direction.UP);
                    mainmutable3.move(Direction.UP);
                    mainmutable4.move(Direction.UP);
                    mainmutable5.move(Direction.UP);
                }
                mainmutable.set(pos);

                //Roots
                BlockPos.MutableBlockPos rootMutable = new BlockPos.MutableBlockPos().set(mainmutable.offset(-4, 0, 0));
                BlockPos.MutableBlockPos rootMutable2 = new BlockPos.MutableBlockPos().set(mainmutable.offset(4, 0, 0));
                BlockPos.MutableBlockPos rootMutable3 = new BlockPos.MutableBlockPos().set(mainmutable.offset(0, 0, -4));
                BlockPos.MutableBlockPos rootMutable4 = new BlockPos.MutableBlockPos().set(mainmutable.offset(0, 0, 4));

                for (int buildRoot = 0; buildRoot <= 5; buildRoot++) {
                    this.treeBranch(changedBlocks, worldIn, rootMutable, boundsIn);
                    this.treeBranch(changedBlocks, worldIn, rootMutable2, boundsIn);
                    this.treeBranch(changedBlocks, worldIn, rootMutable3, boundsIn);
                    this.treeBranch(changedBlocks, worldIn, rootMutable4, boundsIn);

                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        if (direction != Direction.WEST)
                            this.treeBranch(changedBlocks, worldIn, rootMutable.relative(direction), boundsIn);
                        if (direction != Direction.EAST)
                            this.treeBranch(changedBlocks, worldIn, rootMutable2.relative(direction), boundsIn);
                        if (direction != Direction.NORTH)
                            this.treeBranch(changedBlocks, worldIn, rootMutable3.relative(direction), boundsIn);
                        if (direction != Direction.SOUTH)
                            this.treeBranch(changedBlocks, worldIn, rootMutable4.relative(direction), boundsIn);
                    }

                    rootMutable.move(Direction.DOWN);
                    rootMutable2.move(Direction.DOWN);
                    rootMutable3.move(Direction.DOWN);
                    rootMutable4.move(Direction.DOWN);
                }

                //Roots/Stump
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 2, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 2, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 3, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 3, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 4, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 4, 2), boundsIn);


                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 1, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 5, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 5, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 5, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 4, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 4, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 4, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 4, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 4, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 4, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, randTreeHeight - 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, randTreeHeight - 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight - 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, randTreeHeight, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, randTreeHeight, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, randTreeHeight, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, randTreeHeight, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 1, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, randTreeHeight + 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, randTreeHeight + 1, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 1, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 1, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 1, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 1, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 4), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.defaultBlockState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.WILLOW_LOG.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos().set(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.WILLOW_LEAVES.defaultBlockState(), boundingBox);
        }
    }


    private boolean doesTreeFit(LevelSimulatedRW reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 2;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHereWater(reader, pos.set(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}