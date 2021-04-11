package com.company.exception;

public class RespuestaVaciaException extends Exception{
    public RespuestaVaciaException(){

    }

    public RespuestaVaciaException(String msg){
        super(msg);
    }
}
