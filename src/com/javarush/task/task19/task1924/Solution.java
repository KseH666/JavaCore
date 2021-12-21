package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        String fileName = file.readLine();
        file.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String[] slot;
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            slot = line.split(" ");
            for (int i = 0; i < slot.length; i++) {
                try {
                    if (Integer.parseInt(slot[i]) <= 12) {
                        slot[i] = map.get(Integer.parseInt(slot[i]));
                    }
                } catch (NumberFormatException ignored) {
                }
            }
            for (int i = 0; i < slot.length; i++) {
                if (i == slot.length - 1) {
                    System.out.print(slot[i]);
                } else {
                    System.out.print(slot[i] + " ");
                }
            }
            System.out.println();
        }
        fileReader.close();
    }
}
