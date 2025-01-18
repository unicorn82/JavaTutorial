package com.unicorn.algorithm;


import org.junit.jupiter.api.Assertions;

public class Hash {

    public int partialMatch(String s_text, String l_text){
        int s_length = s_text.length();
        int s_hash = s_text.hashCode();
        int length = l_text.length();
        for (int i = 0; i < l_text.length()-s_length+1; i++) {
            String partial = l_text.substring(i, i+s_length);

            if(partial.hashCode() == s_hash){
                return i;
            }

        }

        return 0;

    }

    public static void main(String[] args) {
        String s = "1234";
        String l = "dksoqkeqk1dsp12kdd1234kdkos";

        Hash h = new Hash();
        int s_index = h.partialMatch(s, l);
        Assertions.assertEquals(s, l.substring(s_index, s_index+s.length()));
        System.out.println(l.substring(s_index, s_index+s.length()));


    }
}
