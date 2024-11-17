package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameUtils;

public class GameEven {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    public static void gamePlay() {
        String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] rules = prepareRules();
        Engine.playGame(task, rules);
    }

    private static String[][] prepareRules() {
        String[][] rules = new String[Engine.getMaxTries()][2];
        for (int i = 0; i < rules.length; i++) {
            int questionInt = GameUtils.returnRandomNumber(LOWER_BOUND, UPPER_BOUND);
            String answer = findCorrectAnswer(questionInt);
            rules[i][0] = Integer.toString(questionInt);
            rules[i][1] = answer;
        }
        return rules;
    }

    public static String findCorrectAnswer(int questionInt) {
        String result;
        if (questionInt % 2 == 0) {
            result = "yes";
        } else {
            result = "no";
        }
        return result;
    }
}
