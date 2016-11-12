package com.deepakm.impl;

import com.deepakm.impl.modes.Modes;
import com.deepakm.impl.modes.Phrygian;


/**
 * Created by dmarathe on 8/17/15.
 */
public enum Scale {
    MAJOR(new int[]{2, 2, 1, 2, 2, 2, 1}),
    NATURAL_MINOR(new int[]{2, 1, 2, 2, 1, 2, 2}),
    MELODIC_MINOR(new int[]{2, 1, 2, 2, 2, 2, 1}),
    HARMONIC_MINOR(new int[]{ 2, 1, 2, 2, 1, 3, 1}),

    //Modes of Major
    IONIAN(new int[]{2, 2, 1, 2, 2, 2, 1}),
    LYDIAN(new int[]{2, 2, 2, 1, 2, 2, 1}),
    MIXOLYDIAN(new int[]{2, 2, 1, 2, 2, 1, 2}),

    //Modes of Minor
    DORIAN(new int[]{2, 1, 2, 2, 2, 1, 2}),
    PHRYGIAN(new int[]{1, 2, 2, 2, 1, 2, 2}),
    AEOLIAN(new int[]{2, 1, 2, 2, 1, 2, 2});

    private int[] stepPattern;

    private Scale(int[] stepPattern) {
        this.stepPattern = stepPattern;
    }

    public int[] getStepPattern(){
        return stepPattern;
    }

    public Key[] getForNote(Key note) {
        Key[] notes = new Key[8];
        notes[0] = note;
        short noteIndex = 1;
        for (int step : stepPattern) {
            notes[noteIndex] = notes[noteIndex - 1].next(step);
            noteIndex++;
        }
        return notes;
    }

    public Key getKeyOfDegree(Key key, Degree degree){
        return getForNote(key)[degree.getDegree()];
    }

    public static void main(String[] args) {
        Key key = MAJOR.getKeyOfDegree(Key.C, Degree.I);
        System.out.println(key);
        System.out.println("C major degree 2 : " + MAJOR.getKeyOfDegree(Key.C, Degree.II));
        System.out.println(MAJOR.getKeyOfDegree(Key.C, Degree.V));
        System.out.println(MAJOR.getKeyOfDegree(Key.C, Degree.DOMINENT));

        System.out.println(NATURAL_MINOR.getKeyOfDegree(Key.C, Degree.II));
        System.out.println(MAJOR.getKeyOfDegree(Key.C, Degree.II));

        Key[] keys = Modes.Major.Ionian.getKeys(Key.C);
        System.out.println("Keys : ");
        for(Key key1 : keys){
            System.out.println(key1);
        }
        keys = Modes.Minor.Phrygian.getKeys(Key.G);
        System.out.println("Keys : ");
        for(Key key1 : keys){
            System.out.println(key1);
        }

        keys = Modes.Major.Ionian.getKeys(Key.E);
        System.out.println("Keys : ");
        for(Key key1 : keys){
            System.out.println(key1);
        }
    }
}
