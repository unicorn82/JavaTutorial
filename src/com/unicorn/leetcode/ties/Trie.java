package com.unicorn.leetcode.ties;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;

public class Trie {
    class TrieNode {
        String val;
        // Map<String, TrieNode> children;
        TrieNode[] children;
        boolean isWord;

        public TrieNode(){
            // this.val = val;
            isWord = false;
            children = new TrieNode[26];
            // children = new HashMap();
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();

    }

    public void insert(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(node.children[chars[i] - 'a'] == null){
                node.children[chars[i] - 'a'] = new TrieNode();
            }
            node = node.children[chars[i] - 'a'];

            // String key = String.valueOf(chars[i]);
            // if(node.children.containsKey(key)){
            //     node = node.children.get(key);
            // }else{
            //     TrieNode child = new TrieNode(key);
            //     node.children.put(key, child);
            //     node = child;
            // }

        }
        node.isWord = true;




    }



    public boolean search(String word) {
        TrieNode node = root;
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(node.children[chars[i] - 'a'] == null){
                return false;
            }
            node = node.children[chars[i] - 'a'];

            // String key = String.valueOf(chars[i]);
            // if(!node.children.containsKey(key)){
            //     return false;
            // }
            // node = node.children.get(key);
        }
        return node.isWord;



    }



    public boolean startsWith(String prefix) {
        TrieNode node = root;
        char[] chars = prefix.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(node.children[chars[i] - 'a'] == null){
                return false;
            }
            node = node.children[chars[i] - 'a'];
            // String key = String.valueOf(chars[i]);
            // if(!node.children.containsKey(key)){
            //     return false;
            // }
            // node = node.children.get(key);
        }
        return true;


    }
}
