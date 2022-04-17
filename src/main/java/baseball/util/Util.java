package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.HashSet;

public class Util {

    public static String ConsoleOutput(Integer[] randomBot) {
        return Arrays.toString(randomBot);
    }


    public static Boolean validateInput(String input, int i) {
        return '0' <= input.charAt(i) && input.charAt(i) <= '9';
    }

    public static int convertStringToInt(String input, int i) {
        return input.charAt(i) - '0';
    }
}
