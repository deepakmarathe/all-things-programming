package com.deepakm.impl;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.deepakm.impl.Progression.*;

/**
 * Created by dmarathe on 11/20/16.
 */
public class ProgressionBuilder {

    private Key key;
    //    private Scale scale;
    private List<Progression> progressions;

    public ProgressionBuilder() {
        progressions = new ArrayList<>();
    }

    public ProgressionBuilder withKey(Key key) {
        this.key = key;
        return this;
    }
//    public ProgressionBuilder withScale(Scale scale) {
//        this.scale = scale;
//        return this;
//    }

    public ProgressionBuilder of(Progression... progressions) {
        if (key == null) {
            throw new IllegalArgumentException("Key is not supplied.");
        }
        for (Progression progression : progressions) {
            this.progressions.add(progression);
        }
        return this;
    }

    public List<Key[]> chords() {
        List<Key[]> list = new ArrayList<>();
        for (Progression progression : progressions) {
            Key[] chord = progression.inKey(key);
            list.add(chord);
        }
        return list;
    }

    public static void main(String[] args) {
        ProgressionBuilder builder = new ProgressionBuilder()
                .withKey(Key.C).of(I, V, vi, IV);

        for (Key[] keys : builder.chords()) {
            System.out.println(Arrays.asList(keys));
        }

    }
}
