package baseball.util;

public class Parse {

    public static int[] userInputParser(String input, int size) throws IllegalArgumentException {
        validLength(input);
        return parseInt(input, size);
    }

    public static void validLength(String input) throws IllegalArgumentException{
        if(input.length() != 3)
            throw new IllegalArgumentException();
    }

    public static int [] parseInt(String input, int size) {
        int[] parseInt = new int[size];
        for (int i = 0; i < input.length(); i++) {
            if (!(validateInput(input, i))) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = convertStringToInt(input, i);
        }
        return parseInt;
    }

    public static Boolean validateInput(String input, int i) {
        return '0' <= input.charAt(i) && input.charAt(i) <= '9';
    }

    public static int convertStringToInt(String input, int i) {
        return input.charAt(i) - '0';
    }
}
