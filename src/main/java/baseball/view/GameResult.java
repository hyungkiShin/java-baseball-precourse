package baseball.view;

public class GameResult {
    public static void gameCountReturn(int strike, int ball) {
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }

        if(ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }

        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }

        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
