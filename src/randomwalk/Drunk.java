package randomwalk;

import mvc.*;
import simstation.*;

class Drunk extends Agent {
    private Heading heading;

    public Drunk() {
        super();
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}
