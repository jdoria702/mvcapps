package prisonersDilemma;

public class Cooperate extends Strategy{
    @Override
    public boolean cooperate() {
        return true;
    }

    @Override
    public String getStrategy() {
        return "Cooperate";
    }
}
