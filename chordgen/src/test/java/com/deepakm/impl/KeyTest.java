package com.deepakm.impl;

import static com.deepakm.impl.Key.*;

/**
 * Created by dmarathe on 8/17/15.
 */
public class KeyTest {

    public void testNotesEquitemper() {

        assert C.next(1) == C_SHARP;
        assert C_SHARP.next(1) == D;
        assert D.next(1) == D_SHARP;
        assert D_SHARP.next(1) == E;
        assert E.next(1) == F;
        assert F.next(1) == F_SHARP;
        assert F_SHARP.next(1) == G;
        assert G.next(1) == G_SHARP;
        assert G_SHARP.next(1) == A;
        assert A.next(1) == A_SHARP;
        assert A_SHARP.next(1) == B;
        assert B.next(1) == C;

        assert B.next(2) == C_SHARP;

        assert B.next(0) == B;
        assert B.next(12) == B;
        assert B.next(24) == B;
    }



    public static void main(String[] args) {
        new KeyTest().testNotesEquitemper();
    }
}
