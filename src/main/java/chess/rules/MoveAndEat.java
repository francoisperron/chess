package chess.rules;

import chess.Piece;
import chess.Pieces;
import gui.MoveCommand;

public class MoveAndEat implements MoveCommand
{
    private Pieces pieces;

    public MoveAndEat(Pieces pieces)
    {
        this.pieces = pieces;
    }

    @Override
    public void move(String initialPosition, String targetPosition)
    {
        Piece piece = pieces.getPieceWithPosition(initialPosition);
        Piece eaten = pieces.getPieceWithPosition(targetPosition);
        pieces.remove(eaten);
        piece.setPosition(targetPosition);
    }
}
