package NICK_HW.less_10_IO;

public enum LoggingLevel {
    INFO,
    DEBUG;

    public boolean includeLevel(LoggingLevel level) {

        return this == DEBUG || level == INFO;
    }
}
