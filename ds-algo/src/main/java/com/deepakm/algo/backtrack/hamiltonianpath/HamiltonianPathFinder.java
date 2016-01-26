package com.deepakm.algo.backtrack.hamiltonianpath;

/**
 * Created by dmarathe on 1/22/16.
 */
public class HamiltonianPathFinder {
    int g[][];
    int v;
    int path[];
    int pos;

    public HamiltonianPathFinder(int g[][]) {
        this.g = g;
        this.v = g.length;
        this.path = new int[v];
        this.pos = 0;
        for(int i=0;i<v;i++){
            path[i] = -1;
        }
        path[0] = 0;
    }

    public boolean isSafe(int nextVertex, int pos) {
        if (g[path[pos - 1]][nextVertex] == 0) return false;

        for (int i = 0; i < pos; i++) {
            if (path[i] == nextVertex) {
                return false;
            }
        }
        return true;
    }

    public boolean solve(int pos) {
        if (pos == this.v) {
            if (g[path[pos - 1]][path[0]] == 1) {
                return true;
            }
            return false;
        }

        for (int i = 1; i < v; i++) {
            if (isSafe(i, pos)) {
                path[pos] = i;
                if (solve(pos + 1)) {
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }

    public void printPath() {
        for (int i = 0; i < v; i++) {
            System.out.print(path[i] + ", ");
        }
    }

    public static void main(String[] args) {
        int g1[][] = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        int g2[][] = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0},
        };
        HamiltonianPathFinder hamiltonianPathFinder = new HamiltonianPathFinder(g1);
        if (hamiltonianPathFinder.solve(1)) {
            hamiltonianPathFinder.printPath();
            System.out.println("");
        }
        hamiltonianPathFinder = new HamiltonianPathFinder(g2);
        if(hamiltonianPathFinder.solve(1)){
            hamiltonianPathFinder.printPath();
        } else {
            System.out.println("Solution does not exist.");
        }
    }
}
