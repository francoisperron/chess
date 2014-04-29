package userTests;

import gui.GameFrame;
import imhotep.Imhotep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.PlayerDriver;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static gui.GameFrame.TITLE;
import static support.PlayerDriver.*;

@Imhotep(level="UI")
public class DisplayTest {

    GameFrame game;
    PlayerDriver player;

    @Before
    public void
    showGame() {
        game = new GameFrame();
        game.setVisible( true );
        player = new PlayerDriver();
    }
    @After
    public void
    hideFrame() {
        game.setVisible( false );
    }

    @Test
    public void
    frameTitle() {
        player.hasTitle(TITLE);
    }

    @Test public void
    canDisplayAWhitePawn() throws InterruptedException {
        game.display( aPawn().white().on( "e2" ).build() );
        player.seesAWhite(pawn(), on("e2"));
    }

    @Test public void
    canDisplayABlackPawn() throws InterruptedException {
        game.display( aPawn().black().on( "e2" ).build() );
        player.hasBlack(pawn(), on("e2"));
    }

    @Test public void
    canDisplayABlackQueen() throws InterruptedException {
        game.display( aQueen().black().on( "d5" ).build() );
        player.hasBlack(queen(), on("d5"));
    }

    @Test public void
    canDisplayAWhiteQueen() throws InterruptedException {
        game.display( aQueen().white().on( "d5" ).build() );
        player.seesAWhite(queen(), on("d5"));
    }

}
