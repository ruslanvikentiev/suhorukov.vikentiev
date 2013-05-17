package com.vikentiev.mycalc;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
public class PrintCmd extends Check implements Command{
    public void execute(Stack st, String str, Map mp) {
        String tmp;
        if (this.isEmpty(st)) return;
        tmp = st.peek().toString();
        System.out.println("Print: "+tmp);
    }

}