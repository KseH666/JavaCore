package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(reader.readLine());
        if (first <= 0) {
            int a = first + Math.abs(first);
            int b = 1 / a;
        }
        int second = Integer.parseInt(reader.readLine());
        if (second <= 0) {
            int a = second + Math.abs(second);
            int b = 1 / a;
        }
        List<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        if (list.get(0) < list.get(1)) {
            Collections.swap(list, 1, 0);
        }
        for (int i = 0; ; i++) {
            int r = list.get(i) % list.get(i + 1);
            if (r != 0) {
                list.add(r);
            } else {
                list.add(r);
                break;
            }
        }
        System.out.println(list.get(list.size() - 2));
    }
}

