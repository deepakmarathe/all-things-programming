package com.deepakm.algo.backtrack.towerofhanoi;

import java.util.Scanner;

/**
 * Created by dmarathe on 9/29/16.
 */
public class TowerOfHanoi {
    long counter = 0L;

    public TowerOfHanoi() {
        this.counter = 0L;
    }

    public void move(int n, char source, char target, char aux) {

        if (n == 1) {
            System.out.println("moving from " + source + " to " + target);
            counter = counter + 1;
            return;
        }

        move(n - 1, source, aux, target);
        System.out.println("moving from " + source + " to " + target);
        counter = counter + 1;
        move(n - 1, aux, target, source);

    }

    public static void main(String[] args) {
        char source = 'A';
        char target = 'B';
        char aux = 'C';
        System.out.println("Enter the number of blocks : ");
        int n = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
        }
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.move(n, source, target, aux);
        System.out.println("Took " + towerOfHanoi.counter + " steps to move.");
    }
}
