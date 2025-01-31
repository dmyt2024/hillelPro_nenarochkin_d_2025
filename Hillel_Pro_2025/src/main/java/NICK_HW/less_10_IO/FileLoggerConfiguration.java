package NICK_HW.less_10_IO;

public class FileLoggerConfiguration {
    private String fileName;
    private LoggingLevel level;
    private long sizeFile;
    private String format;

    public FileLoggerConfiguration(String fileName, LoggingLevel level, long sizeFile, String format) {
        this.fileName = fileName;
        this.level = level;
        this.sizeFile = sizeFile;
        this.format = format;
    }


    public String getFileName() {

        return fileName;
    }

    public LoggingLevel getLevel() {

        return level;
    }

    public long getSizeFile() {

        return sizeFile;
    }

    public String getFormat() {

        return format;
    }


}

