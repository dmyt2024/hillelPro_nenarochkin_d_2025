package org.lesson_10_addHwNick;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.format;


public class FileLogger {
    private FileLoggerConfiguration configuration;

    public FileLogger(FileLoggerConfiguration config) {

        this.configuration = config;
    }

    public void debug(String message) {

        try {
            log(LoggingLevel.DEBUG, message);
        } catch (FileMaxSizeReachedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void info(String message) {

        try {
            log(LoggingLevel.INFO, message);
        } catch (FileMaxSizeReachedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void log(LoggingLevel level, String message) throws FileMaxSizeReachedException, IOException {
        if (!configuration.getLevel().includeLevel(level)) {
            return;
        }

        File logFile = new File(configuration.getFileName());

        if (logFile.exists() && logFile.length() >= configuration.getSizeFile()) {
            try {
                throw new FileMaxSizeReachedException("MaxSizeFile is: " + configuration.getSizeFile() +
                        " Current SizeFile is: " + logFile.length());
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();

            }
            logFile = createNewLogFile();

        }


        String logMessage = format("[%s][%s] %s%n",
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()),
                level, message);

        try (PrintWriter writer = new PrintWriter(new FileWriter(logFile, true))) {

            writer.write(logMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private File createNewLogFile() {
        String newFileName = configuration.getFileName().replace(".txt", "") +
                "_" + new SimpleDateFormat("dd.MM.yyyy-HH:mm").format(new Date()) + ".txt";
        return new File(newFileName);
    }
}

