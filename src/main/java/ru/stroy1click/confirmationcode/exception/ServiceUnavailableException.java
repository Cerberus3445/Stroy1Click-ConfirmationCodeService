package ru.stroy1click.confirmationcode.exception;

public class ServiceUnavailableException extends RuntimeException {

    private final static String MESSAGE = "Сервис недоступен, пожалуйста, повторите позже";

    public ServiceUnavailableException(){
        super(MESSAGE);
    }
}
