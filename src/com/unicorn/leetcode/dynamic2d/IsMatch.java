package com.unicorn.leetcode.dynamic2d;

public class IsMatch {

    public boolean isMatch(String s, String p) {
        Boolean[][] cache = new Boolean[s.length()+1][p.length()+1];
        return match(s, p, 0, 0, cache);
    }

    private boolean match(String s, String p, int in_s, int in_p, Boolean[][] cache){

        if(cache[in_s][in_p] != null) return cache[in_s][in_p];
        if(in_s >= s.length() && in_p >= p.length() ) {return true;} //

        if(in_p >= p.length())  {return false;}

        boolean isMatch = in_s < s.length() && (s.charAt(in_s) == p.charAt(in_p) || p.charAt(in_p) == '.');
        if(in_p +1 < p.length() && p.charAt(in_p+1) == '*'){ //next is *
            cache[in_s][in_p] = match(s, p, in_s, in_p+2, cache) || (isMatch && match(s, p, in_s+1, in_p, cache));

        }else{
            cache[in_s][in_p] = isMatch && match(s, p, in_s+1, in_p+1, cache);
        }


        return cache[in_s][in_p];
    }
}
