package ai.maxhome.europa;

import java.util.Map;
import java.util.HashMap;

/**
 * Represents the four directions.
 */
public enum Direction {
    NORTH('N'),
    EAST('E'),
    SOUTH('S'),
    WEST('W');

    private final char code;

    private static final Map<Character, Direction> lookup = new HashMap<>();

    static {
        for (Direction d : Direction.values()) {
            lookup.put(d.getCode(), d);
        }
    }

    Direction(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Direction fromCode(char code) {
        if (lookup.containsKey(code)) {
            throw new IllegalArgumentException("Invalid direction code: " + code);
        }
        return lookup.get(code);
    }

    public Direction turnLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                throw new IllegalStateException("Unexpected direction");
        }
    }

    public Direction turnRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                throw new IllegalStateException("Unexpected direction");
        }
    }
}
