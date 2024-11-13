package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Arrays;

public class GameCalculator {
    private static String question;

    public static void gamePlay() {
        int maxTries = Engine.getMaxTries();
        int triesCounter = 0;
        // Greetings and getting playerName
        String playerName = Engine.greetPlayer();

        Engine.formTask("What is the result of the expression?");

        // Forming a question
        final int lowerBound = 0;
        final int upperBound = 10;
        ArrayList<String> operatorsList = new ArrayList<String>(Arrays.asList("+", "*", "-"));
        while (triesCounter < maxTries) {
            question = Engine.returnRandomNumber(lowerBound, upperBound) + " "
                    + Engine.returnRandomFromList(operatorsList) + " "
                    + Engine.returnRandomNumber(lowerBound, upperBound);
            Engine.formQuestion(question);
            String answer = Engine.askForAnswer().trim();

            if (Engine.checkAnswer(answer, findCorrectAnswer())) {
                System.out.println("Correct!");
                triesCounter++;
            } else {
                Engine.printFail(answer, findCorrectAnswer(), playerName);
                break;
            }
        }

        if (triesCounter >= maxTries) {
            Engine.printSuccess(playerName);
        }
    }

    public static String findCorrectAnswer() {
        question = question.replaceAll("\\s", "");
        String[] parts = question.split("(?<=[-+*])|(?=[-+*])");

        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);
        String operator = parts[1];

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
