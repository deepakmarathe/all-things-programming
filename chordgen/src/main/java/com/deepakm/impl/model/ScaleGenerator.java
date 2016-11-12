package com.deepakm.impl.model;

import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;
import sun.jvm.hotspot.memory.SystemDictionary;
import sun.jvm.hotspot.runtime.Bytes;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.*;

/**
 * Created by dmarathe on 11/10/16.
 */
public class ScaleGenerator implements Serializable{
    public static Key[] getScale(Key note, Scale scale) {
        Key[] keys = new Key[8];
        NoteVertex vertex = NoteFactory.get(note);
        int stepPattern[] = scale.getStepPattern();

        int counter = 0;
        keys[counter++] = note;
        for (int i : stepPattern) {
            vertex = vertex.getFastCache(i);
            keys[counter++] = vertex.getNote();
        }
        return keys;
    }

    public static void main(String[] args) throws Exception{
        for (Key key : ScaleGenerator.getScale(Key.B, Scale.PHRYGIAN)) {
            System.out.println(key);
        }
    }
}
