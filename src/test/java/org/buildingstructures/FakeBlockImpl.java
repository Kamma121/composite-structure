package org.buildingstructures;

public class FakeBlockImpl implements Block{
    private final String color;
    private final String material;

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

    public FakeBlockImpl(String color, String material) {
        this.color = color;
        this.material = material;
    }
}
