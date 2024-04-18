package flocking;

import mvc.AppPanel;
import mvc.Utilities;
import simstation.Simulation;
import simstation.Agent;
import simstation.SimulationPanel;
import simstation.Heading;

public class FlockingSimulation extends Simulation {
    public void populate() {
        for (int i = 0; i < 15; i++)
            addAgent(new Bird());
    }

    public void stats() {
        Utilities.inform(getStats());
    }

    public String[] getStats() {
        int one = 0, two = 0, three = 0, four = 0, five = 0;
        for(Agent a : agents)
        {
            if (a instanceof Bird b)
            {
                if (b.getSpeed() == 1){one++;}
                else if (b.getSpeed() == 2){two++;}
                else if (b.getSpeed() == 3){three++;}
                else if (b.getSpeed() == 4){four++;}
                else if (b.getSpeed() == 5){five++;}

            }
        }
       String[] stats = new String[5];
       stats[0] = "#birds @ speed 1 = " + one;
       stats[1] = "#birds @ speed 2 = " + two;
       stats[2] = "#birds @ speed 3 = " + three;
       stats[3] = "#birds @ speed 4 = " + four;
       stats[4] = "#birds @ speed 5 = " + five;
       return stats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
