package com.unicorn.leetcode.stack;

import java.util.*;

public class GenerateParenthesis {

    List<String> results = new ArrayList();
    int n;



    public List<String> generateParenthesis_backtrack(int n) {
        this.n = n;

        backtrack(0, 0, "");
        return results;

    }

    private void backtrack(int open, int close, String str){
        if(open == close && open == this.n){
            this.results.add(str);
            return;
        }
        if(open < n){
            backtrack(open+1, close,  str+"(");
        }
        if(close < open){
            backtrack(open, close+1, str+")");
        }

    }


    public List<String> generateParenthesis(int n) {
        Map<String, int[]> map = new HashMap();

        List<String> list = new ArrayList();
        list.add("(");
        map.put("(", new int[]{1,0});

        for(int i=1;i<2*n;i++){
            List<String> temp = new ArrayList();
            for(String str: list){
                int[] count = map.get(str);
                if(count[0] < n){
                    temp.add(str+"(");
                    map.put(str+"(", new int[]{count[0]+1, count[1]});
                }
                if(count[1] < count[0]){
                    temp.add(str+")");
                    map.put(str+")", new int[]{count[0], count[1]+1});
                }

            }
            list = temp;

        }


        return list;

    }


    public List<String> generateParenthesis_brutal(int n) {




        List<String> list = new ArrayList();
        list.add("(");
        for(int i=1;i<2*n;i++){
            List<String> temp = new ArrayList();
            for(String str: list){
                temp.addAll(appendOneParenthesis(str));
            }
            list = temp;

        }
        List<String> results = new ArrayList<>();
        for(String str: list){
            if(isValid(str)){
                System.out.println(str);
                results.add(str);
            }
        }

        return results;

    }

    private List<String> appendOneParenthesis(String str){
        List<String> newlist =  new ArrayList<String>();
        newlist.add(str+"(");
        newlist.add(str+")");

        return newlist;

    }

    private boolean isValid(String str){
        int count = 0;
        char[] chars = str.toCharArray();
        for(char c: chars){
            switch(c){
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
                default:
                    break;
            }
            if(count < 0){
                return false;
            }

        }
        return count ==0;
    }

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        g.generateParenthesis_backtrack(3);

        Map<String, int[]> map = new HashMap<>();
        int[] test = new int[]{4,3};
        map.put("test", test);
        System.out.println(map.get("test")[0]);
    }
}
