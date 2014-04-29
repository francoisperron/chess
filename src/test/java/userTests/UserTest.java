package userTests;

import application.Application;
import org.junit.After;
import org.junit.Before;
import support.PlayerDriver;

public abstract class UserTest {

    protected PlayerDriver player;

    @Before
    public void
    startGame() {
        Application.main();
        player = new PlayerDriver();
    }
    @After
    public void
    stopGame() {
        Application.close();
    }
}
