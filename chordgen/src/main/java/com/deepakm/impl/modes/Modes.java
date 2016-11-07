package com.deepakm.impl.modes;

import com.deepakm.impl.Degree;
import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;

/**
 * Created by dmarathe on 11/8/16.
 */
public enum Modes {
    IONIAN(Major.Ionian),
    DORIAN(Minor.Dorian),
    PHRYGIAN(Minor.Phrygian),
    LYDIAN(Major.Lydian),
    MIXOLYDIAN(Major.Mixolydian),
    AEOLIAN(Minor.Aeolian);

    private Mode mode;
    private Modes(Mode mode){
        this.mode = mode;
    }

    public enum Major implements Mode{
        Ionian(new IonianMode()),
        Lydian(new LydianMode()),
        Mixolydian(new MixolydianMode());

        private Mode mode;
        private Major(Mode mode){
            this.mode = mode;
        }

        @Override
        public Scale getScale() {
            return mode.getScale();
        }

        @Override
        public Key[] getKeys(Key key) {
            return mode.getKeys(key);
        }

        @Override
        public Key getKeyOfDegree(Key key, Degree degree) {
            return mode.getKeyOfDegree(key, degree);
        }
    }

    public enum Minor implements Mode{
        Dorian(new Dorian()),
        Phrygian(new Phrygian()),
        Aeolian(new Aeolian());

        private Mode mode;
        private Minor(Mode mode){
            this.mode = mode;
        }

        @Override
        public Scale getScale() {
            return mode.getScale();
        }

        @Override
        public Key[] getKeys(Key key) {
            return mode.getKeys(key);
        }

        @Override
        public Key getKeyOfDegree(Key key, Degree degree) {
            return mode.getKeyOfDegree(key, degree);
        }
    }

}
