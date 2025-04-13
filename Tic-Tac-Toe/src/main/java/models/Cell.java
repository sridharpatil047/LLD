package models;

import lombok.Data;

@Data
public class Cell {
    private int row;
    private int col;
    private Player owns;
}
