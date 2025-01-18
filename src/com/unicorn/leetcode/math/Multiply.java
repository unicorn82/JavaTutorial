package com.unicorn.leetcode.math;

public class Multiply {

    public String multiply(String num1, String num2) {
        String result = "";
        if(num1.equals("0") || num2.equals("0")) return "0";
        int[] arrys = new int[num1.length()+num2.length()];
        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                int temp = convertInt(num1.charAt(num1.length()-i-1)) * convertInt(num2.charAt(num2.length()-j-1));
                arrys[i+j] += temp %10;

                arrys[i+j+1] += temp/10;
            }

        }

        for(int i=0;i<arrys.length-1;i++){
            if(arrys[i] > 9){
                arrys[i+1] += arrys[i] /10;
                arrys[i] = arrys[i] % 10;
            }
        }
        boolean isLeadingZero = true;
        for(int i=arrys.length-1;i>=0;i--){
            if(arrys[i] != 0) isLeadingZero = false;
            if(!isLeadingZero) result += arrys[i];

        }
        return result;

    }



    private int convertInt(char n){
        return n-'0';
    }

    public static void main(String[] args) {
        Multiply m = new Multiply();


    }
}
