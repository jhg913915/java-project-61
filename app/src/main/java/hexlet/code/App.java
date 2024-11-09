package hexlet.code;

import hexlet.code.games.GameCalculator;
import hexlet.code.games.GameEven;

import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String gameType;
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calculator
                0 - Exit
                Your choice: \s""");
        gameType = scanner.nextLine();

        switch (gameType) {
            case "3":
                GameCalculator.gamePlay();
                break;
            case "2":
                GameEven.gamePlay();
                break;
            case "1":
                Engine.greetPlayer();
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
