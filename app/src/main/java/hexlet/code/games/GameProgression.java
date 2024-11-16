package hexlet.code.games;

import hexlet.code.Engine;

public class GameProgression {

    public static void gamePlay() {
        String task = "What number is missing in the progression";
        String[][] rules = prepareRules();
        Engine.playGame(task, rules);
    }

    private static String[][] prepareRules() {
        final int progressionLength = 10;
        final int lowerBound = 2;
        final int upperBound = 50;
        String[][] rules = new String[Engine.getMaxTries()][2];
        for (int i = 0; i < rules.length; i++) {
            int missingNumberIndex = Engine.returnRandomNumber(1, progressionLength);
            int startNumber = Engine.returnRandomNumber(lowerBound, upperBound);
            int addUpNumber = Engine.returnRandomNumber(lowerBound, upperBound);
            String unparsedProgression = createUnparsedProgression(startNumber, addUpNumber,
                    progressionLength, missingNumberIndex);
            String question = findQuestion(unparsedProgression);
            String answer = findCorrectAnswer(unparsedProgression);
            rules[i][0] = question;
            rules[i][1] = answer;
        }
        return rules;
    }

    public static String createUnparsedProgression(int startNumber, int addUpNumber, int progressionLength,
                                                   int missingNumberIndex) {
        StringBuilder sb = new StringBuilder();
        sb.append(startNumber);
        String correctAnswer = "";
        for (int i = 0; i <= progressionLength; i++) {
            startNumber += addUpNumber;
            if (i != missingNumberIndex) {
                sb.append(" ").append(startNumber);
            } else {
                sb.append(" ").append("..");
                correctAnswer = String.valueOf(startNumber);
            }
        }
        sb.append(":").append(correctAnswer);
        return sb.toString();
    }

    public static String findCorrectAnswer(String unparsedProgression) {
        String[] parts = unparsedProgression.split(":");
        return parts[1];
    }

    public static String findQuestion(String unparsedProgression) {
        String[] parts = unparsedProgression.split(":");
        return parts[0];
    }
}
