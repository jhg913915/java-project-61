package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Arrays;

public class GameCalculator {
    static String question;
    static String answer;
    static String playerName;

    public static void gamePlay() {
        int triesCounter = 0;
        // Greetings and getting playerName
        playerName = Engine.greetPlayer();

        Engine.formTask("What is the result of the expression?");

        // Forming a question
        int lowerBound = 0;
        int upperBound = 10;
        ArrayList<String> operatorsList = new ArrayList<String>(Arrays.asList("+", "*", "-"));
        while (triesCounter < 3) {
            question = Engine.returnRandomNumber(lowerBound, upperBound) + " "
                    + Engine.returnRandomFromList(operatorsList) + " "
                    + Engine.returnRandomNumber(lowerBound, upperBound);
            Engine.formQuestion(question);
            answer = Engine.askForAnswer().trim();

            if (Engine.checkAnswer(answer, findCorrectAnswer())) {
                System.out.println("Correct!");
                triesCounter++;
            } else {
                Engine.printFail(answer, findCorrectAnswer(), playerName);
                break;
            }
        }

        if (triesCounter >= 3) {
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
