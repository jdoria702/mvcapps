package plague;

import mvc.Model;
import simstation.SimStationFactory;

public class PlagueFactory extends SimStationFactory {
    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public String getTitle() {
        return "Plague";
    }
}