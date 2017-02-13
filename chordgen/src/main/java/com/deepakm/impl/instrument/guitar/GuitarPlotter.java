package com.deepakm.impl.instrument.guitar;

import com.deepakm.impl.Chord;
import com.deepakm.impl.Degree;
import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public Map<Integer, List<Set<FretPosition>>> rank(Map<Key, Set<FretPosition>> chordPosition) {
        Map<Integer, List<Set<FretPosition>>> scoreMap = new HashMap<>();

//        Map<FretPosition, Map<FretPosition, Map<FretPosition, Integer>>> scoreMap = new HashMap<>();

        outer:
        for (Map.Entry<Key, Set<FretPosition>> one : chordPosition.entrySet()) {
            for (Map.Entry<Key, Set<FretPosition>> two : chordPosition.entrySet()) {
                if (one.getKey() == two.getKey()) continue;
                for (Map.Entry<Key, Set<FretPosition>> three : chordPosition.entrySet()) {
                    if (three.getKey() == one.getKey() || three.getKey() == two.getKey()) continue;


                    System.out.println("keys : " + one.getKey() + ", " + two.getKey() + ", " + three.getKey());
                    for (FretPosition fretOne : one.getValue()) {
                        for (FretPosition fretTwo : two.getValue()) {
                            // if (!fretOne.isFeasible(fretTwo)) continue;

                            for (FretPosition fretThree : three.getValue()) {
                                // if (!fretThree.isFeasible(fretOne) || !fretThree.isFeasible(fretTwo))
                                //   continue;
                                if (fretOne.isFeasible(fretTwo) && fretTwo.isFeasible(fretThree) && fretOne.isFeasible(fretThree)) {
                                    System.out.println("The combination : " + fretOne + ", " + fretTwo + ", " + fretThree);
                                    //Now we have all distinct notes on fretboard. compute theri score.
                                    int score = triangleDistance(fretOne, fretTwo, fretThree);
                                    if (!scoreMap.containsKey(score)) {
                                        scoreMap.put(score, new ArrayList<Set<FretPosition>>());
                                    }
                                    Set<FretPosition> fretPositions = new HashSet<>();
                                    fretPositions.add(fretOne);
                                    fretPositions.add(fretTwo);
                                    fretPositions.add(fretThree);
                                    scoreMap.get(score).add(fretPositions);
                                }
//                                System.out.println("three positions are : ");
//                                System.out.println("score : " + score + ", positions : " + fretPositions);

                            }
                        }
                    }
                    break outer;
                }
            }
        }
        return scoreMap;
    }

    private int triangleDistance(FretPosition fretOne, FretPosition fretTwo, FretPosition fretThree) {
        int score = 0;
        score = distance(fretOne, fretTwo);
        score += distance(fretOne, fretThree);
        score += distance(fretTwo, fretThree);
        return score;
    }

    public int distance(FretPosition a, FretPosition b) {
        return Math.abs(a.getFretPosition() - b.getFretPosition()) +
                Math.abs(a.getStringNumber() - b.getStringNumber());
    }

    public static void main(String[] args) {

        Key[] chord = Chord.getForKey(Key.A, Scale.NATURAL_MINOR, Degree.I, 3);
        Map<Key, Set<FretPosition>> chordPositions = new HashMap<>();
        FretBoard fretBoard = new FretBoard();

        for (Key key : chord) {
            List<FretPosition> fretPositions = FretBoard.getFretPositions(key);
            System.out.println("Key : " + key + " FretPositions : " + fretPositions);
            chordPositions.put(key, new HashSet<>(fretPositions));
        }
        Map<Integer, List<Set<FretPosition>>> chords = new GuitarPlotter().rank(chordPositions);
        for (int i = 0; i < 100; i++) {
            if (chords.containsKey(i)) {
                System.out.println("Found! score : " + i);
                for (Set<FretPosition> set : chords.get(i)) {
                    System.out.println("combination : " + set);
                }
            }
        }
        //rank by distance and give the possible chord positions.
        //shorter the distance inbetween positions in fretboard, higher chances of being easier to hold.

    }
}
