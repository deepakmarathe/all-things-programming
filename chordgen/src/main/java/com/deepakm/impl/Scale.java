package com.deepakm.impl;

/**
 * Created by dmarathe on 8/17/15.
 */
public enum Scale {
    MAJOR(new short[]{2, 2, 1, 2, 2, 2, 1}),
    NATURAL_MINOR(new short[]{2, 1, 2, 2, 1, 2, 2}),
    MELODIC_MINOR(new short[]{2, 1, 2, 2, 2, 2, 1}),
    HARMONIC_MINOR(new short[]{ 2, 1, 2, 2, 1, 3, 1});

    private short[] stepPattern;

    private Scale(short[] stepPattern) {
        this.stepPattern = stepPattern;
    }

    public Key[] getForNote(Key note) {
        Key[] notes = new Key[8];
        notes[0] = note;
        short noteIndex = 1;
        for (short step : stepPattern) {
            notes[noteIndex] = notes[noteIndex - 1].next(step);
            noteIndex++;
        }
        return notes;
    }
}
