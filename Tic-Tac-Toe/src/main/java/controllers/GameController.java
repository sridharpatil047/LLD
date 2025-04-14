package controllers;

import dtos.CreateGameReqDto;
import models.*;
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
                .winningStrategy(null)
                .build();
    }

    public void startGame(Game game) {
        while (game.getStatus() == Status.IN_PROGRESS) {
            // Display Board
            boardController.printBoard(game.getBoard());

            Player currentPlayer = game.getPlayers().get(game.getTurn() % game.getPlayers().size());
            System.out.println("Player : " + currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ")");
            Cell userCellInput = getUserInput();
            Move move = new Move(currentPlayer, userCellInput);

            // Valid move?
            if (!isValidMove(move)) {
                System.out.println("Invalid move, please try again");
                continue;
            }
            game.getMoves().add(move);
            boardController.updateCell(game.getBoard(), move);

            // Winner?
            Player winner = game.getWinningStrategy().checkWinner();
            if (winner != null) {
                game.setWinner(winner);
                game.setStatus(Status.WIN);
                break;
            }

            // Draw?
            if (game.getMoves().size() == game.getBoard().getCells().size()) {
                game.setWinner(null);
                game.setStatus(Status.DRAW);
                break;
            }

            game.setTurn(game.getTurn() + 1);
        }
    }

    private Cell getUserInput() {
        System.out.print("Row : "); int row = scanner.nextInt();
        System.out.print("Column : "); int column = scanner.nextInt();

        return new Cell(row, column);
    }
    private boolean isValidMove(Move move) {
        return true;
    }
}
