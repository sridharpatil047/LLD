package strategies;

import models.Board;
import models.Cell;
import models.Move;
import models.Player;

import java.util.List;

public class SuboptimalStrategyImpl extends AbstractWinningStrategy {

    @Override
    public Player checkWinner(Board board, Move lastMove) {
        int dimension = board.getDimension();
        List<Cell> cells = board.getCells();

        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();
        Player currentPlayer = lastMove.getPlayer();
        String symbol = currentPlayer.getSymbol();

        // Check Row
        boolean rowWin = true;
        for (int c = 0; c < dimension; c++) {
            Player cellPlayer = cells.get(row * dimension + c).getOwns();
            if (cellPlayer == null || !symbol.equals(cellPlayer.getSymbol())) {
                rowWin = false;
                break;
            }
        }
        if (rowWin) return currentPlayer;

        // Check Column
        boolean colWin = true;
        for (int r = 0; r < dimension; r++) {
            Player cellPlayer = cells.get(r * dimension + col).getOwns();
            if (cellPlayer == null || !symbol.equals(cellPlayer.getSymbol())) {
                colWin = false;
                break;
            }
        }
        if (colWin) return currentPlayer;

        // Check Top-left to Bottom-right Diagonal (if applicable)
        if (row == col) {
            boolean diag1Win = true;
            for (int i = 0; i < dimension; i++) {
                Player cellPlayer = cells.get(i * dimension + i).getOwns();
                if (cellPlayer == null || !symbol.equals(cellPlayer.getSymbol())) {
                    diag1Win = false;
                    break;
                }
            }
            if (diag1Win) return currentPlayer;
        }

        // Check Top-right to Bottom-left Diagonal (if applicable)
        if (row + col == dimension - 1) {
            boolean diag2Win = true;
            for (int i = 0; i < dimension; i++) {
                Player cellPlayer = cells.get(i * dimension + (dimension - 1 - i)).getOwns();
                if (cellPlayer == null || !symbol.equals(cellPlayer.getSymbol())) {
                    diag2Win = false;
                    break;
                }
            }
            if (diag2Win) return currentPlayer;
        }

        return null;
    }
}
