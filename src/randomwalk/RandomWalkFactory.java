package randomwalk;

import mvc.*;

class RandomWalkFactory extends SimulationFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}
