package com.javarush.task.task13.task1326;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = nameReader.readLine();
        nameReader.close();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<Integer> list = new ArrayList<>();
        while (fileReader.ready()) {
            int numb = Integer.parseInt(fileReader.readLine());
            if (numb % 2 == 0) {
                list.add(numb);
            }
        }
        fileReader.close();
        Collections.sort(list);
        for (int x : list) {
            System.out.println(x);
        }
    }
}
