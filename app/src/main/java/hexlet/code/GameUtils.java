package hexlet.code;

import java.util.ArrayList;
import java.util.Random;

public class GameUtils {
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
