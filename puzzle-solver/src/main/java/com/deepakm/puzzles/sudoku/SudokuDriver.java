package com.deepakm.puzzles.sudoku;

import com.deepakm.puzzles.sudoku.board.ArrayBackedBoard;
import com.deepakm.puzzles.sudoku.board.Board;
import com.deepakm.puzzles.sudoku.solver.BacktrackingSudokuSolver;
import com.deepakm.puzzles.sudoku.solver.SudokuSolver;

/**
 * Created by dmarathe on 1/21/16.
 */
public class SudokuDriver {

    public static void main(String[] args) {

        int grid[][] = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        Board board = new ArrayBackedBoard();
        board.initialise(grid);
        System.out.println("Puzzle is : ");
        board.printBoard();

        SudokuSolver sudokuSolver = new BacktrackingSudokuSolver(board);
        sudokuSolver.solve();
        System.out.println("Solved puzzle : ");
        board.printBoard();
    }
}
