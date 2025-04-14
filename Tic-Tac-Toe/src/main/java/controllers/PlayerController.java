package controllers;

import exceptions.SymbolAlreadyTakenException;
import models.Player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerController {

    public List<Player> validatePlayers(List<Player> players) {
        // Validate players info
        Set<String> symbolSet = new HashSet<>();
        for (Player player : players) {
            if (!symbolSet.contains(player.getSymbol())) {
                symbolSet.add(player.getSymbol());
            }else {
                throw new SymbolAlreadyTakenException("Symbol already taken for " + player.getSymbol());
            }
        }
        return players;
    }
}
