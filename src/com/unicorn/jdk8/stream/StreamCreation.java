package com.unicorn.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b","c");
        Stream<String> stream = list.stream();//Create a sequential stream
        Stream<String> parallelStream = list.parallelStream(); //Create a parallel steam

        int[] array = {1,3,5,8};
        IntStream intStream = Arrays.stream(array);




    }
}
