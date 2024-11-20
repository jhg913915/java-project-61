package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int MAX_TRIES = 3;

    public static void playGame(String task, String[][] rules) {
        String playerName = greetPlayer();
        formTask(task);
        for (String[] rule : rules) {
            formQuestion(rule[0]);
            String playerAnswer = askForAnswer().trim();
            if (GameUtils.checkAnswer(playerAnswer, rule[1])) {
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

    public static int getMaxTries() {
        return MAX_TRIES;
    }
}
