package com.vikentiev.mycalc2;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
public class MultCmd extends Check implements Command {
    Stack st1;
    @In(arg = {Param.STACK})
    public void execute() {
        double a, b, c;

        if (this.isEmpty(st1)) return;
        a = Double.parseDouble(st1.pop().toString());
        if (this.isEmpty(st1)) {
            st1.push(a);
            return;
        }
        b = Double.parseDouble(st1.pop().toString());
        c = a * b;
        st1.push(c);
        System.out.println(c);
    }
}