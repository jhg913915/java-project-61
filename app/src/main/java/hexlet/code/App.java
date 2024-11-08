package hexlet.code;

import hexlet.code.gameslogic.GameEven;

import java.util.Scanner;

public class App {
    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        Cli.getPlayerName();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String gameType;
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit
                Your choice: \s""");
        gameType = scanner.nextLine();

        switch (gameType) {
        case "2":
            GameEven.gamePlay();
            break;
        case "1":
            greeting();
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
