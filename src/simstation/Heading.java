package simstation;

import java.util.Random;

public class Heading {
    private int direction;

    public Heading() {
        random();
    }

    public void random() {
        Random random = new Random();
        direction = random.nextInt(360);
    }

    public int getDirection() {
        return direction;
    }
}
