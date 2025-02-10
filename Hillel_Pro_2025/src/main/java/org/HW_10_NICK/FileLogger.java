package org.HW_10_NICK;

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


        log(LoggingLevel.DEBUG, message);

    }

    public void info(String message) {


        log(LoggingLevel.INFO, message);
    }


    private void log(LoggingLevel level, String message) {
        if (!configuration.getLevel().includeLevel(level)) return;

        File logFile = new File(configuration.getFileName());


        if (logFile.length() >= configuration.getSizeFile()) {
            try {
                throw new FileMaxSizeReachedException("MaxSizeFile is: " + configuration.getSizeFile() +
                        " Current SizeFile is: " + logFile.length());
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();

            }
            logFile = createNewLogFile();

        }

        String logMessage = String.format("[%s][%s] %s%n",
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                level, message);

        try (FileWriter wr = new FileWriter(logFile, true)) {
            wr.write(logMessage);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи в лог-файл: " + e.getMessage());
        }
    }


    private File createNewLogFile() {
        String newFileName = configuration.getFileName().replace(".txt", "") +
                "_" + new SimpleDateFormat("dd.MM.yyyy-HH:mm").format(new Date()) + ".txt";
        return new File(newFileName);
    }
}

