package chess;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static chess.rules.InitialPositions.initialPositions;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GameTest
{
    private Game game;

    @Before public void
    aGame() {
        game = new Game();
    }

    @Test public void
    placePiecesOnInitialPositionsOnCreation() {
        Pieces pieces = new Pieces();
        Collections.addAll(pieces, initialPositions());

        assertThat( game.Pieces().size(), equalTo(32) );
    }
}
