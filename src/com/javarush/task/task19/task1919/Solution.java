package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> values = new TreeMap<>();
        while (fileReader.ready()) {
            String all = fileReader.readLine();
            double value = Double.parseDouble(all.substring(all.indexOf(" ")));
            if (values.containsKey(all.substring(0, all.indexOf(" ")))) {
                values.put(all.substring(0, all.indexOf(" ")), values.get(all.substring(0, all.indexOf(" "))) + value);
            } else {
                values.put(all.substring(0, all.indexOf(" ")), value);
            }
        }
        fileReader.close();
        ArrayList<String> list = new ArrayList<>(values.keySet());
        for (String s : list) {
            System.out.println(s + " " + values.get(s));
        }
    }

}
