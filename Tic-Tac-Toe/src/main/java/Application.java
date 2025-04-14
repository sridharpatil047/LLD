import controllers.BoardController;
import controllers.GameController;
import dtos.CreateGameReqDto;
import models.Game;
import models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BoardController boardController = new BoardController();
        GameController gameController = new GameController(boardController);
        while(true){

            System.out.print("Board Dimension : ");
            int dem = scanner.nextInt();

            System.out.print("# players : ");
            int players = scanner.nextInt();
            List<Player> playerList = new ArrayList<>(players);
            for (int i = 0; i < players; i++) {
                System.out.println("Player " + (i + 1) + ": ");
                System.out.print("Name : "); String name = scanner.next();
                System.out.print("Symbol : "); String symbol = scanner.next();

                Player player = new Player();
                player.setSymbol(symbol);
                player.setName(name);
                playerList.add(player);

                System.out.println();
            }

            CreateGameReqDto createGameReqDto = new CreateGameReqDto();
            createGameReqDto.setBoardDimension(dem);
            createGameReqDto.setPlayers(playerList);
            Game game = gameController.createGame(createGameReqDto);
            gameController.startGame(game);

            break;
        }

    }
}
