package com.vikentiev.mycalc2;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Ryslan
 * Date: 15.05.13
 * Time: 20:32
 * To change this template use File | Settings | File Templates.
 */
public class Factory{
    Properties getProperties() throws IOException{
        File file = new File("C:/Ruslan/commands2.txt");
        FileInputStream inF = new FileInputStream(file);
        try{
            inF = new FileInputStream(file);
        } catch (FileNotFoundException e) {
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(inF, "windows-1251"));

        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e){
        }
        return prop;
    }
}
