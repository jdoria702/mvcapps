package flocking;

import mvc.*;
import simstation.*;

public class FlockingFactory extends SimStationFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public View makeView(Model m) {
        return new FlockingView((FlockingSimulation) m);
    }
    public String getTitle() { return "Flocking";}
}
