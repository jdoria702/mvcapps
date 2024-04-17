package randomwalk;

import mvc.*;
import simstation.*;

class Drunk extends Agent {
    public Drunk() {
        super();
        heading = new Heading();
        xc = (int) (Math.random() * 415);
        yc = (int) (Math.random() * 500);
    }

    @Override
    public void update() {
        heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}
