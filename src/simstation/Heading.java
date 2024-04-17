package simstation;

import mvc.*;
import java.util.Random;

public class Heading {
    private int direction;

    public Heading() {
        random();
    }
//    NORTH, EAST, SOUTH, WEST;

//    public static Heading parse(String heading) {
//        if (heading.equalsIgnoreCase("north")) return NORTH;
//        if (heading.equalsIgnoreCase("east")) return EAST;
//        if (heading.equalsIgnoreCase("south")) return SOUTH;
//        if (heading.equalsIgnoreCase("west")) return WEST;
//        Utilities.error("Invalid heading: " + heading);
//        return null;
//    }

//    public static Heading random() {
//        int luck = Utilities.rng.nextInt(4);
//        if (luck == 0) return NORTH;
//        if (luck == 1) return SOUTH;
//        if (luck == 2) return EAST;
//        return WEST;
//    }

    public void random() {
        Random random = new Random();
        direction = random.nextInt(360);
    }

    public int getDirection() {
        return direction;
    }
}
