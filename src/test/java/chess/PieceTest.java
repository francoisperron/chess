package chess;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class PieceTest
{
    @Test public void
    toStringRendersPieceType()
    {
        assertThat(new Pawn().toString(), endsWith("Pawn"));
    }

    @Test public void
    toStringRendersPieceColor()
    {
        Pawn whitePawn = new Pawn();
        whitePawn.setWhite(true);

        assertThat(whitePawn.toString(), startsWith("White"));
    }
}
