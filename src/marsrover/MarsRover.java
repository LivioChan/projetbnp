package marsrover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No input given");
            return;
        }

        String inputFile = args[0];
    	File file = new File(inputFile);
        try {
            Scanner scanner = new Scanner(file);

            int gridX = scanner.nextInt();
            int gridY = scanner.nextInt();

            List<Rover> rovers = new ArrayList<>();

            while (scanner.hasNext()) {
                int roverX = scanner.nextInt();
                int roverY = scanner.nextInt();
                String direction = scanner.next();
                Rover rover = new Rover(roverX, roverY, direction,gridX,gridY);
                rovers.add(rover);

                String commands = scanner.next();
                rover.processCommands(commands);
            }

            scanner.close();

            for (Rover rover : rovers) {
                System.out.println(rover.getPosition());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}


