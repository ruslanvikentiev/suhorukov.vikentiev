package com.vikentiev.mycalc;

import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 20:30
 * To change this template use File | Settings | File Templates.
 */
public class DefineCmd implements Command{
    public void execute(Stack st, String str, Map mp) {
        double a;
        int k, l;
        k = str.indexOf(" ");
        l = str.lastIndexOf(" ");
        String tmp;
        if ((k < 0) | (l < 0)) {
            System.out.println("Команда некорректна!");
            return;
        }
        tmp = str.substring(k,l);
        //проверить что tmp правильный идентификатор
        System.out.println("define(param)="+tmp);

        try {
            a = Double.parseDouble(str.substring(l));
            System.out.println("define(value)="+a);
            mp.put(tmp, a);
        } catch (NumberFormatException e) {
            System.out.println("Некорректный формат числа!");
        }
    }
}