package prisonersDilemma;

public class Tit4Tat extends Strategy {
    @Override
    public boolean cooperate() {
        if (myPrisoner.partnerCheated) {
            return false;
        }
        return true;
    }
}
