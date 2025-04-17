package controllers;

import exceptions.InvalidBoardSizeException;
import models.Board;
import models.Cell;
import models.Move;
import models.Player;

import java.util.ArrayList;
import java.util.List;

public class BoardController {

    public Board createBoard(int dimension) {
        // Validate board dimension
        if (dimension < 3){
            throw new InvalidBoardSizeException("Board dimension should be at least 3");
        }

        // Create Cells
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cells.add(new Cell(i, j));
            }
        }

        // Setup Board
        Board board = new Board();
        board.setDimension(dimension);
        board.setCells(cells);

        return board;
    }

    public Board flushBoard(Board board) {
        int dimension = board.getDimension();
        List<Cell> cells = board.getCells();
        for (Cell cell : cells) {
            cell.setOwns(null);
        }
        board.setCells(cells);
        return board;
    }

    public Cell updateCell(Board board, Move move) {
        int dimension = board.getDimension();
        Cell cell = move.getCell();
        List<Cell> cells = board.getCells();
        Cell cell1 = cells.get(dimension * cell.getRow() + cell.getCol());
        cell1.setOwns(move.getPlayer());
        return cell1;
    }

    public void printBoard(Board board) {
        int dimension = board.getDimension();
        List<Cell> cells = board.getCells();
        for (int i = 0; i < dimension; i++) {
            System.out.print(" | ");
            for (int j = 0; j < dimension; j++) {
                Player player = cells.get(dimension*i+j).getOwns();
                if (player != null) {
                    System.out.print(player.getSymbol());
                }else {
                    System.out.print("-");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

}
