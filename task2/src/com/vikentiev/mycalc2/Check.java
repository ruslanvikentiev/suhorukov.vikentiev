package com.vikentiev.mycalc2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 18.05.13
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
public class Check {
    public boolean isEmpty(Stack st){
        if (st.isEmpty()) {
            System.out.println("Стек не содержит достаточное кол-во значений, выполнение операции невозможно!");
            return true;
        }
        return false;
    }
}
