package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; ; i++) {
            String read = reader.readLine();

            if (!read.equals("exit")) {
                try {
                    if (read.contains(".")) {
                        print(Double.parseDouble(read));
                    } else if (Integer.parseInt(read) > 0 && Integer.parseInt(read) < 128) {
                        print((short) Integer.parseInt(read));
                    } else if (Integer.parseInt(read) <= 0 || Integer.parseInt(read) >= 128) {
                        print(Integer.parseInt(read));
                    }

                } catch (NumberFormatException e) {
                    print(read);
                }

            } else break;
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
