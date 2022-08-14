package edu.itstep.examination.exception;

public class InvalidFormatSourceLineException extends RuntimeException {

    public InvalidFormatSourceLineException() {
        this("Неверный формат введенной строки");
    }

    public InvalidFormatSourceLineException(String message) {
        super(message);
    }
}
