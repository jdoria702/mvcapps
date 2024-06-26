package prisonersDilemma;

import mvc.Utilities;
import simstation.*;

public class Prisoner extends Agent {
    private int fitness = 0;
    protected boolean partnerCheated = false;
    protected Strategy strategy;
    private Prisoner partner;

    public Prisoner(Strategy s) {
        super();
        strategy = s;
        s.setMyPrisoner(this);
        heading = new Heading();
        xc = (int) (Math.random() * 415);
        yc = (int) (Math.random() * 500);
    }

    public int getFitness() {
        return fitness;
    }
    @Override
    public void update() {
        partner = (Prisoner) simulation.getNeighbor(this, 10);
        heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;

        if (partner == null) {
            move(steps);
            return;
        }

        if (this.strategy.cooperate() && partner.strategy.cooperate()) {
            this.fitness += 3;
            partner.fitness += 3;
            this.partnerCheated = false;
            partner.partnerCheated = false;
        } else if (this.strategy.cooperate() && !partner.strategy.cooperate()) {
            partner.fitness += 5;
            this.partnerCheated = true;
            partner.partnerCheated = false;
        } else if (!this.strategy.cooperate() && partner.strategy.cooperate()) {
            this.fitness += 5;
            this.partnerCheated = false;
            partner.partnerCheated = true;
        } else if (!this.strategy.cooperate() && !partner.strategy.cooperate()) {
            this.fitness += 1;
            partner.fitness += 1;
            this.partnerCheated = true;
            partner.partnerCheated = true;
        }

        move(steps);
    }
}
