package com.vikentiev.mycalc2;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 25.04.13
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */



public interface Command{
    void execute();
}

class Check{
    public boolean isEmpty(Stack st){
        if (st.isEmpty()) {
            System.out.println("Стек не содержит достаточное кол-во значений, выполнение операции невозможно!");
            return true;
        }
        return false;
    }
}








