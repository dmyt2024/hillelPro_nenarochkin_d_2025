package org.dmytr.less_42_spring_data.exeption;

public class ProhibitedEmailExeption extends RuntimeException {


    public ProhibitedEmailExeption() {
    }

    public ProhibitedEmailExeption(String message) {
        super(message);
    }

    public ProhibitedEmailExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
