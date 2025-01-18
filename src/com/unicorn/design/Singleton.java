package com.unicorn.design;

public class Singleton {

    private static Singleton instance = null;

    private String member = "This is a member sample";

    public String getMember(){
        return member;
    }

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1.getMember());
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton3 = Singleton.getInstance();

        System.out.println("singleton1 code="+singleton1.hashCode()+" singleton2 code="+singleton2.hashCode()+" singleton3 code="+singleton3.hashCode());
    }
}
