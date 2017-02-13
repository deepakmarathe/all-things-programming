package com.deepakm.impl.model;

import com.deepakm.impl.Interval;
import com.deepakm.impl.Key;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmarathe on 11/10/16.
 */
public class NoteVertex {
    private Key note;
    private NoteVertex[] fastCache;

    private static int MAX_DEPTH = 3;

    public NoteVertex(Key note) {
        this.note = note;
        this.fastCache = new NoteVertex[12];
    }

    public void initialiseAdjecencyList(){
        for(int i=0;i<12;i++){
            Key k = note.next(i);
            fastCache[i] = NoteFactory.get(k);
        }
    }

    public Key getNote() {
        return note;
    }

    public NoteVertex getFastCache(Integer distance) {
        int interval = distance;
        while(interval < 0){
            interval = interval + 12;
        }
        interval = interval % 12;
        return fastCache[interval];
    }

    public static int getMaxDepth() {
        return MAX_DEPTH;
    }

}
