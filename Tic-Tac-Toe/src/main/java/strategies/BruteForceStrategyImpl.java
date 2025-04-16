package strategies;

import models.Board;
import models.Cell;
import models.Move;
import models.Player;

import java.util.List;


public class BruteForceStrategyImpl extends AbstractWinningStrategy {

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        int dimension = board.getDimension();
        List<Cell> cells = board.getCells();

        // Check each row
        for (int row = 0; row < dimension; row++) {
            Player first = cells.get(row * dimension).getOwns();
            if (first == null) continue;

            String symbol = first.getSymbol();
            boolean isWinningRow = true;

            for (int col = 1; col < dimension; col++) {
                Player current = cells.get(row * dimension + col).getOwns();
                if (current == null || !symbol.equals(current.getSymbol())) {
                    isWinningRow = false;
                    break;
                }
            }

            if (isWinningRow) return first;
        }

        // Check each column
        for (int col = 0; col < dimension; col++) {
            Player first = cells.get(col).getOwns();
            if (first == null) continue;

            String symbol = first.getSymbol();
            boolean isWinningColumn = true;

            for (int row = 1; row < dimension; row++) {
                Player current = cells.get(row * dimension + col).getOwns();
                if (current == null || !symbol.equals(current.getSymbol())) {
                    isWinningColumn = false;
                    break;
                }
            }

            if (isWinningColumn) return first;
        }

        // Diagonal checks can also be added here if needed

        return null;
    }
}
