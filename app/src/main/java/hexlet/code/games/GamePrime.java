package hexlet.code.games;

import hexlet.code.Engine;

import java.math.BigInteger;

public class GamePrime {
    static int question;
    static String answer;
    static String playerName;
    public static void gamePlay() {
        int triesCounter = 0;

        playerName = Engine.greetPlayer();
        Engine.formTask("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int lowerBound = 0;
        int upperBound = 100;
        while (triesCounter < 3) {
            question = Engine.returnRandomNumber(lowerBound, upperBound);
            Engine.formQuestion(String.valueOf(question));
            answer = Engine.askForAnswer();
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

    private static String findCorrectAnswer() {
        String result;

        if (isPrime()) {
            result = "yes";
        } else {
            result = "no";
        }
        return result;
    }

    public static boolean isPrime() {
        BigInteger bigInteger = BigInteger.valueOf(question);
        return bigInteger.isProbablePrime((int) Math.log(question));
    }

}
