package prisonersDilemma;

public class Cheat extends Strategy {
    @Override
    public boolean cooperate() {
        return false;
    }
}
