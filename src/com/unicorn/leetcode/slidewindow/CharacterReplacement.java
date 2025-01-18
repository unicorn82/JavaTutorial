package com.unicorn.leetcode.slidewindow;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int max = 0;
        int start = 0;
        int end = 0;
        int[] letters = new int[26];

        while(start < s.length() && end < s.length()){
            letters[s.charAt(end) - 'A']++;
            //validation
            boolean validate = isValidate(letters, end-start+1, k);
            if(validate){

                max = Math.max((end -start+1), max);
                end ++;

            }else {
                //invalidation
                letters[s.charAt(start) - 'A'] --;
                letters[s.charAt(end) - 'A']--;
                start ++;

            }
        }

        return max;

    }



    private boolean isValidate(int[] letters, int length, int k){
        int m = 0;
        for(int l: letters){
            m = Math.max(m, l);
        }
        return !((length - m) > k);
    }

    public int characterReplacement1(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        CharacterReplacement c = new CharacterReplacement();
        System.out.println(c.characterReplacement(s, k));
    }
}
