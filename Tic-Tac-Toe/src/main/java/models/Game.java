package models;

import lombok.Builder;
import lombok.Data;
import strategies.WinningStrategy;

import java.util.List;

@Data
@Builder
public class Game {
    private Board board;
    private List<Player> players;
    private Status status;
    private List<Move> moves;
    private Player winner;
    private int turn;
    private WinningStrategy winningStrategy;
}
