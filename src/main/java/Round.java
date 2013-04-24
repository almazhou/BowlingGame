public class Round {
    public static final int FULLNUM = 10;
    private int firstHit=0;
    private int secondHit=0;

    public void receiveScore(int firstHit, int secondHit) {
        this.firstHit=firstHit;
        this.secondHit=secondHit;
    }

    public int getScore() {
        return firstHit+secondHit;
    }

    public boolean isSpare() {
        return firstHit!=FULLNUM&&getScore()== FULLNUM;
    }

    public boolean isUnderFull() {
        return firstHit<=FULLNUM&&secondHit<=FULLNUM&&getScore()<=FULLNUM;
    }

    public boolean isStrike() {
        return firstHit==FULLNUM;
    }

    public int getFirstHit() {
        return firstHit;
    }

    public int getSecondHit() {
        return secondHit;
    }
}
