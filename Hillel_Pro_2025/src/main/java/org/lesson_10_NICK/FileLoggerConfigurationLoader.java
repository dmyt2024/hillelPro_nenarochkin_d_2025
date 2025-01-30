package org.lesson_10_NICK;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileLoggerConfigurationLoader {

    String file;
    LoggingLevel level;
    long sizeFile;
    String format;

    public FileLoggerConfiguration load(String fileName) {

        try (BufferedReader r = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = r.readLine()) != null) {
                String[] parts = line.split(": ");

                switch (parts[0].trim()) {
                    case "FILE":
                        file = parts[1].trim();
                        break;
                    case "LEVEL":
                        level = LoggingLevel.valueOf(parts[1].trim());
                        break;
                    case "SIZE":
                        sizeFile = Long.parseLong(parts[1].trim());
                        break;
                    case "FORMAT":
                        format = parts[1].trim();
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new FileLoggerConfiguration(file, level, sizeFile, format);
    }
}
