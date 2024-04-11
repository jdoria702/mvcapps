package CALab;

import mvc.*;
import java.awt.*;

public class GridView extends View {

    private CellView cellViews[][];

    public GridView(Model model) {
        super(model); // Call the constructor of the superclass View with the provided Model object
        Grid grid = (Grid) model;
        int size = grid.getDim();
        cellViews = new CellView[size][size];
        this.setLayout((new GridLayout(size,size)));

        // creating a spot in the grid for every cell
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell myCell = grid.getCell(i,j);
                myCell.row = i;
                myCell.col = j;
                cellViews[i][j] = new CellView(myCell);
                this.add(cellViews[i][j]);
            }
        }
    }



    public void update() {
        // Call update method of each CellView
        for (int i = 0; i < cellViews.length; i++) {
            for (int j = 0; j < cellViews[i].length; j++) {
                cellViews[i][j].update();
            }
        }
    }

    @Override
    public void setModel(Model newModel) {
        this.model.unsubscribe(this);
        this.model = newModel;
        this.model.subscribe(this);

        int size = ((Grid) model).getDim();
        cellViews = new CellView[size][size];
        this.setLayout((new GridLayout(size, size)));
        this.removeAll();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = ((Grid) model).getCell(i, j);
                cell.row = i;
                cell.col = j;
                cellViews[i][j] = new CellView(cell);
                this.add(cellViews[i][j]);
            }
        }
    }
}