import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingTests {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    public void rollZeroScoreIsZero() {
        game.roll(0);
        assertEquals(0,game.getScore());
    }

    @Test
    public void openFramesAddsPins() {
        game.roll(2);
        game.roll(4);
        assertEquals(6, game.getScore());
    }

    @Test
    public void spareAddNextBall(){
        game.roll(6);
        game.roll(4);
        game.roll(3);
        game.roll(0);
        assertEquals(16, game.getScore());
    }

    @Test
    public void aTenInTwoFramesIsNotAFrame(){
        game.roll(3);
        game.roll(6);
        game.roll(4);
        game.roll(2);
        assertEquals(15,game.getScore());

    }

    @Test
    public void aStrikeAddsNextTwoBalls() {
        game.roll(10);
        game.roll(3);
        game.roll(2);
        assertEquals(20, game.getScore());
    }
    @Test
    public void perfectGameScoreIs300(){
        for(int i=0;i<12;i++)
        {
            game.roll(10);
        }
        assertEquals(300, game.getScore());
    }

    @Test

    public void testPlayMainFunction() {
        ArrayList<Integer> rolls = new ArrayList<>();
        rolls.add(10);
        rolls.add(3);
        rolls.add(2);

        assertEquals(20, game.play(rolls));
    }
}
