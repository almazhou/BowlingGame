import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private ScoreCalculator scoreCalculator;
    private Round rounds[]=new Round[11];
    Game(){
        scoreCalculator =new ScoreCalculator();
        for (int i=0;i<11;i++){
            rounds[i]=new Round();
        }
        scoreCalculator.saveRound(rounds);
    }
    public static void main(String argv[]){
        Game game=new Game();

        game.start();
    }

    private void start() {
        int k=0;
        List<Integer> scoreList=new ArrayList<Integer>();
        scoreList= Arrays.asList(7, 2, 6, 2, 9, 1, 10, 0, 1, 4, 5, 5, 4, 5, 6, 3, 6, 4, 10, 0, 5, 0);
        for(int i=0;i<scoreList.size();i+=2){
            rounds[k++].receiveScore(scoreList.get(i),scoreList.get(i+1));
        }
        showScore();
    }

    private void showScore() {
        for(int i=0;i<rounds.length;i++){
            System.out.println("(" + rounds[i].getFirstHit() + "," + rounds[i].getSecondHit() + ")" + scoreCalculator.getTotalScore(i + 1));
        }
    }
}
