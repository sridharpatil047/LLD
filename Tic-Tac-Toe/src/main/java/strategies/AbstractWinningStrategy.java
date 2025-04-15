package strategies;

import models.Board;
import models.Move;
import models.Player;

import java.util.List;

public abstract class AbstractWinningStrategy implements WinningStrategy {
    @Override
    public abstract Player checkWinner(Board board, Move lastMove);

    @Override
    public boolean checkDraw(Board board, List<Move> moves) {
        return moves.size() == board.getCells().size();
    }
}
