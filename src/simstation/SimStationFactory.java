package simstation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class SimStationFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new Simulation();
    }

    @Override
    public View makeView(Model m) {
        return new SimulationView((Simulation) m);
    }

    @Override
    public String getTitle() {
        return "Simulation";
    }

    @Override
    public String[] getHelp() {
        return new String[] {
                "Click buttons and it'll do what it says"
        };
    }

    @Override
    public String about() {
        return "SimStation assignment, Group 6";
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {
                "start",
                "suspend",
                "resume",
                "stop",
                "stats"
        };
    }

    @Override
    public Command makeEditCommand(Model model, String name, Object object) {
        if (name.equals("start")) {
            return new StartCommand(model);
        } else if (name.equals("suspend")) {
            return new SuspendCommand(model);
        } else if (name.equals("resume")) {
            return new ResumeCommand(model);
        } else if (name.equals("stop")) {
            return new StopCommand(model);
        } else if (name.equals("stats")) {
            return new StatsCommand(model);
        }
        return null;
    }
}
