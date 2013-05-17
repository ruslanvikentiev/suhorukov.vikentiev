package com.vikentiev.httpserver;

import java.io.*;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 11.05.13
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
public class GeneratorHTML {
    /**
     ServerSocket
     SocketInputStream
     SocketOutputStream
     port >1024  (например 8080)
     LocalHost:8080
     1) создавать html страницу
     серверу в качестве парам передаем директорию (выше директории прыгать не надо)- выдает html  + имя html файла

     File = new File("") //путь брать из командной строки - может быть относит или полный
     если это директория, то получить все папки и файлы
     сортировка-сначала директории, потом файла и внутри категории сортировка по имени
     MessageFormat
     "Hi {0}"
     MessageFormat.getInstance.format(str, ...) //для формирования html
     */
    public static void main(String[] args) throws IOException  {
       //чтение директории
       String dirName;

       //Scanner scanner = new Scanner(System.in);
       //dirName = scanner.nextLine();
       //System.out.println("dirName=" + dirName);
       dirName = ".";//временно
       File file = new File(dirName);

       if (file.isDirectory()) {
          System.out.println("Указанное имя " + dirName  + " является директорией, создаем html файл");
          File[] fArr = file.listFiles();

          //сортируем массиы файлов с помощью компаратора
           Arrays.sort(fArr, new Comparator<File>() {
               @Override
               public int compare(File o1, File o2) {
                   String f1, f2;

                   f1 = o1.getName().toString().toLowerCase();
                   f2 = o2.getName().toString().toLowerCase();

                   int res;
                   res = 0;

                   if (o1.isDirectory() & !o2.isDirectory()){
                       res = -1;
                   } else if (o2.isDirectory() & !o1.isDirectory()){
                       res = 1;
                   } else if (o1.isDirectory() & o1.isDirectory()){
                       if (f1.compareTo(f2)<0){
                           res = -1;
                       } else {
                           res = 1;
                       }
                   } else if (!o1.isDirectory() & !o1.isDirectory()){
                       if (f1.compareTo(f2)<0){
                           res = -1;
                       } else {
                           res = 1;
                       }
                   }
                   return res;
               }
           });

          CreateHTML cHtml = new CreateHTML();
          cHtml.Print(fArr, dirName);
       } else {
           System.out.println("Указанное имя не является директорией");

       }
    }
}

class CreateHTML{
    public void Print(File[] fArr, String dirName) throws IOException  {
               File flt = new File(dirName + "/Index.html");
               if (flt.exists()) {
                   System.out.println("Файл 'Index.html' уже существует в директории '" + dirName +  "', создание файла отменено!");
                   return;
               }
               PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(flt)));

               String str;
               str = "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"></head><table>";
               out.println(str);
               String row;
               //URLEncoder
               row = "<tr><td><b>Имя</b></td><td><b>Дата последнего изменнения</b></td><td><b>Размер</b></td></tr>";
               out.println(row);

               row = "<tr><td><a href='" + dirName + "/" + ".." +"'> .. </td><td></td><td></td></tr>";
               out.println(row);
               String fName;

               for (File file : fArr){
                   fName = file.getName();
                   Date dt = new Date(file.lastModified());
                   String length;
                   if (file.isDirectory()){
                       length = "";
                   } else {
                       length = ""+file.length();
                   }

                   System.out.println(file.getName());
                   row = "<tr><td><a href='" + dirName + "/" + fName +"'> " + fName + "</td><td>" + dt + "</td><td>"+length+"</td></tr>";
                   out.println(row);
               }
               out.println("</table>");
               out.flush();
               out.close();
           }
}