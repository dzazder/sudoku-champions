package dev.lampart.bartosz.sudokuchampions;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] Sudoku = SudokuGenerator.getInstance().generateGrid();
        GameEngine.getInstance().setSudoku(Sudoku);

        printSudoku(Sudoku);
    }

    private void printSudoku(int Sudoku[][]) {
        for (int y = 0; y < SudokuGenerator.SIZE; y++) {
            String line = "";
            for (int x = 0; x < SudokuGenerator.SIZE; x++) {

                line += Sudoku[x][y] + "|";

            }
            Log.d("SUDOKU", line);
        }
    }
}
