package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        int[] frequency  = new int[128];
        while (fileInputStream.available() > 0) {
            frequency [fileInputStream.read()]++;
        }
        fileInputStream.close();
        for (int a = 0; a < frequency .length; a++) {
            if (frequency [a] != 0) {
                System.out.println((char) a + " " + frequency [a]);
            }
        }

    }

}