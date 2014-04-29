package userTests;

import application.Application;
import gui.GameFrame;
import imhotep.Imhotep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import support.PlayerDriver;

import static org.junit.Assert.assertThat;
import static support.PlayerDriver.on;
import static support.PlayerDriver.queen;

@Imhotep(level="User")
public class UserCapturesTest extends UserTest {

    @Test public void
    canCapture() {
        player.cell("d1").click();
        player.cell("d7").click();

        player.seesAWhite(queen(), on("d7"));
    }
}
