package com.deepakm.impl.instrument.guitar;

import com.deepakm.impl.Key;
import com.sun.org.apache.xml.internal.utils.ObjectPool;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Created by dmarathe on 11/14/16.
 */
public class DefaultGuitarTableModel {

    private static Object[][] tableModel = new Object[][]{
//            {Key.E, null, null, null, null, null, null, null, null, null, null, null},
//            {Key.B, null, null, null, null, null, null, null, null, null, null, null},
//            {Key.G, null, null, null, null, null, null, null, null, null, null, null},
//            {Key.D, null, null, null, null, null, null, null, null, null, null, null},
//
//            {Key.A, null, null, null, null, null, null, null, null, null, null, null},
//
//            {Key.E, null, null, null, null, null, null, null, null, null, null, null},

            {Key.E, null, null, null, null, null, null, null, null, null, null, null},
            {Key.A, null, null, null, null, null, null, null, null, null, null, null},
            {Key.D, null, null, null, null, null, null, null, null, null, null, null},
            {Key.G, null, null, null, null, null, null, null, null, null, null, null},
            {Key.B, null, null, null, null, null, null, null, null, null, null, null},
            {Key.E, null, null, null, null, null, null, null, null, null, null, null},
    };
    static String header[] = new String[]{
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
    };


    public static Object[][] getTableModel() {
        return tableModel;
    }

    public static String[] getHeader() {
        return header;
    }
}
