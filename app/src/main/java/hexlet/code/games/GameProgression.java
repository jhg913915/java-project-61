package hexlet.code.games;

import hexlet.code.Engine;

public class GameProgression {

    public static void gamePlay() {
        int maxTries = 3;
        int triesCounter = 0;
        String correctAnswer = "";

        String playerName = Engine.greetPlayer();
        Engine.formTask("What number is missing in the progression");

        int progUpperBound = 10;
        int lowerBound = 2;
        int upperBound = 50;
        while (triesCounter < maxTries) {
            int missingNumberIndex = Engine.returnRandomNumber(1, progUpperBound);
            int startNumber = Engine.returnRandomNumber(lowerBound, upperBound);
            int addUpNumber = Engine.returnRandomNumber(lowerBound, upperBound);
            StringBuilder sb = new StringBuilder();
            sb.append(startNumber);
            for (int i = 0; i <= progUpperBound; i++) {
                startNumber += addUpNumber;
                if (i != missingNumberIndex) {
                    sb.append(" ").append(startNumber);
                } else {
                    sb.append(" ").append("..");
                    correctAnswer = String.valueOf(startNumber);
                }
            }
            String question = sb.toString();
            Engine.formQuestion(question);
            String answer = Engine.askForAnswer();

            if (Engine.checkAnswer(answer, correctAnswer)) {
                System.out.println("Correct!");
                triesCounter++;
            } else {
                Engine.printFail(answer, correctAnswer, playerName);
                break;
            }
        }

        if (triesCounter >= maxTries) {
            Engine.printSuccess(playerName);
        }
    }
}
