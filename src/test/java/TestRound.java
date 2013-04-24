import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestRound {
    private Round  round,round1;
    @Before
    public void setup(){
        round=new Round();
        round1=new Round();
    }
    @Test
    public void score_of_every_hit_should_be_no_bigger_than_10(){
        round.receiveScore(11,0);
        assertFalse(round.isUnderFull());
    }
    @Test
    public void totalScore_should_be_no_bigger_than_10(){
        round.receiveScore(6,7);
        assertFalse(round.isUnderFull());
    }
    @Test
    public void totalScore_should_be_sum_of_two_hits_for_one_round(){
        round.receiveScore(5,4);
        assertThat(round.getScore(),is(9));
    }
    @Test
    public void the_round_should_be_spare_when_total_score_is_full(){
        round.receiveScore(5, 5);
        assertTrue(round.isSpare());
    }
    @Test
    public void the_round_should_be_strike_when_first_hit_is_full(){
        round.receiveScore(10, 0);
        assertTrue(round.isStrike());
    }

}
