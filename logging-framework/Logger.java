import enums.LogLevel;
import interfaces.ConsoleAppender;
import models.LogMessage;
import models.LoggerConfig;

public class Logger {
    private static Logger instance;
    private LoggerConfig loggerConfig;
    private Logger() {
        loggerConfig = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());
    }

    public static Logger getInstance() {
        if (instance == null) {
            if(instance == null){
                synchronized (Logger.class){
                    if(instance == null){
                        instance = new Logger();
                    }
                }
            }
        }
        return instance;
    }

    public void setConfig(LoggerConfig loggerConfig) {
        this.loggerConfig = loggerConfig;
    }

    public void log(LogLevel logLevel, String message) {
        if (logLevel.ordinal() >= loggerConfig.getLogLevel().ordinal()) {
            LogMessage logMessage = new LogMessage(logLevel, message);
            loggerConfig.getLogAppender().append(logMessage);
        }
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}

