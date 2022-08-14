package edu.itstep.examination.exception;

public class InvalidNumberRangeException extends RuntimeException {

    public InvalidNumberRangeException() {
        this("Неверный диапозон чисел, допустимый диапозон: [1;10]");
    }

    public InvalidNumberRangeException(String message) {
        super(message);
    }
}
