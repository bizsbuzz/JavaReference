package com.ip.x;


import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/*
https://springframework.guru/log4j-2-configuration-using-xml/
https://dzone.com/articles/asynchronous-logging-with-log4j-2
https://stackify.com/log4j-guide-dotnet-logging/
*/

@Getter
@Setter
public class Log4J2XmlConf {
    //     log4j2
    //    private static Logger logger = LogManager.getLogger();
    final Logger logger = LoggerFactory.getLogger(Log4J2XmlConf.class);
    private int newTemp;
    private int oldTemp;

    public Log4J2XmlConf(int newTemp, int oldTemp) {
        this.newTemp = newTemp;
        this.oldTemp= oldTemp;

    }

    public void logAllLogLevel() {
        //fatal < Error < Warn < Info < Debug < Trace
        logger.trace("This is a trace message");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
//        logger.fatal("This is a fatal message");

    }

    public void logVariousSyntax() {

        // You can also use parameterized messages:
        logger.info("The value of x is {}", 8);

        // You can add a marker to the log message:
        Marker myMarker = MarkerFactory.getMarker("MY_MARKER");
        logger.info(myMarker, "This is a message with a marker");


    }


    public void showTemperature() {
        //https://www.slf4j.org/manual.html#projectDep
        // using fluent API, log message with arguments
        logger.atDebug().log("Temperature set to {}. Old value was {}.", newTemp, oldTemp);
        // using fluent API, add arguments one by one and then log message
        logger.atDebug().setMessage("Temperature set to {}. Old value was {}.").addArgument(newTemp).addArgument(oldTemp).log();
        // using fluent API, add one argument with a Supplier and then log message with one more argument.
        logger.atDebug().setMessage("Temperature set to {}. Old value was {}.").addArgument(this.getNewTemp()).addArgument(() -> this.getOldTemp()).log();

        // using traditional API
        logger.debug("Temperature set to {}. Old value was {}.", newTemp, oldTemp);

        // using traditional API
        logger.debug("oldT={} newT={} Temperature changed.", oldTemp, newTemp);
        // using fluent API
        // FIXME This is not working as suggested
        logger.atDebug().setMessage("Temperature changed.").addKeyValue("oldTemp", oldTemp).addKeyValue("oldTemp", newTemp).log();


        if (newTemp > 50) {
            logger.debug("Temperature has risen above 50 degrees.");
        }
    }




}