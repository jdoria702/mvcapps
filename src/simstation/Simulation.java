package simstation;

import mvc.Model;
import mvc.Subscriber;

import java.util.LinkedList;
import java.util.List;

public class Simulation extends Model {
    private int clock = 0;
    private List<Agent> agents = new LinkedList<Agent>();
    private boolean hasStarted = false;

    public String execute(String cmmd) throws Exception {
        if (cmmd.equalsIgnoreCase("start") && !hasStarted) {
            hasStarted = true;
            populate();
            // Start world clock here
            for (Agent a : agents) {
                a.run();
                notifySubscribers();  // <-- im not sure if this is the right location
            }
        } else if (cmmd.equalsIgnoreCase("suspend")) {
            for (Agent a : agents) {
                a.suspend();
            }
        } else if (cmmd.equalsIgnoreCase("resume")) {
            for (Agent a : agents) {
                a.resume();
            }
        } else if (cmmd.equalsIgnoreCase("stop")) {
            for (Agent a : agents) {
                a.stop();
            }
        } else if (cmmd.equalsIgnoreCase("stats")) {
            for (Agent a : agents) {
                // nothing yet
            }
        } else {
            throw new Exception("unrecognized command: " + cmmd);
        }
        return "ok";
    }

    public void addAgent(Agent a) {
        agents.add(a);
        a.setSimulation(this);
    }

    public Agent getNeighbor(Agent a, double radius) {
        return null; // for now
    }

    public void populate() {
        // empty and will be specified in subclasses
    }

}
