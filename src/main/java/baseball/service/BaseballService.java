package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.view.GameResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class BaseballService {
    Computer computer = new Computer();
    User user = new User();

    public void startGame() throws IllegalArgumentException {
        while(computer.getStrikeCount() != 3) {
            notStrike();
            billboardResults(user.getUserNumbers(), computer.getBotNumber());
            GameResult.gameCountReturn(computer.getStrikeCount(), computer.getBallCount());
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void settingGame() {
        computer.setRandomNumbers(randomItem());
    }

    public void notStrike() {
        computer.resetGame();
        user.setUserNumbers(user.userInput(3));
        System.out.println("test = " + user.getUserNumbers().toString());
    }

    public static Integer[] randomItem() {
        HashSet<Integer> randomNumbers = new HashSet<>();

        while(randomNumbers.size() < 3){
            randomNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return randomNumbers.toArray(new Integer[0]);
    }

    public void billboardResults(int[] userInputItems, Integer[] randomBot) {
        for (int i = 0; i < 3; i++) {
            if(userInputItems[i] == randomBot[i]) {
                strikeCounter();
                break;
            }
            ballCounter(userInputItems, randomBot[i]);
        }
    }

    void strikeCounter() {
        computer.strikeCountInc();
    }

    void ballCounter(int[] userInputItems, int botNumber) {
        for (int i = 0; i < userInputItems.length; i++) {
            if (botNumber == userInputItems[i]) {
                computer.ballCountInc();
            }
        }
    }



}
