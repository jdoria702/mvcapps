package CALab;

import java.awt.*;
import java.util.*;
import java.io.*;
import mvc.*;

public abstract class Grid extends Model {
    static private int time = 0;
    protected int dim = 20;
    protected Cell[][] cells;

    public int getDim() { return dim; }
    public int getTime() { return time; }
    public Cell getCell(int row, int col) { return cells[row][col]; }
    public abstract Cell makeCell(boolean uniform);


    public Grid(int dim) {
        this.dim = dim;
        cells = new Cell[dim][dim];
        populate();
    }
    public Grid() { this(20); }

    protected void populate() {
        // 1. use makeCell to fill in cells
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j] = makeCell(true);
            }
        }

        // 2. Use getNeighbors to set the neighbors field of each cell
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].neighbors = getNeighbors(cells[i][j],1);
            }
        }
    }

    // called when Populate button is clicked
    public void repopulate() {
        // randomly set the status of each cell
        Random random = new Random();
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].reset(true);
            }
        }
        updateLoop(1);
    }

    public void clear() {
        // set the status of each cell to 0 (dead)
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].reset(false);
            }
        }
        updateLoop(1);
    }


    public Set<Cell> getNeighbors(Cell asker, int radius) {
        /*
        return the set of all cells that can be reached from the asker in radius steps.
        If radius = 1 this is just the 8 cells touching the asker.
        Tricky part: cells in row/col 0 or dim - 1.
        The asker is not a neighbor of itself.
        */
        Set<Cell> neighbors = new HashSet<>();
        int row = asker.getRow();
        int col = asker.getCol();

        // Iterate over rows within the specified radius
        for (int i = row - radius; i <= row + radius; i++) {
            // Adjust row index for wrapping around
            int adjustedRow = (i + dim) % dim;

            // Iterate over columns within the specified radius
            for (int j = col - radius; j <= col + radius; j++) {
                // Adjust column index for wrapping around
                int adjustedCol = (j + dim) % dim;

                // Skip the current cell (asker)
                if (adjustedRow == row && adjustedCol == col) {
                    continue;
                }
                // Add the cell to neighbors set
                neighbors.add(cells[adjustedRow][adjustedCol]);
            }
        }
        return neighbors;
    }

    // override these
    public int getStatus() { return 0; }
    public Color getColor() { return Color.GREEN; }

    // cell phases:

    public void observe() {
        // call each cell's observe method and notify subscribers
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].neighbors = getNeighbors(cells[i][j],1);
                cells[i][j].observe();
            }
        }
    }

    public void interact() {
        // Call each cell's interact method
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].interact();
            }
        }
    }

    public void update() {
        // Call each cell's update method
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                cells[i][j].update();
            }
        }
        changed();
    }

    public void updateLoop(int cycles) {
        observe();
        for(int cycle = 0; cycle < cycles; cycle++) {
            interact();
            update();
            observe();
            time++;
        }
    }
}