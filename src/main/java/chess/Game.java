package chess;

import chess.rules.MoveAndEat;
import gui.MoveCommand;

import java.util.Collections;

import static chess.rules.InitialPositions.initialPositions;

public class Game
{
    private Pieces pieces = new Pieces();
    private MoveCommand moveCommand;

    public Game(){
        Collections.addAll(pieces, initialPositions());

        moveCommand = new MoveAndEat(pieces);
    }

    public Pieces Pieces(){
        return pieces;
    }

    public void move(String initialPosition, String targetPosition) {
        moveCommand.move(initialPosition, targetPosition);
    }
}
