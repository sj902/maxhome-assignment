package ai.maxhone.europa;

import ai.maxhome.europa.Direction;
import ai.maxhome.europa.Plateau;
import ai.maxhome.europa.Position;
import ai.maxhome.europa.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    private Plateau plateau;

    @BeforeEach
    void setUp() {
        plateau = new Plateau(5, 5);
    }

    @Test
    void testFirstRoverFromExample() {
        Position startPos = new Position(1, 2);
        Rover rover = new Rover(startPos, Direction.NORTH, plateau);
        rover.processInstructions("LMLMLMLMM");
        assertEquals("1 3 N", rover.getStatus());
    }

    @Test
    void testSecondRoverFromExample() {
        Position startPos = new Position(3, 3);
        Rover rover = new Rover(startPos, Direction.EAST, plateau);
        rover.processInstructions("MMRMMRMRRM");
        assertEquals("5 1 E", rover.getStatus());
    }

    @Test
    void testRoverStopsAtBoundary() {
        Position startPos = new Position(0, 0);
        Rover rover = new Rover(startPos, Direction.WEST, plateau);
        rover.processInstructions("M");
        assertEquals("0 0 W", rover.getStatus(), "Rover should not move off the grid");

        Rover rover2 = new Rover(new Position(3, 5), Direction.NORTH, plateau);
        rover2.processInstructions("MM");
        assertEquals("3 5 N", rover2.getStatus(), "Rover should not move off the grid");
    }

    @Test
    void test360DegreeSpins() {
        Position startPos = new Position(2, 2);
        Rover rover = new Rover(startPos, Direction.NORTH, plateau);

        rover.processInstructions("LLLL");
        assertEquals("2 2 N", rover.getStatus(), "Four left turns should return to original direction");

        rover.processInstructions("RRRR");
        assertEquals("2 2 N", rover.getStatus(), "Four right turns should return to original direction");
    }

    @Test
    void testComplexMovement() {
        Position startPos = new Position(0, 0);
        Rover rover = new Rover(startPos, Direction.NORTH, plateau);
        rover.processInstructions("RMMMLMMLMM");
        assertEquals("1 2 W", rover.getStatus());
    }
}