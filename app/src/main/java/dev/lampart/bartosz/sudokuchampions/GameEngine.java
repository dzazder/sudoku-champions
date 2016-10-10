package dev.lampart.bartosz.sudokuchampions;

/**
 * Created by bartek on 10.10.2016.
 */
public class GameEngine {
    private static GameEngine instance;

    private int[][] Sudoku;

    private GameEngine() {

    }

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }

        return instance;
    }

    public int[][] getSudoku() {
        return Sudoku;
    }

    public void setSudoku(int[][] sudoku) {
        Sudoku = sudoku;
    }
}
