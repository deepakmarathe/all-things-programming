package com.deepakm.impl.instrument.guitar;

import com.deepakm.impl.Key;


/**
 * Created by dmarathe on 11/9/16.
 */
public class FretPosition {


    private int stringNumber;
    private int fretPosition;

    public Key getNote() {
        return note;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FretPosition that = (FretPosition) o;

        if (stringNumber != that.stringNumber) return false;
        return fretPosition == that.fretPosition;
    }

    @Override
    public int hashCode() {
        int result = stringNumber;
        result = 31 * result + fretPosition;
        return result;
    }

    public boolean isFeasible(FretPosition other) {
        return (Math.abs(this.getFretPosition() - other.getFretPosition()) <= 3 ) &&
                (getStringNumber() != other.getStringNumber());
    }

    @Override
    public String toString() {
        return note.toString() + ":(" + stringNumber + "," + fretPosition + ")";
    }
}
