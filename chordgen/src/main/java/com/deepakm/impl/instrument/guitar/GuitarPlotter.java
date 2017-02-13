package com.deepakm.impl.instrument.guitar;

import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmarathe on 11/9/16.
 */
public class GuitarPlotter {

    private List<Key> strings = new ArrayList<Key>() {{
        add(Key.E);
        add(Key.A);
        add(Key.D);
        add(Key.G);
        add(Key.B);
        add(Key.E);
    }};

    public GuitarPlotter() {

    }

    @Override
    public String toString() {

        for (Key note : strings) {
            Key[] keys = Scale.MAJOR.getForNote(note);
            for (Key key : keys) {
                System.out.print(key + "\t\t");
            }
            System.out.println();
        }
        ;
        return "";
    }

    public static void main(String[] args) {

        new FretBoard().getFretPositions(Key.E);
//        new GuitarPlotter().toString();
    }
}
