package hexlet.code.games;

import hexlet.code.Engine;

public class GameEven {
    private static int question;

    public static void gamePlay() {
        int maxTries = Engine.getMaxTries();
        int triesCounter = 0;

        // Greetings and getting playerName
        String playerName = Engine.greetPlayer();
        Engine.formTask("Answer 'yes' if the number is even, otherwise answer 'no'.");

        // Forming a question
        final int lowerBound = 0;
        final int upperBound = 100;
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

    public static String findCorrectAnswer() {
        String result;

        if (question % 2 == 0) {
            result = "yes";
        } else {
            result = "no";
        }
        return result;
    }
}
