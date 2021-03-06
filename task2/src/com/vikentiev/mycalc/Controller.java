package com.vikentiev.mycalc;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 14.05.13
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */

public class Controller{
    public Command getC(String cmdStr){
        Command cmd;
        cmd = null;

        Class c = null;
        try {
            //System.out.println("creating class c = " + cmdStr);
            c = Class.forName(cmdStr);
            try {
                cmd = (Command) c.newInstance();
                //System.out.println(cmd.getClass().toString());
            } catch (InstantiationException e) {
                System.out.println("InstantiationException");
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }

        return cmd;
    }
}
