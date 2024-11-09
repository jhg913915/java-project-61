package hexlet.code;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Engine {
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
}
