package chess;

import java.util.Collections;

import static chess.rules.InitialPositions.initialPositions;

public class Game
{
    private Pieces pieces = new Pieces();

    public Game(){
        Collections.addAll(pieces, initialPositions());
    }

    public Pieces Pieces(){
        return pieces;
    }
}
