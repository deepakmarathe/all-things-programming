package com.deepakm.algo.backtrack.nqueen;

/**
 * Created by dmarathe on 1/22/16.
 */
public class NQueenProblem {
    int board[][];
    int N = 0;

    public NQueenProblem(int board[][]) {
        if (board == null) {
            throw new IllegalArgumentException("board cannot be null");
        }
        if (board.length == 0) {
            throw new IllegalArgumentException("board size == 0");
        }
        if (board[0].length == 0) {
            throw new IllegalArgumentException("board size == 0");
        }
        if (board.length != board[0].length) {
            throw new IllegalArgumentException("malformed board");
        }
        this.board = board;
        this.N = this.board.length;
    }

    public boolean isSafe(int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public boolean solve(int column) {
        if (column == this.N) {
            return true;
        }
        for (int i = 0; i < this.N; i++) {
            if (isSafe(i, column)) {
                board[i][column] = 1;
                if (solve(column + 1)) {
                    return true;
                }
                board[i][column] = 0;
            }
        }
        return false;
    }

    public void printSolution() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " , ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int board[][] = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };
        NQueenProblem problem = new NQueenProblem(board);
        if (problem.solve(0)) {
            problem.printSolution();
        }
    }
}
