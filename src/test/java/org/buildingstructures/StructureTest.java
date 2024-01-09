package org.buildingstructures;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StructureTest {
    private Wall wall;

    @BeforeEach
    void setUp() {
        List<Block> blockList = new ArrayList<>();
        FakeCompositeBlockImpl compositeBlock = new FakeCompositeBlockImpl();
        FakeCompositeBlockImpl compositeBlock1 = new FakeCompositeBlockImpl();
        compositeBlock1.addBlock(new FakeBlockImpl("grey", "clay"));
        compositeBlock1.addBlock(new FakeBlockImpl("green", "wool"));
        compositeBlock.addBlock(new FakeBlockImpl("brown", "wood"));
        compositeBlock.addBlock(new FakeBlockImpl("yellow", "wool"));
        compositeBlock.addBlock(compositeBlock1);
        compositeBlock.addBlock(new FakeBlockImpl("red", "brick"));
        blockList.add(compositeBlock);
        blockList.add(new FakeBlockImpl("grey", "wool"));
        blockList.add(new FakeBlockImpl("blue", "wool"));
        blockList.add(new FakeBlockImpl("blue", "wool"));
        wall = new Wall(blockList);
    }

    @Test
    void testFindBlockByColorExists() {
        Optional<Block> result = wall.findBlockByColor("red");
        assertTrue(result.isPresent());
        assertEquals("red", result.get().getColor());
    }

    @Test
    void testFindByColorNotExists() {
        Optional<Block> result = wall.findBlockByColor("white");
        assertFalse(result.isPresent());
    }

    @Test
    void testFindBlocksByMaterial() {
        List<Block> woolBlocks = wall.findBlocksByMaterial("wool");
        assertEquals(5, woolBlocks.size());
        assertEquals("wool", woolBlocks.get(0).getMaterial());
    }

    @Test
    void testFindBlocksByMaterialNotExist() {
        List<Block> metalBlocks = wall.findBlocksByMaterial("metal");
        assertTrue(metalBlocks.isEmpty());
    }

    @Test
    void testCount() {
        assertEquals(8, wall.count());
    }

}
