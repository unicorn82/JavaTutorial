package com.unicorn.leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ladder = 1;
        if(!wordList.contains(endWord)){ return 0; }
        Queue<String> queue = new LinkedList();
        HashSet<String> hash = new HashSet();
        Map<String, List<String>> adjacentMap = new HashMap();
        Map<String, List<String>> patternsMap = new HashMap();
        wordList.add(beginWord);
        hash.add(beginWord);
        for(String word: wordList){
            List<String> patterns = getPattern(word, patternsMap);
            for(String pattern: patterns){
                List<String> adjacents = adjacentMap.getOrDefault(pattern, new ArrayList<>());
                adjacents.add(word);
                adjacentMap.put(pattern, adjacents);
            }

        }
        queue.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String word = queue.poll();
                if(word.equals(endWord)){
                    return ladder;
                }
                findAdjacent(word, queue, hash, wordList, adjacentMap,patternsMap);
            }
            ladder++;

        }
        return 0;


    }

    private List<String> getPattern(String word, Map<String, List<String>> patternsMap){
        List<String> patterns = new ArrayList();
        for(int i=0;i<word.length();i++){
            StringBuilder sb = new StringBuilder(word);
            sb.setCharAt(i, '*');
            patterns.add(sb.toString());
        }
        patternsMap.put(word, patterns);
        return patterns;
    }

    private void findAdjacent(String word, Queue queue, HashSet hash, List<String> wordList, Map<String, List<String>> adjacentMap, Map<String, List<String>> patternsMap){
        List<String> patterns = patternsMap.get(word);
        for(String pattern: patterns){
            List<String> adjacents = adjacentMap.get(pattern);
            for(String next: adjacents){
                if(!hash.contains(next) && !word.equals(next)){
                    hash.add(next);
                    queue.add(next);
                }
            }
        }


        // for(String next: wordList){
        //     if(!hash.contains(next) && isAdjacent(word, next)){
        //         hash.add(next);
        //         queue.add(next);
        //     }
        // }
    }









    private boolean isAdjacent(String word1, String word2){
        int diff = 0;
        char[] charWord1 = word1.toCharArray();
        char[] charWord2 = word2.toCharArray();
        for(int i=0;i <charWord1.length;i++){
            if(charWord1[i] != charWord2[i]){
                diff ++;
            }
        }
        return diff == 1;

    }

    public static void main(String[] args) {
        String[] strs = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> list = new ArrayList<>();
        for(String str: strs){
            list.add(str);
        }
        LadderLength l = new LadderLength();
        l.ladderLength("hit","cog", list);
    }
}
