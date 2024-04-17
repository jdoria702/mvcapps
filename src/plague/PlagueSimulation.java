package plague;

import mvc.AppPanel;
import mvc.Utilities;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationPanel;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 5; // % chance of resisting infection

    @Override
    public void populate() {
        for (int i = 0; i < 50; i++) {
            PlagueAgent host = new PlagueAgent("Host " + i);
            addAgent(host);
            // TODO unsure how to initialize
            if (Utilities.rng.nextInt(100) < 5) {
                host.setInfected(true);
            }
        }
    }

    //@Override
    //TODO rewrite the method similarly to the prisoners dilemma
    public String[] getStats() {
        String[] statsStrings = new String[3];
        statsStrings[0] = "# agents = " + agents.size();
        statsStrings[1] = "clock = " + clock;
        int infectedCount = 0;
        for (Agent a : agents) {
            if (a instanceof PlagueAgent host) {
                if (host.isInfected()) {
                    infectedCount++;
                }
            }
        }
        statsStrings[2] = String.format("%% infected = %.1f", infectedCount * 100.0 / agents.size());
        return statsStrings;
    }
    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}