package edu.itstep.examination.exception;

public class DifferentNumberSystemException extends RuntimeException {

    public DifferentNumberSystemException() {
        this("Используются одновременно разные системы счисления");
    }

    public DifferentNumberSystemException(String message) {
        super(message);
    }
}
