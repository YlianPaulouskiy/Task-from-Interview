package edu.itstep.examination.exception;

public class NegativeNumberException extends RuntimeException {

    public NegativeNumberException() {
        this("В римской системе нет отрицательных чисел");
    }

    public NegativeNumberException(String message) {
        super(message);
    }
}
