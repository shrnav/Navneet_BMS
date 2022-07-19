package com.navneet.learning.bms.bmsapi.exception;

public class ElementAlreadyExistException extends RuntimeException {
    private String message;

    public ElementAlreadyExistException() {}

    public ElementAlreadyExistException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
