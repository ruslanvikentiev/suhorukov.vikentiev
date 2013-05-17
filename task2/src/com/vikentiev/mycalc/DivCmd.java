package com.vikentiev.mycalc;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */
public class DivCmd extends Check implements Command{
    public void execute(Stack st, String str, Map mp) {
        double a, b, c;

        if (this.isEmpty(st)) return;
        a = Double.parseDouble(st.pop().toString());
        if (this.isEmpty(st)) {
            st.push(a);
            return;
        }
        b = Double.parseDouble(st.pop().toString());
        c = a / b;
        st.push(c);
        System.out.println(c);
    }
}