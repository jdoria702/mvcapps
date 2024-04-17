package plague;

import mvc.Model;
import prisonersDilemma.Prisoner;
import prisonersDilemma.PrisonersDilemmaSimulation;
import simstation.*;
import mvc.AppPanel;

import java.awt.*;

public class PlagueView extends SimulationView {
    public PlagueView(Model model) {
        super(model);
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        setBackground(Color.WHITE);
        PlagueSimulation plagueSimulation = (PlagueSimulation) model;
        Color oldColor = gc.getColor();
        for (Agent a : plagueSimulation.getAgents()) {
            PlagueAgent host = (PlagueAgent) a;
            if (host.isInfected())
                gc.setColor(Color.RED);
            else
                gc.setColor(Color.GREEN);

            int r = 10;
            gc.fillOval(host.getXc(), host.getYc(), r, r);
        }
        gc.setColor(oldColor);

        }
    }



    //TODO override paint method to do the right colors


