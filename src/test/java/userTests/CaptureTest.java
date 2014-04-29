package userTests;

import gui.GameFrame;
import imhotep.Imhotep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.PlayerDriver;

import static builders.PawnBuilder.aPawn;
import static builders.QueenBuilder.aQueen;
import static org.junit.Assert.assertThat;
import static support.PlayerDriver.on;
import static support.PlayerDriver.queen;

@Imhotep(level="UI")
public class CaptureTest {

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

    @Test public void
    canCapture() {
        game.display(
                aQueen().white().on( "d1" ).build(),
                aPawn().black().on( "d7" ).build() );

        player.cell("d1").click();
        player.cell("d7").click();

        player.seesAWhite(queen(), on("d7"));
    }
}
