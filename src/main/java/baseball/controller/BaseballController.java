package baseball.controller;

import baseball.service.BaseballService;
import baseball.view.GameMessage;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    BaseballService service = new BaseballService();

    public void play() {
        service.settingGame();
        service.startGame();
        reGameJudgment();
    }

    public void reGameJudgment() {
        GameMessage.currentGameMessage();
        String userInput = Console.readLine();
        if(userInput.equals("1")) {
            play();
        }
    }
}
