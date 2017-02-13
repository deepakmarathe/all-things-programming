package com.deepakm.ui;

import com.deepakm.impl.instrument.guitar.FretPosition;

import javax.swing.table.DefaultTableModel;
import java.util.Set;

/**
 * Created by dmarathe on 11/14/16.
 */
public class GuitarTableModel extends DefaultTableModel {
    public GuitarTableModel(Set<FretPosition> fretPositions) {
        Object[][] model = new Object[6][12];
        for(FretPosition fretPosition : fretPositions){
            model[fretPosition.getStringNumber()-1][fretPosition.getFretPosition()] = fretPosition;
        }
        setDataVector(model, null);
    }
}
