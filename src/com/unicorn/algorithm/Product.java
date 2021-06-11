package com.unicorn.algorithm;

import com.unicorn.utils.CollectionsUtils;

public class Product {

    private void refactNum(int[] a, int[] a1, int[] a2){
        //if(a.length>1) {

            for (int i = 0; i <a.length ; i++) {
                if(i<a1.length){
                    a1[i] = a[i];
                }else {
                    a2[i-a1.length] = a[i];
                }
            }
        //}
    }



    public int[] arraySum(int[] a, int[] b){
        int len = a.length>b.length?a.length:b.length;
        int[] re = new int[len+1];
        int pos_a = a.length-1;
        int pos_b = b.length-1;
        int next = 0;
        for (int i = re.length-1; i >=0 ; i--) {
            int n1 = pos_a<0? 0:a[pos_a];
            int n2 = pos_b<0? 0: b[pos_b];
            int num = n1 + n2 + next;
            re[i] = num%10;
            next = num/10;
            pos_a --;
            pos_b --;
        }
        return re;
    }

    public int[] arrayMulti(int a, int b){
        int[] result = new int[2];
        if(a<10 && b<10){
            int num = a*b;
            result[0] = num/10;
            result[1] = num%10;

        }
        return result;
    }

    public int[] recursivelyProduct(int[] a, int[] b){

        if(a.length == 1 && b.length == 1){
            return arrayMulti(a[0], b[0]);
        }else if(a.length == 0 || b.length == 0){
            return new int[]{0};
        }

        int[] a1, a2, b1, b2;

        a1 = new int[a.length / 2];
        a2 = new int[a.length - a.length / 2];
        int an = a.length - a.length / 2;


        b1 = new int[b.length / 2];
        b2 = new int[b.length - b.length / 2];
        int bn = b.length - b.length / 2;
        refactNum(a, a1, a2);
        refactNum(b, b1, b2);


        int[] result1 = powerOfTen(recursivelyProduct(a1,b1), (an+bn));
        int[] result2 = powerOfTen(recursivelyProduct(a1,b2), (an));
        int[] result3 = powerOfTen(recursivelyProduct(a2,b1), (bn));
        int[] result4 = recursivelyProduct(a2,b2);
        return arraySum(arraySum(arraySum(result1, result2),result3),result4);




    }


    public int[] powerOfTen(int[] nums, int pow) {
        int[] new_nums = new int[nums.length+pow];
        for (int i = 0; i < new_nums.length; i++) {
            if(i<nums.length){
                new_nums[i] = nums[i];
            }else {
                new_nums[i] = 0;
            }

        }


        return new_nums;
    }


    public int[] regularProduct(int[] a, int[] b){
        int a_length = a.length;
        int b_length = b.length;
        int[] results = new int[b_length+a_length+1];
        int result_length = results.length;
        int level = 0;
        for (int i = a_length-1; i>=0 ; i--) {
            int[][] step = new int[a_length][b_length+1];
            int next = 0;
            for (int j = b_length-1; j>=0 ; j--) {
                int m1 = a[i] * b[j] + next;
                next = m1/10;
                step[level][j+1] = m1%10;
                if(j==0){
                    step[level][0] = next;
                }
            }
            int pos = 0;
            int r_next = 0;
            for(int k=step[level].length-1;k>=0;k--){
                int r_pos = result_length-1-pos-level;
                int temp = results[r_pos] + step[level][k] + r_next;
                results[r_pos] = temp % 10;
                r_next = temp/10;
                pos++;

            }
            level++;
        }
        return results;

    }


    public static void main(String[] args) {


        Product p = new Product();
        int[] a = new int[]{1,2,3,4};
        int[] b = new int[]{5,6,7,8,9};
        CollectionsUtils.printArray(p.recursivelyProduct(a, b));
//        CollectionsUtils.printArray(p.regularProduct(a,b));

//        int[] a = new int[]{1,2,3,4,5};
//        int[] b = new int[]{1,3,6};

//        p.recursivelyProduct(a,b);
//        CollectionsUtils.printArray(p.regularProduct(a,b));

    }
}
