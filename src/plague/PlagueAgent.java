//package plague;
//
//import simstation.Agent;
//import simstation.Heading;
//import mvc.Utilities;
//
//import java.awt.*;
//
//public class PlagueAgent extends Agent {
//
//    private boolean infected;
//    private boolean resistant;
//    final Color HEALTHY_COLOR = Color.GREEN;
//    final Color INFECTED_COLOR = Color.RED;
//    final int RADIUS = 10;
//    final int MAX_SPEED = 3;
//
//    public PlagueAgent() {
//            this("");
//        }
//
//    public PlagueAgent(String name) {
//            super(name);
//            infected = false;
//            if (Utilities.rng.nextInt(100) < PlagueSimulation.RESISTANCE) {
//                resistant = true;
//            }
//        }
//        @Override
//        public synchronized void update() {
//            Agent neighbor = simulation.getNeighbor(this, RADIUS);
//            if (!resistant && neighbor != null) {
//                if (neighbor instanceof PlagueAgent host) {
//                    if (host.isInfected()) {
//                        if (Utilities.rng.nextInt(100) < PlagueSimulation.VIRULENCE) {
//                            infected = true;
//                        }
//                    }
//                }
//            }
//            heading.random();
//            int steps = Utilities.rng.nextInt(MAX_SPEED) + 1;
//            move(steps);
//        }
//
//        @Override
//        public Color getColor () {
//            if (infected) {
//                return INFECTED_COLOR;
//            }
//            return HEALTHY_COLOR;
//        }
//
//        public boolean isInfected () {
//            return infected;
//        }
//
//        public void setInfected (boolean infected){
//            this.infected = infected;
//        }
//
//    }