package baseball.domain;

import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;

public class User {

    int[] userNumbers;

    public int[] getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(int[] userNumbers) {
        this.userNumbers = userNumbers;
    }

    public int [] userInput(int SIZE) {
        System.out.print("숫자를 입력해 주세요 : ");
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
}
