public class Game {
    ScoreCal scoreCal;
    Round rounds[]=new Round[11];
    Game(){
        scoreCal=new ScoreCal();
        for (int i=0;i<11;i++){
            rounds[i]=new Round();
        }
        scoreCal.saveRound(rounds);
    }
    public static void main(String argv[]){
        Game game=new Game();
        game.start();
    }

    private void start() {
        for(int i=0;i<Round.FULLNUM;i++){
            playHits(i);
            playHits(i);
        }
        extraHit();
        showScore();
    }

    private void showScore() {
        for(int i=0;i<rounds.length;i++){
            System.out.println("("+rounds[i].getFirstHit()+","+rounds[i].getSecondHit()+")"+scoreCal.getTotalScore(i+1));
        }
    }

    private void playHits(int roundNum) {
        rounds[roundNum].roll();
    }

    private void extraHit() {
        if(rounds[Round.FULLNUM-2].isSpare())
        {
            playHits(Round.FULLNUM-1);
        }else if(rounds[Round.FULLNUM-2].isStrike()){
            playHits(Round.FULLNUM-1);
            playHits(Round.FULLNUM-1);
        }
    }

    private int roll() {
        return (int)Math.round(10*Math.random());
    }


}
