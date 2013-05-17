package com.vikentiev.mycalc;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 20:42
 * To change this template use File | Settings | File Templates.
 */
public class ExpCmd extends Check implements Command{
    public void execute(Stack st, String str, Map mp) {
        double a, b;
        if (this.isEmpty(st)) return;
        a = Double.parseDouble(st.pop().toString());
        b = Math.exp(a);
        st.push(b);
        System.out.println(b);
    }

}