package com.turtle;

public class SketchPad {

    private int [][] floor = new int [20][20];

    public void setFloor(int[][] newFloor) {
        floor = newFloor;
    }

    public int[][] getFloor() {
        return floor;
    }
}
