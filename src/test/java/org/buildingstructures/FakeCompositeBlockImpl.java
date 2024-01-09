package org.buildingstructures;

import java.util.ArrayList;
import java.util.List;

public class FakeCompositeBlockImpl implements CompositeBlock {
    private final List<Block> blocks;

    public FakeCompositeBlockImpl() {
        this.blocks = new ArrayList<>();
    }

    public void addBlock(Block block) {
        this.blocks.add(block);
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }
}
