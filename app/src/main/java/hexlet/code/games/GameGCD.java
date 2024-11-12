package hexlet.code.games;

import hexlet.code.Engine;

import java.math.BigInteger;

public class GameGCD {
    static String question;
    static String answer;
    static String playerName;
    static int secondNum;
    static int firstNum;
    static int gcd;
    public static void gamePlay() {
        int triesCounter = 0;

        playerName = Engine.greetPlayer();

        Engine.formTask("Find the greatest common divisor of given numbers.");

        int lowerBound = 1;
        int upperBound = 10;

        while (triesCounter < 3) {
            gcd = Engine.returnRandomNumber(lowerBound, upperBound);
            firstNum = Engine.returnRandomNumber(lowerBound, gcd);
            secondNum = Engine.returnRandomNumber(lowerBound, gcd);

            // We need to check that gcd != 1 because if it is,
            // it can create infinite loop
            if (secondNum == firstNum && gcd != 1) {
                do {
                    secondNum = Engine.returnRandomNumber(lowerBound, gcd);
                } while (secondNum == firstNum);
            }
            question = firstNum * gcd + " " + secondNum * gcd;
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

    private static String findCorrectAnswer() {
        return String.valueOf(getGCD(firstNum * gcd, secondNum * gcd));
    }

    private static int getGCD(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcdTemp = b1.gcd(b2);
        return gcdTemp.intValue();
    }
}
