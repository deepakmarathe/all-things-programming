package com.deepakm.impl;

/**
 * Created by dmarathe on 8/17/15.
 */
public enum Chord {
    MAJOR(new short[]{4, 3}, Scale.MAJOR),

    MINOR_NATURAL(new short[]{3, 4}, Scale.NATURAL_MINOR);

//    MELODIC_MINOR(new short),
//
//    HARMONIC_MINOR,
//
//    MINOR_PENTATONIC;


    private short[] steps;
    private Scale scale;

    private Chord(short steps[], Scale scale) {
        this.steps = steps;
        this.scale = scale;
    }

    public Key[] getForKey(Key key) {

        Key[] chord = new Key[3];
        chord[0] = key;
        chord[1] = scale.getForNote(key)[steps[0]];
        chord[2] = scale.getForNote(key)[steps[1]];
        return chord;

    }

}