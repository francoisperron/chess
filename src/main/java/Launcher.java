import chess.Game;
import gui.GameFrame;

import static chess.rules.InitialPositions.initialPositions;

public class Launcher {

    public static void main(String... arg) {
        GameFrame frame = new GameFrame();
        Game game = new Game();
        frame.render(game);
    }
}
