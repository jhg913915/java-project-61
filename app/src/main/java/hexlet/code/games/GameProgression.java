package hexlet.code.games;

import hexlet.code.Engine;

public class GameProgression {
    static String question;
    static String answer;
    static String playerName;
    public static void gamePlay() {
        String correctAnswer = "";
        int triesCounter = 0;

        // Greetings and getting playerName
        playerName = Engine.greetPlayer();
        Engine.formTask("What number is missing in the progression");

        // Forming a question
        int progLowerBound = 5;
        int progUpperBound = 10;
        int lowerBound = 2;
        int upperBound = 50;
        while (triesCounter < 3) {
            int missingNumberIndex = Engine.returnRandomNumber(progLowerBound, progUpperBound);
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
            question = sb.toString();
            Engine.formQuestion(question);
            answer = Engine.askForAnswer();

            if (Engine.checkAnswer(answer, correctAnswer)) {
                System.out.println("Correct!");
                triesCounter++;
            } else {
                Engine.printFail(answer, correctAnswer, playerName);
                break;
            }
        }

        if (triesCounter >= 3) {
            Engine.printSuccess(playerName);
        }
    }
}
