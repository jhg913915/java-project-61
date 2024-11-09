package hexlet.code.games;

import hexlet.code.Engine;

public class GameEven {
    static int question;
    static String answer;
    static String playerName;

    public static void gamePlay() {
        int triesCounter = 0;

        // Greetings and getting playerName
        playerName = Engine.greetPlayer();
        Engine.formTask("Answer 'yes' if the number is even, otherwise answer 'no'.");

        // Forming a question
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
