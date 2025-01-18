package com.unicorn.utils;

import java.util.List;

public class CollectionsUtils  {

    public  static void printArray(int[] arrays){
        System.out.println("");
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]+";");

        }
        System.out.println("");
    }

    public static <T> void printList(List<T> list1){
        for(int i=0;i<list1.size();i++){
            T s = list1.get(i);
            System.out.print(s+";");
        }
        System.out.println("");

    }
}
