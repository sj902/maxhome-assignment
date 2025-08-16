package ai.maxhome.europa;

public class Plateau {
    private final int maxX;
    private final int maxY;
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;

    public Plateau(int maxX, int maxY) {
        if (maxX < 0 || maxY < 0) {
            throw new IllegalArgumentException("Plateau dimensions cannot be negative.");
        }
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isWithinBounds(Position position) {
        return position.getX() >= MIN_X && position.getX() <= maxX &&
                position.getY() >= MIN_Y && position.getY() <= maxY;
    }
}
