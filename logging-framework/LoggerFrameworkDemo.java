import enums.LogLevel;
import interfaces.ConsoleAppender;
import interfaces.FileAppender;
import models.LoggerConfig;

public class LoggerFrameworkDemo {
    public static void run(){
        Logger logger = Logger.getInstance();
        logger.info("This is an information message");
        logger.error("This is an error message");
        logger.warn("This is a warning message");


        LoggerConfig loggerConfig = new LoggerConfig(LogLevel.ERROR, new ConsoleAppender());
        logger.setConfig(loggerConfig);
        
        logger.info("This is an information message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");

        LoggerConfig loggerConfig2 = new LoggerConfig(LogLevel.INFO, new FileAppender("log.txt"));
        logger.setConfig(loggerConfig2);

        logger.info("This is a new information message");
        logger.warn("This is a new warning message");

    }
}
