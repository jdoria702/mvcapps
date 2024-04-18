package flocking;
import simstation.*;
import simstation.Agent;
import mvc.*;

public class Bird extends Agent {
    private int speed;
    public Bird(){
        super();
        this.speed = Utilities.rng.nextInt(5) + 1;
        heading = new Heading();
        xc = (int) (Math.random() * 415);
        yc = (int) (Math.random() * 500);
    }

    public int getSpeed(){
        return this.speed;
    }
    public void update() {
        Bird neighbor = (Bird) simulation.getNeighbor(this, 20);
        if (neighbor != null) {
            this.heading = neighbor.heading;
            this.speed = neighbor.speed;
            move(speed);
        }
        else{
            move(speed);
        }
    }


}
