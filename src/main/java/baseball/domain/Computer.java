package baseball.domain;

public class Computer {

    int strikeCnt;
    int ballCnt;
    Integer [] randomNumbers;

    public void resetGame() {
        strikeCnt = 0;
        ballCnt = 0;
    }

    public int getStrikeCount() {
        return strikeCnt;
    }

    public int getBallCount() {
        return ballCnt;
    }

    public Integer[] getRandomNumbers() {
        return randomNumbers;
    }

    public Integer[] getBotNumber() {
        return randomNumbers;
    }

    public void setRandomNumbers(Integer[] randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public void strikeCountInc() {
        strikeCnt += 1;
    }

    public void ballCountInc() {
        ballCnt += 1;
    }

}
