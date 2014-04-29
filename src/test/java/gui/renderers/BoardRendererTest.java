package gui.renderers;

import gui.GameFrame;
import imhotep.Imhotep;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static gui.renderers.BoardRenderer.CELL_BLACK;
import static gui.renderers.BoardRenderer.CELL_WHITE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Imhotep(level="Unit")
public class BoardRendererTest
{
    static GameFrame frame;

    @BeforeClass
    public static void
    showGame() {
        frame = new GameFrame();
    }

    @Test
    public void
    gridLayout() {
        assertThat( frame.getContentPane().getLayout(), instanceOf( GridLayout.class ) );
    }

    @Test public void
    allComponentsMustBeOpaque() {
        Component[] all = frame.getContentPane().getComponents();
        for( Component component : all) {
            assertTrue( component.getName() + " should be opaque", component.isOpaque() );
        }
    }

    @Test public void
    allCellsMustHaveAnEmptyContentByDefault() {
        Component[] all = frame.getContentPane().getComponents();
        for( Component component : all) {
            assertThat( ((JButton) component).getText(), equalTo( "" ) );
        }
    }

    @Test public void
    allCellsMustHaveAnEmptyImageByDefault() {
        Component[] all = frame.getContentPane().getComponents();
        for( Component component : all) {
            assertThat( ((JButton) component).getIcon(), equalTo( null ) );
        }
    }

    @Test public void
    firstLine() {
        assertThat( colorOf( "a8" ), is( CELL_WHITE ) );
        assertThat( colorOf( "b8" ), is( CELL_BLACK ) );
        assertThat( colorOf( "c8" ), is( CELL_WHITE ) );
        assertThat( colorOf( "d8" ), is( CELL_BLACK ) );
        assertThat( colorOf( "e8" ), is( CELL_WHITE ) );
        assertThat( colorOf( "f8" ), is( CELL_BLACK ) );
        assertThat( colorOf( "g8" ), is( CELL_WHITE ) );
        assertThat( colorOf( "h8" ), is( CELL_BLACK ) );
    }

    @Test public void
    secondLine() {
        assertThat( colorOf( "a7" ), is( CELL_BLACK ) );
        assertThat( colorOf( "b7" ), is( CELL_WHITE ) );
        assertThat( colorOf( "c7" ), is( CELL_BLACK ) );
        assertThat( colorOf( "d7" ), is( CELL_WHITE ) );
        assertThat( colorOf( "e7" ), is( CELL_BLACK ) );
        assertThat( colorOf( "f7" ), is( CELL_WHITE ) );
        assertThat( colorOf( "g7" ), is( CELL_BLACK ) );
        assertThat( colorOf( "h7" ), is( CELL_WHITE ) );
    }

    private Color colorOf(String name) {
        return frame.getButtonNamed( name ).getBackground();
    }

}
