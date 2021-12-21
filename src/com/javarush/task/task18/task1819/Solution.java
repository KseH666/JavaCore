package com.javarush.task.task18.task1819;

/*
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(file1);
        ArrayList<Integer> list = new ArrayList<>();
        while (inputStream.available() > 0) {
            list.add(inputStream.read());
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        FileInputStream inputStream1 = new FileInputStream(file2);
        ArrayList<Integer> list1 = new ArrayList<>();
        while (inputStream1.available() > 0) {
            list1.add(inputStream1.read());
        }
        for (Integer integer : list1) {
            fileOutputStream.write(integer);
        }
        for (Integer integer : list) {
            fileOutputStream.write(integer);
        }
        inputStream.close();
        inputStream1.close();
        fileOutputStream.close();
    }
}
