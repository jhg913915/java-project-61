package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Arrays;

public class GameCalculator {

    public static void gamePlay() {
        String task = "What is the result of the expression?";
        String[][] rules = prepareRules();
        Engine.playGame(task, rules);
    }

    public static String[][] prepareRules() {
        final int lowerBound = 0;
        final int upperBound = 10;
        final ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "*", "-"));
        String[][] rules = new String[Engine.getMaxTries()][2];
        for (int i = 0; i < rules.length; i++) {
            String question = Engine.returnRandomNumber(lowerBound, upperBound) + " "
                    + Engine.returnRandomFromList(operators) + " "
                    + Engine.returnRandomNumber(lowerBound, upperBound);
            String answer = findCorrectAnswer(question);
            rules[i][0] = question;
            rules[i][1] = answer;
        }
        return rules;
    }

    private static String findCorrectAnswer(String question) {
        String[] parts = question.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int num2 = Integer.parseInt(parts[2]);
        int result = calculate(num1, num2, operator);
        return String.valueOf(result);
    }

    private static int calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> throw new IllegalArgumentException("Некорректный оператор");
        };
    }
}
