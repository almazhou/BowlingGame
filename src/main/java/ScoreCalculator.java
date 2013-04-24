import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {
    List <Round>roundList= new ArrayList();

    public int getScore(int roundNum) {
        Round tempRound=roundList.get(roundNum-1);
        if(tempRound.isStrike()){
            return tempRound.getScore()+roundList.get(roundNum).getScore();
        }else if(tempRound.isSpare()){
            return tempRound.getScore()+roundList.get(roundNum).getFirstHit();
        }else {
            return tempRound.getScore();
        }
    }

    public void saveRound(Round round) {
        roundList.add(round);
    }

    public int getTotalScore(int roundNum) {
        int sum=0;
        for(int i=0;i<roundNum;i++){
            sum+=getScore(i+1);
        }
        return sum;

    }

    public void saveRound(Round[] rounds) {
        for(int i=0;i<rounds.length;i++){
            roundList.add(rounds[i]);
        }
    }
}
