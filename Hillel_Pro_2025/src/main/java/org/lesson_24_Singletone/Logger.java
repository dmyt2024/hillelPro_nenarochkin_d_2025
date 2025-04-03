package org.lesson_24_Singletone;

public class Logger {

    private static Logger instance;
    private static String logFile = "This is a log file\n";

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void addMsg(String msg) {
        logFile += msg + "\n";
    }

    public void logInfo() {
        System.out.println(logFile);
    }
}
