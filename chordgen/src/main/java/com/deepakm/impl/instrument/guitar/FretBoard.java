package com.deepakm.impl.instrument.guitar;

import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;

import java.util.*;

/**
 * Created by dmarathe on 11/9/16.
 */
public class FretBoard {
    static Map<Key, List<FretPosition>> fretBoard;
    static Map<Integer, Key> stringNumberToNote;
    static FretPosition[][] fretPositions;


    public FretBoard() {
        stringNumberToNote = new HashMap<>();

        fretBoard = new HashMap<>();

        fretPositions = new FretPosition[6][12];
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
        for(int stringNumber=0;stringNumber<6;stringNumber++){
            Key key = stringNumberToNote.get(stringNumber+1);
            for(int j=0;j<12;j++){
                fretPositions[stringNumber][j] =  new FretPosition(stringNumber, j, key.next(j));
            }
        }
    }


    public static List<FretPosition> getFretPositions(Key note) {
        return fretBoard.get(note);
    }

    public static Set<FretPosition> getFretPositions(Key note, Scale scale) {
        Set<FretPosition> positions = new HashSet<>();
        for (Key key : scale.getForNote(note)) {
            for (FretPosition position : fretBoard.get(key)) {
                positions.add(position);
            }
        }
        return positions;
    }

    public static void main(String[] args) {
        Set<FretPosition> positions = new FretBoard().getFretPositions(Key.E, Scale.MAJOR);
        for (FretPosition position : positions) {
//            System.out.println(position.get);
        }
    }
}
