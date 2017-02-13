package com.deepakm.impl.model;

import com.deepakm.impl.Key;

import java.util.*;

/**
 * Created by dmarathe on 11/10/16.
 */
public class NoteFactory {
    private static Map<Key, NoteVertex> noteFactory = new HashMap<>();

    static {
        noteFactory = new HashMap<>();

        for (Key key : Key.values()) {
            noteFactory.put(key, new NoteVertex(key));
        }
        for (Key key : Key.values()) {
            noteFactory.get(key).initialiseAdjecencyList();
        }
    }

    public static NoteVertex get(Key note) {
        if (!noteFactory.containsKey(note)) {
            noteFactory.put(note, new NoteVertex(note));
        }
        return noteFactory.get(note);
    }

    public static void main(String[] args) {
        NoteVertex vertex = NoteFactory.get(Key.C);
        System.out.println(vertex.getNote());
        for (int i = 0; i < 12; i++) {
            System.out.println(vertex.getFastCache(i).getNote());
        }
    }
}
