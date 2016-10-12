package dev.lampart.bartosz.sudokuchampions;

import android.content.Context;

import dev.lampart.bartosz.sudokuchampions.view.sudokugrid.GameGrid;

/**
 * Created by bartek on 10.10.2016.
 */
public class GameEngine {
    private static GameEngine instance;

    private GameGrid grid = null;

    private GameEngine() {

    }

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }

        return instance;
    }

    public void createGrid(Context context) {
        int[][] Sudoku = SudokuGenerator.getInstance().generateGrid();
        Sudoku = SudokuGenerator.getInstance().removeElements(Sudoku, 30);
        grid = new GameGrid(context);
        grid.setGrid(Sudoku);

    }

    public GameGrid getGrid() {
        return grid;
    }
}
