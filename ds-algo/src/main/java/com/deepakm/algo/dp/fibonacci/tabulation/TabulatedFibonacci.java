package com.deepakm.algo.dp.fibonacci.tabulation;

/**
 * Created by dmarathe on 1/27/16.
 */
public class TabulatedFibonacci {
    public static long fibonacci(int n){
        long fib[] = new long[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        long f93 = fibonacci(90);
        System.out.println(f93);
    }
}
