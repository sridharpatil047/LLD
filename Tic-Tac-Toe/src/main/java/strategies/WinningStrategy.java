package strategies;

import models.Player;

public interface WinningStrategy {
    Player checkWinner();
    boolean checkDraw();
}
