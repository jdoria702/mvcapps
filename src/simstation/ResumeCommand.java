package simstation;

import mvc.*;

public class ResumeCommand extends Command {
    public ResumeCommand(Model model) {
        super(model);
    }

    public void execute() throws Exception {
        Simulation simulation = (Simulation) model;
        simulation.execute("resume");
    }
}
