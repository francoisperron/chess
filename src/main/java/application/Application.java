package application;

import chess.Game;
import gui.GameFrame;

import static chess.rules.InitialPositions.initialPositions;

public class Application {

    private static GameFrame frame;

    public static void main(String... arg) {
        frame = new GameFrame();
        Game game = new Game();
        frame.render(game);
    }

    public static void close(){
        frame.dispose();
    }
}
