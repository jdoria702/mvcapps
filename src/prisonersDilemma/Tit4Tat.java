package prisonersDilemma;

public class Tit4Tat extends Strategy {
    @Override
    public boolean cooperate() {
        if (myPrisoner.partnerCheated) {
            return false;
        }
        return true;
    }

    @Override
    public String getStrategy() {
        return "Tit4Tat";
    }
}
