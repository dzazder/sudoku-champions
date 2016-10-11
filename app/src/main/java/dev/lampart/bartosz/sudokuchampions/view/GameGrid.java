package dev.lampart.bartosz.sudokuchampions.view;

import android.content.Context;

import dev.lampart.bartosz.sudokuchampions.SudokuGenerator;

/**
 * Created by bartek on 11.10.2016.
 */
public class GameGrid {
    private SudokuCell[][] Sudoku = new SudokuCell[SudokuGenerator.SIZE][SudokuGenerator.SIZE];

    public GameGrid(Context context) {
        for (int x = 0; x < SudokuGenerator.SIZE; x++) {
            for (int y = 0; y < SudokuGenerator.SIZE; y++) {
                Sudoku[x][y] = new SudokuCell(context);
            }
        }
    }

    public void setGrid(int[][] grid) {
        for (int x = 0; x < SudokuGenerator.SIZE; x++) {
            for (int y = 0; y < SudokuGenerator.SIZE; y++) {
                Sudoku[x][y].setValue(grid[x][y]);
            }
        }
    }

    public SudokuCell[][] getGrid() {
        return Sudoku;
    }

    public SudokuCell getItem(int x, int y) {
        return Sudoku[x][y];
    }

    public SudokuCell getItem(int position) {
        int x = position % SudokuGenerator.SIZE;
        int y = position / SudokuGenerator.SIZE;

        return Sudoku[x][y];
    }
}
