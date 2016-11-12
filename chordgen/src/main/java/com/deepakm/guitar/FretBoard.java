package com.deepakm.guitar;

import com.deepakm.impl.Key;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dmarathe on 11/9/16.
 */
public class FretBoard {
    Map<Key, List<FretPosition>> fretBoard;
    Map<Integer, Key> stringNumberToNote;

    public FretBoard() {
        stringNumberToNote = new HashMap<>();

        fretBoard = new HashMap<>();

        init();
    }

    private void init() {
        stringNumberToNote.put(1, Key.E);
        stringNumberToNote.put(2, Key.A);
        stringNumberToNote.put(3, Key.D);
        stringNumberToNote.put(4, Key.G);
        stringNumberToNote.put(5, Key.B);
        stringNumberToNote.put(6, Key.E);

        for (Key key : Key.values()) {
            if (!fretBoard.containsKey(key)) {
                fretBoard.put(key, new ArrayList<FretPosition>());
            }
        }

        for (int noteNumber : stringNumberToNote.keySet()) {
            for (int i = 0; i < 12; i++) {
                FretPosition position = new FretPosition(noteNumber, i, stringNumberToNote.get
                        (noteNumber).next(i));
                List<FretPosition> positions = fretBoard.get(stringNumberToNote.get
                        (noteNumber).next(i));
                positions.add(position);
            }
        }
    }

    public void printPositions(Key note) {
        for(FretPosition position : fretBoard.get(note)){
            System.out.print(position + "\t\t");
        }
    }
}
