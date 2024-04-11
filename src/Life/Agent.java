package Life;

import CALab.Cell;

import java.awt.*;
import java.util.Random;

public class Agent extends Cell {

    private int status = 0;
    private int ambience = 0;


    public Agent(int status) {
        this.status = status;
    }

    @Override
    public void observe() {
        // Initialize a counter to keep track of the number of living neighbors
        ambience = 0;

        // Iterate over the neighbors of the cell
        for (Cell neighbor : neighbors) {
            if (neighbor instanceof Agent) {
                // Check if the neighbor is alive
                if (((Agent) neighbor).status == 1) {
                    // Increment the counter if the neighbor is alive
                    ambience++;
                }
            }
        }
    }

    @Override
    public void interact() {
        // No interaction phase
    }

    @Override
    public void update() {
        if (status == 1) {
            if (Society.death.contains(ambience)) {
                status = 0;
            }
        } else {
            if (Society.rebirth.contains(ambience)) {
                status = 1;
            }
        }

    }

    @Override
    public void nextState() {
//        status = (status + 1) % 2;
        if (status == 0 && Society.death.contains(status)) {
            status = 1;
        }
        else if (status == 1 && Society.death.contains(ambience)) {
            status = 0;
        }
    }

    @Override
    public void reset(boolean randomly) {
        if (randomly) {
            status = new Random().nextInt(2); // Generates either 0 or 1 randomly
        } else {
            status = 0; // Sets the status to dead (0)
            ambience = 0;
        }
    }

    @Override
    public int getStatus() {
        return status; // Simply return the status value
    }

    @Override
    public int getAmbience() {
        return ambience;
    }

    @Override
    public Color getColor() {
        if (getStatus() == 0) {
            return Color.RED;
        }
        else {
            return Color.GREEN;
        }
    }
}