package ai.maxhome.europa;

public class Rover {
    private Position position;
    private Direction direction;
    private final Plateau plateau;

    public Rover(Position position, Direction direction, Plateau plateau) {
        if (!plateau.isWithinBounds(position)) {
            throw new IllegalArgumentException("Rover's initial position is outside the plateau.");
        }
        this.position = position;
        this.direction = direction;
        this.plateau = plateau;
    }

    public void processInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (Character.toUpperCase(instruction)) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    move();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid instruction: " + instruction);
            }
        }
    }

    private void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    private void turnRight() {
        this.direction = this.direction.turnRight();
    }

    private void move() {
        Position nextPosition = this.position.getNextPosition(this.direction);
        if (plateau.isWithinBounds(nextPosition)) {
            System.err.println("Rover has moved out of bounds. Doing nothing here.");
            this.position = nextPosition;
        }
    }

    public String getStatus() {
        return position.getX() + " " + position.getY() + " " + direction.getCode();
    }
}