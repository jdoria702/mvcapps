package simstation;

public abstract class Agent implements Runnable {
    protected Simulation simulation;
    private Thread myThread;
    private String name;
    protected Heading heading;
    protected int xc;
    protected int yc;
    private boolean suspended = false, stopped = false;

    public Agent(String name) {
        this.name = name;
    }

    public Agent() {

    }

    public void setSimulation(Simulation s) {
        this.simulation = s;
    }

    public void start() {
        myThread = new Thread(this);
        myThread.start();
    }

    @Override
    public void run() {
        while (!isStopped()) {
            try {
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
        double angleInRadians = Math.toRadians(heading.getDirection());
        for (int i = 0; i < steps; i++) {
            double deltaX = Math.cos(angleInRadians) * 1.5;
            double deltaY = Math.sin(angleInRadians) * 1.5;

            // Update agent's position
            this.xc += (int) deltaX;
            this.yc += (int) deltaY;

            // Wrap around the panel
            if (this.xc >= 415) {
                this.xc = 0; // Wrap to the left
            } else if (this.xc < 0) {
                this.xc = 415 - 1; // Wrap to the right
            }
            if (this.yc >= 430) {
                this.yc = 0; // Wrap to the top
            } else if (this.yc < 0) {
                this.yc = 430 - 1; // Wrap to the bottom
            }

            simulation.changed();
        }
    }


    public int getXc() {
        return xc;
    }

    public int getYc() {
        return yc;
    }

    public abstract void update();
}
