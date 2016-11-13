package com.deepakm.ui;

import com.deepakm.impl.Key;
import com.deepakm.impl.instrument.guitar.FretPosition;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by dmarathe on 11/10/16.
 */
public class RadioButtonRenderer implements TableCellRenderer {
    JRadioButton button;
    Key key;

    public RadioButtonRenderer(Key key) {
        this.button = new JRadioButton();
        this.button.setSelected(Boolean.FALSE);
        this.key = key;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        System.out.println(value);
        Object val = table.getModel().getValueAt(row, column);

        if (val == null) {
            return new JLabel(String.valueOf(""));
        } else {
            JRadioButton button = new JRadioButton();
            if( val instanceof FretPosition){
                if( ((FretPosition)val).getNote() == key) {
                button.setSelected(Boolean.TRUE);
                }
            }
            button.setText(String.valueOf(val));
            return button;
        }
    }
}
