package com.turtle;

import java.math.BigInteger;

public class Turtle {

    private int xCoordinate;
    private int yCoordinate;
    private CardinalDirection direction = CardinalDirection.NORTH;

    private Pen turtlePen;

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Pen getTurtlePen() {
        return turtlePen;
    }

    public void setTurtlePen(Pen turtlePen) {
        this.turtlePen = turtlePen;
    }

    public void moveForward(int numberOfSteps) {
        this.xCoordinate = numberOfSteps - 1;
    }

    public CardinalDirection getDirection() {
        return direction;
    }

    public void setDirection(CardinalDirection direction) {
        this.direction = direction;
    }

    public void changePenPosition(PenPosition newPosition) {
        turtlePen.setPositionOfThePen(newPosition);
    }

    public void draw(int [][] canvas, int numberOfSteps) {
        this.turtlePen.setPositionOfThePen(PenPosition.DOWN);
        if (this.direction == CardinalDirection.NORTH) {
            for (int i = 0; i < numberOfSteps; i++) {
                canvas[yCoordinate][i] = BigInteger.ONE.intValue();
            }
            this.xCoordinate = numberOfSteps - 1;
        } else if (this.direction == CardinalDirection.EAST) {
            for(int i = 0; i < numberOfSteps; i++) {
                canvas[i][xCoordinate] = 1;
            }
            this.yCoordinate = numberOfSteps - 1;
        } else if (this.direction == CardinalDirection.SOUTH) {
            for(int i = numberOfSteps - 1; i >= 0 ; i--) {
                canvas[yCoordinate][i] = 1;
            }
            this.xCoordinate = xCoordinate - --numberOfSteps;
        } else if (this.direction == CardinalDirection.WEST) {
            for(int i = numberOfSteps - 1; i >= 0; i--) {
                canvas[i][xCoordinate] = 1;
            }
            this.yCoordinate = yCoordinate - --numberOfSteps;
        }
    }

    public void turnRight() {
        if(direction == CardinalDirection.NORTH) {
            direction = CardinalDirection.EAST;
        } else if (direction == CardinalDirection.EAST) {
            direction = CardinalDirection.SOUTH;
        } else if (direction == CardinalDirection.SOUTH) {
            direction = CardinalDirection.WEST;
        } else if (direction == CardinalDirection.WEST) {
            direction = CardinalDirection.NORTH;
        }

    }
}

