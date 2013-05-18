package com.vikentiev.mycalc2;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
public class DefineCmd implements Command {
    @Res(type=Param.CONTEXT)
    String str1;
    @Res(type=Param.MAP)
    Map mp1;
    public void execute() {
        double a;
        int k, l;
        k = str1.indexOf(" ");
        l = str1.lastIndexOf(" ");
        String tmp;
        if ((k < 0) | (l < 0)) {
            System.out.println("Команда некорректна!");
            return;
        }
        tmp = str1.substring(k,l);
        //проверить что tmp правильный идентификатор
        //System.out.println("define(param)="+tmp);

        try {
            a = Double.parseDouble(str1.substring(l));
            //System.out.println("define(value)="+a);
            mp1.put(tmp, a);
        } catch (NumberFormatException e) {
            System.out.println("Некорректный формат числа!");
        }
    }
}