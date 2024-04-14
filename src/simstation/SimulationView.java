package simstation;

import mvc.*;
import java.awt.*;

public class SimulationView extends View {
    public SimulationView(Model model) {
        super(model);
        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        setBackground(Color.LIGHT_GRAY);
        Simulation simulation = (Simulation) model;
        gc.setColor(Color.WHITE);
        for (Agent a : simulation.getAgents()) {
            gc.fillOval(a.xc, a.yc, 10, 10);
        }
    }
}
