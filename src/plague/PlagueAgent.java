//package plague;
//
//import simstation.Agent;
//import simstation.Heading;
//
//public class PlagueAgent extends Agent {
//
//    public PlagueAgent(String name, PlagueSimulation world, boolean infected) {
//        this(name, world);
//        this.infected = infected;
//    }
//
//    public boolean isInfected() {
//        return infected;
//    }
//
//    private boolean infected;
//
//
//    public PlagueAgent(String name, PlagueSimulation world) {
//        super(name, world);
//        infected = false;
//    }
//
//    @Override
//    public void update() {
//        moveRandomly();
//
//        PlagueAgent neighbor = (PlagueAgent) world.getNeighbor(this);
//
//        if (this.infected)
//            infectOthers(neighbor);
//
//        world.changed();
//    }
//
//    private void moveRandomly() {
//        this.heading = Heading.values()[random.nextInt(4)];
//        this.speed = random.nextInt(10);
//
//        move(speed);
//        world.changed();
//    }
//
//    private void infectOthers(PlagueAgent target) {
//
//        int randomNumber = (int) (random.nextDouble() * 100);
//
//        if (randomNumber < PlagueSimulation.VIRULENCE) {
//
//            randomNumber = (int) (random.nextDouble() * 100);
//
//            if (randomNumber > PlagueSimulation.RESISTANCE && !target.isInfected()) {
//                target.infected = true;
//                PlagueSimulation world = (PlagueSimulation) this.world;
//            }
//        }
//    }
//}