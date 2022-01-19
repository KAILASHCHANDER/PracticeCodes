package com.sg.assignment.processing;

import com.sg.assignment.utils.ExceptionMessanger;


public interface Executor {
    public boolean process() throws ExceptionMessanger;
}
