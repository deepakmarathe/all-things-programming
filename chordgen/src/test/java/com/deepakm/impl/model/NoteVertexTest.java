package com.deepakm.impl.model;

import com.deepakm.impl.Key;


/**
 * Created by dmarathe on 11/10/16.
 */
public class NoteVertexTest {

    public void testGetFastCache() throws Exception {
        System.out.println();
        NoteVertex vertex;
        for (Key key : Key.values()) {
            vertex = NoteFactory.get(key);
            System.out.println("Test Begins : ");
            for (int i = 0; i < 12; i++) {
                System.out.println(vertex.getFastCache(i).getNote());
            }
            System.out.println("negative Test Begins : ");
            for (int i = 0; i > -11; i--) {
                System.out.println(vertex.getFastCache(i).getNote());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new NoteVertexTest().testGetFastCache();
    }
}