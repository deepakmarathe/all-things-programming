package com.deepakm.vertica.udx.scalar;

/**
 * Created by dmarathe on 12/29/15.
 */
public class VowelRemover {
    public String removeVowels(String input){
        return input.replaceAll("(?i)[aeiouy]", "");
    }
}
