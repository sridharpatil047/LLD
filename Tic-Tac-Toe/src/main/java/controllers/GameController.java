package controllers;

import dtos.CreateGameReqDto;
import exceptions.InvalidBoardSizeException;
import exceptions.SymbolAlreadyTakenException;
import models.Player;

import java.util.*;

public class GameController {

    public void CreateGame(CreateGameReqDto createGameReqDto) {

        int boardDimension = createGameReqDto.getBoardDimension();
        List<Player> players = createGameReqDto.getPlayers();

        // Validate board dimension
        if (boardDimension < 3){
            throw new InvalidBoardSizeException("Board dimension should be at least 3");
        }


        // Validate players info
        Set<String> symbolSet = new HashSet<>();
        for (Player player : players) {
            if (!symbolSet.contains(player.getSymbol())) {
                symbolSet.add(player.getSymbol());
            }else {
                throw new SymbolAlreadyTakenException("Symbol already taken for " + player.getSymbol());
            }
        }

    }

}
