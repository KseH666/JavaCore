package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        List<String> list = new ArrayList<>();
        String all = "";
        while (fileInputStream.available() > 0) {
            char read = (char) fileInputStream.read();
            if (read != '\n') {
                all = all + read;
                if (fileInputStream.available() == 1) {
                    list.add(all);
                    all = "";
                }
            } else {
                list.add(all);
                all = "";
            }
        }
        fileInputStream.close();
        for (int z = 0; z < list.size(); z++) {
            if (list.get(z).startsWith(args[0] + " ")) {
                System.out.println(list.get(z));
            }
        }
    }
}

