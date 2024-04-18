package flocking;

import mvc.*;
import simstation.*;
public class Bird extends Agent {
    private Bird partner;
    private final int radius = 20;
    private int speed;

    public Bird() {
        super();
        speed = Utilities.rng.nextInt(0, 5) + 1;
        heading = new Heading();
        xc = (int) (Math.random() * 415);
        yc = (int) (Math.random() * 500);
    }
    @Override
    public void update() {
        partner = (Bird) simulation.getNeighbor(this, radius);
        if (partner == null) {
            move(speed);
        } else {
            this.speed = partner.speed;
            this.heading = partner.heading;
            move(speed);
        }
    }
}
