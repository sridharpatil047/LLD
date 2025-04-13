package models;

import lombok.Data;

import java.util.List;

@Data
public class Board {
    private int dimension;
    private List<Cell> cells;
}
