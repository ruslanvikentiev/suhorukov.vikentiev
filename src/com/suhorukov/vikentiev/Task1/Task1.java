package com.suhorukov.vikentiev.Task1;

import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 24.04.13
 * Time: 9:44
 * To change this template use File | Settings | File Templates.
 */

enum Result {
    GUESS, LESS, MORE
}

public class Task1 {    /////
    public static void main(String[] args) {
        //инициализация случайного числа от 1 до 100
        Random random = new Random();
        int n = 100;
        int m = random.nextInt(n) + 1;
        Scanner scanner = new Scanner(System.in);

        //создание и инициализация класса проверки числа
        CheckNumber cNumber = new CheckNumber(m);

        boolean isFind;
        isFind = false;
        Result tmpRes;

        // цикл ввода чисел с консоли
        while (cNumber.isExistAttempt()){
                System.out.println("Введите число:");
                try {
                   int k = scanner.nextInt();
                   tmpRes = cNumber.check(k);

                   if (tmpRes == Result.GUESS){
                        System.out.println("Вы угадали число!");
                        isFind = true;
                        break;
                   } else if (tmpRes == Result.LESS){
                        System.out.println("Загаданное число меньше!");
                   } else if (tmpRes == Result.MORE){
                        System.out.println("Загаданное число больше!");
                   }
                } catch (RuntimeException e) {
                    String str = scanner.nextLine();
                    System.out.println("Введите корректное число! Введенное вами значение "+ str + " не является числом!");
                }
        }
    //в случае проигрыша показываем загаданное число
    if (!isFind) System.out.println("Вы использовали все попытки! Загаданное число = " + m);
    }
}

class CheckNumber{
    private int guessNumber;  // загаданное число
    private int numRetry;     // число попыток
    private int attempt;      // текущий номер попытки

    //инициализация всех переменных класса
    public CheckNumber(int args) {
      guessNumber = args;
      numRetry = 7;
      attempt = 0;
    }

    //сверка загаданного и введенного числа
    public Result check(int k){
       Result res;
       res = Result.GUESS;

       changeAttempt(1);

       if (k > guessNumber)   {
           res = Result.LESS;
       } else if (k < guessNumber)   {
           res = Result.MORE;
       }
       return res;
    }

    // есть ли еще попытки
    public boolean isExistAttempt(){
        //System.out.println("попытка номер "+ attempt);
        if (attempt < numRetry){
            return true;
        }  else {
            return false;
        }
    }

    //увеличение счетчика использованных попыток
    private void changeAttempt(int n){
      attempt = attempt + n;
    }


}