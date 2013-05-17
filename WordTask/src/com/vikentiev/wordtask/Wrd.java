package com.vikentiev.wordtask;

import java.io.*;
import java.util.*;
import java.lang.*;


class Counter {
    private int count;

    public Counter() {
        count = 1;
    }

    public void bumpCount() {
        count++;
    }

    //public int getCount() {
    //    return count;
    //}

    public String toString() {
        return Integer.toString(count);
    }
}

public class Wrd {
    static Map<String, Counter> map = new HashMap<String, Counter>();
    //static Map map = new LinkedHashMap();

    // инициализировать таблицу
    static void initMap(String key) {
        map.put(key, new Counter());
    }

    // инкрементировать счетчик слова
    static void useWord(String key) {
        Counter ctr = map.get(key);
        if (ctr == null){
            initMap(key);
        } else {
            ctr.bumpCount();
        }
    }

    // отобразить содержимое таблицы
    /**
    static void displayMap(int allNum) {
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            double d = (Double.parseDouble(entry.getValue().toString()) / allNum)*100;
            d = Math.ceil(d*100.0)/100.0;
            System.out.println(entry.getKey() + ", " + entry.getValue() + ", " + d + "%");
        }
    }  */

    public static void main(String args[])  throws IOException  {
        int allNum;
        allNum = 0;
        File file = new File("C:/Ruslan/test5.txt");
        FileInputStream inF = new FileInputStream(file);
        String encoding;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inF, "windows-1251"));
            System.out.println(System.getProperty("file.encoding"));

            StringBuilder sb = new StringBuilder();

            int content;
            while ((content = in.read()) != -1) {
                char ch;
                ch = (char) content;

                if (Character.isLetterOrDigit(ch)){
                    sb.append((char) content);
                } else if (!(sb.toString().trim().equals(""))){
                    useWord(sb.toString().toLowerCase());
                    allNum++;
                    sb.delete(0,sb.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inF != null)
                    inF.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        class Item implements Comparable{
            Object key;
            Object value;
            Item(Object k, Object v) {
                key = k; value = v;
            }

            @Override
            public int compareTo(Object other) {
                final int LESS_THAN = -1;
                final int EQUAL = 0;
                final int GREATER_THAN = 1;

                Item otherObj = (Item) other;
                if ( this == otherObj ) return EQUAL;

                int comparison;

                comparison = 0;
                String val1 = this.value.toString();
                int v1 = Integer.parseInt(val1);
                //System.out.println("val=" + value);
                String val2 = otherObj.value.toString();
                int v2 = Integer.parseInt(val2);
                //System.out.println("val2=" + value);
                String key1 = this.key.toString();
                String key2 = otherObj.key.toString();

                if (v1 < v2) {
                    comparison = GREATER_THAN;
                } else if (v1 > v2) {
                    comparison = LESS_THAN;
                } else if (key1.compareTo(key2) > 0) {
                    comparison = GREATER_THAN;
                } else if (key1.compareTo(key2) < 0) {
                    comparison = LESS_THAN;
                }
                if (comparison != EQUAL) return comparison;
                return EQUAL;
            }
        }

        List<Item> list = new ArrayList<Item>();

        for (String key: map.keySet()){
            list.add(new Item(key, map.get(key)));
        }

        Collections.sort(list);
        System.out.println("allNum=" + allNum);
        System.out.println();

        File fileOut = new File("C:/Ruslan/test3_Out.txt");
        try {
        FileOutputStream outF = new FileOutputStream("C:/Ruslan/test3_Out.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        File flt = new File("C:/Ruslan/test3_Out.txt");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(flt)));

        String str;
        for (Item aList : list) {
            double d = (Double.parseDouble(aList.value.toString()) / allNum) * 100;
            d = Math.ceil(d * 100.0) / 100.0;
            str = aList.key + ": " + aList.value + ", " + d;
            System.out.println(str);
            out.println(str);
        }
        out.flush();
    }
}

