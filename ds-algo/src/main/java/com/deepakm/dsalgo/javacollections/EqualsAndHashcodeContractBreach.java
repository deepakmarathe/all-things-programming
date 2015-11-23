package com.deepakm.dsalgo.javacollections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmarathe on 11/23/15.
 */
public class EqualsAndHashcodeContractBreach {
    /**
     * sample immutable class to be used as key in hashmap.
     * The equals and hashcode do not agree to the contracts :
     *  1. If two objects are equal, they return the same hashcode.
     *  2. Two objects with same hashcode might not be equal.
     */
    class Key {

        public int a;
        public int b;

        public Key(int a, int b){
            this.a = a;
            this.b = b;
        }
//        @Override
//        public int hashCode(){
//            return a;
//        }

        @Override
        public boolean equals(Object o){
            if( this == o ) return true;
            if( o == null || o.getClass() != getClass()) return false;
            Key other = (Key)o;
            return other.b == b;
        }
    }

    public void testHashMapWillNotFunctionWhenEqualsAndHashcodeContractNotHonored(){
        Map<Key, String> map = new HashMap<>();

        map.put(new Key(10, 20), "test");
        System.out.println(map.containsKey(new Key(10, 20)));
    }

    public static void main(String[] args) {
        new EqualsAndHashcodeContractBreach().testHashMapWillNotFunctionWhenEqualsAndHashcodeContractNotHonored();
    }
}
