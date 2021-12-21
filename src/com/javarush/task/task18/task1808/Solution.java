package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream0 = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream1 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        if (fileInputStream0.available() % 2 == 0) {
            if ((fileInputStream0.available()) > 0) {
                byte[] buffer = new byte[(fileInputStream0.available() / 2)];
                int count = fileInputStream0.read(buffer);
                fileOutputStream1.write(buffer, 0, count);
            }
        } else {
            if ((fileInputStream0.available()) > 0) {
                byte[] buffer = new byte[(fileInputStream0.available() / 2) + 1];
                int count = fileInputStream0.read(buffer);
                fileOutputStream1.write(buffer, 0, count);
            }
        }
        if ((fileInputStream0.available()) > 0) {
            byte[] buffer2 = new byte[(fileInputStream0.available())];
            int count = fileInputStream0.read(buffer2);
            fileOutputStream2.write(buffer2, 0, count);
        }


        fileInputStream0.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
