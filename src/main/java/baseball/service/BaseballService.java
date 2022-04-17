package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.Util;
import baseball.view.GameMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class BaseballService {
    Computer computer = new Computer();
    User user = new User();

    public void startGame() throws IllegalArgumentException {
        while(computer.getStrikeCount() != 3) {
            notStrike();
            billboardResults(user.getUserNumbers(), computer.getBotNumber());
            GameMessage.gameCountReturn(computer.getStrikeCount(), computer.getBallCount());
        }
        GameMessage.gameOverMessage();
    }

    public void settingGame() {
        computer.setRandomNumbers(randomItem());
    }

    public void notStrike() {
        computer.resetGame();
        user.setUserNumbers(userInput(3));
    }

    public int [] userInput(int SIZE) throws IllegalArgumentException {
        GameMessage.gameStartMessage();
        String userInput = Console.readLine();
        return userInputParser(userInput, SIZE);
    }

    static int[] userInputParser(String input, int size) throws IllegalArgumentException {
        int[] parseInt = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (!(Util.validateInput(input, i))) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = Util.convertStringToInt(input, i);
        }
        return parseInt;
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
