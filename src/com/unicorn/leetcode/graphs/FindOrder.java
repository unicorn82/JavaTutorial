package com.unicorn.leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] results = new int[0];
        List<List<Integer>> courses = new ArrayList();
        for(int i=0; i< numCourses;i++){
            List<Integer> preCourses = new ArrayList();
            courses.add(preCourses);
        }
        for(int[] prerequisit: prerequisites){
            courses.get(prerequisit[0]).add(prerequisit[1]);

        }
        int[] visited = new int[numCourses];
        List<Integer> list = new ArrayList();
        for(int i=0; i< numCourses;i++){
            if(!validate(courses, i, visited, list)){
                return results;
            }

        }

        results = list.stream().mapToInt(Integer::intValue).toArray();
        return results;


    }

    private boolean validate(List<List<Integer>> courses,  int val, int[] visited, List<Integer> list){

        if(visited[val] == 1){
            return false;
        }
        if(visited[val] == 2){
            return true;
        }

        visited[val] = 1;


        for(int nextCourse: courses.get(val)){
            if(!validate(courses,  nextCourse, visited, list)){
                return false;
            }

        }
        visited[val] = 2;
        list.add(val);


        return true;
    }
}
