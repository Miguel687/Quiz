package com.company.exception;

public class PreguntaNoValidaException extends Exception{
    public PreguntaNoValidaException(){

    }

    public PreguntaNoValidaException(String msg){
        super(msg);
    }
}
