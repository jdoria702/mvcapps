package simstation;

import mvc.*;
import javax.swing.*;

public class SimulationPanel extends AppPanel {
    public SimulationPanel(AppFactory factory) {
        super(factory);

        JButton startButton = new JButton("start");
        JButton suspendButton = new JButton("suspend");
        JButton resumeButton = new JButton("resume");
        JButton stopButton = new JButton("stop");
        JButton statsButton = new JButton("stats");

        startButton.addActionListener(this);
        suspendButton.addActionListener(this);
        resumeButton.addActionListener(this);
        stopButton.addActionListener(this);
        statsButton.addActionListener(this);

        controls.add(startButton);
        controls.add(suspendButton);
        controls.add(resumeButton);
        controls.add(stopButton);
        controls.add(statsButton);
    }
}
