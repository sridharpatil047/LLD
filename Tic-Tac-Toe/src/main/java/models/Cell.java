package models;

import lombok.Data;

@Data
public class Cell {
    private int row;
    private int col;
    private Player owns;

    public Cell() {
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
