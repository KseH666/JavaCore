package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        ArrayList<String> strings = new ArrayList<>();
        int count = 0;
        while (fileReader.ready()) {
            strings.add(fileReader.readLine());
        }
        for (int i = 0; i < strings.size(); i++) {
            String thisString = strings.get(i);
            for (int a = 0; a < words.size(); a++) {
                int z = thisString.indexOf(words.get(a));
                while (z >= 0) {
                    count++;
                    z = thisString.indexOf(words.get(a), z + 1);
                }
            }
            if (count == 2) {
                System.out.println(thisString);
            }
            count = 0;
        }
        fileReader.close();
    }
}

