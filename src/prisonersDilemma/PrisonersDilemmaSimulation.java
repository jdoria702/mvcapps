package prisonersDilemma;

import mvc.*;
import simstation.*;

public class PrisonersDilemmaSimulation extends Simulation {
    private int agentSize = 40;
    protected int cooperateScore = 0;
    protected int randomlyCooperateScore = 0;
    protected int cheatScore = 0;
    protected int tit4TatScore = 0;

    public void populate() {
        for (int i = 0; i < agentSize / 4; i++) {
            addAgent(new Prisoner(new Cooperate()));
            addAgent(new Prisoner(new RandomlyCooperate()));
            addAgent(new Prisoner(new Cheat()));
            addAgent(new Prisoner(new Tit4Tat()));
        }
    }

    public void stats() {
        Utilities.inform("Time: " + clock + " seconds\n" +
                "Cooperate fitness: " + agents.size() + "\n" +
                "RandomlyCooperate fitness: " + agents.size() + "\n" +
                "Cheat fitness: " + agents.size() + "\n" +
                "Tit4Tat fitness: " + agents.size() + "\n");
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonersDilemmaFactory());
        panel.display();
    }
}
