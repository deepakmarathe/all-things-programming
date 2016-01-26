package com.deepakm.algo.backtrack.knightmove;

/**
 * Created by dmarathe on 1/22/16.
 */
public class KnightMoveSolver {
    private final int[][] chessBoard;
    private static int highest = 0;
//    private static int nextX[] = new int[]{2, 2, -2, -2, 1, 1, -1, -1};
//    private static int nextY[] = new int[]{1, -1, 1, 1, 2, -2, 2, -2};

    private static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

    public KnightMoveSolver() {
        this.chessBoard = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = -1;
            }
        }
        chessBoard[0][0] = 0;
    }


    public boolean isSafe(int x, int y) {
        return (x >= 0 && x < 8 && y >= 0 && y < 8) && (chessBoard[x][y] == -1);
    }


    public boolean solve(int x, int y, int move) {
        if (highest < move) {
            highest = move;
            System.out.println(highest);
        }

        if (move == 8 * 8) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int nextx = x + xMove[k];
            int nexty = y + yMove[k];
            if (isSafe(nextx, nexty)) {
                chessBoard[nextx][nexty] = move;
                if (solve(nextx, nexty, move + 1)) {
                    return true;
                } else {
                    chessBoard[nextx][nexty] = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        KnightMoveSolver solver = new KnightMoveSolver();

        boolean solution = solver.solve(0, 0, 1);
        if (solution) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    System.out.print(solver.chessBoard[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}


class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}