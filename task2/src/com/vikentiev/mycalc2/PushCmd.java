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
public class PushCmd implements Command {
    String str1;
    Stack st1;
    Map mp1;
    @In(arg = {Param.STACK, Param.CONTEXT, Param.MAP})
    public void execute() {
        double a;
        int k;
        a=0;
        k = str1.indexOf(" ");
        String tmp;

        if (k <= 0) {
            System.out.println("команда не корректна!");
            return;
        }
        tmp = str1.substring(k);

        try{
            a = Double.parseDouble(tmp);
        } catch (NumberFormatException e){
            if (mp1.containsKey(tmp)) {
                a = Double.parseDouble(mp1.get(tmp).toString());
            } else {
                System.out.println("коюч для " + tmp + " не найден");
                return;
            }
        } catch (NullPointerException e) {}
        st1.push(a);
    }

}