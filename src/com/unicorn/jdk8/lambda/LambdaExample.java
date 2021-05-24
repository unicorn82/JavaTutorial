package com.unicorn.jdk8.lambda;


@FunctionalInterface
interface Student {
    String getStudentInfo(String birthday);

}

//#1 Class implement FunctionInterface
class Telsa implements Student{

    @Override
    public String getStudentInfo(String birthday) {
        return "Nikola Tesla. Birthday: "+birthday;
    }
}

public class LambdaExample {
    String instanceVariable = "instance variable |";
    static String staticVariable = "static variable |";

    public void instancePrintFunction(){
        System.out.println("Instance function is being called");
    }

    static void staticPrintFunction(){
        System.out.println("Static function is being called");
    }

    Student student3 = (String birthday) ->{
        String localVariable = "local variable |";
//        private void localPrintFunction(){
//            System.out.println("Local function is beling called");
//
//        }
        instancePrintFunction();
        LambdaExample:staticPrintFunction();

        return "Stephen Hawking. Birthday: "+birthday +" | "+instanceVariable+" "+staticVariable+" "+localVariable;
    };


    public static void main(String[] args) {


        // #1 Create class
        String telsa_birthday = "July 10, 1856";
        Student student1 = new Telsa(); //Polymorphic Statment
        System.out.println("#1 Student Name "+ student1.getStudentInfo(telsa_birthday));

        // #2 Anonymous Class Implementation
        Student einstein = new Student() {

            @Override
            public String getStudentInfo(String birthday) {
                return "Albert Einstein. Birthday: "+birthday;
            }
        };
        String einsein_birthday = "March 14, 1879";
        System.out.println("#2 Student Name "+einstein.getStudentInfo(einsein_birthday));

        // #3 Lambda Expression
        String hawking_birthday = "January 8, 1942";
        LambdaExample example = new LambdaExample();
        System.out.println("#3 Student Name "+example.student3.getStudentInfo(hawking_birthday));

    }








}
