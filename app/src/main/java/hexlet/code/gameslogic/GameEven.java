package hexlet.code.gameslogic;

import hexlet.code.Cli;

import java.util.Random;
import java.util.Scanner;

public class GameEven {
    public static int questionInt;
    public static String answer;
    public static String playerName;

    public static void gamePlay() {
        int triesCounter = 0;

        Scanner scanner = new Scanner(System.in);
        // Greetings and getting playerName
        playerName = Cli.getPlayerName();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        // Forming a question
        Random rand = new Random();
        int upperBound = 100;
        while (triesCounter < 3) {
            questionInt = rand.nextInt(upperBound);
            System.out.println("Question: " + questionInt);
            System.out.println("Your answer: ");
            answer = scanner.nextLine();
            if (!checkAnswer(answer)) {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + findCorrectAnswer() + "'\n" +
                "Let's try again, " + playerName + "!");
                break;
            } else {
                System.out.println("Correct!");
                triesCounter++;
            }
        }

        if (triesCounter >= 3) {
            System.out.println("Congratulations, " + playerName + "!");
        }
    }

    public static boolean checkAnswer(String answer) {
        boolean isCorrect = false;
        String correctAnswer;

        correctAnswer = findCorrectAnswer();

        if (answer.equals(correctAnswer)) {
            isCorrect = true;
        }

        return isCorrect;
    }

    public static String findCorrectAnswer() {
        String result;

        if (questionInt % 2 == 0) {
            result = "yes";
        } else {
            result = "no";
        }
        return result;
    }
}
