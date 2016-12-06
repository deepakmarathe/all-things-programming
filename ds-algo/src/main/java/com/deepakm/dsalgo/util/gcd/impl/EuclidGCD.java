package com.deepakm.dsalgo.util.gcd.impl;


/**
 * Created by dmarathe on 11/17/15.
 */
public class EuclidGCD implements GCD {


    private long gcd_(long a, long b) {
        if (b == 0L) return a;
        return gcd_(b, a%b);
    }

    @Override
    public long gcd(long a, long b) {
        if (a == 0L || b == 0L ) return 0;

        if (b > a) {
            long temp = a;
            a = b;
            b = temp;
        }

        return gcd_(a, b);
    }

    public static void main(String[] args) {
        EuclidGCD gcd = new EuclidGCD();
        long g = gcd.gcd(10,20);
        System.out.println(g);
        System.out.println(gcd.gcd(10,11));
    }
}

interface GCD {
    public long gcd(long a, long b);
}
