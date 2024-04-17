package prisonersDilemma;

import java.util.Random;

public class RandomlyCooperate extends Strategy{
    @Override
    public boolean cooperate() {
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public String getStrategy() {
        return "RandomlyCooperate";
    }
}
