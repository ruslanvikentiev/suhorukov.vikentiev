package com.suhorukov.vikentiev;

import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 13.04.13
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        for (String s:  args){
            System.out.println(s);
        }

         System.out.println("Введите текст:");
         Scanner scanner = new Scanner(System.in);
         String str = scanner.nextLine();
         System.out.println(str);
         //System.out.println(System.getProperty("file.encoding"));

    }
}

class Logic{
    public static void main(String[] args) {

    }

    public String in(String str){
         return str;
    }
}
