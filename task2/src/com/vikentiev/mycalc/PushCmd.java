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
public class PushCmd implements Command{
    public void execute(Stack st, String str, Map mp) {
        double a;
        int k;
        a=0;
        k = str.indexOf(" ");
        String tmp;

        if (k <= 0) {
            System.out.println("команда не корректна!");
            return;
        }
        tmp = str.substring(k);

        try{
            a = Double.parseDouble(tmp);
        } catch (NumberFormatException e){
            if (mp.containsKey(tmp)) {
                a = Double.parseDouble(mp.get(tmp).toString());
            } else {
                System.out.println("коюч для " + tmp + " не найден");
                return;
            }
        } //catch (NullPointerException e) {}
        st.push(a);
        //System.out.println("push = " + a);
    }

}