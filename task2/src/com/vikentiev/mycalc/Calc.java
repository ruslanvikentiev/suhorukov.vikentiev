package com.vikentiev.mycalc;


//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.io.*;
import java.util.*;

import com.vikentiev.*;

public class Calc {
        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);

            String str, cmd;
            str = "";
            Stack st = new Stack();
            Command ccc;
            Controller c;
            int k;

            c = new Controller();

            Map<String, Double> map = new HashMap<String, Double>();

            Properties prop;
            prop = (new Factory()).getProperties();

            while (!( str.equals("q"))){
                str = scanner.nextLine();
                k = str.indexOf(" ");
                if (k > 0) {
                    cmd = str.substring(0, k);
                } else {
                    cmd = str;
                }
                cmd = cmd.toLowerCase();
                System.out.println(cmd + " contains in commands = " + prop.containsKey(cmd));
                if (!prop.containsKey(cmd)){
                    System.out.println("Данная команда " + cmd + " не найдена в commands.txt");
                } else {

                ccc = c.getC(prop.getProperty(cmd));
                if (ccc != null) {
                    ccc.execute(st, str, map);
                } else {
                    System.out.println("Команда не распознана, попробуйте еще раз");
                }
                }
            }
        }
}


       /**
        * пример простейшего синглтона
        Class A{
            private A(){
        private final static A inst = new A;
        public static A getInst(){
        return inst;
        }
        }
        }


        Public sunc static A getA(){
        if (inst == null) {
        cnst = new A();
        }
        }
        */