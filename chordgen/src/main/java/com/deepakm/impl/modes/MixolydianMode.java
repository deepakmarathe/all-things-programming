package com.deepakm.impl.modes;

import com.deepakm.impl.Degree;
import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;

/**
 * Created by dmarathe on 11/8/16.
 */
public class MixolydianMode extends AbstractMode {

    @Override
    public Key[] getKeys(Key key) {
        Scale scale = getScale();
        Key[] keys = scale.getForNote(key);
        Degree degree = Degree.VII;
        keys[degree.getDegree()] = scale.getKeyOfDegree(key, Degree.IV).next(-1);
        return keys;
    }
}
