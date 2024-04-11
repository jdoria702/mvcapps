package Life;

import CALab.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Society extends Grid {

    public static int percentAlive = 50;
    public static Set<Integer> death = new HashSet<Integer>();
    public static Set<Integer> rebirth = new HashSet<Integer>();

    // Static code block to initialize rebirth and death ambiences
    static {
        // Add ambiences to rebirth and death
        rebirth.add(3);
        death.add(0);
        death.add(1);
        death.add(4);
        death.add(5);
        death.add(6);
        death.add(7);
        death.add(8);
    }

    @Override
    public Agent makeCell(boolean uniform) {
        if (uniform) {
            return new Agent(0);                     // Sets all to dead
        } else {
            return new Agent(new Random().nextInt(2));      // Sets all randomly
        }
    }
}
