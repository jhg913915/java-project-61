package hexlet.code;

import hexlet.code.games.GameCalculator;
import hexlet.code.games.GameEven;
import hexlet.code.games.GameGCD;
import hexlet.code.games.GamePrime;
import hexlet.code.games.GameProgression;

import java.util.Scanner;

public class GameChoice {
    public static String askGameType() {
        Scanner scanner = new Scanner(System.in);
        String gameType;
        System.out.println("""
                Welcome to the Brain Games!
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice: \s""");
        gameType = scanner.nextLine();
        return gameType;
    }

    public static void startChosenGame(String gameType) {
        switch (gameType) {
            case "4":
                GameGCD.gamePlay();
                break;
            case "3":
                GameCalculator.gamePlay();
                break;
            case "2":
                GameEven.gamePlay();
                break;
            case "1":
                Engine.greetPlayer();
                break;
            case "5":
                GameProgression.gamePlay();
                break;
            case "6":
                GamePrime.gamePlay();
                break;
            case "0":
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("""
                        There is no such option!
                        Select again!\s""");
        }
    }
}
