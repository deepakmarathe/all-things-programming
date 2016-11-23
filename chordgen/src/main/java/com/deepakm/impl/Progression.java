package com.deepakm.impl;

/**
 * Created by dmarathe on 11/20/16.
 */
public enum Progression {
    i(Scale.NATURAL_MINOR, Degree.I),
    I(Scale.MAJOR, Degree.I),
    ii(Scale.NATURAL_MINOR, Degree.II),
    II(Scale.MAJOR, Degree.II),
    iii(Scale.NATURAL_MINOR, Degree.III),
    III(Scale.MAJOR, Degree.III),
    iv(Scale.NATURAL_MINOR, Degree.IV),
    IV(Scale.MAJOR, Degree.IV),
    v(Scale.NATURAL_MINOR, Degree.V),
    V(Scale.MAJOR, Degree.V),
    vi(Scale.NATURAL_MINOR, Degree.VI),
    VI(Scale.MAJOR, Degree.VI),
    vii(Scale.NATURAL_MINOR, Degree.VII),
    VII(Scale.MAJOR, Degree.VII);


    private Scale scale;
    private Degree degree;

    private Progression(Scale scale, Degree degree) {
        this.scale = scale;
        this.degree = degree;
    }

    public Key[] inKey(Key key) {
//        Key root = scale.getKeyOfDegree(key, degree);
        return Chord.getForKey(key, scale, degree);
    }

    public static Key[] inKey(Key key, Scale scale, Degree degree) {
//        Key root = scale.getKeyOfDegree(key, degree);
        return Chord.getForKey(key, scale);
    }


    public static void main(String[] args) {
        Key[] keys = Progression.inKey(Key.C, Scale.MAJOR, Degree.I);
        for (Key key : keys) {
            System.out.println(key);
        }
    }
}
