package hexlet.code.games;

import hexlet.code.Engine;

import java.math.BigInteger;

public class GamePrime {
    private static int question;

    public static void gamePlay() {
        int maxTries = 3;
        int triesCounter = 0;

        String playerName = Engine.greetPlayer();
        Engine.formTask("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int lowerBound = 0;
        int upperBound = 100;
        while (triesCounter < maxTries) {
            question = Engine.returnRandomNumber(lowerBound, upperBound);
            Engine.formQuestion(String.valueOf(question));
            String answer = Engine.askForAnswer();
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
