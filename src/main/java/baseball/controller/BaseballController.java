package baseball.controller;

import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    BaseballService service = new BaseballService();

    public void play() {
        service.settingGame();
        service.startGame();
        reGameJudgment();
    }

    public void reGameJudgment() {
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if(userInput.equals("1")) {
            play();
        }
    }
}
