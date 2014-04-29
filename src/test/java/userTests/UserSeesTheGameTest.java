package userTests;

import imhotep.Imhotep;
import org.junit.Test;

import static builders.QueenBuilder.aQueen;
import static gui.GameFrame.TITLE;
import static support.PlayerDriver.*;

@Imhotep(level="User")
public class UserSeesTheGameTest extends UserTest{

    @Test
    public void
    seesTheApplicationTitle() {
        player.seesTitle(TITLE);
    }

    @Test public void
    seesAWhitePawn() throws InterruptedException {
        player.seesAWhite(pawn(), on("b2"));
    }

    @Test public void
    seesABlackPawn() throws InterruptedException {
        player.seesABlack(pawn(), on("g7"));
    }

    @Test public void
    seesABlackQueen() throws InterruptedException {
        player.seesABlack(queen(), on("d8"));
    }

    @Test public void
    seesAWhiteQueen() throws InterruptedException {
        player.seesAWhite(queen(), on("d1"));
    }
}
