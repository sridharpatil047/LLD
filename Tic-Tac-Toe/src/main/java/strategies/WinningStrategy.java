package strategies;

import models.Board;
import models.Move;
import models.Player;

import java.util.List;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
    boolean checkDraw(Board board, List<Move> moves);
}
