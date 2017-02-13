package com.deepakm.impl.modes;

import com.deepakm.impl.Degree;
import com.deepakm.impl.Key;
import com.deepakm.impl.Scale;

/**
 * Created by dmarathe on 11/8/16.
 */
public abstract class AbstractMode implements Mode {
    protected Scale scale;
//    protected Key key = null;

    //    public AbstractMode(Scale scale, Key key) {
//        this.key = key;
//        this.scale = scale;
//    }

    public AbstractMode(){
        this(Scale.MAJOR);
    }

    public AbstractMode(Scale scale) {
//        this.key = key;
        this.scale = scale;
    }

    @Override
    public Scale getScale() {
        return this.scale;
    }

    public Key getKeyOfDegree(Key key, Degree degree) {
        return getKeys(key)[degree.getDegree()];
    }

}
