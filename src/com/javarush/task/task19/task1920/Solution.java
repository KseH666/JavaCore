package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
        ArrayList<Double>listttt = new ArrayList<>(values.values());
        Collections.sort(listttt);
        double r = listttt.get(list.size()-1);
        for (String s : list) {
            if (values.get(s) == r) {
                System.out.println(s);
            }
        }
    }
}

