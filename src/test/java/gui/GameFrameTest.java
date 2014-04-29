package gui;

import chess.Pawn;
import chess.Queen;
import imhotep.Imhotep;
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

@Imhotep(level="Unit")
public class GameFrameTest {

    static GameFrame frame;

    @BeforeClass
    public static void
    showGame() {
        frame = new GameFrame();
    }

    @Test public void
    createTheALetterFromIntValue97() {
        assertThat( new Character( (char) 97 ).toString(), equalTo( "a" ));
    }
    
    @Test public void
    recordPiecesPosition() {
        Queen queen = aQueen().white().on( "d1" ).build();
        Pawn pawn = aPawn().white().on( "d2" ).build();
        frame.display( queen, pawn );
        assertThat( frame.getPieces().getPieceWithPosition( "d1" ), instanceOf( Queen.class ) );
        assertThat( frame.getPieces().getPieceWithPosition( "d2" ), instanceOf( Pawn.class ) );
    }

    @Test public void
    delegatesMoveActionToMoveCommand() {
        MoveCommand moveMoveCommand = mock( MoveCommand.class );
        frame.setMoveCommand( moveMoveCommand );
        frame.display( aQueen().black().on( "d5" ).build() );
        frame.clicked( frame.getButtonNamed( "d5" ) );
        frame.clicked( frame.getButtonNamed( "e5" ) );

        verify( moveMoveCommand ).move( "d5", "e5" );
    }
    
}
