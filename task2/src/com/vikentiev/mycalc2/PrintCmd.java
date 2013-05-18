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
public class PrintCmd extends Check implements Command {
    @Res(type=Param.STACK)
    Stack st1;
    public void execute() {
        String tmp;
        if (this.isEmpty(st1)) return;
        tmp = st1.peek().toString();
        System.out.println("Print: "+tmp);
    }

}