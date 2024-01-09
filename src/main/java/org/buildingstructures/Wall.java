package org.buildingstructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return this.findBlockByColorHelper(color, this.blocks);
    }

    private Optional<Block> findBlockByColorHelper(String color, List<Block> currentBlocks) {
        for (Block block : currentBlocks) {
            if (block instanceof CompositeBlock compositeBlock) {
                Optional<Block> composite = findBlockByColorHelper(color, compositeBlock.getBlocks());
                if (composite.isPresent()) {
                    return composite;
                }
            } else {
                if (block.getColor().equals(color)) {
                    return Optional.of(block);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> resultList = new ArrayList<>();
        findBlocksByMaterialHelper(material, this.blocks, resultList);
        return resultList;
    }

    private void findBlocksByMaterialHelper(String material, List<Block> currentBlocks, List<Block> resultList) {
        for (Block block : currentBlocks) {
            if (block instanceof CompositeBlock compositeBlock) {
                findBlocksByMaterialHelper(material, compositeBlock.getBlocks(), resultList);
            } else {
                if (block.getMaterial().equals(material)) {
                    resultList.add(block);
                }
            }

        }
    }

    @Override
    public int count() {
        return this.countHelper(this.blocks);
    }

    private int countHelper(List<Block> currentBlocks) {
        int currentCount = 0;
        for (Block block : currentBlocks) {
            if (block instanceof CompositeBlock compositeBlock) {
                currentCount += countHelper(compositeBlock.getBlocks());
            } else {
                currentCount += 1;
            }
        }
        return currentCount;
    }

}
