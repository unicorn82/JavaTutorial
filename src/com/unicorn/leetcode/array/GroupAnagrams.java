package com.unicorn.leetcode.array;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> maps = new HashMap();
        for(String str: strs){ //O(n)
            int[] unicodes = new int[26];

            // List<Character> l = new ArrayList();

            for(char c: str.toCharArray()){
                unicodes[c-'a']++;
                // l.add(str.charAt(i));
            }

            // Collections.sort(l);
            // Integer key = Arrays.hashCode(unicodes);
            // String key = new String(unicodes);
            Integer key = Arrays.hashCode(unicodes);
            //Integer key = l.hashCode();
            if(!maps.containsKey(key)){
                List<String> list = new ArrayList();
                maps.put(key, new ArrayList());
            }
            maps.get(key).add(str);



        }

        return new ArrayList(maps.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] currentStr = strs[i].toCharArray();
            Arrays.sort(currentStr);
            String sortedStr = String.valueOf(currentStr);
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(strs[i]);
        }

        return new ArrayList<>(anagramMap.values());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c -'a']++;
//            String keyStr = String.valueOf(ca);
            String keyStr = new String(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }



    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams g = new GroupAnagrams();
        g.groupAnagrams1(strs);


        List<Character> l1 = new ArrayList();
        List<Character> l2 = new ArrayList();

        l1.add('e');
        l1.add('a');
        l1.add('t');

        l2.add('a');
        l2.add('e');
        l2.add('t');
        Collections.sort(l1);
        Collections.sort(l2);

        System.out.println(l1.hashCode() == l2.hashCode());

        int[] unicodes1 = new int[]{1,0,1};
        int[] unicodes2 = new int[]{1,0,1};


        System.out.println(Arrays.hashCode(unicodes1) == Arrays.hashCode(unicodes2));
//        System.out.println(unicodes1.hashCode() == unicodes2.equals());




    }
}
