package com.unicorn.leetcode.graphs;

import java.util.ArrayList;
import java.util.List;



public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList();
        for(int i=0; i< numCourses;i++){
            List<Integer> preCourses = new ArrayList();
            courses.add(preCourses);
        }
        for(int[] prerequisit: prerequisites){
            courses.get(prerequisit[0]).add(prerequisit[1]);

        }
        int[] visited = new int[numCourses];
        for(int i=0; i< numCourses;i++){
            if(!validate(courses, i, visited)){
                return false;
            }


        }
        return true;


    }

    private boolean validate(List<List<Integer>> courses,  int val, int[] visited){

        if(visited[val] == 1){
            return false;
        }
        if(visited[val] == 2){
            return true;
        }

        visited[val] = 1;

        for(int nextCourse: courses.get(val)){
            if(!validate(courses,  nextCourse, visited)){
                return false;
            }
        }
        visited[val] = 2;

        return true;
    }

    public static void main(String[] args) {
        int[][] pres = new int[4][2];
        int[] p1 = new int[]{1,4};
        int[] p2 = new int[]{2,4};
        int[] p3 = new int[]{3,1};
        int[] p4 = new int[]{3,2};
        pres[0] = p1;
        pres[1] = p2;
        pres[2] = p3;
        pres[3] = p4;
        CanFinish c = new CanFinish();
        System.out.println(c.canFinish(5, pres));

    }
}
