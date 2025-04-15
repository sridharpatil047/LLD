package strategies;

import models.Board;
import models.Move;
import models.Player;


public class BruteForceStrategyImpl extends AbstractWinningStrategy {
    @Override
    public Player checkWinner(Board board, Move lastMove) {

        int dimension = board.getDimension();
        // Row-wise check
        for (int row = 0; row < dimension; row++) {
            Player player = board.getCells().get(dimension * row).getOwns();
            if (player == null) {continue;}
            String symbolRequired = player.getSymbol();
            int count = 1;
            for (int column = 1; column < dimension; column++) {
                Player player2 = board.getCells().get(dimension * row + column).getOwns();
                if (player2 == null) {continue;}
                String symbol = player2.getSymbol();
                if (symbolRequired.equals(symbol)) {
                    count++;
                }
            }
            if (count == dimension) {
                return player;
            }
        }

        // Column-wise check
        for (int column = 0; column < dimension; column++) {
            Player player = board.getCells().get(column).getOwns();
            if (player == null) {continue;}
            String symbolRequired = player.getSymbol();
            int count = 1;
            for (int row = 1; row < dimension; row++) {
                Player player2 = board.getCells().get(dimension * row + column).getOwns();
                if (player2 == null) {continue;}
                String symbol = player2.getSymbol();
                if (symbolRequired.equals(symbol)) {
                    count++;
                }
            }
            if (count == dimension) {
                return player;
            }
        }
        return null;
    }
}
