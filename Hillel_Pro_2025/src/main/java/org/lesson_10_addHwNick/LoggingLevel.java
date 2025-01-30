package org.lesson_10_addHwNick;

public enum LoggingLevel {
    INFO,
    DEBUG;

    public boolean includeLevel(LoggingLevel level) {

        return this == DEBUG || level == INFO;
    }
}
