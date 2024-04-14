package simstation;

import java.io.Serializable;

public abstract class Agent implements Runnable {
    private Simulation simulation;
    private Thread myThread;
    private String name;
    protected Heading heading;
    protected int xc;
    protected int yc;
    private boolean suspended = false, stopped = false;

    public void setSimulation(Simulation s) {
        this.simulation = s;
    }

    public void start() {
        myThread = Thread.currentThread();
    }

    @Override
    public void run() {
        while (!isStopped()) {
            try {
                System.out.println("Agent is updating");
                update();
                Thread.sleep(20);
                checkSuspended();
            } catch(InterruptedException e) {
                // do nothing for now
            }
        }
    }

    public synchronized void stop() { stopped = true; }
    public synchronized boolean isStopped() { return stopped; }
    public synchronized void suspend() { suspended = true; }
    public synchronized boolean isSuspended() { return suspended;  }
    public synchronized void resume() { notify(); }

    private synchronized void checkSuspended() {
        try {
            while(!isStopped() && isSuspended()) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void move(int steps) {
        // will change the xc and yc of the agent
        // call simulation.changed()
        for (int i = 0; i < steps; i++) {
            if (heading == Heading.NORTH) {
                this.yc++;
                if (this.yc >= 500) {
                    this.yc = 0; // Wrap to the top
                }
                simulation.changed();
            } else if (heading == Heading.EAST) {
                this.xc++;
                if (this.xc >= 415) {
                    this.xc = 0; // Wrap to the left
                }
                simulation.changed();
            } else if (heading == Heading.SOUTH) {
                this.yc--;
                if (this.yc < 0) {
                    this.yc = 500 - 1; // Wrap to the bottom
                }
                simulation.changed();
            } else if (heading == Heading.WEST) {
                this.xc--;
                if (this.xc < 0) {
                    this.xc = 415 - 1; // Wrap to the right
                }
                simulation.changed();
            }
        }
    }

    public abstract void update();
}
