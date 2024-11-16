package hexlet.code;

import hexlet.code.games.GameCalculator;
import hexlet.code.games.GameEven;
import hexlet.code.games.GameGCD;
import hexlet.code.games.GamePrime;
import hexlet.code.games.GameProgression;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final int MAX_TRIES = 3;

    public static void playGame(String task, String[][] rules) {
        String playerName = greetPlayer();
        formTask(task);
        for (String[] rule : rules) {
            formQuestion(rule[0]);
            String playerAnswer = askForAnswer().trim();
            if (checkAnswer(playerAnswer, rule[1])) {
                System.out.println("Correct!");
            } else {
                printFail(playerAnswer, rule[1], playerName);
                return;
            }
        }
        printSuccess(playerName);
    }

    public static void printFail(String wrongAnswer, String answer, String playerName) {
        System.out.println("'" + wrongAnswer + "' is wrong answer ;(. Correct answer was '"
                + answer + "'\n" + "Let's try again, " + playerName + "!");
    }

    public static void printSuccess(String playerName) {
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static String greetPlayer() {
        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("May I have your name? ");
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void formQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static void formTask(String task) {
        System.out.println(task);
    }

    public static String askForAnswer() {
        String answer;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your answer: ");
        answer = scanner.nextLine();
        return answer;
    }

    public static boolean checkAnswer(String answerToCheck, String answer) {
        return answerToCheck.equalsIgnoreCase(answer);
    }

    public static String returnRandomFromList(ArrayList<String> list) {
        Random rand = new Random();
        if (!list.isEmpty()) {
            return list.get(rand.nextInt(list.size()));
        } else {
            return null;
        }
    }

    public static int returnRandomNumber(int lowerBound, int upperBound) {
        return (int) ((Math.random() * (upperBound - lowerBound)) + lowerBound);
    }

    public static int getMaxTries() {
        return MAX_TRIES;
    }

    public static String askGameType() {
        Scanner scanner = new Scanner(System.in);
        String gameType;
        System.out.println("""
                Welcome to the Brain Games!
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice: \s""");
        gameType = scanner.nextLine();
        return gameType;
    }

    public static void startChosenGame(String gameType) {
        switch (gameType) {
            case "4":
                GameGCD.gamePlay();
                break;
            case "3":
                GameCalculator.gamePlay();
                break;
            case "2":
                GameEven.gamePlay();
                break;
            case "1":
                Engine.greetPlayer();
                break;
            case "5":
                GameProgression.gamePlay();
                break;
            case "6":
                GamePrime.gamePlay();
                break;
            case "0":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("""
                        There is no such option!
                        Select again!\s""");
        }
    }
}
