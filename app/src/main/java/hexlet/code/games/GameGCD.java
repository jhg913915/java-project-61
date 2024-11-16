package hexlet.code.games;

import hexlet.code.Engine;

import java.math.BigInteger;

public class GameGCD {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 10;

    public static void gamePlay() {
        String task = "Find the greatest common divisor of given numbers.";
        String[][] rules = prepareRules();
        Engine.playGame(task, rules);
    }

    private static String[][] prepareRules() {
        String[][] rules = new String[Engine.getMaxTries()][2];
        for (int i = 0; i < rules.length; i++) {
            int multiplier = Engine.returnRandomNumber(LOWER_BOUND, UPPER_BOUND);
            int firstNum = Engine.returnRandomNumber(LOWER_BOUND, UPPER_BOUND) * multiplier;
            int secondNum = Engine.returnRandomNumber(LOWER_BOUND, UPPER_BOUND) * multiplier;
            if (secondNum == firstNum) {
                secondNum += multiplier;
            }
            String question = firstNum + " " + secondNum;
            String answer = findCorrectAnswer(question);
            rules[i][0] = question;
            rules[i][1] = answer;
        }
        return rules;
    }

    private static String findCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        return String.valueOf(getGCD(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
    }

    private static int getGCD(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcdTemp = b1.gcd(b2);
        return gcdTemp.intValue();
    }
}
