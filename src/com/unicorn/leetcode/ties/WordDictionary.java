package com.unicorn.leetcode.ties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WordDictionary {
    class TrieNode {
        String val;
        TrieNode[] children;
        boolean isWordEnd;



        public TrieNode(String val){
            this.val = val;
            children = new TrieNode[26];
            isWordEnd = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode(" ");


    }

    public void addWord(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++){
            TrieNode child = node.children[chars[i]-'a'];

            if(child == null){
                child = new TrieNode(String.valueOf(chars[i]));
                node.children[chars[i]-'a'] = child;
            }
            node = child;
        }
        node.isWordEnd = true;

    }

    public boolean search(String word) {
        TrieNode node = root;

        char[] chars = word.toCharArray();
        return searchSingleChar(chars, 0, node);


    }

    private boolean searchSingleChar(char[] chars, int index, TrieNode node){
        if(index < chars.length){
            char target = chars[index];
            if(target == '.'){
                TrieNode[] children = node.children;
                boolean isMatch = false;
                for(TrieNode child: children){
                    if(child != null){
                        if(searchSingleChar(chars, index+1, child)){
                            isMatch = true;
                        }

                    }
                }
                return isMatch;

            }else{
                TrieNode child = node.children[target-'a'];
                if(child != null){
                    return searchSingleChar(chars, index+1, child);
                }else{
                    return false;
                }

            }
        }
        return node.isWordEnd;


    }

}
