package com.vikentiev.mycalc2;


//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.io.IOException;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.lang.String;

public class Calc2 {
        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);

            String str, cmd;
            str = "";
            Stack st = new Stack();
            Command command;
            Controller c;
            int k;

            c = new Controller();

            Map<String, Double> map = new HashMap<String, Double>();

            Properties prop;
            prop = (new Factory()).getProperties();
            Field f;
            Method m;
            //In anno;
            Res anno;
            Annotation[] annos, ann2;
            Field[] flds;


            while (!( str.equals("q"))){
                str = scanner.nextLine();
                k = str.indexOf(" ");
                if (k > 0) {
                    cmd = str.substring(0, k);
                } else {
                    cmd = str;
                }
                cmd = cmd.toLowerCase();

                if (!prop.containsKey(cmd)){
                    System.out.println("Команда '" + cmd + "' не найдена");
                } else {

                command = c.getC(prop.getProperty(cmd));
                try {
                    flds = command.getClass().getDeclaredFields();
                    for (Field f1 : flds) {
                        anno = f1.getAnnotation(Res.class);
                        //System.out.println(anno.type());
                             for (Param s : anno.type()){
                                switch (s) {
                                    case STACK:
                                        //f = command.getClass().getDeclaredField("st1");
                                        f1.setAccessible(true);
                                        f1.set(command, st);
                                        break;
                                    case CONTEXT:
                                        //f = command.getClass().getDeclaredField("str1");
                                        f1.setAccessible(true);
                                        f1.set(command, str);
                                        break;
                                    case MAP:
                                        //f = command.getClass().getDeclaredField("mp1");
                                        f1.setAccessible(true);
                                        f1.set(command, map);
                                        break;
                                }
                             }
                    }
                } catch (IllegalAccessException e) {System.out.println("IllegalAccessException");}

                if (command != null) {
                    command.execute();
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
