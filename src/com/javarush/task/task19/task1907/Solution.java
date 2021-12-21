package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader fr = new FileReader(file);
        String all = "";
        int count = 0;
        while (fr.ready()) {
            all = all + (char)fr.read();
        }
        fr.close();
        String[] words = all.split("\\W");
        for (int z = 0; z < words.length; z++) {
            if (words[z].equals("world")) {
                count++;
            }
        }
        System.out.println(count);
    }

}
