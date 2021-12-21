package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        List<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        fileInputStream.close();
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int a = 0; a < list.size() - 1; a++) {
            if (list.get(a).equals(list.get(a + 1))) {
                count++;
                if (a == list.size() - 2) {
                    map.put(list.get(a), count);
                }
            } else {
                map.put(list.get(a), count);
                count = 1;
            }
        }
        List<Integer> list1 = new ArrayList<>(map.keySet());
        Collections.sort(list1);
        String z = list1.get(0) + " ";
        for (int a = 1; a < list1.size(); a++) {
            z = z.concat(list1.get(a) + " ");
        }
        System.out.println(z.substring(0, z.length() - 1));

    }
}

