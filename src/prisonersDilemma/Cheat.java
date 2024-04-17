package prisonersDilemma;

public class Cheat extends Strategy {
    @Override
    public boolean cooperate() {
        return false;
    }

    @Override
    public String getStrategy() {
        return "Cheat";
    }
}
