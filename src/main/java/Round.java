public class Round {
    public static final int FULLNUM = 10;
    private int count=0;
    private int firstHit=0;
    private int secondHit=0;

    public void hit(int pinNum) {
        if(this.count==0){
            firstHit=pinNum;
            count++;
        }else {
            secondHit=pinNum;
        }
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

    public void roll() {
         int hitNum=(int)Math.round((FULLNUM-firstHit)*Math.random());
         hit(hitNum);
    }
}
