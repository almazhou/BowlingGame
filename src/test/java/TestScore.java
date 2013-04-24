import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestScore {
    private Round  round,round1;
    private ScoreCalculator scoreCalculator;
    @Before
    public void setup(){
        round=new Round();
        round1=new Round();
        scoreCalculator =new ScoreCalculator();
        scoreCalculator.saveRound(round);
        scoreCalculator.saveRound(round1);

    }
    @Test
    public void total_score_should_be_sum_of_two_hits(){
        round.receiveScore(5,4);
        assertThat(scoreCalculator.getScore(1),is(9));
    }
    @Test
    public void total_score_should_be_sum_of_two_hits_plus_first_hit_of_next_round_for_spare_round(){
        round.receiveScore(5, 5);
        round1.receiveScore(5, 3);
        assertThat(scoreCalculator.getScore(1),is(15));
    }
    @Test
    public void total_score_should_be_sum_of_two_hits_plus_total_score_of_next_round_for_strike_round(){
        round.receiveScore(10,0);
        round1.receiveScore(4, 5);
        assertThat(scoreCalculator.getScore(1),is(19));
    }
    @Test
    public void should_get_total_score_of_every_round(){
        round.receiveScore(10,0);
        round1.receiveScore(4, 5);
        assertThat(scoreCalculator.getTotalScore(2),is(28));
    }
}
