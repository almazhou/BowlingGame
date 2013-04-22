import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestScore {
    Round  round,round1;
    ScoreCal scoreCal;
    @Before
    public void setup(){
        round=new Round();
        round1=new Round();
        scoreCal=new ScoreCal();
        scoreCal.saveRound(round);
        scoreCal.saveRound(round1);

    }
    @Test
    public void total_score_should_be_sum_of_two_hits(){
        round.hit(5);
        round.hit(4);
        assertThat(scoreCal.getScore(1),is(9));
    }
    @Test
    public void total_score_should_be_sum_of_two_hits_plus_first_hit_of_next_round_for_spare_round(){
        round.hit(5);
        round.hit(5);
        round1.hit(5);
        assertThat(scoreCal.getScore(1),is(15));
    }
    @Test
    public void total_score_should_be_sum_of_two_hits_plus_total_score_of_next_round_for_strike_round(){
        round.hit(10);
        round1.hit(5);
        round1.hit(4);
        assertThat(scoreCal.getScore(1),is(19));
    }
    @Test
    public void should_get_total_score_of_every_round(){
        round.hit(10);
        round1.hit(5);
        round1.hit(4);
        assertThat(scoreCal.getTotalScore(2),is(28));
    }
}
