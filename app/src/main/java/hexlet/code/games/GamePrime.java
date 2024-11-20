package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameUtils;

public class GamePrime {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final String TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void gamePlay() {
        String[][] rules = prepareRules();
        Engine.playGame(TASK, rules);
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

    private static String findCorrectAnswer(int questionInt) {
        String result;
        if (isPrime(questionInt)) {
            result = "yes";
        } else {
            result = "no";
        }
        return result;
    }

    public static boolean isPrime(int questionInt) {
        for (int i = 2; i < questionInt; i++) {
            if ((questionInt % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
