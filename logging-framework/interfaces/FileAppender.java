package interfaces;

import java.io.FileWriter;
import java.io.IOException;

import models.LogMessage;

public class FileAppender implements LogAppender {
    String filePath;
    public FileAppender(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void append(LogMessage logMessage) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write(logMessage.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}