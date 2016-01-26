package com.deepakm.algo.dp.fibonacci.memoized;

/**
 * Created by dmarathe on 1/27/16.
 */
public class MemoizedFibonacci {

    public static final int MAX_LOOKUP = 100;
    private final long[] fibonacci;

    public MemoizedFibonacci(){
        this.fibonacci = new long[MAX_LOOKUP];
        for(int i = 0; i < fibonacci.length; i++){
            fibonacci[i]  = 0;
        }
    }

    public long fibonacci(int n){
        if( fibonacci[ n] == 0){
            if( n <= 1) {
                fibonacci[n] = n;
            } else {
                fibonacci[n] = fibonacci(n-1) + fibonacci(n-2);
            }
        }
        return fibonacci[n];
    }

    public static void main(String[] args) {
        MemoizedFibonacci fibonacci = new MemoizedFibonacci();
        long thirty = fibonacci.fibonacci(93);
        System.out.println(thirty);
    }
}
