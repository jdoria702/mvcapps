package simstation;

import mvc.*;
import java.util.*;

public class Simulation extends Model {
    protected int clock = 0;
    transient private Timer timer;
    protected List<Agent> agents = new LinkedList<Agent>();
    private boolean hasStarted = false;


    public void start() {
        if (hasStarted == true) {
            Utilities.inform("Simulation has already started");
        } else {
            hasStarted = true;
            startTimer();
            populate();
            // Start world clock here
            for (Agent a : agents) {
                a.start();
            }
        }
    }

    public void suspend() {
        stopTimer();
        for (Agent a : agents) {
            a.suspend();
        }
    }

    public void resume() {
        startTimer();
        for (Agent a : agents) {
            a.resume();
        }
    }

    public void stop() {
        stopTimer();
        for (Agent a : agents) {
            a.stop();
        }
    }

    public void stats() {
        Utilities.inform("Time: " + clock + " seconds\n" + "Number of Agents: " + agents.size());
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
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

    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
        }
    }
}
