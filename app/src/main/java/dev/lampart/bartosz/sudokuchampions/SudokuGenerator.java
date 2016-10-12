package dev.lampart.bartosz.sudokuchampions;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by bartek on 09.10.2016.
 */
public class SudokuGenerator {
    public static int SIZE = 9;
    public static int REGIONS = 3;
    private static SudokuGenerator instance;
    private ArrayList<ArrayList<Integer>> Available = new ArrayList<ArrayList<Integer>>();

    private Random rand = new Random();

    private SudokuGenerator() {

    }

    public static SudokuGenerator getInstance() {
        if (instance == null) {
            instance = new SudokuGenerator();
        }

        return instance;
    }

    public int[][] generateGrid() {
        int[][] Sudoku = new int[SIZE][SIZE];
        int currentPos = 0;

        clearGrid(Sudoku);

        while (currentPos < SIZE*SIZE) {
            if (Available.get(currentPos).size() != 0) {
                int i = rand.nextInt(Available.get(currentPos).size());
                int number = Available.get(currentPos).get(i);

                if (!checkConflict(Sudoku, currentPos, number)) {
                    int xPos = currentPos % SIZE;
                    int yPos = currentPos / 9;

                    Sudoku[xPos][yPos] = number;

                    Available.get(currentPos).remove(i);

                    currentPos++;
                }
                else {
                    Available.get(currentPos).remove(i);
                }
            } else {
                for (int i =1; i <= SIZE; i++) {
                    Available.get(currentPos).add(i);
                }
                currentPos--;
            }
        }

        return Sudoku;
    }

    public int[][] removeElements(int[][] Sudoku, int removeElCount) {
        int i = 0;
        while(i < removeElCount) {
            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);

            if (Sudoku[x][y] != 0) {
                Sudoku[x][y] = 0;
                i++;
            }
        }

        return Sudoku;
    }

    private void clearGrid(int[][] Sudoku) {
        Available.clear();

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                Sudoku[x][y] = -1;
            }
        }

        for (int x = 0; x < SIZE*SIZE; x++) {
            Available.add(new ArrayList<Integer>());
            for (int i = 1; i <= SIZE; i++) {
                Available.get(x).add(i);
            }
        }
    }

    private boolean checkConflict(int[][] Sudoku, int currentPos, final int number) {
        int xPos = currentPos % SIZE;
        int yPos = currentPos / SIZE;

        if (checkHorizontalConflict(Sudoku, xPos, yPos, number) ||
                checkVerticalConflict(Sudoku, xPos, yPos, number) ||
                checkRegionConflict(Sudoku, xPos, yPos, number)) {
            return true;
        }


        return false;
    }

    /**
     * Returns true if is the conflict
     * @param Sudoku
     * @param xPos
     * @param yPos
     * @param number
     * @return
     */
    private boolean checkHorizontalConflict(final int[][] Sudoku, final int xPos, final int yPos,
                                            final int number) {
        for (int x = xPos - 1; x >= 0; x--) {
            if (number == Sudoku[x][yPos]) {
                return true;
            }
        }

        return false;
    }

    private boolean checkVerticalConflict(final int[][] Sudoku, final int xPos, final int yPos,
                                           final int number) {
        for (int y = yPos - 1; y >= 0; y--) {
            if (number == Sudoku[xPos][y]) {
                return true;
            }
        }

        return false;
    }

    private boolean checkRegionConflict(final int[][] Sudoku, final int xPos, final int yPos,
                                          final int number) {

        int xRegion = xPos / REGIONS;
        int yRegion = yPos / REGIONS;

        for (int x = xRegion * REGIONS; x < xRegion * REGIONS + REGIONS; x++) {
            for (int y = yRegion * REGIONS; y < yRegion * REGIONS + REGIONS; y++) {
                if ((x != xPos || y != yPos) && number == Sudoku[x][y]) {
                    return true;
                }
            }
        }

        return false;
    }
}
