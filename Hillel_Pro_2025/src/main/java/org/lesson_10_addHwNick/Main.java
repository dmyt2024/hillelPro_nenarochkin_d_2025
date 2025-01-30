package org.lesson_10_addHwNick;

public class Main {
    public static void main(String[] args) {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration config = loader.load("src/main/java/less_10_Nick_IO/config.txt");

        FileLogger logger = new FileLogger(config);

        logger.info("Programm beging");
        logger.debug("Connection...");
        logger.debug("Loading end.");
        logger.info("Operation finished correctly.");
    }
}
