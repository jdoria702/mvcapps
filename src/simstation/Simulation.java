package simstation;

import mvc.Model;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
                System.out.println("agent is starting");
                Thread thread = new Thread(a); // Create a new Thread for the Agent
                thread.start(); // Start the thread associated with the Agent
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

    public List<Agent> getAgents() {
        return agents;
    }

    public Agent getNeighbor(Agent a, double radius) {          // doesn't wrap around
        List<Agent> closeNeighbors = new LinkedList<Agent>();
        for (Agent other : agents) {
            if (Math.pow((other.xc - a.xc), 2) + Math.pow((other.yc - a.yc), 2) <= radius * radius) {
                closeNeighbors.add(other);
            }
        }

        if (closeNeighbors.isEmpty()) {
            return null;
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(closeNeighbors.size());
        return closeNeighbors.get(randomIndex);
    }

    public void populate() {
        // empty and will be specified in subclasses
    }

}
