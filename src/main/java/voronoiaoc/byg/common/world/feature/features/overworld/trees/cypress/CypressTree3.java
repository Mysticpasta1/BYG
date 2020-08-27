package voronoiaoc.byg.common.world.feature.features.overworld.trees.cypress;

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

public class CypressTree3 extends BYGAbstractTreeFeature<NoneFeatureConfiguration> {

    public CypressTree3(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    //TODO: Root builder.

    protected boolean place(Set<BlockPos> changedBlocks, WorldGenLevel worldIn, Random rand, BlockPos pos, BoundingBox boundsIn, boolean isSapling) {
        int randTreeHeight = 15 + rand.nextInt(5);
        BlockPos.MutableBlockPos mainmutable = new BlockPos.MutableBlockPos().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.below(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                for (int buildTrunk = 0; buildTrunk <= randTreeHeight; buildTrunk++) {
                    this.treeLog(changedBlocks, worldIn, mainmutable, boundsIn);

                    mainmutable.move(Direction.UP);
                }
                mainmutable.set(pos);
                //Stump
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 0, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 0, -4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 0, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-4, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(4, 0, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 0, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 0, 4), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 1, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 1, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 1, 3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 2, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 2, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 2, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 2, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 2, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 3, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(0, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, 3, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, 4, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, 4, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, 5, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, 6, -2), boundsIn);


                //Top Branches
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 5, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 4, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 4, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 3, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 3, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 3, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 2, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight, 0), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, -2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 1, -1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 1, 1), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 1, 2), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, -3), boundsIn);
                this.treeBranch(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, 0), boundsIn);

                //Stump Leaves
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(6, 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 4, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 4, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 4, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, 4, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 4, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 5, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 5, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 5, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 5, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, 5, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, 5, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 6, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 6, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 6, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, 6, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 6, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 7, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 7, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, 7, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, 7, -1), boundsIn);

                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight - 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 2, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight - 2, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight - 2, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight - 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight - 2, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 1, -3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 1, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight - 1, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, -6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, -4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, -3), boundsIn);
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
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 2, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-6, randTreeHeight + 2, -1), boundsIn);
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
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-6, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 2, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-6, randTreeHeight + 2, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 2, 1), boundsIn);
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
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 2, 2), boundsIn);
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
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 2, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 2, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 2, 6), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, -5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, -4), boundsIn);
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
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 3, -2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 3, -1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(5, randTreeHeight + 3, 0), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-5, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 3, 1), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-4, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(4, randTreeHeight + 3, 2), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-3, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, 3), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-2, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(-1, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(2, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(3, randTreeHeight + 3, 4), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(0, randTreeHeight + 3, 5), boundsIn);
                this.leafs(changedBlocks, worldIn, mainmutable.offset(1, randTreeHeight + 3, 5), boundsIn);
            }
        }
        return true;
    }

    //Log Placement
    private void treeLog(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.CYPRESS_LOG.defaultBlockState(), boundingBox);
        }
    }

    //Log Placement
    private void treeBranch(Set<BlockPos> setlogblock, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        if (canLogPlaceHereWater(reader, pos)) {
            this.setFinalBlockState(setlogblock, reader, pos, BYGBlockList.CYPRESS_LOG.defaultBlockState(), boundingBox);
        }
    }

    //Leaves Placement
    private void leafs(Set<BlockPos> blockPos, WorldGenLevel reader, BlockPos pos, BoundingBox boundingBox) {
        BlockPos.MutableBlockPos blockpos = new BlockPos.MutableBlockPos().set(pos);
        if (isAirOrWater(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, BYGBlockList.CYPRESS_LEAVES.defaultBlockState(), boundingBox);
        }
    }


    private boolean doesTreeFit(LevelSimulatedRW reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 0;

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