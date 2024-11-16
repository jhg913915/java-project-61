package hexlet.code;

public class App {
    public static void main(String[] args) {
        String gameType = Engine.askGameType();
        Engine.startChosenGame(gameType);
    }
}
