package com.unicorn.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] cache = new Boolean[s.length()];

        return wordBreak(s, 0, wordDict, cache);

    }

    private boolean wordBreak(String s, int left, List<String> wordDict, Boolean[] cache){
        if(left == s.length() ) return true;
        if(cache[left] != null) return cache[left];

        for(int i=0;i<wordDict.size();i++){
            String word = wordDict.get(i);
            if(s.startsWith(word, left) && wordBreak(s, left+word.length(), wordDict, cache)){
                cache[left] = true;
                return true;
            }
        }
        cache[left] = false;
        return false;

    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();

    }


}
