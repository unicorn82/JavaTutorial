package com.unicorn.leetcode.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class Anagram {

    public boolean isAnagram1(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0).intValue()+1);
        }
        for(char c: t.toCharArray()){
            if(!map.containsKey(c)) return false;
            map.put(c, map.get(c).intValue()-1);
        }
        for(int r: map.values()){
            if(r != 0) return false;
        }

        return true;


    }

    public boolean isAnagram(String s, String t) {

        int[] alphebets = new int[26];
        for(int i=0; i<s.length();i++){
            alphebets[s.charAt(i)-'a'] += 1;
        }
        for(int i=0;i<t.length();i++){
            alphebets[t.charAt(i)-'a'] -= 1;
        }
        for(int i=0;i<alphebets.length;i++){
            if(alphebets[i] !=0){
                return false;
            }
        }
        return true;


    }

    public static void main(String[] args) {
        Anagram a = new Anagram();
        System.out.println(a.isAnagram("anagram", "nagaram"));
        System.out.println(a.isAnagram("rat", "cat"));
        System.out.println(a.isAnagram("a", "ab"));
    }


}
