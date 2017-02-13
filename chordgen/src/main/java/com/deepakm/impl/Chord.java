package com.deepakm.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmarathe on 8/17/15.
 */
public enum Chord {
    MAJOR(new short[]{0, 1, 3, 5});

//    MINOR_NATURAL(new short[]{3, 4}, Scale.NATURAL_MINOR);

//    MELODIC_MINOR(new short),
//
//    HARMONIC_MINOR,
//
//    MINOR_PENTATONIC;


    private short[] steps;
    private Scale scale;
    private static Map<Degree, Scale> chordMap = new HashMap<Degree, Scale>(){{
        put(Degree.I, Scale.MAJOR);
        put(Degree.II, Scale.NATURAL_MINOR);
        put(Degree.III, Scale.NATURAL_MINOR);
        put(Degree.IV, Scale.MAJOR);
        put(Degree.V, Scale.MAJOR);
        put(Degree.VI, Scale.NATURAL_MINOR);

    }};

    private Chord(short steps[]) {
        this.steps = steps;
        this.scale = scale;
    }

    public static Key[] getForKey(Key key, Scale scale) {
        Degree degree = Degree.I;
        return getForKey(key, scale, degree);
    }

    public static Key[] getForKey(Key key, Scale scale, Degree degree) {
        Key base[] = scale.getForNote(key);
        int index = degree.getDegree();
        Key[] c = new Key[3];
        c[0] = base[index % (base.length-1)];
        c[1] = base[(index+2) % (base.length-1)];
        c[2] = base[(index+4) % (base.length-1)];
        return c;
//
//        Key root = scale.getKeyOfDegree(key, degree);
//        Scale baseScale = chordMap.get(degree);
//
//        Key[] chord = new Key[3];
//        chord[0] = baseScale.getKeyOfDegree(root, Degree.I);
//        chord[1] = baseScale.getKeyOfDegree(root, Degree.III);
//        chord[2] = baseScale.getKeyOfDegree(root, Degree.V);
//        return chord;
    }

    public static Key[] getForKey(Key key, Scale scale, Degree degree, int notes) {
        Key base[] = scale.getForNote(key);
        int index = degree.getDegree();
        Key[] c = new Key[notes];
        for(int i=0;i<notes;i++) {
            c[i] = base[index + (2*i) % (base.length - 1)];
        }
        return c;
    }
    public static void main(String[] args) {

        for (Key key : Chord.getForKey(Key.C, Scale.MAJOR, Degree.I, 7)) {
            System.out.println(key);
        }
//        for (Key key : Chord.getForKey(Key.D, Scale.HARMONIC_MINOR)) {
//            System.out.println(key);
//        }

    }

}