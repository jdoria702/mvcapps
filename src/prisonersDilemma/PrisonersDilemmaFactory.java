package prisonersDilemma;

import mvc.*;
import simstation.SimStationFactory;

public class PrisonersDilemmaFactory extends SimStationFactory {
    public Model makeModel() { return new PrisonersDilemmaSimulation(); }
    public View makeView(Model m) {
        return new PrisonersDilemmaView((PrisonersDilemmaSimulation) m);
    }
    public String getTitle() { return "Prisoner's Dilemma";}
}
