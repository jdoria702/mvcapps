package simstation;

import mvc.*;

public enum Heading {
    NORTH, EAST, SOUTH, WEST;

    public static Heading parse(String heading) {
        if (heading.equalsIgnoreCase("north")) return NORTH;
        if (heading.equalsIgnoreCase("east")) return EAST;
        if (heading.equalsIgnoreCase("south")) return SOUTH;
        if (heading.equalsIgnoreCase("west")) return WEST;
        Utilities.error("Invalid heading: " + heading);
        return null;
    }

    public static Heading random() {
        int luck = Utilities.rng.nextInt(4);
        if (luck == 0) return NORTH;
        if (luck == 1) return SOUTH;
        if (luck == 2) return EAST;
        return WEST;
    }
}
