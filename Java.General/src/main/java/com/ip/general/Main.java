package com.ip.general;


import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Playground.class);

    enum Function {
        LOGFILE, READFILEBYTOKEN, HASTOE, ISNULLOREMPTY, ARRAYS
    }

    public static void main(String[] args) {
        Playground playground = new Playground();
        Function fn = Function.ARRAYS;

        switch (fn) {
            case LOGFILE: {

                playground.zipLogFiles(playground.getLogFiles("DATA_PROCESSING", "C:\\birst\\Repositories\\data\\fd5b8a85-4f79-4535-bcac-4b96026cee15", String.format("%010d", 11)));
                break;
            }
            case READFILEBYTOKEN: {
                String filePath1 = "C:\\\\birst\\\\Repositories\\\\data\\\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\\\logs\\\\smiengine.PSC01-BQUC-S010.0000000011.log";
                System.out.println(playground.readFilebyToken(filePath1, "acbu793twywj4e"));
                break;

            }
            case HASTOE: {

                StopWatch watch = new StopWatch();
                watch.start();
                System.out.println("Is Toe acbu793twywj4e matching? " + playground.hasToe("C:\\birst\\Repositories\\data\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\logs\\smiengine.PSC01-BQUC-S010.0000000011.log", "acbu793twywj4e"));
                watch.stop();
                System.out.println("Time Elapsed: " + watch.getTime());
                watch.reset();
                watch.start();
                System.out.println("Is Toe acbu793twywj4e matching? " + playground.hasToe("C:\\birst\\Repositories\\data\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\logs\\smiengine.PSC01-BQUC-S012.0000000011.log", "acbu793twywj4e"));
                watch.stop();
                System.out.println("Time Elapsed: " + watch.getTime());
                watch.reset();
                watch.start();
                System.out.println("Is Toe acbu793twywj4e matching? " + playground.hasToe("C:\\birst\\Repositories\\data\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\logs\\smiengine.PSC01-BQUC-S0122.0000000011.log", "acbu793twywj4e"));
                watch.stop();
                System.out.println("Time Elapsed: " + watch.getTime());
                break;

            }
            case ISNULLOREMPTY: {

                String filePath1 = "C:\\\\birst\\\\Repositories\\\\data\\\\fd5b8a85-4f79-4535-bcac-4b96026cee15\\\\logs\\\\smiengine.PSC01-BQUC-S010.0000000011.log";
                System.out.println(playground.isNullOREmpty("acbu793twywj4e"));
                System.out.println(playground.isNullOREmpty(""));
                System.out.println(playground.isNullOREmpty(null));

                System.out.println(playground.isNullOREmpty(new File(filePath1), "acbu793twywj4e"));
//			System.out.println(isNullOREmpty("","acbu793twywj4e"));
                System.out.println(playground.isNullOREmpty(null, "acbu793twywj4e"));

                System.out.println("  ".isBlank());
                System.out.println("  ".isEmpty());

                break;

            }
            case ARRAYS: {
                playground.multidimensionalArrays();
                break;

            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + fn);
        }

    }
}

