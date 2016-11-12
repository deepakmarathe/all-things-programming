package com.deepakm.ui;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 * Created by dmarathe on 11/10/16.
 */
public class RadioButtonRenderer implements TableCellRenderer {
    JRadioButton button;

    public RadioButtonRenderer() {
        this.button = new JRadioButton();
        this.button.setSelected(Boolean.TRUE);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        System.out.println(value);
        Object val = table.getModel().getValueAt(row, column);
        if (val == null) return new JLabel(String.valueOf(val));
        button.setText(String.valueOf(val));
        return button;
    }
}
