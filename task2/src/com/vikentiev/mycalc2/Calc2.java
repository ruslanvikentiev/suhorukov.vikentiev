package com.vikentiev.mycalc2;


//import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.io.IOException;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.lang.String;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
@interface In{
        Param[] arg();
}


public class Calc2 {
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
            Field f;
            Method m;
            In anno;


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

                ccc = c.getC(prop.getProperty(cmd));
                try {
                    try {
                    m = ccc.getClass().getMethod("execute");
                    anno = m.getAnnotation(In.class);
                        try {
                            for (Param s : anno.arg()){
                                switch (s) {
                                    case STACK:
                                        f = ccc.getClass().getDeclaredField("st1");
                                        f.setAccessible(true);
                                        f.set(ccc, st);
                                        break;
                                    case CONTEXT:
                                        f = ccc.getClass().getDeclaredField("str1");
                                        f.setAccessible(true);
                                        f.set(ccc, str);
                                    case MAP:
                                        f = ccc.getClass().getDeclaredField("mp1");
                                        f.setAccessible(true);
                                        f.set(ccc, map);
                                }
                                /**
                                if (s.equals(Param.STACK)){
                                    f = ccc.getClass().getDeclaredField("st1");
                                    f.setAccessible(true);
                                    f.set(ccc, st);
                                } else if (s.equals(Param.CONTEXT)){
                                    f = ccc.getClass().getDeclaredField("str1");
                                    f.setAccessible(true);
                                    f.set(ccc, str);
                                }else if (s.equals(Param.MAP)){
                                    f = ccc.getClass().getDeclaredField("mp1");
                                    f.setAccessible(true);
                                    f.set(ccc, map);
                                }*/

                            }
                        } catch (IllegalAccessException e) {System.out.println("IllegalAccessException");}
                    } catch (NoSuchMethodException e) {}
                } catch (NoSuchFieldException e) {System.out.println("NoSuchFieldException");}

                if (ccc != null) {
                    ccc.execute();
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
