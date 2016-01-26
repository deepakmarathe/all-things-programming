package com.deepakm.algo.backtrack.ratinamaze.algo;

/**
 * Created by dmarathe on 1/22/16.
 */
public class BacktrackingSolver {

    int maze[][];
    int pathx[];
    int pathy[];
    int pathCounter = 0;

    public BacktrackingSolver(int a[][]) {
        this.maze = a;
        this.pathx = new int[a.length * a[0].length];
        this.pathy = new int[a.length * a[0].length];
    }

    public boolean isSafe(int x, int y) {
        return (x < maze[0].length && y < maze.length) && maze[x][y] == 1;
    }

    public boolean solve(int x, int y, int targetX, int targetY) {
        if (x == targetX && y == targetY)
            return true;

        // go right
        if (isSafe(x + 1, y)) {

            if (solve(x + 1, y, targetX, targetY)) {
                pathx[pathCounter] = x + 1;
                pathy[pathCounter] = y;
                pathCounter += 1;
                return true;
            }
        } else if(isSafe(x, y+1)) {
            if (solve(x, y + 1, targetX, targetY)) {
                pathx[pathCounter] = x;
                pathy[pathCounter] = y + 1;
                pathCounter += 1;
                return true;
            }
        }
        return false;
    }


    public void printPath() {
        for (int i = pathCounter; i >= 0; i--) {
            System.out.println("(" + pathx[i] + "," + pathy[i] + ") ");
        }

    }

    public static void main(String[] args) {
        int maze[][] = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        BacktrackingSolver solver = new BacktrackingSolver(maze);
        if (solver.solve(0, 0, 3, 3)) {
            solver.printPath();
        }
    }
}
