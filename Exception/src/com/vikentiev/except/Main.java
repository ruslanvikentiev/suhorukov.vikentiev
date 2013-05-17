package com.vikentiev.except;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 1:37
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        ExceptionGenerator ex;
        ex = new ExceptionGenerator() {
            @Override
            public void generateNullPointerException() {
                //To change body of implemented methods use File | Settings | File Templates.
                Object o1 = null;
                System.out.println(o1.toString());
            }

            @Override
            public void generateClassCastException() {
                //To change body of implemented methods use File | Settings | File Templates.
                Object ch = new Character('a');
                System.out.println((Byte)ch);
            }

            @Override
            public void generateNumberFormatException() {
                //To change body of implemented methods use File | Settings | File Templates.
                String tmp="a";
                double b = Double.parseDouble(tmp);
            }

            @Override
            public void generateStackOverflowError() {
                //To change body of implemented methods use File | Settings | File Templates.
                rek();
            }
            private void rek(){
                rek();
            }

            @Override
            public void generateOutOfMemoryError() {
                //To change body of implemented methods use File | Settings | File Templates.
                Stack st = new Stack();
                while (true){
                    st.push("1");
                }
            }

            @Override
            public void generateMyException(String Message) throws MyException {
                //To change body of implemented methods use File | Settings | File Templates.
                    throw new MyException (Message);
            }
        };

        try {
        ex.generateNullPointerException();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try {
            ex.generateNumberFormatException();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            ex.generateClassCastException();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        try {
            ex.generateStackOverflowError();
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }

        try {
            ex.generateOutOfMemoryError();
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        try {
            ex.generateMyException("Error MyException");
        } catch (MyException e) {
            //System.err.println(e);
            e.printStackTrace();
        }
    }
}

