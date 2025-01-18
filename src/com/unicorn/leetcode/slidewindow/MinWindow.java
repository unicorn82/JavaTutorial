package com.unicorn.leetcode.slidewindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWindow {

    public String minWindow(String s, String t) {
        if(s.length() < t.length()){return "";}
        Map<String, Integer> letters = new HashMap();
        int match = 0;
        for(int i = 0;i<t.length();i++){
            String key_t = String.valueOf(t.charAt(i));
            int count_t = 0;
            if(letters.containsKey(key_t)){
                count_t = letters.get(key_t);
            }
            letters.put(key_t, ++count_t);

        }
        match = letters.size();

        int start = 0;
        String result = "";
        for(int end = 0; end < s.length(); end++){
            String key_end = String.valueOf(s.charAt(end));
            if(letters.containsKey(key_end))
            {
                int count_end = letters.get(key_end);
                letters.put(key_end, --count_end);
                if(count_end == 0)
                {
                    match--;

                    while(match == 0){
                        result = (result.length() == 0 || (end-start+1)<result.length())? s.substring(start, end+1): result;
                        String key_start = String.valueOf(s.charAt(start));
                        if(letters.containsKey(key_start)){
                            int count_start = letters.get(key_start);
                            letters.put(key_start, ++count_start);
                            if(count_start == 1){
                                match++;
                            }

                        }

                        start++;


                    }
                }

            }


        }
        return result;

    }


    public String minWindow3(String s, String t) {
        if(s.length() < t.length()){return "";}
        int[] letters = new int[52];
        int match = 0;
        for(int i = 0;i<t.length();i++){
            int t_index = getIndex(t.charAt(i));
            letters[t_index]++;



        }
        for(int i=0;i<letters.length;i++){
            if(letters[i] > 0){
                match ++;
            }
        }

        int start = 0;
        String result = "";
        for(int end = 0; end < s.length(); end++){

            if(--letters[getIndex(s.charAt(end))] == 0  )
            {
                match--;

                while(match == 0){
                    result = (result.length() == 0 || (end-start+1)<result.length())? s.substring(start, end+1): result;

                    if(++letters[getIndex(s.charAt(start))] ==1){
                        match ++;
                    }
                    start++;


                }

            }


        }
        return result;

    }
    public String minWindow2(String s, String t) {
        if(s.length() < t.length()){return "";}
        int[] letters = new int[52];
        for(int i = 0;i<t.length();i++){
            int t_index = getIndex(t.charAt(i));
            letters[t_index]++;
            int s_index = getIndex(s.charAt(i));
            letters[s_index]--;

        }
        if(isZero(letters)){return s.substring(0, t.length());}

        int start = 0;
        String result = s;
        for(int end = t.length();end < s.length(); end++){
            // while(letters[getIndex(s.charAt(end)) <= 0]){
            //     end++;
            // }


            letters[getIndex(s.charAt(end))]--;
            if(isZero(letters))
            {
                result = (end-start+1)<result.length()? s.substring(start, end+1): result;
                while(isZero(letters)){
                    letters[getIndex(s.charAt(start))]++;
                    result = (end-start+1)<result.length()? s.substring(start, end+1): result;
                    start++;


                }
            }


        }
        return result;

    }

    private boolean isZero(int[] letters){

        for(int l : letters){
            if(l > 0){
                return false;
            }

        }
        return true;
    }

    public int getIndex (char c){
        return c >= 'a'? c-'a'+26: c-'A';
    }



    public String minWindow4(String s, String t) {
        String result = "";
        Integer[] target = new Integer[52];
        for(char c : t.toCharArray()){
            if(target[getPos(c)] == null){
                target[getPos(c)] = 0;
            }
            target[getPos(c)]++;
        }
        List<int[]> positions = new ArrayList<>();
        char[] s_chars = s.toCharArray();
        for(int i=0;i<s_chars.length;i++){
            if(target[getPos(s_chars[i])] != null){
                positions.add(new int[]{i,getPos(s_chars[i])});
            }
        }
        int l_index = 0;


        int match = t.length();
        for(int i=0;i<positions.size();i++){
            int[] r = positions.get(i);
            if(--target[r[1]]>=0) match--;
            while(match == 0){ //substring
                int[] l = positions.get(l_index);
                if( (r[0]-l[0]+1) < result.length() || result.length() == 0 ){
                    result = s.substring(l[0], r[0]+1);
                }
                if(++target[l[1]] >0) match++;
                l_index++;


            }
        }
       
        return result;




    }

    private boolean validate(Integer[] target){
        for(Integer t:target){
            if( t != null && t > 0) return false;
        }
        return true;
    }

    private int getPos(char c){
        if(c >= 'A' && c<= 'Z') return c-'A';
        return c-'a'+26;
    }

    public static void main(String[] args) {
//        String s = "ADOBECODEBANC", t = "ABC";
//        System.out.println(s.substring(0, 6));
//        MinWindow m = new MinWindow();
//        System.out.println(m.getIndex('a'));
//        System.out.println(m.minWindow4(s, t));
//
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();

        map1.put("key0", 0L);
        map1.put("key1", 1L);
        map1.put("key2", 2L);

        Long test = 0L;
        for(int i=0;i<3;i++){
            map2.put("key"+i, test);
            test = (Long)map1.get("key"+i);
            test = 5L;

        }

    }
}
