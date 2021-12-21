package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream0 = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine(),true);
        FileInputStream fileInputStream1 = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileInputStream fileInputStream2 = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        while (fileInputStream1.available()>0){
            fileOutputStream0.write(fileInputStream1.read());
        }
        fileInputStream1.close();
        while (fileInputStream2.available()>0){
            fileOutputStream0.write(fileInputStream2.read());
        }
        fileInputStream2.close();
        fileOutputStream0.close();
    }
}
