package com.deepakm.algo.sort.topological;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by dmarathe on 2/12/16.
 */
class Graph {
    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topologicalSortUtil(int v, Boolean visited[], Stack stack){
        visited[v] = true;
        for(int w : adj[v]){
            if(!visited[w]){
                topologicalSortUtil(w, visited, stack);
            }
        }
        stack.push(v);
    }

    void topologicalSort(){
        Stack stack = new Stack();
        Boolean visited[] = new Boolean[v];
        for(int i=0;i<v;i++){
            visited[i] = false;
        }
        for(int i=0;i<v;i++){
            if(!visited[i] ){
                topologicalSortUtil(i, visited, stack);
            }
        }
        while(!stack.empty()){
            System.out.print(stack.pop() + ", ");
        }
    }
}
