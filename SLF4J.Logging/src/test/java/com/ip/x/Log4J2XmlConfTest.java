package com.ip.x;

import com.ip.y.Log4J2XmlConfPackageTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
E:\Git\Java\JavaReference\SLF4J.Logging\src\test\resources\logs
 */

class Log4J2XmlConfTest {

    Log4J2XmlConf xmlConf = null;
    Log4J2XmlConfPackageTest packageTest = null;

    @BeforeEach
    void setUp() {

        xmlConf = new Log4J2XmlConf(75, 50);
        packageTest = new Log4J2XmlConfPackageTest();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void logAllLogLevel() {
        xmlConf.logAllLogLevel();
        packageTest.logAllLogLevel();
    }

    @Test
    void logVariousSyntax() {
        xmlConf.logVariousSyntax();
    }

    @Test
    void showTemperature() {
        xmlConf.showTemperature();
    }
}