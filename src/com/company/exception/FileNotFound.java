package com.company.exception;

public class FileNotFound extends Exception{

    public FileNotFound(){

    }

    public FileNotFound(String msg){
        super(msg);
    }
}
