package controllers;

import dtos.CreateGameReqDto;
import models.*;
import strategies.BruteForceStrategyImpl;
import strategies.SuboptimalStrategyImpl;
import strategies.WinningStrategy;

import java.util.*;

public class GameController {
    private final BoardController boardController;
    private final PlayerController playerController;
    private final Scanner scanner;

    public GameController(BoardController boardController) {
        this.boardController = boardController;
        this.playerController = new PlayerController();
        this.scanner = new Scanner(System.in);
    }

    public Game createGame(CreateGameReqDto createGameReqDto) {

        int boardDimension = createGameReqDto.getBoardDimension();
        List<Player> players = createGameReqDto.getPlayers();

        // Create Board
        Board board = boardController.createBoard(boardDimension);

        // Validate Players
        List<Player> playersList = playerController.validatePlayers(players);


        // Setup Game
        return Game.builder()
                .board(board)
                .players(playersList)
                .moves(new ArrayList<>())
                .status(Status.IN_PROGRESS)
                .turn(0)
                .winningStrategy(new SuboptimalStrategyImpl())
                .build();
    }

    public void startGame(Game game) {
        boardController.printBoard(game.getBoard());

        while (game.getStatus() == Status.IN_PROGRESS) {

            Player currentPlayer = game.getPlayers().get(game.getTurn() % game.getPlayers().size());
            System.out.println("Player : " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")");
            Cell userCellInput = getUserInput();
            Move move = new Move(currentPlayer, userCellInput);

            // Valid move?
            if (!isValidMove(game.getBoard(), move)) {
                System.out.println("Invalid move, please try again");
                continue;
            }
            game.getMoves().add(move);
            boardController.updateCell(game.getBoard(), move);

            // Winner?
            WinningStrategy winningStrategy = game.getWinningStrategy();

            Player winningCandidate = winningStrategy.checkWinner(game.getBoard(), move);
            if (winningCandidate != null) {
                game.setWinner(winningCandidate);
                game.setStatus(Status.WIN);
                break;
            }

            // Draw?
            if (winningStrategy.checkDraw(game.getBoard(), game.getMoves())) {
                game.setWinner(null);
                game.setStatus(Status.DRAW);
                break;
            }

            game.setTurn(game.getTurn() + 1);

            // Display Board
            boardController.printBoard(game.getBoard());
        }
    }

    private Cell getUserInput() {
        System.out.print("Row : "); int row = scanner.nextInt();
        System.out.print("Column : "); int column = scanner.nextInt();

        return new Cell(row, column);
    }

    private boolean isValidMove(Board board, Move move) {
        // Cell in the range?
        Cell cell = move.getCell();
        int dimension = board.getDimension();
        if (cell.getRow() >= dimension
                || cell.getRow() < 0
                || cell.getCol() >= dimension
                || cell.getCol() < 0) {
            return false;
        }

        // Is Cell empty?
        int row = cell.getRow();
        int col = cell.getCol();
        Player player = board.getCells().get(dimension * row + col).getOwns();
        if (player != null) {
            return false;
        }

        return true;
    }
}
