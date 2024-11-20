package hexlet.code;

public class App {
    public static void main(String[] args) {
        String gameType = GameChoice.askGameType();
        GameChoice.startChosenGame(gameType);
    }
}
