package com.vikentiev.except;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 1:33
 * To change this template use File | Settings | File Templates.
 */
public interface ExceptionGenerator {
    void generateNullPointerException();
    void generateClassCastException();
    void generateNumberFormatException();
    void generateStackOverflowError();
    void generateOutOfMemoryError();
    void generateMyException(String Message) throws MyException;
}

class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}

