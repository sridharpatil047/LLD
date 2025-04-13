package dtos;

import lombok.Data;
import models.Player;

import java.util.List;

@Data
public class CreateGameReqDto {
    private int boardDimension;
    private List<Player> players;
}
