package com.unicorn.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Student {
    private Double score;
    private Integer gradeYear;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(Integer gradeYear) {
        this.gradeYear = gradeYear;
    }
}


public class InternalIteration {

    private List<Student> students = new ArrayList<>();
    private int sizeOfStudent = 1000;
    private final int targetYear = 2011;
    private final int minYear = 2010;
    private final int maxYear = 2015;
    private double maxScore = 0.0;
    private Random rand = new Random();

    public InternalIteration(){
        for(int i=0;i<sizeOfStudent;i++){
            students.add(generateRandomStudent());
        }



    }

    private Student generateRandomStudent(){
        Student student = new Student();
        student.setGradeYear(generateRandomGradeYear());
        student.setScore(generateRandomScore());
        return student;
    }

    private Integer generateRandomGradeYear(){
        return rand.nextInt(maxYear-minYear+1)+minYear;
    }

    private Double generateRandomScore(){
        double min = 50;
        double max = 100;
        return min + (max - min) * rand.nextDouble();
    }



    public Double findMaxScore(){
        for(Student student: students){
            if(student.getGradeYear() == targetYear){
                if(student.getScore()>maxScore){
                    maxScore = student.getScore();
                }
            }
        }
        return maxScore;
    }

//    public Double findMaxScoreLambda(){
//
//    }





}
