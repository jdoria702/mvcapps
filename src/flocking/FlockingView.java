package flocking;

import mvc.Model;
import simstation.*;

import java.awt.*;

public class FlockingView extends SimulationView {
    public FlockingView(Model model) {
        super(model);
        setBackground(Color.GRAY);
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        setBackground(Color.GRAY);
        FlockingSimulation flockingSimulation = (FlockingSimulation) model;
        for (Agent a : flockingSimulation.getAgents()) {
            Bird b = (Bird) a;
            gc.fillOval(b.getXc(), b.getYc(), 10, 10);
        }
    }
}
