package gui;

import chess.Game;
import chess.Piece;
import chess.Pieces;
import chess.rules.MoveAndEat;
import gui.renderers.BoardRenderer;
import gui.renderers.PieceRenderer;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public static final String TITLE = "Chess";
    private String selection = null;
    private MoveCommand moveCommand;
    private Game game = new Game();

    public GameFrame() {
        this.setName(TITLE);
        this.setTitle(TITLE);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        new BoardRenderer().renderOn(this);

        moveCommand = new MoveAndEat(game.Pieces());
    }

    public JButton getButtonNamed(String name) {
        Component[] all = this.getContentPane().getComponents();
        for (Component component : all) {
            if (component.getName().equalsIgnoreCase(name)) {
                return (JButton) component;
            }
        }
        return null;
    }

    public void clicked(JButton source) {
        if (selection == null) {
            selection = source.getName();
        } else {
            Piece piece = game.Pieces().getPieceWithPosition(selection);
            String initialPosition = piece.getPosition();

            moveCommand.move(initialPosition, source.getName());

            clearPosition(initialPosition);
            display(piece);
            selection = null;
        }
    }

    public Pieces getPieces() {
        return game.Pieces();
    }

    public void display(Piece piece) {
        PieceRenderer renderer = new RendererFactory().rendererOf(piece);
        renderer.visit(getButtonNamed(piece.getPosition()));
        if (!game.Pieces().contains(piece)) {
            game.Pieces().add(piece);
        }
    }

    public void display(Piece... given) {
        for (Piece piece : given) {
            display(piece);
        }
    }

    public void setMoveCommand(MoveCommand moveCommand) {
        this.moveCommand = moveCommand;
    }

    public void clearPosition(String initialPosition) {
        getButtonNamed(initialPosition).setIcon(null);
    }

    public void render(Game game) {
        this.game = game;
        setVisible(true);

        display(game.Pieces().toArray(new Piece[]{}));
    }
}
