package org.lesson_10_NICK;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration config = loader.load("src/main/java/org/lesson_10_NICK/config.txt");

        FileLogger logger = new FileLogger(config);

        logger.info("Programm beging");
        logger.debug("Connection...");
        logger.debug("Loading end.");
        logger.info("Operation finished correctly.");
    }
}
