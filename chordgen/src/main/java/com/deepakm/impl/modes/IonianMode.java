package com.deepakm.impl.modes;

import com.deepakm.impl.Degree;
import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;

/**
 * Created by dmarathe on 11/8/16.
 */
public class IonianMode extends AbstractMode {

    @Override
    public Key[] getKeys(Key key) {
        Scale scale = getScale();
        Key[] keys = scale.getForNote(key);
        return keys;
    }

}
