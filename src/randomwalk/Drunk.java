package randomwalk;

import mvc.*;
import simstation.*;

class Drunk extends Agent {
    public Drunk() {
        super();
        heading = Heading.random();
    }

    @Override
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}
