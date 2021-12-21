package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (fileInputStream.available() > 0) {
            byte[] buffer = new byte[(fileInputStream.available())];
            for(int j = fileInputStream.read(buffer) - 1; j >= 0; j--){
                fileOutputStream.write(buffer[j]);
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}