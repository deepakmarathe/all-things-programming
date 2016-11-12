package com.deepakm.guitar;

import com.deepakm.impl.Key;


/**
 * Created by dmarathe on 11/9/16.
 */
public class FretPosition {
    private int stringNumber;
    private int fretPosition;
    private Key note;

    public FretPosition(int stringNumber, int fretPosition, Key note) {
        this.stringNumber = stringNumber;
        this.fretPosition = fretPosition;
        this.note = note;
    }

    public int getStringNumber() {
        return stringNumber;
    }

    public void setStringNumber(int stringNumber) {
        this.stringNumber = stringNumber;
    }

    public int getFretPosition() {
        return fretPosition;
    }

    public void setFretPosition(int fretPosition) {
        this.fretPosition = fretPosition;
    }

    @Override
    public String toString() {
        return note.toString() + ":(" + stringNumber + "," + fretPosition + ")";
    }
}
