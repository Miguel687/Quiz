package com.company.exception;

public class PreguntaNotFoundException extends Exception{
    public PreguntaNotFoundException(){

    }

    public PreguntaNotFoundException(String msg){
        super(msg);
    }
}
