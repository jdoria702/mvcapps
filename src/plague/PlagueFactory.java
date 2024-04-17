package plague;

import mvc.Model;
import mvc.View;
import simstation.SimStationFactory;
import simstation.Simulation;
import simstation.SimulationView;

public class PlagueFactory extends SimStationFactory {
    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public String getTitle() {
        return "Plague";
    }

    @Override
    public View makeView(Model m) {
        return new PlagueView((Simulation) m);
    }
}