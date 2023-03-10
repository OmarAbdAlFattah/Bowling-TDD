import java.util.ArrayList;

public class Game {
    int[] rolled = new int[22];
    int currentBall = 0;
    public void roll(int pinsDropped) {
        rolled[currentBall] = pinsDropped;
        currentBall++;
    }

    public int getScore() {
        int score = 0;
        int thisBall = 0;
        for (int i = 0; i < 10; i++) {
            if (isStrike(rolled[thisBall])){
                score += rolled[thisBall] + rolled[thisBall + 1] + rolled[thisBall + 2];
                thisBall++;
            }
            else if (isSpare(rolled[thisBall] + rolled[thisBall + 1])) {
                score += 10 + rolled[thisBall + 2];
                thisBall += 2;
            }
            else {
                score += rolled[thisBall] + rolled[thisBall + 1];
                thisBall += 2;
            }
        }
        return score;
    }

    public int play(ArrayList<Integer> rolls) {
        for (int i = 0; i < rolls.size(); i++) {
            roll(rolls.get(i));
        }
        return getScore();
    }
    private boolean isSpare(int rolled) {
        return rolled == 10;
    }

    private boolean isStrike(int rolled) {
        return rolled == 10;
    }
}
