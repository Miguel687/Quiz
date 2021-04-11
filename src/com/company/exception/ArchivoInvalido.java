package com.company.exception;

public class ArchivoInvalido extends Exception{
    public ArchivoInvalido() {
    }

    public ArchivoInvalido(String msg){
        super(msg);
    }
}
