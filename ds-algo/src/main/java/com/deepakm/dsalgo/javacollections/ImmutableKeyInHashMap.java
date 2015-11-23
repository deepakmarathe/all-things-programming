package com.deepakm.dsalgo.javacollections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmarathe on 11/23/15.
 */

/**
 * Demonstration of the requirement of keys in hashmap to be immutable.
 * Otherwise, map llokup and other functionalities will not work as expected.
 */
public class ImmutableKeyInHashMap {

    /**
     * A sample mutable class, to be used as a key in hashmap.
     */
    class Key {
        public int a;

        @Override
        public int hashCode(){
            return a;
        }

        @Override
        public boolean equals(Object o){
            if( this == o ) return true;
            if( o == null || o.getClass() != getClass()) return false;
            Key other = (Key)o;
            return other.a == a;
        }

    }

    public void demonstrateMutableKeysWillRenderHashMapLookupsFail(){
        Key t = new Key();
        t.a = 10;
        Map<Key, String> m = new HashMap<>();
        m.put(t, "t");
        System.out.println( "map contains the object : " + m.containsKey(t));

        t.a = 20;
        System.out.println("changed the key object contents. hashmap will not rehash the object and hence," +
                " further lookups will return null on the same key. ");
        System.out.println("map contains the object : " + m.containsKey(t));
    }

    public static void main(String[] args) {
        new ImmutableKeyInHashMap().demonstrateMutableKeysWillRenderHashMapLookupsFail();
    }
}
