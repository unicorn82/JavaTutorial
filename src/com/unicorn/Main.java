package com.unicorn;

import com.unicorn.jdk8.InternalIteration;
import com.unicorn.jdk8.SupplierFunction;

import java.util.Random;
import java.util.logging.Logger;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        InternalIteration interation = new InternalIteration();
        logger.info("Find Max Score: "+interation.findMaxScore());


    }
}
