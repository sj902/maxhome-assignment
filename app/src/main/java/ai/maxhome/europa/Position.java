package ai.maxhome.europa;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getNextPosition(Direction direction) {
        switch (direction) {
            case NORTH:
                return new Position(this.x, this.y + 1);
            case EAST:
                return new Position(this.x + 1, this.y);
            case SOUTH:
                return new Position(this.x, this.y - 1);
            case WEST:
                return new Position(this.x - 1, this.y);
            default:
                throw new IllegalArgumentException("Invalid direction:" + direction.getCode());
        }
    }
}