package com.deepakm.impl.modes;

import com.deepakm.impl.Degree;
import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;

/**
 * Created by dmarathe on 11/8/16.
 */
public interface Mode {
    Scale getScale();

    Key[] getKeys(Key key);

    public Key getKeyOfDegree(Key key, Degree degree);
}
