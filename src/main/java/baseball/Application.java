package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        play();
        reGameJudgment();
    }

    static void play() {
        final int SIZE = 3;

        int[] randomBot = RandomItemSetting(SIZE, 1,9);

        System.out.println("RandomOutput = " + ConsoleOutput(randomBot));
        startGame(SIZE, randomBot);
    }

    private static String ConsoleOutput(int [] inputArray) {
        return Arrays.toString(inputArray);
    }

    public static int[] RandomItemSetting(int size, int start, int end) {
        int[] numbers = new int[3];

        for (int i = 0; i < size; i++) {
            numbers[i] = getUniqueRandomNumber(numbers, start, end, i);
        }
        return numbers;
    }

    private static int getUniqueRandomNumber(int[] numbers, int start, int end, int i) {
        int randomNumber = Randoms.pickNumberInRange(start, end);
        while (!isUnique(numbers, i, randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(start, end);
        }
        return randomNumber;
    }

    private static Boolean isUnique(int[] numbers, int i, int randomNumber) {
        for (int j = 0; j < i; j++) {
            if (numbers[j] == randomNumber) {
                return false;
            }
        }

        return true;
    }

    static void startGame(int SIZE, int [] randomBot) throws IllegalArgumentException {
        int strike =0, ball = 0;

        while(strike != 3) {
            strike = 0;
            ball = 0;
            System.out.print("숫자를 입력해 주세요 : ");
            String userInput = Console.readLine();

            final int[] userInputItems = userInputParser(userInput, SIZE);
            for (int i = 0; i < SIZE; i++) {
                if(userInputItems[i] == randomBot[i]) {
                    strike += 1;
                }
                if(userInputItems[i] != randomBot[i]) {
                    int botNumber = randomBot[i];
                    ball += ballCounter(botNumber, userInputItems);
                }
            }
            System.out.println(gameCounter(strike, ball));
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static void reGameJudgment() {
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if(userInput.equals("1")) {
            play();
        }
    }

    static String gameCounter(int strike, int ball) {
        String resultMessage = "";
        if(ball == 0 && strike == 0) {
            resultMessage = "낫싱";
        }

        if(ball != 0 && strike == 0) {
            resultMessage = ball + "볼";
        }

        if (ball == 0 && strike != 0) {
            resultMessage = strike + "스트라이크";
        }

        if (ball != 0 && strike != 0) {
            resultMessage = + ball + "볼 " + strike + "스트라이크" ;
        }

        return resultMessage;
    }

    static int ballCounter(int botNumber, int [] userInputItems) {
        int sameCount = 0;
        for (int i = 0; i < userInputItems.length; i++) {
            if (botNumber == userInputItems[i]) {
                sameCount += 1;
            }
        }
        return sameCount;
    }

    static int[] userInputParser(String input, int size) throws IllegalArgumentException {
        int[] parseInt = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (!validateInput(input, i)) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = convertStringToInt(input, i);
        }
        return parseInt;
    }

    private static Boolean validateInput(String input, int i) {
        return '0' <= input.charAt(i) && input.charAt(i) <= '9';
    }

    private static int convertStringToInt(String input, int i) {
        return input.charAt(i) - '0';
    }

}