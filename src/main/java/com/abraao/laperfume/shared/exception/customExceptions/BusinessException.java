package com.abraao.laperfume.shared.exception.customExceptions;

public class BussinesException extends RuntimeException {


    public BussinesException() {
        super("error.bussines_exception");
    }


    public BussinesException(String message) {
        super(message);
    }
}
