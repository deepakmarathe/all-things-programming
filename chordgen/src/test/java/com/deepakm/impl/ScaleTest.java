package com.deepakm.impl;

import static com.deepakm.impl.Key.*;
import static com.deepakm.impl.Scale.*;

/**
 * Created by dmarathe on 8/17/15.
 */
public class ScaleTest {

    public void testMajorScale() {

        Key[] cMajor = MAJOR.getForNote(C);
        assert cMajor[0] == C;
        assert cMajor[1] == D;
        assert cMajor[2] == E;
        assert cMajor[3] == F;
        assert cMajor[4] == G;
        assert cMajor[5] == A;
        assert cMajor[7] == B;
    }

    public void testMinorScale(){
        printScale(MAJOR.getForNote(C));
        printScale(NATURAL_MINOR.getForNote(A));
        Key[] dMinor = NATURAL_MINOR.getForNote(D);
        printScale(dMinor);

    }

    public static void main(String[] args) {
        new ScaleTest().testMinorScale();
    }

    private void printScale(Key[] keys) {
        for (Key key : keys) {
            System.out.print(key + ", ");
        }
        System.out.println();
    }

}
