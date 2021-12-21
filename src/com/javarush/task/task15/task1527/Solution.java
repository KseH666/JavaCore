package com.javarush.task.task15.task1527;

/*
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        String ind = URL;
        List<String> LOR = new ArrayList<>();
        char[] chars = URL.toCharArray();
        char[] a = new char[URL.length()];
        String res = null;
        String val = null;
        int index = ind.indexOf("&");
        int count = 0;
        while (index != -1) {
            count++;
            ind = ind.substring(index + 1);
            index = ind.indexOf("&");
        }
        if (count == 0) {
            for (int i = URL.indexOf("?") + 1; i < URL.length(); i++) {
                a[i] = chars[i];
                res = String.valueOf(a);
            }
            LOR.add(res);
        }
        if (count == 1) {
            for (int i = URL.indexOf("?") + 1; i < URL.indexOf("&"); i++) {
                a[i] = chars[i];
                res = String.valueOf(a);
            }
            LOR.add(res);
            val = URL.substring(URL.indexOf("&") + 1);
            a = new char[URL.length()];
            chars = val.toCharArray();
            for (int i = 0; i < val.length(); i++) {
                a[i] = chars[i];
                res = String.valueOf(a);
            }
            LOR.add(res);
        }
        if (count > 1) {
            for (int i = URL.indexOf("?") + 1; i < URL.indexOf("&"); i++) {
                a[i] = chars[i];
                res = String.valueOf(a);
            }
            LOR.add(res);
            val = URL.substring(URL.indexOf("&") + 1);
            a = new char[URL.length()];

            for (int i = 0; i < val.indexOf("&"); i++) {
                a[i] = chars[URL.indexOf("&") + i + 1];
                res = String.valueOf(a);
            }
            LOR.add(res);
            for (int o = 0; o < count - 2; o++) {
                val = val.substring(val.indexOf("&") + 1);
                a = new char[URL.length()];
                chars = val.toCharArray();
                for (int i = 0; i < val.indexOf("&"); i++) {
                    a[i] = chars[i];
                    res = String.valueOf(a);
                }
                LOR.add(res);
            }
            val = val.substring(val.indexOf("&") + 1);
            a = new char[URL.length()];
            chars = val.toCharArray();
            for (int i = 0; i < val.length(); i++) {
                a[i] = chars[i];
                res = String.valueOf(a);
            }
            LOR.add(res);
        }
        List<String> LOR2 = new ArrayList<>(LOR);


        for (int i = 0; i < LOR.size(); i++) {
            if (LOR.get(i).contains("=")) {
                LOR.set(i, LOR.get(i).substring(0, LOR.get(i).indexOf("=")));
                if (i != LOR.size() - 1) {
                    System.out.print(LOR.get(i).trim() + " ");
                } else System.out.println(LOR.get(i).trim());
            } else {
                if (i != LOR.size() - 1) {
                    System.out.print(LOR.get(i).trim() + " ");
                } else System.out.println(LOR.get(i).trim());
            }
        }
        System.out.println("");

        for (int i = 0; i < LOR2.size(); i++) {
            if (LOR2.get(i).contains("obj=") && LOR2.get(i).trim().startsWith("obj=")) {
                LOR2.set(i, LOR2.get(i).substring(LOR2.get(i).indexOf("=") + 1, LOR2.get(i).length()));
                try {
                    alert(Double.parseDouble(LOR2.get(i)));
                } catch (Exception e) {
                    alert(LOR2.get(i));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
