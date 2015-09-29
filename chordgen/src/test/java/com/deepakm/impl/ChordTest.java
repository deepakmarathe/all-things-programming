package com.deepakm.impl;

/**
 * Created by dmarathe on 8/17/15.
 */
public class ChordTest {
    public void testCMajor() {

        Key keys[] = Chord.MAJOR.getForKey(Key.C);
        assert keys[0] == Key.C;
        assert keys[1] == Key.E;
        assert keys[2] == Key.G;
    }

    private void printChords(Key[] keys) {
        for (Key key : keys) {
            System.out.print(key + ", ");
        }
        System.out.println();
    }

    public void getChordTest() {
        printChords(Chord.MAJOR.getForKey(Key.G));
        printChords(Chord.MINOR_NATURAL.getForKey(Key.A));
        printChords(Chord.MINOR_NATURAL.getForKey(Key.D));
        printChords(Chord.MAJOR.getForKey(Key.F));
    }

    public static void main(String[] args) {
        new ChordTest().getChordTest();
    }
}
