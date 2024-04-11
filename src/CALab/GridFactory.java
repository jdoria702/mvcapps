package CALab;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public abstract class GridFactory implements AppFactory {

    // create and return instance of grid model
    @Override
    public abstract Model makeModel();

    // create and return instance of grid model view
    @Override
    public abstract View makeView(Model m);

    // title of CALab
    @Override
    public String getTitle() {
        return "Cell Automata: Life";
    }

    // help instructions
    @Override
    public String[] getHelp() {
        return new String[] {"Click Run to update and view the status of cells as time passes",
                "Click Populate to create cells within the grid",
                "Click Clear to empty the grid"};
    }

    // provide information about the application
    @Override
    public String about() {
        return "Cellular Automata: Life Group 4";
    }

    // return array of edit commands
    @Override
    public String[] getEditCommands() {
        return new String[] {"Run1", "Run50", "Populate", "Clear"};
    }

    // create and return appropriate edit commands
    @Override
    public Command makeEditCommand(Model model, String name, Object object) {
        if (name.equals("Populate")) {
            return new PopulateCommand(model);
        } else if (name.equals("Run1")) {
            return new RunCommand(model, 1);
        } else if (name.equals("Run50")) {
            return new RunCommand(model, 50);
        } else if (name.equals("Clear")) {
            return new ClearCommand(model);
        }
        return null;
    }
}
