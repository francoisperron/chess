package gui;

import chess.Game;
import chess.Pawn;
import chess.Pieces;
import chess.Queen;
import imhotep.Imhotep;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Imhotep(level="Unit")
public class GameFrameTest {

    static GameFrame frame;

    @BeforeClass
    public static void
    theFrame() {
        frame = new GameFrame();
    }

    @AfterClass
    public static void
    closeFrame() {
        frame.dispose();
    }

    @Test public void
    recordPiecesPosition() {
        Queen queen = aQueen().white().on( "d1" ).build();
        Pawn pawn = aPawn().white().on( "d2" ).build();
        frame.display( queen, pawn );
        assertThat( frame.getPieces().getPieceWithPosition( "d1" ), instanceOf( Queen.class ) );
        assertThat(frame.getPieces().getPieceWithPosition("d2"), instanceOf(Pawn.class));
    }

    @Test public void
    delegatesMoveActionToGame() {
        frame = new GameFrame();
        Game mockGame = mock(Game.class);
        when(mockGame.Pieces()).thenReturn(new Pieces());

        frame.render(mockGame);
        frame.display(aQueen().black().on("d5").build());
        frame.clicked( frame.getButtonNamed( "d5" ) );
        frame.clicked( frame.getButtonNamed( "e5" ) );

        verify( mockGame ).move( "d5", "e5" );
    }
}
