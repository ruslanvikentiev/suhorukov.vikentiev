package com.vikentiev.mycalc2;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 20:39
 * To change this template use File | Settings | File Templates.
 */
public class SqrtCmd extends Check implements Command {
    @Res(type=Param.STACK)
    Stack st1;
    public void execute() {
        double a, b;
        if (this.isEmpty(st1)) return;
        a = Double.parseDouble(st1.pop().toString());
        b = Math.sqrt(a);
        st1.push(b);
        System.out.println(b);
    }

}
