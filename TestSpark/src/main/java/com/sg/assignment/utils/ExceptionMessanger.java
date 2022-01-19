package com.sg.assignment.utils;

public class ExceptionMessanger extends Exception{

    public ExceptionMessanger(String message)
    {
        super(message);
    }

    public ExceptionMessanger(String message,Throwable th)
    {
        super(message,th);
    }
}
