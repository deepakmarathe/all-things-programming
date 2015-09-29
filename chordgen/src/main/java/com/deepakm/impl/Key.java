package com.deepakm.impl;

/**
 * Created by dmarathe on 8/17/15.
 */
public enum Key {
//    C((short) 1),
//    C_SHARP((short) 2),
//    D((short) 3),
//    D_SHARP((short) 4),
//    E((short) 5),
//    F((short) 6),
//    F_SHARP((short) 7),
//    G((short) 8),
//    G_SHARP((short) 9),
//    A((short) 10),
//    A_SHARP((short) 11),
//    B((short) 12);

    //    private short ordinal;
//
//    private Key(short ordinal) {
//        this.ordinal = ordinal;
//    }
//
    C,
    C_SHARP,
    D,
    D_SHARP,
    E,
    F,
    F_SHARP,
    G,
    G_SHARP,
    A,
    A_SHARP,
    B;

    public Key next(int skip) {
        int nextNote = (ordinal() + skip) % 12;
        return values()[nextNote];
    }
//    private short ordinal;
//
//    private Key(short ordinal) {
//        this.ordinal = ordinal;
//    }
}
