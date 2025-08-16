package ai.maxhome.europa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int plateauMaxX = scanner.nextInt();
            int plateauMaxY = scanner.nextInt();
            scanner.nextLine();

            Plateau plateau = new Plateau(plateauMaxX, plateauMaxY);

            while (scanner.hasNextLine()) {
                String positionLine = scanner.nextLine();
                if (positionLine.trim().isEmpty()) {
                    break;
                }

                String[] initialPos = positionLine.split(" ");
                int startX = Integer.parseInt(initialPos[0]);
                int startY = Integer.parseInt(initialPos[1]);
                char startDirCode = initialPos[2].charAt(0);

                Position startPosition = new Position(startX, startY);
                Direction startDirection = Direction.fromCode(startDirCode);

                Rover rover = new Rover(startPosition, startDirection, plateau);

                if (scanner.hasNextLine()) {
                    String instructions = scanner.nextLine();
                    rover.processInstructions(instructions);
                }

                System.out.println(rover.getStatus());
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
