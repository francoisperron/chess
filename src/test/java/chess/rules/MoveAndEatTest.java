package chess.rules;

import chess.Game;
import chess.Pieces;
import chess.Queen;
import imhotep.Imhotep;
import org.junit.Before;
import org.junit.Test;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

@Imhotep(level="Rule")
public class MoveAndEatTest
{
    private Pieces pieces;

    @Before public void
    movingAQueenOnAPawn() {
        pieces = new Game().Pieces();
        pieces.add(aQueen().black().on("d5").build());
        pieces.add(aPawn().white().on("e5").build());

        MoveAndEat moveCommand = new MoveAndEat(pieces);

        moveCommand.move( "d5", "e5" );
    }

    @Test public void
    movesTheQueenToTheTargetPosition() {
        assertThat( pieces.getPieceWithPosition( "e5" ), instanceOf( Queen.class ) );
    }

    @Test public void
    removesTheQueenFromInitialPosition() {
        assertThat( pieces.getPieceWithPosition( "e3" ), equalTo(null) );
    }
}
