package com.unicorn.leetcode.array;

import com.unicorn.utils.CollectionsUtils;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {


    final String separator = ";;";
    public String encode1(List<String> strs) {
        String encode_str = "";

        for(String str: strs){
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);

                if(c >= 'a' && c<= 'z'){
                    c = (char)('z' - c + 'a');
                }else if(c >= 'A' && c<='Z'){
                    c = (char) ('Z' - c + 'A');
                }
                encode_str += c;

            }
        encode_str += separator;


        }
        return encode_str;

}

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode1(String str) {
        // write your code here

        String[] strs = str.split(separator);

        for(int s=0; s<strs.length;s++){
            String new_str = strs[s];
            System.out.println("new_str "+new_str);
            String decode_str = "";
            for(int i=0; i<new_str.length();i++){
                char c = new_str.charAt(i);

                if(c >= 'a' && c<= 'z'){
                    c = (char) ('z' - c + 'a');
                }else if(c >= 'A' && c<='Z'){
                    c = (char)('Z' - c + 'A');
                }
                decode_str += c;
            }
            strs[s] = decode_str;

        }
        return Arrays.asList(strs);
    }


    public String encode(List<String> strs) {
        // write your code here
        StringBuffer sb = new StringBuffer();
        for(String str: strs){
            sb.append("["+str.length()+"]").append(str);
        }
        return sb.toString();

    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> strs = new ArrayList<>();
        while(str.length() > 0){

            int length = Integer.parseInt(str.substring(1, str.indexOf("]", 0)));

            strs.add(str.substring(str.indexOf("]", 0)+1, str.indexOf("]", 0)+length+1));
            str = str.substring(str.indexOf("]", 0)+length+1);

        }
        return strs;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList(new String[]{"lintlintlintlintlintttttttttttt","codecodecodecodecodecodecodecode","lovelove","you"});
        EncodeDecode ed = new EncodeDecode();
        String encode = ed.encode(strs);
        System.out.println(encode);
        List<String> decodes = ed.decode(encode);
        CollectionsUtils.printList(decodes);
    }
}
