package com.ip.y;


import com.ip.x.Log4J2XmlConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4J2XmlConfPackageTest {

    final Logger logger = LoggerFactory.getLogger(Log4J2XmlConfPackageTest.class);

    public void logAllLogLevel() {
        //fatal < Error < Warn < Info < Debug < Trace
        logger.trace("This is a trace message");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
//        logger.fatal("This is a fatal message");

    }

}
