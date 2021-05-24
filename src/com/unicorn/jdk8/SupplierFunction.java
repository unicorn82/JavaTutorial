package com.unicorn.jdk8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SupplierFunction {

    public SupplierFunction(){
        logger.setLevel(Level.INFO);
    }



    private final static Logger logger = Logger.getLogger(SupplierFunction.class.getName());

    /**
     * expensive function to return log data
     * @return
     */
    private String getStatusData(){
        logger.info("function getStatusData is being called");
        return "status message returned";

    }

    public void logStatusData(){
        logger.info("Setting log level to 'info', getStatusData function is also called. ");
        logger.finest(getStatusData());
    }

    public void logStatusDataBySupplier(){
        logger.info("Setting log level to 'info', getStatusData function is NOT called due to supplier function used. ");
        logger.finest(()-> getStatusData());
        logger.finest(this::getStatusData);}
}
