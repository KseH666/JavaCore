package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int countSpaces = 0;
        int countChars = 0;
        while (fileInputStream.available()>0){
            int a = fileInputStream.read();
            if(a==32){
                countSpaces++;
                countChars++;
            }else countChars++;
        }
        fileInputStream.close();
        System.out.println(String.format("%.2f",countSpaces*100.00/countChars));

    }
}
