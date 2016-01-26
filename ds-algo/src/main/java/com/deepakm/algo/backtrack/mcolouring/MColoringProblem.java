package com.deepakm.algo.backtrack.mcolouring;

/**
 * Created by dmarathe on 1/22/16.
 */
public class MColoringProblem {
    int v;
    int M;
    int adj[][];
    int color[];

    public MColoringProblem(int v, int adj[][], int M) {
        this.adj = adj;
        this.v = v;
        this.M = M;
        this.color = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = -1;
        }
    }

    public boolean isSafe(int vertex, int c) {
        for (int i = 0; i < v; i++) {
            if (adj[vertex][i] == 1 && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    public boolean solve(int vertex) {
        if (vertex == v) {
            return true;
        }

        for (int i = 0; i < M; i++) {
            if (isSafe(vertex, i)) {
                color[vertex] = i;
                if (solve(vertex + 1)) {
                    return true;
                }
                color[vertex] = -1;
            }
        }
        return false;
    }

    public void printSolution(){
        for(int i=0;i<color.length;i++){
            System.out.println("vertex : " + i + ", color : " + color[i]);
        }
    }
    public static void main(String[] args) {
        int graph[][] = {
                {0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        int m = 3; // Number of colors
        MColoringProblem problem = new MColoringProblem(graph.length, graph, m);
        if( problem.solve(0) ){
            problem.printSolution();
        }
    }
}
