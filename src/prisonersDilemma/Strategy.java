package prisonersDilemma;

public abstract class Strategy {
    protected Prisoner myPrisoner;

    public void setMyPrisoner(Prisoner p) {
        myPrisoner = p;
    }
    public abstract boolean cooperate();
}
