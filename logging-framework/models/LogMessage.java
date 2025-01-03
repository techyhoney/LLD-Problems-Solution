package models;

import java.time.LocalDateTime;
import java.util.UUID;

import enums.LogLevel;

public class LogMessage {
    private LogLevel level;
    private String id;
    private String message;
    private LocalDateTime timestamp;

    public LogMessage(LogLevel level, String message) {
        this.id= UUID.randomUUID().toString();
        this.level = level;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public LogLevel getLevel() {
        return level;
    }
    
    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s", level, message, timestamp);
    }
    
}