package com.deepakm.algo.backtrack.ratinamaze.maze;

/**
 * Created by dmarathe on 1/22/16.
 */
public class ArrayBackedMaze implements Maze {
    private final int[][] container;

    public ArrayBackedMaze(int container[][]) {
        this.container = container;
    }

    @Override
    public boolean isWall(int x, int y) {
        return this.container[x][y] == 0;
    }

    @Override
    public boolean isOpen(int x, int y) {
        return this.container[x][y] == 1;
    }
}
