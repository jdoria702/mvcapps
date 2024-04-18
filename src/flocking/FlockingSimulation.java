package flocking;

import mvc.AppPanel;
import prisonersDilemma.PrisonersDilemmaFactory;
import simstation.*;

public class FlockingSimulation extends Simulation {
    private final int agentSize = 40;

    public void populate() {
        for (int i = 0; i < agentSize; i++) {
            addAgent(new Bird());
        }
    }

    public void stats() {

    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}
