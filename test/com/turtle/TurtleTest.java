package com.turtle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurtleTest {
    Turtle ijapa;
    Pen biro;
    SketchPad pad;

    @BeforeEach
    void setUp() {
        ijapa = new Turtle();
        biro = new Pen();
        ijapa.setTurtlePen(biro);
        pad = new SketchPad();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createTurtleTest() {
        assertEquals(0, ijapa.getXCoordinate());
        assertEquals(0, ijapa.getYCoordinate());
        assertEquals(PenPosition.UP, ijapa.getTurtlePen().getPositionOfThePen());
    }

    @Test
    void moveForwardWithPenUpTest() {
        assertEquals(0, ijapa.getXCoordinate());
        assertEquals(0, ijapa.getYCoordinate());
        assertEquals(PenPosition.UP, ijapa.getTurtlePen().getPositionOfThePen());
        assertEquals(CardinalDirection.NORTH, ijapa.getDirection());
        ijapa.moveForward(7);
        assertEquals(6, ijapa.getXCoordinate());
        assertEquals(0, ijapa.getYCoordinate());
        assertEquals(CardinalDirection.NORTH, ijapa.getDirection());
    }

    @Test
    void putPenDownTest(){
        assertEquals(PenPosition.UP, ijapa.getTurtlePen().getPositionOfThePen());
        ijapa.changePenPosition(PenPosition.DOWN);
        assertEquals(PenPosition.DOWN, ijapa.getTurtlePen().getPositionOfThePen());
    }

    @Test
    void drawTest() {
        int steps = 7;
//        ijapa.changePenPosition(PenPosition.DOWN);
        ijapa.draw(pad.getFloor(), steps);
        for(int i = 0; i < steps; i++) {
            assertEquals(1, pad.getFloor()[0][i]);
        }
    }

    @Test
    void turnRightWhenFacingNorthTest() {
        assertEquals(CardinalDirection.NORTH, ijapa.getDirection());
        ijapa.turnRight();
        assertEquals(CardinalDirection.EAST, ijapa.getDirection());
    }

    @Test
    void turnRightWhenFacingEastTest() {
        ijapa.setDirection(CardinalDirection.EAST);
        ijapa.turnRight();
        assertEquals(CardinalDirection.SOUTH, ijapa.getDirection());
    }

    @Test
    void turnRightWhenFacingSouthTest() {
        ijapa.setDirection(CardinalDirection.SOUTH);
        ijapa.turnRight();
        assertEquals(CardinalDirection.WEST, ijapa.getDirection());
    }

    @Test
    void turnRightWhenFacingWestTest() {
        ijapa.setDirection(CardinalDirection.WEST);
        ijapa.turnRight();
        assertEquals(CardinalDirection.NORTH, ijapa.getDirection());
    }

    @Test
    void drawSquareText() {
        assertEquals(CardinalDirection.NORTH, ijapa.getDirection());
        int steps = 12;
        ijapa.draw(pad.getFloor(), steps);

        ijapa.turnRight(); //East
        ijapa.draw(pad.getFloor(), steps);

        ijapa.turnRight(); //South
        ijapa.draw(pad.getFloor(), steps);

        ijapa.turnRight(); //West
        ijapa.draw(pad.getFloor(), steps);

        for(int i = 0; i < pad.getFloor().length; i++) {
            for(int j = 0; j < pad.getFloor().length; j++) {
                if(pad.getFloor()[i][j] == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
