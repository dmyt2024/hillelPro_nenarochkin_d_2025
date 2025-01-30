package org.HW_10_NICK;

public enum LoggingLevel {
    INFO,
    DEBUG;

    public boolean includeLevel(LoggingLevel level) {

        return this == DEBUG || level == INFO;
    }
}
