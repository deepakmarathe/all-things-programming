package com.deepakm.impl.modes;

import com.deepakm.impl.Degree;
import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;

/**
 * Created by dmarathe on 11/8/16.
 */
public class Dorian extends AbstractMode {

    @Override
    public Key[] getKeys(Key key) {
        Scale scale = getScale();
        Key[] keys = scale.getForNote(key);
        keys[Degree.III.getDegree()] = scale.getKeyOfDegree(key, Degree.III).next(-1);
        keys[Degree.VII.getDegree()] = scale.getKeyOfDegree(key, Degree.VII).next(-1);
        return keys;
    }
}
