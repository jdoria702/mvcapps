package simstation;

import mvc.Command;
import mvc.Model;

public class StatsCommand extends Command {
    public StatsCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {
        Simulation simulation = (Simulation) model;
        simulation.execute("stats");
    }
}
