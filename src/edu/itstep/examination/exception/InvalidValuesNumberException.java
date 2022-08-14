package edu.itstep.examination.exception;

public class InvalidValuesNumberException extends RuntimeException {

    public InvalidValuesNumberException() {
        this("Неверное количество параметров");
    }

    public InvalidValuesNumberException(String message) {
        super(message);
    }
}
