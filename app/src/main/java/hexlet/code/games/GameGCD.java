package hexlet.code.games;

import hexlet.code.Engine;

import java.math.BigInteger;

public class GameGCD {
    private static int secondNum;
    private static int firstNum;

    public static void gamePlay() {
        int maxTries = 3;
        int triesCounter = 0;

        String playerName = Engine.greetPlayer();

        Engine.formTask("Find the greatest common divisor of given numbers.");

        int lowerBound = 1;
        int upperBound = 10;

        while (triesCounter < maxTries) {
            int multiplier = Engine.returnRandomNumber(lowerBound, upperBound);
            firstNum = Engine.returnRandomNumber(lowerBound, upperBound) * multiplier;
            secondNum = Engine.returnRandomNumber(lowerBound, upperBound) * multiplier;
            if (secondNum == firstNum) {
                secondNum += multiplier;
            }
            String question = firstNum + " " + secondNum;
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

    private static String findCorrectAnswer() {
        return String.valueOf(getGCD(firstNum, secondNum));
    }

    private static int getGCD(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcdTemp = b1.gcd(b2);
        return gcdTemp.intValue();
    }
}
