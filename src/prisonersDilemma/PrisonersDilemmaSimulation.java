package prisonersDilemma;

import mvc.*;
import simstation.*;

public class PrisonersDilemmaSimulation extends Simulation {
    private int agentSize = 40;

    public void populate() {
        for (int i = 0; i < agentSize / 4; i++) {
            addAgent(new Prisoner(new Cooperate()));
            addAgent(new Prisoner(new RandomlyCooperate()));
            addAgent(new Prisoner(new Cheat()));
            addAgent(new Prisoner(new Tit4Tat()));
        }
    }

    public void stats() {
        int cooperateScore = 0;
        int randomlyCooperateScore = 0;
        int cheatScore = 0;
        int tit4TatScore = 0;

        for (Agent agent : agents) {
            Prisoner prisoner = (Prisoner) agent;
            String strategy = prisoner.strategy.getStrategy();
            switch (strategy) {
                case "Cooperate":
                    cooperateScore += prisoner.getFitness();
                    break;
                case "RandomlyCooperate":
                    randomlyCooperateScore += prisoner.getFitness();
                    break;
                case "Cheat":
                    cheatScore += prisoner.getFitness();
                    break;
                case "Tit4Tat":
                    tit4TatScore += prisoner.getFitness();
                    break;
                default:
                    break;
            }
        }

        Utilities.inform("Time: " + clock + " seconds\n" +
                "AVERAGE FITNESS \n" +
                "Cooperate fitness (GREEN) : " + cooperateScore / 4 + "\n" +
                "RandomlyCooperate fitness (CYAN) : " + randomlyCooperateScore / 4 + "\n" +
                "Cheat fitness (RED) : " + cheatScore / 4+ "\n" +
                "Tit4Tat fitness (ORANGE) : " + tit4TatScore / 4+ "\n");
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonersDilemmaFactory());
        panel.display();
    }
}
