package CALab;

import mvc.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
        update();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState(); // Call nextState() method of the Cell when the button is clicked
        update();
    }

    // called by notifySubscribers and GridView.update
    @Override
    public void update() {
        setOpaque(true);
        setBackground(myCell.getColor());
        setBorder(BorderFactory.createLineBorder(Color.black)); // needed?
        setText("" + myCell.getAmbience());
    }
}