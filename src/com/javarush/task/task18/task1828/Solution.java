package com.javarush.task.task18.task1828;

/*
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] arg = {"-u", "198478", "Test", "1450", "125"};
        if (args.length != 0 && args[0].equals("-u")){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
            String line = "";
            ArrayList<String> list = new ArrayList<>();
            while (readerFile.ready()){
                line = readerFile.readLine();
                String str = line.substring(0, 8).trim();
                int n = Integer.parseInt(str);
                if (n != Integer.parseInt(args[1])) {
                    list.add(line);
                } else {
                    list.add(String.format("%-8d%-30s%-8s%-4s", n, args[2], args[3], args[4]));
                }
            }

            readerFile.close();
            BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileName));
            for (String str: list){
                writerFile.write(str);
                writerFile.newLine();
            }
            writerFile.close();
        }
        if (args.length != 0 && args[0].equals("-d")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            BufferedReader readerFile = new BufferedReader(new FileReader(fileName));
            String line = "";
            ArrayList<String> list = new ArrayList<>();
            while (readerFile.ready()){
                line = readerFile.readLine();
                String str = line.substring(0, 8).trim();
                int n = Integer.parseInt(str);
                if (n != Integer.parseInt(args[1])) {
                    list.add(line);
                }
            }
            readerFile.close();
            BufferedWriter writerFile = new BufferedWriter(new FileWriter(fileName));
            for (String str: list){
                writerFile.write(str);
                writerFile.newLine();
            }
            writerFile.close();
        }
    }
}
